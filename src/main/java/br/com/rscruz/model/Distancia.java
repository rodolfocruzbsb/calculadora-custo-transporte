package br.com.rscruz.model;

/**
 * <p>
 * <b>Title:</b> Distancia.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Representa uma distância
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public class Distancia {

	private double quantidadeDeQuilometros;

	private TipoDeVia tipoDeVia;

	public Distancia() {

	}

	private Distancia( TipoDeVia tipoDeVia ) {

		this.tipoDeVia = tipoDeVia;

	}

	private Distancia( double quantidadeDeQuilometros, TipoDeVia tipoDeVia ) {

		this.quantidadeDeQuilometros = quantidadeDeQuilometros;
		this.tipoDeVia = tipoDeVia;
	}

	/**
	 * Método responsável por fabricar Distancias
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param quantidadeDeQuilometros
	 * @param tipoDeVia
	 * @return
	 */
	public static Distancia novaCom(double quantidadeDeQuilometros, TipoDeVia tipoDeVia) {

		return new Distancia(quantidadeDeQuilometros, tipoDeVia);
	}

	/**
	 * <p>
	 * Método responsável por fabricar distância <b>Pavimentada</b>
	 * </p>
	 * 
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param quantidadeDeQuilometros
	 * @return
	 * 
	 * @see br.com.rscruz.model.TipoDeVia#PAVIMENTADA
	 */
	public static Distancia novaPavimentadaCom(double quantidadeDeQuilometros) {

		return new Distancia(quantidadeDeQuilometros, TipoDeVia.PAVIMENTADA);
	}

	/**
	 * <p>
	 * Método responsável por fabricar distância <b>Pavimentada</b>
	 * </p>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	public static Distancia novaPavimentada() {

		return new Distancia(TipoDeVia.PAVIMENTADA);
	}

	/**
	 * <p>
	 * Método responsável por fabricar distância <b>Não Pavimentada</b></pp>
	 * 
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param quantidadeDeQuilometros
	 * @return
	 * 
	 * @see br.com.rscruz.model.TipoDeVia#NAO_PAVIMENTADA
	 */
	public static Distancia novaNaoPavimentadaCom(double quantidadeDeQuilometros) {

		return new Distancia(quantidadeDeQuilometros, TipoDeVia.NAO_PAVIMENTADA);
	}

	/**
	 * <p>
	 * Método responsável por fabricar distância <b>Não Pavimentada</b>
	 * </p>
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	public static Distancia novaNaoPavimentada() {

		return new Distancia(TipoDeVia.NAO_PAVIMENTADA);
	}

	/**
	 * Retorna o valor do atributo <code>quantidadeDeQuilometros</code>
	 *
	 * @return <code>double</code>
	 */
	public double getQuantidadeDeQuilometros() {

		return quantidadeDeQuilometros;
	}

	/**
	 * Define o valor do atributo <code>quantidadeDeQuilometros</code>.
	 *
	 * @param quantidadeDeQuilometros
	 */
	public void setQuantidadeDeQuilometros(double quantidadeDeQuilometros) {

		this.quantidadeDeQuilometros = quantidadeDeQuilometros;
	}

	/**
	 * Retorna o valor do atributo <code>tipoDeVia</code>
	 *
	 * @return <code>TipoDeVia</code>
	 */
	public TipoDeVia getTipoDeVia() {

		return tipoDeVia;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "Distancia [quantidadeDeQuilometros=" + quantidadeDeQuilometros + ", tipoDeVia=" + tipoDeVia + "]";
	}

}
