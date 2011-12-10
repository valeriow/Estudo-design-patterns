package br.curso.designpatterns.cap3.ex5;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public interface Formato {
	
	public void setProximo(Formato proximoFormato);
	public String retorno(ContaBancaria conta, Formato formato);
	public String nomeFormato();
}
