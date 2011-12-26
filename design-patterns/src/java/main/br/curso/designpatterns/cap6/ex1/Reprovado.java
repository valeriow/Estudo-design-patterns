package br.curso.designpatterns.cap6.ex1;

public class Reprovado implements EstadoDeUmOrcamento {

	public void aplicaDescontoExtra(Orcamento orcamento) {
		 throw new RuntimeException("Orçamentos reprovados não recebem desconto extra!");
		
	}

	public void aprova(Orcamento orcamento) {
		 // jah estou em aprovacao
	    throw new RuntimeException("Orçamento já está em estado de reprovação");
		
	}

	public void reprova(Orcamento orcamento) {
		// nao pode ser reprovado agora!
	    throw new RuntimeException("Orçamento está em estado de reprovação e não pode ser reprovado");
		
	}

	public void finaliza(Orcamento orcamento) {
		 // daqui posso ir para o estado de finalizado
	    orcamento.estadoAtual = new Finalizado();
		
	}

}
