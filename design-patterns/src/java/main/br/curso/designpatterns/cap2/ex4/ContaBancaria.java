package br.curso.designpatterns.cap2.ex4;

import java.util.Calendar;

public class ContaBancaria {
 private double saldo = 0.0;
 private String nomeTitular;
 private Calendar dataAbertura;
 
public ContaBancaria(double depositoInicial){
	setSaldo(depositoInicial);
}

public ContaBancaria(double depositoInicial, String nomeTitular){
	setSaldo(depositoInicial);
	setNomeTitular(nomeTitular);
}

public ContaBancaria(double depositoInicial, String nomeTitular,Calendar dataAbertura){
	setSaldo(depositoInicial);
	setNomeTitular(nomeTitular);
	setDataAbertura(dataAbertura);
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

public void setDataAbertura(Calendar dataAbertura) {
	this.dataAbertura = dataAbertura;
}

public Calendar getDataAbertura() {
	return dataAbertura;
}
}
