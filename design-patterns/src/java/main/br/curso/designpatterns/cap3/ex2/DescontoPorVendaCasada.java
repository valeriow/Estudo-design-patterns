package br.curso.designpatterns.cap3.ex2;

import br.curso.designpatterns.Orcamento;
import br.curso.designpatterns.cap3.ex1.Desconto;


public class DescontoPorVendaCasada implements Desconto {

	
	private Desconto proximo;
	
	public double desconto(Orcamento orcamento) {
		
		if ( orcamento.existeItem("LAPIS") && orcamento.existeItem("CANETA") ){
			return orcamento.getValor()*0.05;
		}else{
			return proximo.desconto(orcamento);
		}	
	}

	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

}
