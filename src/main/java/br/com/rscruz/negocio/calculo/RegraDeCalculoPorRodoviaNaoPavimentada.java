package br.com.rscruz.negocio.calculo;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public class RegraDeCalculoPorRodoviaNaoPavimentada extends RegraDeCalculo {

	@Override
	protected double aplicarRegra(ParametrosParaCalculoWrapper parametro) {

		return parametro.getDistanciaNaoPavimentada().getValor();
	}

	@Override
	protected boolean validar(ParametrosParaCalculoWrapper parametro) {

		return parametro.temQuantidadeDeQuilometrosNaoPavimentadosInformada();
	}
}
