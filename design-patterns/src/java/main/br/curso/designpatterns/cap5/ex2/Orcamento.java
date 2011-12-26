package br.curso.designpatterns.cap5.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.curso.designpatterns.cap3.ex1.Item;

public class Orcamento {
	private final double valor;
	private final List<Item> itens;

	public void adicionaItem(Item item){
		itens.add(item);
	}
	public List<Item> getItens() {
		return Collections.unmodifiableList(itens) ;
	}

	public Orcamento (double valor){
		this.valor = valor;
		this.itens = new ArrayList<Item>();
		
	}

	public double getValor() {
		return valor;
	}
	
	public boolean existeItem(String nomeDoItem){ 
		for (Item item : getItens()){
			if ( item.getNome().equals(nomeDoItem) )
				return true;
		}
		return false;
	}
	
}
