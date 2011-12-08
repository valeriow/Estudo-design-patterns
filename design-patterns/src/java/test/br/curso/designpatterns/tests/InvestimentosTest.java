package br.curso.designpatterns.tests;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;
import br.curso.designpatterns.cap2.ex4.Investimento;
import br.curso.designpatterns.cap2.ex4.InvestimentoArrojado;
import br.curso.designpatterns.cap2.ex4.InvestimentoConservador;
import br.curso.designpatterns.cap2.ex4.InvestimentoModerado;
import br.curso.designpatterns.cap2.ex4.RealizadorDeInvestimentos;

public class InvestimentosTest {
  
	private ContaBancaria conta;
	
	private RealizadorDeInvestimentos realizadorInvestimentos;
	
	@BeforeClass
	public void init(){
		this.realizadorInvestimentos = new RealizadorDeInvestimentos();
	}
	
	@BeforeMethod
	public void setUp(){
		this.conta = new ContaBancaria(1000.0); 
	}
	
  @Test
  public void testaInvestimentoConservador() {
  	Investimento investimento = new InvestimentoConservador();
  	double chance = 0.0;
  	realizadorInvestimentos.investe(conta, investimento,chance);
  	//Saldo era de 1000.0, lucro bruto de 80, menos 25% de imposto = 1000 + 60 = 1060
  	assertEquals(1060.0,conta.getSaldo());
  }
  
  @Test
  public void testaInvestimentoModerado() {
  	Investimento investimento = new InvestimentoModerado();
  	double chance = 0.1;
  	realizadorInvestimentos.investe(conta, investimento, chance);
  	chance = 0.6;
  	ContaBancaria conta2 = new ContaBancaria(1000.0);
  	realizadorInvestimentos.investe(conta2, investimento, chance);
  	//"MODERADO", que tem 50% de chances de retornar 2.5%
  	//e 50% de chances de retornar 0.7%;
  	//Saldo era 1000
  	//No sorteio até 50% retorna 2.5% menos 25% de IR
  	//No sorteio acima de 50% retorn 0.7% menos 25% de IR
  	assertEquals(1000+(25*0.75),conta.getSaldo());
  	assertEquals(1000+(7*0.75),conta2.getSaldo());
  }
  
  @Test
  public void testaInvestimentoArrojado() {
  	/* "ARROJADO", que tem 20% de chances de retornar 5%, 
  	 * 30% de chances de retornar 3%, 
  	 * e 50% de chances de retornar 0.6%. 
  	 */
  	
  	Investimento investimento = new InvestimentoArrojado();
  	double chance = 0.1;
  	realizadorInvestimentos.investe(conta, investimento, chance);
  	ContaBancaria conta2 = new ContaBancaria(1000.0);
  	chance = 0.3;
  	realizadorInvestimentos.investe(conta2, investimento, chance);
  	ContaBancaria conta3 = new ContaBancaria(1000.0);
  	chance = 0.6;
  	realizadorInvestimentos.investe(conta3, investimento, chance);
  	assertEquals(1000+(50*0.75),conta.getSaldo());
  	assertEquals(1000+(30*0.75),conta2.getSaldo());
  	assertEquals(1000+(6*0.75),conta3.getSaldo());
  }
}
