package br.curso.designpatterns;

public class IR implements Imposto {

	public double calcula(Orcamento orcamento) {
		return orcamento.getValor()*0.25;
	}

}
