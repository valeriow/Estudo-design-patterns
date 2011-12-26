package br.curso.designpatterns.cap5.ex3;

public class IR extends Imposto {

	public IR(Imposto outroImposto){
		super(outroImposto);
	}
	
	public IR(){}
	
	
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor()*0.25 + calculaOutroImposto(orcamento);
	}

}
