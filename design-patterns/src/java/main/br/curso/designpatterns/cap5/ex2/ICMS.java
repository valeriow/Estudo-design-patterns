package br.curso.designpatterns.cap5.ex2;

public class ICMS extends Imposto {

	public ICMS(Imposto outroImposto){
		super(outroImposto);
	}
	
	public ICMS(){}
	
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor()*0.05+50.0 + calculaOutroImposto(orcamento);
	}

}
