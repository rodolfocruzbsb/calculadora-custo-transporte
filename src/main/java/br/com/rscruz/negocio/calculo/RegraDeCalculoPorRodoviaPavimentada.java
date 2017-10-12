package br.com.rscruz.negocio.calculo;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public class RegraDeCalculoPorRodoviaPavimentada extends RegraDeCalculoDecorator {

	public RegraDeCalculoPorRodoviaPavimentada( RegraDeCalculo regra ) {

		this.regra = regra;

		this.parametro = this.regra.parametro;

	}

	@Override
	protected boolean validar(ParametrosParaCalculoWrapper parametro) {

		return parametro.temQuantidadeDeQuilometrosPavimentadosInformada();
	}

	@Override
	public double getCusto() {

		return this.parametro.getDistanciaPavimentada().getValor() + this.regra.getCusto();
	}
}
