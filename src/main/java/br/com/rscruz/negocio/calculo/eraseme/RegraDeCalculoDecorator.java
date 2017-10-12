package br.com.rscruz.negocio.calculo.eraseme;

import br.com.rscruz.negocio.calculo.RegraDeCalculo;

public abstract class RegraDeCalculoDecorator extends RegraDeCalculo {

	private RegraDeCalculo regra;

	public RegraDeCalculoDecorator( RegraDeCalculo regra ) {

		this.regra = regra;
	}

	/**
	 * Retorna o valor do atributo <code>regra</code>
	 *
	 * @return <code>RegraDeCalculo</code>
	 */
	public RegraDeCalculo getRegra() {

		return regra;
	}

}
