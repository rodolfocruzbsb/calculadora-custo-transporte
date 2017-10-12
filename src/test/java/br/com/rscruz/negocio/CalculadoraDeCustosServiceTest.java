package br.com.rscruz.negocio;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.rscruz.configuracoes.CalculadoraCustoTransporteApplicationTests;
import br.com.rscruz.model.ParametrosParaCalculoWrapper;
import br.com.rscruz.model.Veiculo;
import br.com.rscruz.model.utils.ParametrosParaCalculoWrapperBuilder;

public class CalculadoraDeCustosServiceTest extends CalculadoraCustoTransporteApplicationTests {

	@Autowired
	private CalculadoraDeCustosService service;

	@Autowired
	private VeiculoService veiculoService;

	private Map<Integer, ParametrosParaCalculoWrapper> cenarios = new HashMap<>();

	@Before
	public void setUp() {

		final Veiculo bau = veiculoService.buscarPorId(1l).get();

		final Veiculo cacamba = veiculoService.buscarPorId(2l).get();

		final Veiculo carreta = veiculoService.buscarPorId(3l).get();

		cenarios.put(1, ParametrosParaCalculoWrapperBuilder.criar()

				.comDistanciaPavimentada(100)

				.comDistanciaNaoPavimentada(0)

				.comVeiculo(cacamba)

				.comToneladas(8)

				.controi());

		cenarios.put(2, ParametrosParaCalculoWrapperBuilder.criar()

				.comDistanciaPavimentada(0)

				.comDistanciaNaoPavimentada(60)

				.comVeiculo(bau)

				.comToneladas(4)

				.controi());

		cenarios.put(3, ParametrosParaCalculoWrapperBuilder.criar()
				
				.comDistanciaPavimentada(0)
				
				.comDistanciaNaoPavimentada(180)
				
				.comVeiculo(carreta)
				
				.comToneladas(12)
				
				.controi());

		cenarios.put(4, ParametrosParaCalculoWrapperBuilder.criar()
				
				.comDistanciaPavimentada(80)
				
				.comDistanciaNaoPavimentada(20)
				
				.comVeiculo(bau)
				
				.comToneladas(6)
				
				.controi());

		cenarios.put(5, ParametrosParaCalculoWrapperBuilder.criar()
				
				.comDistanciaPavimentada(50)
				
				.comDistanciaNaoPavimentada(30)
				
				.comVeiculo(cacamba)
				
				.comToneladas(5)
				
				.controi());

		
	}

	@Test
	public void testarResultadoComDistanciaPavimentadaEmCacambaComOitoToneladas() {

		assertThat(service.calcular(cenarios.get(1)))

				.isEqualTo(62.70);
	}
}
