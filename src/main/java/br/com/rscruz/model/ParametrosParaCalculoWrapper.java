package br.com.rscruz.model;

import org.springframework.util.ObjectUtils;

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

	private final Distancia distanciaPavimentada = Distancia.novaPavimentada();

	private final Distancia distanciaNaoPavimentada = Distancia.novaNaoPavimentada();

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
	 * Retorna o valor do atributo <code>distanciaNaoPavimentada</code>
	 *
	 * @return <code>Distancia</code>
	 */
	public Distancia getDistanciaNaoPavimentada() {

		return distanciaNaoPavimentada;
	}

	/**
	 * Método responsável por verificar se o objeto em questao tem os parametros minimos para o calculo
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	public boolean temParametrosMinimos() {

		return temPeloMenosUmaDistanciaInformada()

				&& this.getToneladas() > 0

				&& !ObjectUtils.isEmpty(this.getVeiculo());

	}

	/**
	 * Método responsável por verificar se tem pelo menos uma distância informada
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	public boolean temPeloMenosUmaDistanciaInformada() {

		return temQuantidadeDeQuilometrosInformada(this.getDistanciaPavimentada()) || temQuantidadeDeQuilometrosInformada(this.getDistanciaNaoPavimentada());
	}

	/**
	 * Método responsável por verificar se tem dados informado na distância
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param distancia
	 * @return
	 */
	private boolean temQuantidadeDeQuilometrosInformada(Distancia distancia) {

		return !ObjectUtils.isEmpty(distancia) && distancia.getQuantidadeDeQuilometros() > 0;
	}
	
	public boolean temQuantidadeDeQuilometrosPavimentadosInformada() {

		return !ObjectUtils.isEmpty(this.getDistanciaPavimentada()) && this.getDistanciaPavimentada().getQuantidadeDeQuilometros() > 0;
	}
	
	public boolean temQuantidadeDeQuilometrosNaoPavimentadosInformada() {

		return !ObjectUtils.isEmpty(this.getDistanciaNaoPavimentada()) && this.getDistanciaNaoPavimentada().getQuantidadeDeQuilometros() > 0;
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
