package br.curso.designpatterns.cap3.ex6;

import br.curso.designpatterns.Orcamento;

public class SemDesconto implements Desconto{

	public double desconto(Orcamento orcamento) {
		return 0;
	}

	public void setProximo(Desconto proximo) {
		// n�o tem pr�x
		
	}

	public Desconto getProximo() {
		return null;
	}

}
