package br.curso.designpatterns.cap5.ex3;


public abstract class TemplateImpostoCondicional extends Imposto {
	
	public TemplateImpostoCondicional(Imposto outroImposto) {
		super(outroImposto);
	}

	public TemplateImpostoCondicional() {
	}
	
	public final double calcula(Orcamento orcamento) {
	      
	      if(deveUsarMaximaTaxacao(orcamento)) {
	        return maximaTaxacao(orcamento) + calculaOutroImposto(orcamento);
	      } else {
	        return minimaTaxacao(orcamento) + calculaOutroImposto(orcamento);
	      }
	       
	 }

	public abstract double minimaTaxacao(Orcamento orcamento);

	public abstract double maximaTaxacao(Orcamento orcamento);

	public abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento); 
	          
}
