package br.curso.designpatterns.cap8.ex1;

public class NotaFiscalDao implements AcoesAposGerarNota {

	public void executa(NotaFiscal nf) {
		System.out.println("Gravou no banco de dados");

	}

}
