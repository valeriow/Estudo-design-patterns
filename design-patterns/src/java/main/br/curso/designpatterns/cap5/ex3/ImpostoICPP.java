package br.curso.designpatterns.cap5.ex3;

public class ImpostoICPP extends TemplateImpostoCondicional {
	/* O imposto ICPP � calculado da seguinte forma: 
	 * caso o valor do or�amento seja menor que 500,00, deve-se cobrar 5%; 
	 * caso contr�rio, 7%.
	 */
	 
	public ImpostoICPP(Imposto outroImposto){
		super(outroImposto);
	}
	
	public ImpostoICPP(){}
	
	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor()*0.05;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor()*0.07;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return (orcamento.getValor()>=500.0);
	}

}
