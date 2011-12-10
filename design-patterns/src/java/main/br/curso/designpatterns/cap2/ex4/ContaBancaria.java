package br.curso.designpatterns.cap2.ex4;

public class ContaBancaria {
 private double saldo = 0.0;
 private String nomeTitular;
 
public ContaBancaria(double depositoInicial){
	setSaldo(depositoInicial);
}

public ContaBancaria(double depositoInicial, String nomeTitular){
	setSaldo(depositoInicial);
	setNomeTitular(nomeTitular);
}

public void deposito(double valor){
	setSaldo(this.saldo+valor);
}

public void setSaldo(double saldo) {
	this.saldo = saldo;
}

public double getSaldo() {
	return saldo;
}

public void setNomeTitular(String nomeTitular) {
	this.nomeTitular = nomeTitular;
}

public String getNomeTitular() {
	return nomeTitular;
}
}
