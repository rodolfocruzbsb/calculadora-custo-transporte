package br.com.rscruz.negocio.calculo;

import java.util.ArrayList;
import java.util.List;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public final class MotorDeCalculo {

	private ParametrosParaCalculoWrapper parametrosParaCalculo;

	private List<RegraDeCalculo> regras = new ArrayList<>();

	public MotorDeCalculo( ParametrosParaCalculoWrapper parametrosParaCalculo ) {

		super();
		this.parametrosParaCalculo = parametrosParaCalculo;
	}

	public void adicionar(RegraDeCalculo regra) {

		this.regras.add(regra);
	}

	public double calcular() {
		
		return this.regras.stream().mapToDouble(r -> r.calcular(parametrosParaCalculo)).sum();
	}
}
