package br.curso.designpatterns.cap2.ex4;

public class InvestimentoModerado implements Investimento {

	public double resultado (double investimento){
		return resultado(investimento, new java.util.Random().nextDouble());	
	}
	
	public double resultado(double investimento, double chance ) {
		//"MODERADO", que tem 50% de chances de retornar 2.5%
		// e 50% de chances de retornar 0.7%;
		double taxa = 0.0;
		if (chance>0.5) taxa = 0.007;
		else taxa = 0.025;
		return investimento*taxa;
	}

}
