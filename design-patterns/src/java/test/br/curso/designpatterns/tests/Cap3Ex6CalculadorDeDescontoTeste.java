package br.curso.designpatterns.tests;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.curso.designpatterns.Orcamento;
import br.curso.designpatterns.cap3.ex6.CalculadorDeDesconto;
import br.curso.designpatterns.cap3.ex1.Item;

public class Cap3Ex6CalculadorDeDescontoTeste {
  
	private CalculadorDeDesconto calculadora;

	@BeforeClass
  public void setUp(){
  	this.calculadora = new CalculadorDeDesconto();
  }
	
	
	@Test
  public void testaDescontoMaisDeCincoItens() {
		Orcamento orcamento = new Orcamento(100);
		orcamento.adicionaItem(new Item("Lápis1",5));
		orcamento.adicionaItem(new Item("Lápis2",5));
		orcamento.adicionaItem(new Item("Lápis3",5));
		orcamento.adicionaItem(new Item("Lápis4",5));
		orcamento.adicionaItem(new Item("Lápis5",5));
		orcamento.adicionaItem(new Item("Lápis6",5));
		
		double desconto = calculadora.calcula(orcamento);
		
		assertEquals(10.0,desconto);
		
  }
	
	@Test
  public void testaDescontoMaisDe500Reais() {
		Orcamento orcamento = new Orcamento(1000);
		orcamento.adicionaItem(new Item("Lápis1",5));
		
		double desconto = calculadora.calcula(orcamento);
		assertEquals(70.0,desconto);
  }
	
	@Test
  public void testaNenhumDesconto() {
		Orcamento orcamento = new Orcamento(100);
		orcamento.adicionaItem(new Item("Lápis1",5));
		
		double desconto = calculadora.calcula(orcamento);
		assertEquals(0.0,desconto);
  }
	
  @Test
  public void testaDescontoMaisDe5ItensComMaisde500Reais() {
		Orcamento orcamento = new Orcamento(1000);
		orcamento.adicionaItem(new Item("Lápis1",5));
		orcamento.adicionaItem(new Item("Lápis2",5));
		orcamento.adicionaItem(new Item("Lápis3",5));
		orcamento.adicionaItem(new Item("Lápis4",5));
		orcamento.adicionaItem(new Item("Lápis5",5));
		orcamento.adicionaItem(new Item("Lápis6",5));
		
		double desconto = calculadora.calcula(orcamento);
		assertEquals(100.0,desconto);
  }

  @Test
  public void testaDescontoPorVendaCasada() {
		Orcamento orcamento = new Orcamento(100);
		orcamento.adicionaItem(new Item("Lápis1",5));
		orcamento.adicionaItem(new Item("Lápis2",5));
		orcamento.adicionaItem(new Item("LAPIS",5));
		orcamento.adicionaItem(new Item("Lápis4",5));
		orcamento.adicionaItem(new Item("CANETA",5));
		
		double desconto = calculadora.calcula(orcamento);
		assertEquals(5.0,desconto);
  }

}
