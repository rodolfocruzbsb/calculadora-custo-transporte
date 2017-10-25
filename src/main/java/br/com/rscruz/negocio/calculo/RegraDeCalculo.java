package br.com.rscruz.negocio.calculo;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public abstract class RegraDeCalculo {

	protected ParametrosParaCalculoWrapper parametro;

	public abstract double getCusto();

	/**
	 * 
	 * Método responsável por realizar as validações específicas de cada regra
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param parametro
	 * @return
	 */
	protected boolean validar(ParametrosParaCalculoWrapper parametro) {

		return true;
	}

	/**
	 * Método responsável por organizar os passos para aplicação das regras de calculo
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param parametro
	 * @return
	 */
	public final double calcular() {

		double resultado = 0;

		aplicarValidacaoBasica(parametro);

		if (validar(parametro)) {

			resultado = getCusto();
		}

		return resultado;
	}

	/**
	 * Método responsável por aplicar uma validação básica para qualquer regra de calculo
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param parametro
	 */
	private void aplicarValidacaoBasica(ParametrosParaCalculoWrapper parametro) {

		if (parametro == null) {
			throw new IllegalStateException("Parametro está nulo");
		} else if (!parametro.temParametrosMinimos()) {
			throw new IllegalStateException("Os valores mínimos para realização do calculo não foram informados.");
		}

	}

}
