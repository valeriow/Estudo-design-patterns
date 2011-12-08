package br.curso.designpatterns;

public class CalculadordeImpostos {

	public double calculaImposto(Orcamento orcamento, Imposto imposto) {
		return imposto.calcula(orcamento);
	}

}
