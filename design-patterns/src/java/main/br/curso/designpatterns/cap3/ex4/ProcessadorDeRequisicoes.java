package br.curso.designpatterns.cap3.ex4;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class ProcessadorDeRequisicoes {
	public String requisita(ContaBancaria conta, Formato formato){
		Formato f1 = new FormatoXML();
		Formato f2= new FormatoCSV();
		Formato f3 = new FormatoPorcento();
		
		f1.setProximo(f2);
		f2.setProximo(f3);
		
		return f1.retorno(conta,formato);
			
	}
}
