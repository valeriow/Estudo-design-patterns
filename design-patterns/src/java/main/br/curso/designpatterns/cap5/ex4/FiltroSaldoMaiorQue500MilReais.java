package br.curso.designpatterns.cap5.ex4;

import java.util.ArrayList;
import java.util.List;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class FiltroSaldoMaiorQue500MilReais extends Filtro {

	public FiltroSaldoMaiorQue500MilReais(Filtro outroFiltro){
		super(outroFiltro);
	}
	
	public FiltroSaldoMaiorQue500MilReais(){

	}

	@Override
	public List<ContaBancaria> filtra(List<ContaBancaria> contas) {
		List<ContaBancaria> resultado = new ArrayList<ContaBancaria>(); 
		for (ContaBancaria c  : contas ){
			if (c.getSaldo()>500000){
				resultado.add(c);
			}
		}
		return aplicaOutroFiltro(resultado);
	}

}
