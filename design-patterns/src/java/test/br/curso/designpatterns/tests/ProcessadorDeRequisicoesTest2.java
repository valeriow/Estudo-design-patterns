package br.curso.designpatterns.tests;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;
import br.curso.designpatterns.cap3.ex5.Formato;
import br.curso.designpatterns.cap3.ex5.FormatoCSV;
import br.curso.designpatterns.cap3.ex5.FormatoPorcento;
import br.curso.designpatterns.cap3.ex5.FormatoXML;
import br.curso.designpatterns.cap3.ex5.ProcessadorDeRequisicoes;

public class ProcessadorDeRequisicoesTest2 {
  
	private ProcessadorDeRequisicoes processador;
	private ContaBancaria conta;
	
	private final double saldo = 1000.0;
	private final String nomeTitular = "João da Silva";

  @BeforeClass
  public void setUp(){
  	this.processador = new ProcessadorDeRequisicoes();
  	this.conta = new ContaBancaria(saldo,nomeTitular);
  }
	
	
  @Test
  public void testaRequisicaoXML() {
	  Formato formato= new FormatoXML();
	  String resultadoEsperado = ""; 
	  resultadoEsperado = "<ContaBancaria>" +
	  	"<NomeTitular>" +
	  		nomeTitular+
	  	"</NomeTitular>" +
	  	"<Saldo>" +
	  		saldo+
	  	"</Saldo>" +
	  "</ContaBancaria>"; 
	  assertEquals(resultadoEsperado,processador.requisita(conta, formato));
		
  }
	
  @Test
  public void testaRequisicaoCSV() {
	  Formato formato= new FormatoCSV();
	  String resultadoEsperado = ""; 
	  resultadoEsperado = nomeTitular+","+saldo; 
	  assertEquals(resultadoEsperado,processador.requisita(conta, formato));
  }
  
  @Test
  public void testaRequisicaoPorcento() {
	  Formato formato= new FormatoPorcento();
	  String resultadoEsperado = ""; 
	  resultadoEsperado = nomeTitular+"%"+saldo; 
	  assertEquals(resultadoEsperado,processador.requisita(conta, formato));
		
  }
	
}
