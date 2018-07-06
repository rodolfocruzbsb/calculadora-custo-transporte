package br.com.rscruz.model;

/**
 * <p>
 * <b>Title:</b> TipoDeVia.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Enum para representar os tipos de Vias
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public enum TipoDeVia {
	/** Via PAVIMENTADA. */
	PAVIMENTADA(0.542),

	/** Via NAO_PAVIMENTADA. */
	NAO_PAVIMENTADA(0.62);

	private double valorPorQuilometro;

	private TipoDeVia( double valorPorQuilometro ) {

		this.valorPorQuilometro = valorPorQuilometro;

	}

	/**
	 * Método responsável por
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param quilometros
	 * @return
	 */
	public double getTotalPor(double quilometros) {

		return quilometros * valorPorQuilometro;
	}

	/**
	 * Retorna o valor do atributo <code>valorPorQuilometro</code>
	 *
	 * @return <code>double</code>
	 */
	public double getValorPorQuilometro() {

		return valorPorQuilometro;
	}

}
