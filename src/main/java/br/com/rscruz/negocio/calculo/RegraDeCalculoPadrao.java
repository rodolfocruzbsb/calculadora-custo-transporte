package br.com.rscruz.negocio.calculo;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

/**
 * <p>
 * <b>Title:</b> RegraDeCalculoPadrao.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Representa uma regra padrao para inicialização do Decorador. NullObject
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public class RegraDeCalculoPadrao extends RegraDeCalculo {

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param parametro
	 */
	public RegraDeCalculoPadrao( ParametrosParaCalculoWrapper parametro ) {

		this.parametro = parametro;

	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.negocio.calculo.RegraDeCalculo#getCusto()
	 */
	@Override
	public double getCusto() {

		return 0;
	}

}
