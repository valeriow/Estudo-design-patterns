package br.curso.designpatterns.cap4.ex5;

import java.util.List;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class GeradorDeRelatorio {

	public String geraRelatorio(Banco banco, List<ContaBancaria> relacaoDeContas){
		Relatorio r1 = new RelatorioDiario();
		Relatorio r2 = new RelatorioMensal();
		r1.setProximo(r2);
		return r1.gera(banco, relacaoDeContas);
	}
	

	
}
