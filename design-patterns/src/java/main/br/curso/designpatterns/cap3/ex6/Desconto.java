package br.curso.designpatterns.cap3.ex6;

import br.curso.designpatterns.Orcamento;

public interface Desconto {
	public double desconto(Orcamento orcamento);
	public void setProximo(Desconto proximo);
	public Desconto getProximo();

}
