package br.curso.designpatterns.tests;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.curso.designpatterns.CalculadordeImpostos;
import br.curso.designpatterns.ICCC;
import br.curso.designpatterns.ICMS;
import br.curso.designpatterns.ISS;
import br.curso.designpatterns.Imposto;
import br.curso.designpatterns.Orcamento;

public class CalculadorDeImpostosTeste {
 
  private CalculadordeImpostos calculador;
	
  @BeforeClass
  public void setUp(){
	  this.calculador = new CalculadordeImpostos();
  }
  @Test
  public void testaCalculoICMS() {
	  double valorOrcamento = 1000.0;
	  Imposto imposto = new ICMS();
	  Orcamento orcamento = new Orcamento(valorOrcamento); 
	  //ICMS = 5% + R$50
	  assertTrue((valorOrcamento*0.05)+50 == calculador.calculaImposto(orcamento,imposto));
	  assertTrue(100 == calculador.calculaImposto(orcamento,imposto));
	    
  }
  
  @Test
  public void testaCalculoISS(){
	  Orcamento orcamento = new Orcamento(1000);
	  Imposto imposto = new ISS();
	  //ISS = 6%
	  assertTrue(60==calculador.calculaImposto(orcamento, imposto));
  }
  
//  Crie o imposto que se chama ICCC, 
//  que retorna 5% do valor total caso o o orçamento seja menor do que R$ 1000,00 reais, 
//  7% caso o valor esteja entre R$ 1000 e R$ 3000,00, 
//  ou 8% mais 30 reais, caso o valor esteja acima de R$ 3000,00. 

  @Test
  public void testaCalculoICCC_OrcamentoMenorQue1000(){
	  Orcamento orcamento = new Orcamento(100);
	  Imposto imposto = new ICCC();
	  //retorna 5% do valor total caso o o orçamento seja menor do que R$ 1000,00 reais,
	  assertTrue(5==calculador.calculaImposto(orcamento, imposto));
  }
  
  @Test
  public void testaCalculoICCC_OrcamentoEntre1000e3000(){
	  Orcamento orcamento = new Orcamento(1000);
	  Imposto imposto = new ICCC();
	  //7% caso o valor esteja entre R$ 1000 e R$ 3000,00,
	  assertTrue(70==calculador.calculaImposto(orcamento, imposto));
	  assertTrue(70==imposto.calcula(orcamento));
  }
  
  @Test
  public void testaCalculoICCC_OrcamentoMaiorQue3000(){
	  Orcamento orcamento = new Orcamento(4000);
	  Imposto imposto = new ICCC();
	  //8% mais 30 reais, caso o valor esteja acima de R$ 3000,00.
	  assertTrue(320+30==calculador.calculaImposto(orcamento, imposto));
  }
}
