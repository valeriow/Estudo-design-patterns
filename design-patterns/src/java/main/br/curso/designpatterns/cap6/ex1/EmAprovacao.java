package br.curso.designpatterns.cap6.ex1;

public class EmAprovacao implements EstadoDeUmOrcamento {

	private boolean aplicouDesconto = false;
	
	public void aplicaDescontoExtra(Orcamento orcamento) {
		if (this.aplicouDesconto)
			throw new RuntimeException("J� doi dado desconto para esse estado. N�o � poss�vel um novo desconto.");
		else{
			orcamento.valor -= orcamento.valor * 0.05;
			this.aplicouDesconto = true;
		}
		
	}

	public void aprova(Orcamento orcamento) {
		// desse estado posso ir para o estado de aprovado
	    orcamento.estadoAtual = new Aprovado();
		
	}

	public void reprova(Orcamento orcamento) {
		 // desse estado posso ir para o estado de reprovado tambem
	    orcamento.estadoAtual = new Reprovado();
		
	}

	public void finaliza(Orcamento orcamento) {
		 // daqui n�o posso ir direto para finalizado
	    throw new RuntimeException("Orcamento em aprova��o n�o podem ir para finalizado diretamente");
		
	}

}
