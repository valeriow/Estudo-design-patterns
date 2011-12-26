package br.curso.designpatterns.cap6.ex1;

public class Reprovado implements EstadoDeUmOrcamento {

	public void aplicaDescontoExtra(Orcamento orcamento) {
		 throw new RuntimeException("Or�amentos reprovados n�o recebem desconto extra!");
		
	}

	public void aprova(Orcamento orcamento) {
		 // jah estou em aprovacao
	    throw new RuntimeException("Or�amento j� est� em estado de reprova��o");
		
	}

	public void reprova(Orcamento orcamento) {
		// nao pode ser reprovado agora!
	    throw new RuntimeException("Or�amento est� em estado de reprova��o e n�o pode ser reprovado");
		
	}

	public void finaliza(Orcamento orcamento) {
		 // daqui posso ir para o estado de finalizado
	    orcamento.estadoAtual = new Finalizado();
		
	}

}
