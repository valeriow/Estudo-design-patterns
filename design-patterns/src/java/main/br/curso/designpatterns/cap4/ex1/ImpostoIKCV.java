package br.curso.designpatterns.cap4.ex1;

import br.curso.designpatterns.Orcamento;
import br.curso.designpatterns.cap3.ex1.Item;

public class ImpostoIKCV extends TemplateImpostoCondicional {

	/* 
	 * Já o imposto IKCV, caso 
	 * o valor do orçamento seja maior que 500,00 
	 * 	e algum item tiver valor superior a 100,00, 
	 * o imposto a ser cobrado é de 10%; caso contrário 6%.
	 */

	
	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor()*0.06;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor()*0.1;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return ( orcamento.getValor()>500.0 && algumItemComValorSuperiorA(100.0,orcamento) );
	}

	private boolean algumItemComValorSuperiorA(double valor, Orcamento orcamento) {
		for (Item i : orcamento.getItens()){
			if (i.getValor()>valor)
				return true;
		}
		return false;
	}

}
