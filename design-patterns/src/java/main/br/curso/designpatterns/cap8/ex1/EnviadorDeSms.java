package br.curso.designpatterns.cap8.ex1;

public class EnviadorDeSms implements AcoesAposGerarNota {

	public void executa(NotaFiscal nf) {
		System.out.println("Enviou SMS");

	}

}
