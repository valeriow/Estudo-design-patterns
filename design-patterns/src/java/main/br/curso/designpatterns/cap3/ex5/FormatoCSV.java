package br.curso.designpatterns.cap3.ex5;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class FormatoCSV implements Formato {
	
	public final static String NOME_FORMATO = "CSV";
	
	private Formato proximoFormato;

	public FormatoCSV(){
	}
			
	public FormatoCSV(Formato proximoFormato){
		setProximo(proximoFormato);
	}
	public void setProximo(Formato proximoFormato) {
		this.proximoFormato = proximoFormato;
	}

	public String retorno(ContaBancaria conta, Formato formato) {
		if ( formato.nomeFormato() == NOME_FORMATO  ){
			return conta.getNomeTitular()+","+Double.toString(conta.getSaldo());
		}else{
			return proximoFormato.retorno(conta, formato);
		}
	}

	public String nomeFormato() {
		return NOME_FORMATO;
	}

}
