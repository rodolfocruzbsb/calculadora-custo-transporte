package br.com.rscruz.model.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.rscruz.configuracoes.CalculadoraCustoTransporteApplicationTests;
import br.com.rscruz.model.ParametrosParaCalculoWrapper;
import br.com.rscruz.model.TipoDeVia;
import br.com.rscruz.model.Veiculo;
import br.com.rscruz.negocio.VeiculoService;

public class ParametrosParaCalculoWrapperBuilderTest extends CalculadoraCustoTransporteApplicationTests {

	@Autowired
	private VeiculoService veiculoService;

	private ParametrosParaCalculoWrapper cenarioUm;

	private Veiculo carreta;

	@Before
	public void setUp() throws Exception {

		carreta = this.veiculoService.buscarPorId(3l).orElse(null);

		cenarioUm = ParametrosParaCalculoWrapperBuilder.criar()

				.comDistanciaNaoPavimentada(100.10)

				.comDistanciaPavimentada(200.20)

				.comToneladas(300)

				.comVeiculo(carreta)

				.controi();
	}

	@Test
	public void testarConstrucaoDeUmObjetoValido() {

		assertNotNull(cenarioUm.getDistanciaNaoPavimentada());
		assertNotNull(cenarioUm.getDistanciaPavimentada());
		assertEquals(TipoDeVia.NAO_PAVIMENTADA, cenarioUm.getDistanciaNaoPavimentada().getTipoDeVia());
		assertEquals(TipoDeVia.PAVIMENTADA, cenarioUm.getDistanciaPavimentada().getTipoDeVia());
		assertEquals(100.10, cenarioUm.getDistanciaNaoPavimentada().getQuantidadeDeQuilometros(), 0);
		assertEquals(200.20, cenarioUm.getDistanciaPavimentada().getQuantidadeDeQuilometros(), 0);
		assertEquals(300, cenarioUm.getToneladas());
		assertEquals(carreta, cenarioUm.getVeiculo());

	}

}
