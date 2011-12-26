package br.curso.designpatterns.cap6.ex1;

public class Aprovado implements EstadoDeUmOrcamento {

	private boolean aplicouDesconto = false;
	
	public void aplicaDescontoExtra(Orcamento orcamento) {
		if (this.aplicouDesconto)
			throw new RuntimeException("J� doi dado desconto para esse estado. N�o � poss�vel um novo desconto.");
		else{
			orcamento.valor -= orcamento.valor * 0.02;
			this.aplicouDesconto = true;
		}
	}

	public void aprova(Orcamento orcamento) {
		 // jah estou em aprovacao
	    throw new RuntimeException("Or�amento j� est� em estado de aprova��o");
		
	}

	public void reprova(Orcamento orcamento) {
		// nao pode ser reprovado agora!
	    throw new RuntimeException("Or�amento est� em estado de aprova��o e n�o pode ser reprovado");
		
	}

	public void finaliza(Orcamento orcamento) {
		 // daqui posso ir para o estado de finalizado
	    orcamento.estadoAtual = new Finalizado();
		
	}

}
