package br.curso.designpatterns.cap3.ex6;

import br.curso.designpatterns.Orcamento;


public class DescontoPorVendaCasada implements Desconto {

	
	private Desconto proximo;
	
	public Desconto getProximo() {
		if (this.proximo == null){
			return new SemDesconto();
		}else{
			return this.proximo;
		}
		
	}

	public double desconto(Orcamento orcamento) {
		
		if ( orcamento.existeItem("LAPIS") && orcamento.existeItem("CANETA") ){
			return orcamento.getValor()*0.05;
		}else{
			return getProximo().desconto(orcamento);
		}	
	}

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
