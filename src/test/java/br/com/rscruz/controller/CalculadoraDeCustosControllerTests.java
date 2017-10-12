package br.com.rscruz.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.rscruz.configuracoes.CalculadoraCustoTransporteApplicationTests;
import br.com.rscruz.model.ParametrosParaCalculoWrapper;
import br.com.rscruz.model.Veiculo;
import br.com.rscruz.model.utils.ParametrosParaCalculoWrapperBuilder;
import br.com.rscruz.negocio.VeiculoService;

/**
 * <p>
 * <b>Title:</b> CalculadoraDeCustosServiceTests.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Suite de testes para o controlador CalculadoraDeCustosController
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
public class CalculadoraDeCustosControllerTests extends CalculadoraCustoTransporteApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private CalculadoraDeCustosController calculadoraDeCustosController;

	@Autowired
	private VeiculoService veiculoService;

	private ParametrosParaCalculoWrapper parametro;

	@Before
	public void setUp() throws Exception {

		this.mockMvc = MockMvcBuilders.standaloneSetup(this.calculadoraDeCustosController).build();

		final Veiculo bau = this.veiculoService.buscarPorId(1l).get();

		this.parametro = ParametrosParaCalculoWrapperBuilder.criar()

				.comDistanciaPavimentada(80)

				.comDistanciaNaoPavimentada(20)

				.comVeiculo(bau)

				.comToneladas(6)

				.controi();

	}

	@Test
	public void testaRequisicaoViaGETDaPaginaInicial() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/calculadora")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testaRequisicaoViaPOSTcomEntradaValida() throws Exception {

		this.mockMvc.perform(

				MockMvcRequestBuilders.post("/calculadora/calcular")

						.param("toneladas", String.valueOf(this.parametro.getToneladas()))

						.param("veiculo.id", String.valueOf(this.parametro.getVeiculo().getId()))

						.param("distanciaPavimentada.quantidadeDeQuilometros", String.valueOf(this.parametro.getDistanciaPavimentada().getQuantidadeDeQuilometros()))

						.param("distanciaNaoPavimentada.quantidadeDeQuilometros", String.valueOf(this.parametro.getDistanciaNaoPavimentada().getQuantidadeDeQuilometros()))

		).andExpect(MockMvcResultMatchers.model().attributeExists("sucesso"));
	}

	@Test
	public void testaRequisicaoViaPOSTComErroNosDadosDeEntrada() throws Exception {

		this.mockMvc.perform(

				MockMvcRequestBuilders.post("/calculadora/calcular")

		).andExpect(MockMvcResultMatchers.redirectedUrl("/calculadora/")).andExpect(MockMvcResultMatchers.flash().attributeExists("erro"));
	}

}
