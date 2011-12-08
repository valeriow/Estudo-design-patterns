package br.curso.designpatterns.cap2.ex4;

public class InvestimentoConservador implements Investimento {

	public double resultado(double investimento, double chance) {
		//"CONSERVADOR", que sempre retorna 0.8% do valor investido; 
		return investimento*0.08;
	}

}
