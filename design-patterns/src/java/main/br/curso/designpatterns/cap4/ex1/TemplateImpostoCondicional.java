package br.curso.designpatterns.cap4.ex1;

import br.curso.designpatterns.Imposto;
import br.curso.designpatterns.Orcamento;

public abstract class TemplateImpostoCondicional implements Imposto {
	
	public double calcula(Orcamento orcamento) {
	      
	      if(deveUsarMaximaTaxacao(orcamento)) {
	        return maximaTaxacao(orcamento);
	      } else {
	        return minimaTaxacao(orcamento);
	      }
	       
	 }

	public abstract double minimaTaxacao(Orcamento orcamento);

	public abstract double maximaTaxacao(Orcamento orcamento);

	public abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento); 
	          
}
