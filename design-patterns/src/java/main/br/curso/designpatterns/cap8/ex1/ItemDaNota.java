package br.curso.designpatterns.cap8.ex1;

public class ItemDaNota {
	
	private String descricao;
	private double valor;
	
	public ItemDaNota(String descricao, double valor){
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public double getValor() {
		return valor;
	}
}
