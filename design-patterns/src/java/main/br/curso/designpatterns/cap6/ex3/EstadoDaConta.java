package br.curso.designpatterns.cap6.ex3;

public interface EstadoDaConta {
	public void realizaDeposito(double valor, ContaBancaria conta );
	public void realizaSaque(double valor, ContaBancaria conta );
}
