package br.com.rscruz.negocio.calculo.eraseme;

public abstract class RegarDeCalculo {

	double valorAcumulado;

	public double getValor() {

		return this.valorAcumulado;
	}

	public abstract double calcular();
}
