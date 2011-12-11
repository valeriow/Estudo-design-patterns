package br.curso.designpatterns.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.curso.designpatterns.CalculadordeImpostos;
import br.curso.designpatterns.Imposto;
import br.curso.designpatterns.Orcamento;
import br.curso.designpatterns.cap2.ex4.ContaBancaria;
import br.curso.designpatterns.cap3.ex1.Item;
import br.curso.designpatterns.cap4.ex1.ImpostoICPP;
import br.curso.designpatterns.cap4.ex1.ImpostoIKCV;
import br.curso.designpatterns.cap4.ex3.ImpostoIHIT;
import br.curso.designpatterns.cap4.ex4.Banco;
import br.curso.designpatterns.cap4.ex4.RelatorioComplexo;
import br.curso.designpatterns.cap4.ex4.RelatorioSimples;

public class Cap4Ex4Test {

	private Banco banco;
	private List<ContaBancaria> rel;
	
	@BeforeClass
	public void setUp(){
		banco = new Banco();
		banco.setEmail("banco@email.com");
		banco.setEndereço("Av. das Orquídeas, 123");
		banco.setNome("Banco Nacional do Brasil S.A.");
		banco.setTelefone("11 1234-1234");
		
		 
	
		ContaBancaria c1 = new ContaBancaria(1230.0,"João da Silva");
		ContaBancaria c2 = new ContaBancaria(88.0,"Maria da Silva");
		ContaBancaria c3 = new ContaBancaria(173.25,"Rafael da Silva");
		ContaBancaria c4 = new ContaBancaria(543543.0,"George da Silva");
		ContaBancaria c5 = new ContaBancaria(123123.0,"João Oliveira");
		ContaBancaria c6 = new ContaBancaria(1.0,"Renata Bombril");
		ContaBancaria c7 = new ContaBancaria(30000.0,"Rita Bomfim");
		ContaBancaria c8 = new ContaBancaria(12.43,"Rodolfo Pereira");
		ContaBancaria c9 = new ContaBancaria(200.12,"Raquel Rodrigues");
		
		rel = new ArrayList<ContaBancaria>();
		rel.add(c1);
		rel.add(c2);
		rel.add(c3);
		rel.add(c4);
		rel.add(c5);
		rel.add(c6);
		rel.add(c7);
		rel.add(c8);
		rel.add(c9);
	}
	
	@Test
	public void testaRelatorioSimples(){
		RelatorioSimples rels = new RelatorioSimples();
		String relatorio = rels.imprime(banco, rel);
		System.out.println(relatorio);
	}
	@Test
	
	public void testaRelatorioComplexo(){
		RelatorioComplexo rels = new RelatorioComplexo();
		String relatorio = rels.imprime(banco, rel);
		System.out.println(relatorio);
	}
}
