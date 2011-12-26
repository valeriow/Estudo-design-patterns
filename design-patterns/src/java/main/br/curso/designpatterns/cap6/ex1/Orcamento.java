package br.curso.designpatterns.cap6.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.curso.designpatterns.cap3.ex1.Item;

public class Orcamento {
	
	protected EstadoDeUmOrcamento estadoAtual;
	protected double valor;
	protected boolean descontoAplicado = false; 
	private final List<Item> itens;

	public void adicionaItem(Item item){
		itens.add(item);
	}
	public List<Item> getItens() {
		return Collections.unmodifiableList(itens) ;
	}

	public Orcamento(){
		this.itens = new ArrayList<Item>();
		this.estadoAtual = new EmAprovacao();
	}
	public Orcamento (double valor){
		this();
		this.valor = valor;
	}

	public void aplicaDescontoExtra() {
		if (this.descontoAplicado)
			throw new RuntimeException("Já foi aplicado um desconto. Não é possível novo desconto");
		else
			estadoAtual.aplicaDescontoExtra(this);
	}
	
	 public void aprova() {
		    estadoAtual.aprova(this);
	 }
		   
	  public void reprova() {
	    estadoAtual.reprova(this);
	  }
	   
	  public void finaliza() {
	    estadoAtual.finaliza(this);
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
