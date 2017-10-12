package br.com.rscruz.negocio.calculo;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public class RegraDeCalculoPorPesoDaCarga extends RegraDeCalculoDecorator {

	private static final double FATOR_DE_AJUSTE = 0.02;

	private static final int LIMITE_DE_TONELADAS = 5;

	public RegraDeCalculoPorPesoDaCarga( RegraDeCalculo regra ) {

		this.regra = regra;

		this.parametro = this.regra.parametro;

	}

	@Override
	protected boolean validar(ParametrosParaCalculoWrapper parametro) {

		return parametro.getToneladas() > 0;
	}

	@Override
	public double getCusto() {

		double resultado = 0;

		if (this.parametro.getToneladas() > LIMITE_DE_TONELADAS) {

			double quilometragemTotal = this.parametro.getDistanciaPavimentada().getQuantidadeDeQuilometros()

					+ this.parametro.getDistanciaNaoPavimentada().getQuantidadeDeQuilometros();

			int toneladasPassiveisDeCalculo = this.parametro.getToneladas() - LIMITE_DE_TONELADAS;

			resultado += quilometragemTotal * toneladasPassiveisDeCalculo * FATOR_DE_AJUSTE;
		}
		return resultado + this.regra.getCusto();
	}
}
