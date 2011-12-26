package br.curso.designpatterns.cap6.ex3;

public class EstadoNegativo implements EstadoDaConta {

	public void realizaDeposito(double valor, ContaBancaria conta ) {
		conta.deposito(valor*0.95);	
		if (conta.getSaldo()>=0.0) 
			conta.estado = new EstadoPositivo();
	}

	public void realizaSaque(double valor, ContaBancaria conta) {
		throw new RuntimeException("A conta está com saldo negativo e não aceita saques até que seu saldo fique positivo.");
	}



}
