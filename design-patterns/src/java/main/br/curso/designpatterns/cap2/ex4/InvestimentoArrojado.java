package br.curso.designpatterns.cap2.ex4;

public class InvestimentoArrojado implements Investimento {

	public double resultado (double investimento){
		return resultado(investimento, new java.util.Random().nextDouble());	
	}
	
	public double resultado(double investimento, double chance ) {
		 /* 
		  * "ARROJADO", que tem 20% de chances de retornar 5%, 
		  * 30% de chances de retornar 3%,
		  * e 50% de chances de retornar 0.6%. 
		  */
		  
		double taxa = 0.0;
		if (chance<=0.2) taxa = 0.05;
		else
		if (chance<=0.3) taxa = 0.03;
		else taxa = 0.006;
		return investimento*taxa;
	}

}
