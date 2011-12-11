package br.curso.designpatterns.cap4.ex3;

import br.curso.designpatterns.Orcamento;
import br.curso.designpatterns.cap3.ex1.Item;
import br.curso.designpatterns.cap4.ex1.TemplateImpostoCondicional;

public class ImpostoIHIT extends TemplateImpostoCondicional{
	/*
	 *O imposto IHIT  tem a seguinte regra:
	 * caso existam 2 ítens com o mesmo nome:
	 * 	 o imposto deve ser de 13% mais R$100,00.
	 * Caso contrário:
	 * 	 o valor do imposto deverá ser (1% * o número de ítens no orçamento).
	*/
	
	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor()*(0.01*orcamento.getItens().size());
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor()*0.13+100.0;
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return ( existemDoisItemComMesmoNome(orcamento) );
	}
	
	public int quantidadeItemComNome(String nome, Orcamento orcamento){
		int i = 0;
		for (Item item : orcamento.getItens()){
			if ( item.getNome().equals(nome) )
				i++;
		}
		return i;
	}

	public boolean existemDoisItemComMesmoNome(Orcamento orcamento) {
		for (Item item : orcamento.getItens()){
			if ( quantidadeItemComNome(item.getNome(), orcamento) > 1 ){
				return true;
			}
		}
		return false;
	}
		

}
