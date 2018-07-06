package br.com.rscruz.negocio;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.rscruz.model.Veiculo;

@Service("veiculoService")
public class VeiculoServiceImpl implements VeiculoService {

	private static Set<Veiculo> veiculoRepository = new HashSet<Veiculo>();

	static {
		veiculoRepository.add(Veiculo.novoCom(1l, "Caminhão baú", 1.00));
		veiculoRepository.add(Veiculo.novoCom(2l, "Caminhão caçamba", 1.05));
		veiculoRepository.add(Veiculo.novoCom(3l, "Carreta", 1.12));
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.negocio.VeiculoService#buscarTodos()
	 */
	@Override
	public Set<Veiculo> buscarTodos() {

		return veiculoRepository;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.rscruz.negocio.VeiculoService#buscarPorId(java.lang.Long)
	 */
	@Override
	public Optional<Veiculo> buscarPorId(Long id) {

		return veiculoRepository.stream()

				.filter(v -> v.getId().equals(id))

				.findFirst();
	}

}
