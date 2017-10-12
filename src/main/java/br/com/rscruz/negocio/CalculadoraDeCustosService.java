package br.com.rscruz.negocio;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;

/**
 * <p>
 * <b>Title:</b> CalculadoraDeCustosService.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>Contrato para calculo de custos de serviços
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public interface CalculadoraDeCustosService {

	/**
	 * Método responsável por realziar o calculo do custo do transporte baseado nos parametros de entrada
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param parametrosParaCalculo
	 * @return
	 */
	double calcular(ParametrosParaCalculoWrapper parametrosParaCalculo);

}
