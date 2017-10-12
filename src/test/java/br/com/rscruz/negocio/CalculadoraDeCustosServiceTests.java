package br.com.rscruz.negocio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.rscruz.configuracoes.CalculadoraCustoTransporteApplicationTests;
import br.com.rscruz.model.ParametrosParaCalculoWrapper;

public class CalculadoraDeCustosServiceTests extends CalculadoraCustoTransporteApplicationTests {

	private static final double VALOR_PERMITIDO_PARA_IGNORAR_NO_ARREDONDAMENTO = 0.01;

	@Autowired
	private CalculadoraDeCustosService service;

	@Autowired
	private VeiculoService veiculoService;

	private Map<Integer, ParametrosParaCalculoWrapper> cenarios = new HashMap<>();

	@Before
	public void setUp() {

		cenarios.putAll(CriadorDeObjetosParaCenariosDeTeste.obterCenarios(veiculoService));
	}

	@Test
	public void testarResultadoComDistanciaPavimentadaEmCacambaComOitoToneladas() {

		assertThat(service.calcular(cenarios.get(1)))

				.isEqualTo(62.70, offset(VALOR_PERMITIDO_PARA_IGNORAR_NO_ARREDONDAMENTO));
	}

	@Test
	public void testarResultadoComDistanciaNaoPavimentadaEmBauComQuatroToneladas() {

		assertThat(service.calcular(cenarios.get(2)))

				.isEqualTo(37.2, offset(VALOR_PERMITIDO_PARA_IGNORAR_NO_ARREDONDAMENTO));
	}

	@Test
	public void testarResultadoComDistanciaNaoPavimentadaEmCarretaComDozeToneladas() {

		assertThat(service.calcular(cenarios.get(3)))

				.isEqualTo(150.19, offset(VALOR_PERMITIDO_PARA_IGNORAR_NO_ARREDONDAMENTO));
	}

	@Test
	public void testarResultadoComAmbasDistanciasEmBauComSeisToneladas() {

		assertThat(service.calcular(cenarios.get(4)))

				.isEqualTo(57.6, offset(VALOR_PERMITIDO_PARA_IGNORAR_NO_ARREDONDAMENTO));
	}

	@Test
	public void testarResultadoComAmbasDistanciasEmCacambaComCincoToneladas() {

		assertThat(service.calcular(cenarios.get(5)))

				.isEqualTo(47.88, offset(VALOR_PERMITIDO_PARA_IGNORAR_NO_ARREDONDAMENTO));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testarParametrosInvalidosQueDeveSerLancadaException() {

		service.calcular(cenarios.get(6));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testarParametrosInvalidosSemDistanciaQueDeveSerLancadaException() {

		service.calcular(cenarios.get(7));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testarParametrosInvalidosSemVeiculoQueDeveSerLancadaException() {

		service.calcular(cenarios.get(8));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testarParametrosInvalidosSemToneladaQueDeveSerLancadaException() {

		service.calcular(cenarios.get(9));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testarParametrosInvalidosComDistanciaNegativaQueDeveSerLancadaException() {

		service.calcular(cenarios.get(10));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testarParametrosInvalidosComDistanciaZeradaQueDeveSerLancadaException() {
		
		service.calcular(cenarios.get(11));
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testarParametrosInvalidosComToneladaNegativaQueDeveSerLancadaException() {

		service.calcular(cenarios.get(12));

	}
}
