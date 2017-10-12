package br.com.rscruz.negocio;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.rscruz.model.Distancia;
import br.com.rscruz.model.ParametrosParaCalculoWrapper;

/**
 * <p>
 * <b>Title:</b> CalculadoraDeCustosServiceImpl.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Implementação das regras de calculo de custos de transporte
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
@Service("calculadoraDeCustosService")
public class CalculadoraDeCustosServiceImpl implements CalculadoraDeCustosService {

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.negocio.CalculadoraDeCustosService#calcular(br.com.rscruz.model.ParametrosParaCalculoWrapper)
	 */
	@Override
	public double calcular(ParametrosParaCalculoWrapper parametrosParaCalculo) {

		this.validarParametro(parametrosParaCalculo);
		return 62.7;
	}

	/**
	 * Método responsável por validar dados de entrada para o calculo
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param parametrosParaCalculo
	 */
	private void validarParametro(ParametrosParaCalculoWrapper parametrosParaCalculo) {

		if (parametrosParaCalculo == null

				|| (!temQuantidadeDeQuilometrosInformada(parametrosParaCalculo.getDistanciaPavimentada()) && !temQuantidadeDeQuilometrosInformada(parametrosParaCalculo.getDistanciaNaoPavimentada()))

				|| parametrosParaCalculo.getToneladas() <= 0

				|| ObjectUtils.isEmpty(parametrosParaCalculo.getVeiculo())) {

			throw new IllegalArgumentException("Parâmetro não está preenchido com os valores esperados.");
		}

	}

	private boolean temQuantidadeDeQuilometrosInformada(Distancia distancia) {

		return !ObjectUtils.isEmpty(distancia) && distancia.getQuantidadeDeQuilometros() > 0;
	}

}
