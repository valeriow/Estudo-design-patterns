package br.curso.designpatterns.cap5.ex4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class FiltroDataAberturaNoMesCorrente extends Filtro {
	
	public FiltroDataAberturaNoMesCorrente(Filtro outroFiltro){
		super(outroFiltro);
	}
	
	public FiltroDataAberturaNoMesCorrente(){

	}

	@Override
	public List<ContaBancaria> filtra(List<ContaBancaria> contas) {
		List<ContaBancaria> resultado = new ArrayList<ContaBancaria>(); 
		for (ContaBancaria c  : contas ){
			if (c.getDataAbertura().get(Calendar.MONTH)== Calendar.getInstance().get(Calendar.MONTH)){
				resultado.add(c);
			}
		}
		return aplicaOutroFiltro(resultado);
	}

}
