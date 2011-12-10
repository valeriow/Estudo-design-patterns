package br.curso.designpatterns.cap3.ex5;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class ProcessadorDeRequisicoes {
	public String requisita(ContaBancaria conta, Formato formato){
		Formato f3 = new FormatoPorcento(null);
		Formato f2= new FormatoCSV(f3);
		Formato f1 = new FormatoXML(f2);
		
		return f1.retorno(conta,formato);
			
	}
}
