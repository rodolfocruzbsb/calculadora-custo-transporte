package br.com.rscruz.negocio.calculo;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public class RegraDeCalculoPorRodoviaNaoPavimentada extends RegraDeCalculoDecorator {

	public RegraDeCalculoPorRodoviaNaoPavimentada( RegraDeCalculo regra ) {

		this.regra = regra;

		this.parametro = this.regra.parametro;

	}

	@Override
	protected boolean validar(ParametrosParaCalculoWrapper parametro) {

		return parametro.temQuantidadeDeQuilometrosNaoPavimentadosInformada();
	}

	@Override
	public double getCusto() {

		return this.parametro.getDistanciaNaoPavimentada().getValor() + this.regra.getCusto();
	}
}
