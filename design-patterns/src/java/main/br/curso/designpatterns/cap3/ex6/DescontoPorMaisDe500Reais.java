package br.curso.designpatterns.cap3.ex6;

import br.curso.designpatterns.Orcamento;
public class DescontoPorMaisDe500Reais implements Desconto {
	
	private Desconto proximo;

	public double desconto(Orcamento orcamento){
		if (orcamento.getValor()>500.0){
			return orcamento.getValor()*0.07;
		}else{
			return getProximo().desconto(orcamento);
		}
	}

	public Desconto getProximo() {
		if (this.proximo == null){
			return new SemDesconto();
		}else{
			return this.proximo;
		}
		
	}
	
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}
	
}
