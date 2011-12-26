package br.curso.designpatterns.cap6.ex1;

public class Finalizado implements EstadoDeUmOrcamento {

	public void aplicaDescontoExtra(Orcamento orcamento) {
		 throw new RuntimeException("Orçamentos finalizados não recebem desconto extra!");
		
	}

	public void aprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos finalizados não podem mais mudar de estado!");
		
	}

	public void reprova(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos finalizados não podem mais mudar de estado!");
		
	}

	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos finalizados não podem mais mudar de estado!");
		
	}

}
