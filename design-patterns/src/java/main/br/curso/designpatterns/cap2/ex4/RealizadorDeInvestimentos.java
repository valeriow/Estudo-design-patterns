package br.curso.designpatterns.cap2.ex4;

import br.curso.designpatterns.IR;
import br.curso.designpatterns.Imposto;
import br.curso.designpatterns.Orcamento;

public class RealizadorDeInvestimentos {

public void investe(ContaBancaria conta, Investimento investimento, double chance){
	investe(conta,investimento,new IR(),chance);
}

public void investe(ContaBancaria conta, Investimento investimento, Imposto imposto, double chance){
	double saldoCC = conta.getSaldo();
	double retornoBruto = investimento.resultado(saldoCC,chance);
	double valorImposto = imposto.calcula(new Orcamento(retornoBruto));
	double retornoLiquido = retornoBruto - valorImposto; 
	conta.deposito(retornoLiquido);  
}
	
}
