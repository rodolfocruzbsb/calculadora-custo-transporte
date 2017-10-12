package br.com.rscruz.negocio.calculo;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public class RegraDeCalculoPorPesoDaCarga extends RegraDeCalculo {

	private static final double FATOR_DE_AJUSTE = 0.02;

	private static final int LIMITE_DE_TONELADAS = 5;

	@Override
	protected double aplicarRegra(ParametrosParaCalculoWrapper parametro) {

		double resultado = 0;

		if (parametro.getToneladas() > LIMITE_DE_TONELADAS) {

			double quilometragemTotal = parametro.getDistanciaPavimentada().getQuantidadeDeQuilometros()

					+ parametro.getDistanciaNaoPavimentada().getQuantidadeDeQuilometros();

			int toneladasPassiveisDeCalculo = parametro.getToneladas() - LIMITE_DE_TONELADAS;

			resultado += quilometragemTotal * toneladasPassiveisDeCalculo * FATOR_DE_AJUSTE;
		}
		return resultado;
	}

	@Override
	protected boolean validar(ParametrosParaCalculoWrapper parametro) {

		return parametro.getToneladas() > 0;
	}
}
