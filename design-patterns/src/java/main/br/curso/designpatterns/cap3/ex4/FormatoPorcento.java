package br.curso.designpatterns.cap3.ex4;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class FormatoPorcento implements Formato {
	
	public final static String NOME_FORMATO = "PORCENTO";
	
	private Formato proximoFormato;
	
	public void setProximo(Formato proximoFormato) {
		this.proximoFormato = proximoFormato;

	}

	public String retorno(ContaBancaria conta, Formato formato) {
		if ( formato.nomeFormato() == NOME_FORMATO ){
			return conta.getNomeTitular()+"%"+Double.toString(conta.getSaldo());
		}else{
			return "";
		}
	}

	public String nomeFormato() {
		return NOME_FORMATO;
	}

}
