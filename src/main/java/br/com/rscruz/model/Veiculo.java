package br.com.rscruz.model;

/**
 * <p>
 * <b>Title:</b> Veiculo.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe que representa um veículo
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public class Veiculo {

	/** Atributo id. */
	private Long id;

	/** Atributo nome. */
	private String nome;

	/** Atributo fatorMultiplicador. */
	private double fatorMultiplicador;

	/**
	 * Responsável pela criação de novas instâncias desta classe.[Utilizado apenas pelo framework de teste]
	 */
	public Veiculo() {

	}

	private Veiculo( final Long id, final String nome, final double fatorMultiplicador ) {

		this.id = id;
		this.nome = nome;
		this.fatorMultiplicador = fatorMultiplicador;
	}

	/**
	 * Método responsável por fabricar veículos
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param nome
	 * @param fatorMultiplicador
	 * @return
	 */
	public static Veiculo novoCom(Long id, String nome, double fatorMultiplicador) {

		return new Veiculo(id, nome, fatorMultiplicador);
	}

	/**
	 * Retorna o valor do atributo <code>id</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getId() {

		return id;
	}

	/**
	 * Define o valor do atributo <code>id</code>.
	 *
	 * @param id
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * Retorna o valor do atributo <code>nome</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNome() {

		return this.nome;
	}

	/**
	 * Define o valor do atributo <code>nome</code>.
	 *
	 * @param nome
	 */
	public void setNome(final String nome) {

		this.nome = nome;
	}

	/**
	 * Retorna o valor do atributo <code>fatorMultiplicador</code>
	 *
	 * @return <code>double</code>
	 */
	public double getFatorMultiplicador() {

		return this.fatorMultiplicador;
	}

	/**
	 * Define o valor do atributo <code>fatorMultiplicador</code>.
	 *
	 * @param fatorMultiplicador
	 */
	public void setFatorMultiplicador(final double fatorMultiplicador) {

		this.fatorMultiplicador = fatorMultiplicador;
	}

	@Override
	public String toString() {

		return "Veiculo [nome=" + this.nome + ", fatorMultiplicador=" + this.fatorMultiplicador + "]";
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fatorMultiplicador);
		result = prime * result + (int) ( temp ^ ( temp >>> 32 ) );
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
		return result;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (Double.doubleToLongBits(fatorMultiplicador) != Double.doubleToLongBits(other.fatorMultiplicador))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
