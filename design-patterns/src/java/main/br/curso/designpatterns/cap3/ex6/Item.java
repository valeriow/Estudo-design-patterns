package br.curso.designpatterns.cap3.ex6;

public class Item {
	private final String nome;
	private final double valor;
	

	public Item (String nome, double valor){
		this.nome = nome;
		this.valor = valor;
		
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}
}
