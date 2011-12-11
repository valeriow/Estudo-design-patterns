package br.curso.designpatterns.cap4.ex5;

import java.util.List;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public abstract class TemplateRelatorio { 
	
	public String imprime(Banco banco, List<ContaBancaria> relacaoDeContas){
		String relatorio =
		imprimeCabecalho(banco)+
		"\n"+
		imprimeCorpo(relacaoDeContas)+
		"\n"+
		imprimeRodape(banco);
		
		return relatorio;
	}
	
	protected abstract String imprimeCabecalho(Banco banco);
	
	protected abstract String imprimeRodape(Banco banco);
	
	protected abstract String imprimeCorpo(List<ContaBancaria> relacaoDeContas);
	
	
}
