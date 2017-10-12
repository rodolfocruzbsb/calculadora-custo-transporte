package br.com.rscruz.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;
import br.com.rscruz.model.TipoDeVia;
import br.com.rscruz.model.Veiculo;
import br.com.rscruz.negocio.CalculadoraDeCustosService;
import br.com.rscruz.negocio.VeiculoService;

/**
 * <p>
 * <b>Title:</b> CalculadoraDeCustosController.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Controlador principal da aplicação
 * </p>
 * 
 * 
 * @author Rodolfo Cruz - rodolfocruz.ti@gmail.com
 * 
 * @version 1.0.0
 */
@Controller
@RequestMapping("/calculadora")
public class CalculadoraDeCustosController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CalculadoraDeCustosController.class);

	@Autowired
	private CalculadoraDeCustosService calculadoraDeCustosService;

	@Autowired
	private VeiculoService veiculoService;

	@GetMapping({ "", "/" })
	public ModelAndView home() {

		final ParametrosParaCalculoWrapper parametrosParaCalculo = new ParametrosParaCalculoWrapper();

		return new ModelAndView("calculo/home", "parametrosDeCalculo", parametrosParaCalculo);
	}

	@PostMapping("/calcular")
	public String calcular(@ModelAttribute("parametrosDeCalculo") ParametrosParaCalculoWrapper parametro, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		try {
			calculadoraDeCustosService.calcular(parametro);
			redirectAttributes.addFlashAttribute("sucesso", "Calculo realizado com sucesso.");
		} catch (Exception e) {
			LOGGER.error("Erro ao realizar calculo.", e);
			redirectAttributes.addFlashAttribute("erro", "Problema ao realizar o calculo. Motivo: "+ e.getMessage());
		}
		return "redirect:/calculadora/";
	}

	@ModelAttribute("veiculos")
	public Set<Veiculo> listaDeVeiculo() {

		return veiculoService.buscarTodos();
	}
	
	@ModelAttribute("tiposDeVia")
	public TipoDeVia[] listaDeTipoDeVia() {
		
		return TipoDeVia.values();
	}
}
