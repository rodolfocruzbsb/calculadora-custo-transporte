package br.com.rscruz.negocio.calculo;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public class RegraDeCalculoPorRodoviaPavimentada extends RegraDeCalculo {

	@Override
	protected double aplicarRegra(ParametrosParaCalculoWrapper parametro) {

		return parametro.getDistanciaPavimentada().getValor();
	}

	@Override
	protected boolean validar(ParametrosParaCalculoWrapper parametro) {

		return parametro.temQuantidadeDeQuilometrosPavimentadosInformada();
	}
}
