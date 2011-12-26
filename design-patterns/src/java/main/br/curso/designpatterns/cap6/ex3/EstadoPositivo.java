package br.curso.designpatterns.cap6.ex3;

public class EstadoPositivo implements EstadoDaConta {

	public void realizaDeposito(double valor, ContaBancaria conta ) {
		conta.deposito(valor*0.98);	
	}

	public void realizaSaque(double valor, ContaBancaria conta) {
		conta.saque(valor);
		if (conta.getSaldo()<0.0) 
			conta.estado = new EstadoNegativo();
	}



}
