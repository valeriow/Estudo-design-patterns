package br.curso.designpatterns.cap3.ex6;

import br.curso.designpatterns.Orcamento;

public class CalculadorDeDesconto {
	
	public double calcula(Orcamento orcamento){
		Desconto d1 = new DescontoPorCincoItens();
		Desconto d2 = new DescontoPorMaisDe500Reais();
		Desconto d3 = new DescontoPorVendaCasada();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		
		return d1.desconto(orcamento);
	}
}
