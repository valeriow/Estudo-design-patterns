package br.curso.designpatterns.cap3.ex1;

import br.curso.designpatterns.Orcamento;
import br.curso.designpatterns.cap3.ex2.DescontoPorVendaCasada;

public class CalculadorDeDesconto {
	
	public double calcula(Orcamento orcamento){
		Desconto d1 = new DescontoPorCincoItens();
		Desconto d2 = new DescontoPorMaisDe500Reais();
		Desconto d3 = new DescontoPorVendaCasada();
		Desconto d4 = new SemDesconto();
		
		d1.setProximo(d2);
		d2.setProximo(d3);
		d3.setProximo(d4);
		
		return d1.desconto(orcamento);
	}
}
