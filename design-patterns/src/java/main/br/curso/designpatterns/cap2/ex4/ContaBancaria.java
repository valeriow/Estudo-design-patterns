package br.curso.designpatterns.cap2.ex4;

public class ContaBancaria {
 private double saldo = 0.0;

public ContaBancaria(double depositoInicial){
	setSaldo(depositoInicial);
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
}
