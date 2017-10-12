package br.com.rscruz.negocio.calculo;

import org.springframework.util.ObjectUtils;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public class RegraDeCalculoPorTipoDeVeiculo extends RegraDeCalculo {

	@Override
	protected double aplicarRegra(ParametrosParaCalculoWrapper parametro) {

		
		return parametro.getVeiculo().getFatorMultiplicador()*1;
	}

	@Override
	protected boolean validar(ParametrosParaCalculoWrapper parametro) {

		return !ObjectUtils.isEmpty(parametro.getVeiculo());
	}
}
