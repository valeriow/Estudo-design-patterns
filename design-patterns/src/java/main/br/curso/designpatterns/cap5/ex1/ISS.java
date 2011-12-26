package br.curso.designpatterns.cap5.ex1;

public class ISS extends Imposto {

	public ISS(Imposto outroImposto){
		super(outroImposto);
	}
	
	public ISS(){}
	
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor()*0.06 + calculaOutroImposto(orcamento);
	}


}
