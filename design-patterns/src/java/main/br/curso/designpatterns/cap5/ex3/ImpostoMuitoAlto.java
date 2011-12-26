package br.curso.designpatterns.cap5.ex3;

public class ImpostoMuitoAlto extends Imposto {

	public ImpostoMuitoAlto(Imposto outroImposto){
		super(outroImposto);
	}
	
	public ImpostoMuitoAlto(){}
	
	public double calcula(Orcamento orcamento) {
		double valor = orcamento.getValor();
		return valor*0.2 + calculaOutroImposto(orcamento);
	}

}
