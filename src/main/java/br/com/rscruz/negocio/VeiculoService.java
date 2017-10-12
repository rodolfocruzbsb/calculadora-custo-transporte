package br.com.rscruz.negocio;

import java.util.Optional;
import java.util.Set;

import br.com.rscruz.model.Veiculo;

/**
 * <p>
 * <b>Title:</b> VeiculoService.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>Contrato para serviço de veículo
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public interface VeiculoService {

	/**
	 * Método responsável por recuperar todos os veículos
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @return
	 */
	Set<Veiculo> buscarTodos();

	/**
	 * Método responsável por buscar o veículo por ID
	 *
	 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
	 *
	 * @param id
	 * @return
	 */
	Optional<Veiculo> buscarPorId(Long id);

}
