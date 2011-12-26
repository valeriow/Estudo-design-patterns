package br.curso.designpatterns.cap5.ex4;

import java.util.ArrayList;
import java.util.List;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class FiltroSaldoMenorQue100Reais extends Filtro {

	public FiltroSaldoMenorQue100Reais(Filtro outroFiltro){
		super(outroFiltro);
	}
	
	public FiltroSaldoMenorQue100Reais(){

	}
	
	@Override
	public List<ContaBancaria> filtra(List<ContaBancaria> contas) {
		List<ContaBancaria> resultado = new ArrayList<ContaBancaria>(); 
		for (ContaBancaria c  : contas ){
			if (c.getSaldo()<100){
				resultado.add(c);
			}
		}
		return aplicaOutroFiltro(resultado);
	}

}
