package br.com.rscruz.model;

/**
 * <p>
 * <b>Title:</b> ParametrosParaCalculoWrapper.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Wrapper paar input de valores para o calculo
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public class ParametrosParaCalculoWrapper {

	private Veiculo veiculo;

	private int toneladas;

	private Distancia distanciaPavimentada = Distancia.novaPavimentada();

	private Distancia distanciaNaoPavimentada = Distancia.novaNaoPavimentada();

	public ParametrosParaCalculoWrapper() {

	}

	/**
	 * Retorna o valor do atributo <code>veiculo</code>
	 *
	 * @return <code>Veiculo</code>
	 */
	public Veiculo getVeiculo() {

		return veiculo;
	}

	/**
	 * Define o valor do atributo <code>veiculo</code>.
	 *
	 * @param veiculo
	 */
	public void setVeiculo(Veiculo veiculo) {

		this.veiculo = veiculo;
	}

	/**
	 * Retorna o valor do atributo <code>toneladas</code>
	 *
	 * @return <code>int</code>
	 */
	public int getToneladas() {

		return toneladas;
	}

	/**
	 * Define o valor do atributo <code>toneladas</code>.
	 *
	 * @param toneladas
	 */
	public void setToneladas(int toneladas) {

		this.toneladas = toneladas;
	}

	/**
	 * Retorna o valor do atributo <code>distanciaPavimentada</code>
	 *
	 * @return <code>Distancia</code>
	 */
	public Distancia getDistanciaPavimentada() {

		return distanciaPavimentada;
	}

	/**
	 * Define o valor do atributo <code>distanciaPavimentada</code>.
	 *
	 * @param distanciaPavimentada
	 */
	public void setDistanciaPavimentada(Distancia distanciaPavimentada) {

		this.distanciaPavimentada = distanciaPavimentada;
	}

	/**
	 * Retorna o valor do atributo <code>distanciaNaoPavimentada</code>
	 *
	 * @return <code>Distancia</code>
	 */
	public Distancia getDistanciaNaoPavimentada() {

		return distanciaNaoPavimentada;
	}

	/**
	 * Define o valor do atributo <code>distanciaNaoPavimentada</code>.
	 *
	 * @param distanciaNaoPavimentada
	 */
	public void setDistanciaNaoPavimentada(Distancia distanciaNaoPavimentada) {

		this.distanciaNaoPavimentada = distanciaNaoPavimentada;
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

		return "ParametrosParaCalculoWrapper [veiculo=" + veiculo + ", toneladas=" + toneladas + ", distanciaPavimentada=" + distanciaPavimentada + ", distanciaNaoPavimentada=" + distanciaNaoPavimentada + "]";
	}

}
