package br.com.rscruz.negocio;

import java.util.HashMap;
import java.util.Map;

import br.com.rscruz.model.ParametrosParaCalculoWrapper;
import br.com.rscruz.model.Veiculo;
import br.com.rscruz.model.utils.ParametrosParaCalculoWrapperBuilder;

public class CriadorDeObjetosParaCenariosDeTeste {

	public static Map<Integer, ParametrosParaCalculoWrapper> obterCenarios(VeiculoService veiculoService) {

		final Veiculo bau = veiculoService.buscarPorId(1l).get();

		final Veiculo cacamba = veiculoService.buscarPorId(2l).get();

		final Veiculo carreta = veiculoService.buscarPorId(3l).get();

		final Map<Integer, ParametrosParaCalculoWrapper> cenarios = new HashMap<>();

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

		cenarios.put(6, ParametrosParaCalculoWrapperBuilder.criar()

				.controi());
		
		cenarios.put(7, ParametrosParaCalculoWrapperBuilder.criar()

				.comVeiculo(cacamba)

				.comToneladas(5)

				.controi());
		
		cenarios.put(8, ParametrosParaCalculoWrapperBuilder.criar()

				.comDistanciaPavimentada(50)

				.comDistanciaNaoPavimentada(30)

				.comToneladas(5)

				.controi());
		
		cenarios.put(9, ParametrosParaCalculoWrapperBuilder.criar()

				.comDistanciaPavimentada(50)

				.comDistanciaNaoPavimentada(30)

				.comVeiculo(cacamba)

				.controi());
		
		cenarios.put(10, ParametrosParaCalculoWrapperBuilder.criar()

				.comDistanciaPavimentada(-1)

				.comDistanciaNaoPavimentada(-2)

				.comVeiculo(cacamba)

				.comToneladas(5)

				.controi());
		
		cenarios.put(11, ParametrosParaCalculoWrapperBuilder.criar()
				
				.comDistanciaPavimentada(0)
				
				.comDistanciaNaoPavimentada(0)
				
				.comVeiculo(cacamba)
				
				.comToneladas(5)
				
				.controi());
		
		cenarios.put(12, ParametrosParaCalculoWrapperBuilder.criar()
				
				.comDistanciaPavimentada(10)
				
				.comDistanciaNaoPavimentada(20)
				
				.comVeiculo(cacamba)
				
				.comToneladas(-1)
				
				.controi());

		return cenarios;
	}
}
