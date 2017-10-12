package br.com.rscruz.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;
import br.com.rscruz.negocio.calculo.MotorDeCalculo;
import br.com.rscruz.negocio.calculo.RegraDeCalculoPorPesoDaCarga;
import br.com.rscruz.negocio.calculo.RegraDeCalculoPorRodoviaNaoPavimentada;
import br.com.rscruz.negocio.calculo.RegraDeCalculoPorRodoviaPavimentada;

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

	@Autowired
	private VeiculoService veiculoService;

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

		this.carregarObjetos(parametrosParaCalculo);

		MotorDeCalculo motorDeCalculo = new MotorDeCalculo(parametrosParaCalculo);

		motorDeCalculo.adicionar(new RegraDeCalculoPorRodoviaPavimentada());
		
		motorDeCalculo.adicionar(new RegraDeCalculoPorRodoviaNaoPavimentada());

		motorDeCalculo.adicionar(new RegraDeCalculoPorPesoDaCarga());

		double resultado = motorDeCalculo.calcular();

		resultado *= parametrosParaCalculo.getVeiculo().getFatorMultiplicador();

		return resultado;
	}

	private void carregarObjetos(ParametrosParaCalculoWrapper parametrosParaCalculo) {

		parametrosParaCalculo.setVeiculo(veiculoService.buscarPorId(parametrosParaCalculo.getVeiculo().getId()).get());

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

				|| !parametrosParaCalculo.temParametrosMinimos()) {

			throw new IllegalArgumentException("Parâmetro não está preenchido com os valores esperados.");
		}

	}

}
