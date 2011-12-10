package br.curso.designpatterns.cap3.ex6;

import br.curso.designpatterns.Orcamento;

public class DescontoPorCincoItens implements Desconto {
	private Desconto proximo;

	public double desconto(Orcamento orcamento){
		if (orcamento.getItens().size()>5){
			return orcamento.getValor()*0.1;
		}else{
			return getProximo().desconto(orcamento);
		}
	}

	public Desconto getProximo() {
		if (this.proximo == null){
			return new SemDesconto();
		}else{
			return this.proximo;
		}
		
	}
	
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}
}
