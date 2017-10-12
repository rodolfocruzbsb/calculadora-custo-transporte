package br.com.rscruz.negocio.calculo;

import org.springframework.util.ObjectUtils;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public class RegraDeCalculoPorTipoDeVeiculo extends RegraDeCalculoDecorator {

	public RegraDeCalculoPorTipoDeVeiculo( RegraDeCalculo regra ) {

		this.regra = regra;

		this.parametro = this.regra.parametro;

	}

	@Override
	protected boolean validar(ParametrosParaCalculoWrapper parametro) {

		return !ObjectUtils.isEmpty(parametro.getVeiculo());
	}

	@Override
	public double getCusto() {

		return this.parametro.getVeiculo().getFatorMultiplicador() * this.regra.getCusto();
	}
}
