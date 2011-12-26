package br.curso.designpatterns.tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;
import br.curso.designpatterns.cap4.ex5.Banco;
import br.curso.designpatterns.cap4.ex5.RelatorioComplexo;
import br.curso.designpatterns.cap4.ex5.TemplateRelatorio;
import br.curso.designpatterns.cap5.ex4.Filtro;
import br.curso.designpatterns.cap5.ex4.FiltroDataAberturaNoMesCorrente;
import br.curso.designpatterns.cap5.ex4.FiltroSaldoMaiorQue500MilReais;
import br.curso.designpatterns.cap5.ex4.FiltroSaldoMenorQue100Reais;


public class Cap5Ex4Test {

	private Banco banco;
	private List<ContaBancaria> rel;
	
	@BeforeClass
	public void setUp(){
		
		
		banco = new Banco();
		banco.setEmail("banco@email.com");
		banco.setEndereço("Av. das Orquídeas, 123");
		banco.setNome("Banco Nacional do Brasil S.A.");
		banco.setTelefone("11 1234-1234");
		
		Calendar dataMesAtual = Calendar.getInstance();
		
		Calendar dataMesAnterior = new GregorianCalendar(dataMesAtual.get(Calendar.YEAR),10,dataMesAtual.get(Calendar.DATE));
		
	
		ContaBancaria c1 = new ContaBancaria(12300.0,"João da Silva",dataMesAnterior);
		ContaBancaria c2 = new ContaBancaria(88.0,"Maria da Silva",dataMesAnterior);
		ContaBancaria c3 = new ContaBancaria(173.25,"Rafael da Silva",dataMesAnterior);
		ContaBancaria c4 = new ContaBancaria(543543.0,"George da Silva",dataMesAnterior);
		ContaBancaria c5 = new ContaBancaria(123123.0,"João Oliveira",dataMesAtual);
		ContaBancaria c6 = new ContaBancaria(1.0,"Renata Bombril",dataMesAtual);
		ContaBancaria c7 = new ContaBancaria(30000.0,"Rita Bomfim",dataMesAnterior);
		ContaBancaria c8 = new ContaBancaria(12.43,"Rodolfo Pereira",dataMesAtual);
		ContaBancaria c9 = new ContaBancaria(200.12,"Raquel Rodrigues",dataMesAnterior);
		
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
	public void testaFiltroDataAberturaNoMesCorrente(){
		
		Filtro filtro = new FiltroDataAberturaNoMesCorrente();
		
		List<ContaBancaria> relacaoFiltrada = filtro.filtra(rel) ;
		
		TemplateRelatorio relatorio = new RelatorioComplexo();
		String resRelatorio = relatorio.imprime(banco, relacaoFiltrada);
		
		System.out.println(resRelatorio);

	}
	
	@Test
	public void testaFiltroSaldoMenorQue100Reais(){
		
		Filtro filtro = new FiltroSaldoMenorQue100Reais();
		
		List<ContaBancaria> relacaoFiltrada = filtro.filtra(rel) ;
		
		TemplateRelatorio relatorio = new RelatorioComplexo();
		String resRelatorio = relatorio.imprime(banco, relacaoFiltrada);
		
		System.out.println(resRelatorio);

	}
	
	@Test
	public void testaFiltroSaldoMaiorQue500MilReais(){
		
		Filtro filtro = new FiltroSaldoMaiorQue500MilReais();
		
		List<ContaBancaria> relacaoFiltrada = filtro.filtra(rel) ;
		
		TemplateRelatorio relatorio = new RelatorioComplexo();
		String resRelatorio = relatorio.imprime(banco, relacaoFiltrada);
		
		System.out.println(resRelatorio);

	}
	
	@Test
	public void testaFiltroSaldoMaiorQue500MilReaisEDataAberturaNoMesCorrente(){
		
		Filtro filtro = new FiltroSaldoMaiorQue500MilReais(new FiltroDataAberturaNoMesCorrente());
		
		List<ContaBancaria> relacaoFiltrada = filtro.filtra(rel) ;
		
		TemplateRelatorio relatorio = new RelatorioComplexo();
		String resRelatorio = relatorio.imprime(banco, relacaoFiltrada);
		
		System.out.println(resRelatorio);

	}
	
	@Test
	public void  testaFiltroSaldoMenorQue100ReaisEDataAberturaNoMesCorrente(){
		
		Filtro filtro = new FiltroSaldoMenorQue100Reais(new FiltroDataAberturaNoMesCorrente());
		
		List<ContaBancaria> relacaoFiltrada = filtro.filtra(rel) ;
		
		TemplateRelatorio relatorio = new RelatorioComplexo();
		String resRelatorio = relatorio.imprime(banco, relacaoFiltrada);
		
		System.out.println(resRelatorio);

	}
	
}
