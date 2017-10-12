package br.com.rscruz.model.utils;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;
import br.com.rscruz.model.Veiculo;

/**
 * <p>
 * <b>Title:</b> ParametrosParaCalculoWrapperBuilder.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Builder apra facilitar principalmente os testes unitários
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public class ParametrosParaCalculoWrapperBuilder {

	private ParametrosParaCalculoWrapper resultado;

	private ParametrosParaCalculoWrapperBuilder() {

		this.resultado = new ParametrosParaCalculoWrapper();
	}

	public static ParametrosParaCalculoWrapperBuilder criar() {

		return new ParametrosParaCalculoWrapperBuilder();
	}

	public ParametrosParaCalculoWrapperBuilder comVeiculo(Veiculo veiculo) {

		this.resultado.setVeiculo(veiculo);
		return this;
	}

	public ParametrosParaCalculoWrapperBuilder comToneladas(int toneladas) {

		this.resultado.setToneladas(toneladas);
		return this;
	}

	public ParametrosParaCalculoWrapperBuilder comDistanciaPavimentada(double quilometros) {

		this.resultado.getDistanciaPavimentada().setQuantidadeDeQuilometros(quilometros);
		return this;
	}

	public ParametrosParaCalculoWrapperBuilder comDistanciaNaoPavimentada(double quilometros) {

		this.resultado.getDistanciaNaoPavimentada().setQuantidadeDeQuilometros(quilometros);
		return this;
	}

	public ParametrosParaCalculoWrapper controi() {

		return this.resultado;
	}
}
