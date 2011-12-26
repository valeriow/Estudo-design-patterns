package br.curso.designpatterns.cap5.ex2;

public class ICCC extends Imposto {

	public ICCC(Imposto outroImposto){
		super(outroImposto);
	}
	
	public ICCC(){}
	
	public double calcula(Orcamento orcamento) {
		double valor = orcamento.getValor();
		if (valor>3000) return valor*0.08+30 + calculaOutroImposto(orcamento) ;
		if (valor>=1000 && valor<=3000) return valor*0.07 + calculaOutroImposto(orcamento);
		return valor*0.05 + calculaOutroImposto(orcamento);
	}

}
