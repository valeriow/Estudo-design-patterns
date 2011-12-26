package br.curso.designpatterns.tests;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

import br.curso.designpatterns.cap6.ex3.ContaBancaria;


public class Cap6Ex3Test {

	@Test(expectedExceptions = RuntimeException.class)
	public void TestaSaqueComSaldoNegativo(){
		ContaBancaria conta = new ContaBancaria(1000.0);
		conta.realizaDeposito(100.0);
		assertEquals(1098.0,conta.getSaldo());
		conta.realizaSaque(1200.0);
		assertEquals(-102.0,conta.getSaldo());
		conta.realizaSaque(120.0);
		
	}
	
	@Test
	public void TestaSaqueComSaldoPositivoDepoisDeNegativo(){
		ContaBancaria conta = new ContaBancaria(1000.0);
		conta.realizaDeposito(100.0);
		assertEquals(1098.0,conta.getSaldo());
		conta.realizaSaque(1200.0);
		assertEquals(-102.0,conta.getSaldo());
		//Negativo agora e deixa positivo
		conta.realizaDeposito(1000.0);
		conta.realizaSaque(200.0);
		
	}
	
}
