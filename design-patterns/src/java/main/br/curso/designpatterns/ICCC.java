package br.curso.designpatterns;

public class ICCC implements Imposto {

	public double calcula(Orcamento orcamento) {
		double valor = orcamento.getValor();
		if (valor>3000) return valor*0.08+30;
		if (valor>=1000 && valor<=3000) return valor*0.07;
		return valor*0.05;
	}

}
