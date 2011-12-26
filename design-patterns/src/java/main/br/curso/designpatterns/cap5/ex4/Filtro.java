package br.curso.designpatterns.cap5.ex4;

import java.util.List;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public abstract class Filtro {
	
	protected Filtro outroFiltro;
	
	public Filtro (Filtro outroFiltro){
		this.outroFiltro = outroFiltro;
		
	}
	public Filtro(){}
	
    public abstract List<ContaBancaria> filtra(List<ContaBancaria> contas);
    
    protected List<ContaBancaria> aplicaOutroFiltro(List<ContaBancaria> resultado) {
		if (outroFiltro != null) {
			return outroFiltro.filtra(resultado) ;
		}else{
			return resultado;
		}
	}
}