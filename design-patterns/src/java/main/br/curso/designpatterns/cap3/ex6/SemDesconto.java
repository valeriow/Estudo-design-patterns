package br.curso.designpatterns.cap3.ex6;

import br.curso.designpatterns.Orcamento;

public class SemDesconto implements Desconto{

	public double desconto(Orcamento orcamento) {
		return 0;
	}

	public void setProximo(Desconto proximo) {
		// não tem próx
		
	}

	public Desconto getProximo() {
		return null;
	}

}
