package br.curso.designpatterns.cap4.ex5;

import java.util.List;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public interface Relatorio {

	public void setProximo(Relatorio proximo);
	
	public Relatorio getProximo();
	
	public String gera(Banco banco, List<ContaBancaria> relacaoDeContas);
}
