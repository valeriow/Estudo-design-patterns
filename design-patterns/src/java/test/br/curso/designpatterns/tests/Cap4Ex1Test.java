package br.curso.designpatterns.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.curso.designpatterns.CalculadordeImpostos;
import br.curso.designpatterns.Imposto;
import br.curso.designpatterns.Orcamento;
import br.curso.designpatterns.cap3.ex1.Item;
import br.curso.designpatterns.cap4.ex1.ImpostoICPP;
import br.curso.designpatterns.cap4.ex1.ImpostoIKCV;
import br.curso.designpatterns.cap4.ex3.ImpostoIHIT;

public class Cap4Ex1Test {

	private CalculadordeImpostos calculador;

	@BeforeClass
	public void setUp(){
		calculador = new CalculadordeImpostos();
	}
	
	@Test
	public void testaImpostoICPP(){
		Orcamento orcamentoMaiorQue500 = new Orcamento(1000.00);
		Orcamento orcamentoIgualA500 = new Orcamento(500.00);
		Orcamento orcamentoMenorQue500 = new Orcamento(100.00);
		Imposto imposto = new ImpostoICPP();
		
		/* O imposto ICPP é calculado da seguinte forma: 
		 * caso o valor do orçamento seja menor que 500,00, deve-se cobrar 5%; 
		 * caso contrário, 7%. 
		 */
		assertEquals(5.0,calculador.calculaImposto(orcamentoMenorQue500, imposto));
		assertEquals(35.0,calculador.calculaImposto(orcamentoIgualA500, imposto));
		assertEquals(70.0,calculador.calculaImposto(orcamentoMaiorQue500, imposto));
	}
	
	@Test
	public void testaImpostoIKCV(){
		
		/* 
		 * Já o imposto IKCV, caso 
		 * o valor do orçamento seja maior que 500,00 
		 * 	e algum item tiver valor superior a 100,00, 
		 * o imposto a ser cobrado é de 10%; caso contrário 6%.
		 */

		Imposto imposto = new ImpostoIKCV();
		
		Orcamento orcamentoMaiorQue500 = new Orcamento(1000.00);
		Orcamento orcamentoIgualA500 = new Orcamento(500.00);
		Orcamento orcamentoMenorQue500 = new Orcamento(100.00);
		
		List<Orcamento> orcamentos = new ArrayList<Orcamento>();
		orcamentos.add(orcamentoMenorQue500);
		orcamentos.add(orcamentoIgualA500);
		orcamentos.add(orcamentoMaiorQue500);
		
		for (Orcamento o : orcamentos){
			o.adicionaItem(new Item("Lápis1",5));
			o.adicionaItem(new Item("Lápis2",5));
			o.adicionaItem(new Item("Lápis3",5));
			o.adicionaItem(new Item("Lápis4",5));
			o.adicionaItem(new Item("Lápis5",5));
			o.adicionaItem(new Item("Lápis6",5));
		}
		
		/* Já o imposto IKCV, 
		 * caso o valor do orçamento seja maior que 500,00 
		 * e algum item tiver valor superior a 100,00, 
		 * o imposto a ser cobrado é de 10%; 
		 * caso contrário 6%. 
		 */
		//Casos em que nenhum item é maior que 100. Imposto de 6%
		assertEquals(6.0,calculador.calculaImposto(orcamentoMenorQue500, imposto));
		assertEquals(30.0,calculador.calculaImposto(orcamentoIgualA500, imposto));
		assertEquals(60.0,calculador.calculaImposto(orcamentoMaiorQue500, imposto));
		
		//Agora Adiciona um item com valor maior que 100 e testa
		for (Orcamento o : orcamentos){
			o.adicionaItem(new Item("Super Caneta",1000.0));
		}
		
		/* Casos em que um item é maior que 100.
		 *  Imposto de:
		 *  	6%: Caso valor menor que 500 
		 *  	10% caso valor maior ou igual a 500
		 */
	
		assertEquals(6.0,calculador.calculaImposto(orcamentoMenorQue500, imposto));
		assertEquals(30.0,calculador.calculaImposto(orcamentoIgualA500, imposto));
		assertEquals(100.0,calculador.calculaImposto(orcamentoMaiorQue500, imposto));
		
	}
	
	@Test
	public void testaImpostoIHIT(){
		
	/* 
	 *O imposto IHIT  tem a seguinte regra:
	 * caso existam 2 ítens com o mesmo nome:
	 * 	 o imposto deve ser de 13% mais R$100,00.
	 * Caso contrário:
	 * 	 o valor do imposto deverá ser (1% * o número de ítens no orçamento).
	*/
	

		Imposto imposto = new ImpostoIHIT();
		
		Orcamento orcamento= new Orcamento(1000.00);
		
		orcamento.adicionaItem(new Item("Lápis1",5));
		orcamento.adicionaItem(new Item("Lápis2",5));
		orcamento.adicionaItem(new Item("Lápis3",5));
		orcamento.adicionaItem(new Item("Lápis4",5));
		orcamento.adicionaItem(new Item("Lápis5",5));
		orcamento.adicionaItem(new Item("Lápis6",5));
		
		//Nenhum item com o mesmo nome. Imposto de 1%* número de itens
		assertEquals(60.0,calculador.calculaImposto(orcamento, imposto));
		
		//1 item com o mesmo nome. Imposto de 13% mais R$100,00.
		orcamento.adicionaItem(new Item("Lápis6",50));
		assertEquals(130.0+100.0,calculador.calculaImposto(orcamento, imposto));
		
	}
}
