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
		
		/* O imposto ICPP � calculado da seguinte forma: 
		 * caso o valor do or�amento seja menor que 500,00, deve-se cobrar 5%; 
		 * caso contr�rio, 7%. 
		 */
		assertEquals(5.0,calculador.calculaImposto(orcamentoMenorQue500, imposto));
		assertEquals(35.0,calculador.calculaImposto(orcamentoIgualA500, imposto));
		assertEquals(70.0,calculador.calculaImposto(orcamentoMaiorQue500, imposto));
	}
	
	@Test
	public void testaImpostoIKCV(){
		
		/* 
		 * J� o imposto IKCV, caso 
		 * o valor do or�amento seja maior que 500,00 
		 * 	e algum item tiver valor superior a 100,00, 
		 * o imposto a ser cobrado � de 10%; caso contr�rio 6%.
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
			o.adicionaItem(new Item("L�pis1",5));
			o.adicionaItem(new Item("L�pis2",5));
			o.adicionaItem(new Item("L�pis3",5));
			o.adicionaItem(new Item("L�pis4",5));
			o.adicionaItem(new Item("L�pis5",5));
			o.adicionaItem(new Item("L�pis6",5));
		}
		
		/* J� o imposto IKCV, 
		 * caso o valor do or�amento seja maior que 500,00 
		 * e algum item tiver valor superior a 100,00, 
		 * o imposto a ser cobrado � de 10%; 
		 * caso contr�rio 6%. 
		 */
		//Casos em que nenhum item � maior que 100. Imposto de 6%
		assertEquals(6.0,calculador.calculaImposto(orcamentoMenorQue500, imposto));
		assertEquals(30.0,calculador.calculaImposto(orcamentoIgualA500, imposto));
		assertEquals(60.0,calculador.calculaImposto(orcamentoMaiorQue500, imposto));
		
		//Agora Adiciona um item com valor maior que 100 e testa
		for (Orcamento o : orcamentos){
			o.adicionaItem(new Item("Super Caneta",1000.0));
		}
		
		/* Casos em que um item � maior que 100.
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
	 * caso existam 2 �tens com o mesmo nome:
	 * 	 o imposto deve ser de 13% mais R$100,00.
	 * Caso contr�rio:
	 * 	 o valor do imposto dever� ser (1% * o n�mero de �tens no or�amento).
	*/
	

		Imposto imposto = new ImpostoIHIT();
		
		Orcamento orcamento= new Orcamento(1000.00);
		
		orcamento.adicionaItem(new Item("L�pis1",5));
		orcamento.adicionaItem(new Item("L�pis2",5));
		orcamento.adicionaItem(new Item("L�pis3",5));
		orcamento.adicionaItem(new Item("L�pis4",5));
		orcamento.adicionaItem(new Item("L�pis5",5));
		orcamento.adicionaItem(new Item("L�pis6",5));
		
		//Nenhum item com o mesmo nome. Imposto de 1%* n�mero de itens
		assertEquals(60.0,calculador.calculaImposto(orcamento, imposto));
		
		//1 item com o mesmo nome. Imposto de 13% mais R$100,00.
		orcamento.adicionaItem(new Item("L�pis6",50));
		assertEquals(130.0+100.0,calculador.calculaImposto(orcamento, imposto));
		
	}
}
