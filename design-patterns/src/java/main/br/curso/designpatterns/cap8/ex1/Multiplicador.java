package br.curso.designpatterns.cap8.ex1;

public class Multiplicador implements AcoesAposGerarNota {

	private final double fator;
	
	public Multiplicador(double fator){
		this.fator = fator;
		
	}
	public void executa(NotaFiscal nf) {
		System.out.println("Multiplicador: "+nf.getValorBruto()*this.fator);

	}

}
