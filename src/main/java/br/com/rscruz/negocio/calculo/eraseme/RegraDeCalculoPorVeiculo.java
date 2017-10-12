package br.com.rscruz.negocio.calculo.eraseme;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;
import br.com.rscruz.negocio.calculo.RegraDeCalculo;

public class RegraDeCalculoPorVeiculo extends RegraDeCalculoDecorator {

	public RegraDeCalculoPorVeiculo( RegraDeCalculo regra ) {

		super(regra);
	}

	@Override
	protected double aplicarRegra(ParametrosParaCalculoWrapper parametro) {

		return parametro.getVeiculo().getFatorMultiplicador() * getRegra().calcular(parametro);
	}

}
