package br.curso.designpatterns.cap6.ex3;

import java.util.Calendar;

public class ContaBancaria {
 private double saldo = 0.0;
 private String nomeTitular;
 private Calendar dataAbertura;
 protected EstadoDaConta estado = new EstadoPositivo(); 
 
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

public void realizaDeposito(double valor){
	estado.realizaDeposito(valor, this);
	//setSaldo(this.saldo+valor);
}

public void realizaSaque(double valor){
	estado.realizaSaque(valor, this);
	//setSaldo(this.saldo+valor);
}

protected void deposito(double valor){
	setSaldo(this.saldo+valor);
}

protected void saque(double valor){
	setSaldo(this.saldo-valor);
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
