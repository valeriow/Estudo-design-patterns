package br.curso.designpatterns.cap3.ex5;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class FormatoXML implements Formato {

	private Formato proximoFormato;
	public final static String NOME_FORMATO = "XML";

	public FormatoXML(){
		
	}
	public FormatoXML(Formato proximoFormato){
		setProximo(proximoFormato);
	}
	public void setProximo(Formato proximoFormato) {
		this.proximoFormato = proximoFormato;

	}
	
	public String retorno(ContaBancaria conta, Formato formato) {
		if ( formato.nomeFormato() == NOME_FORMATO ){
			String xml = "";
			xml = "<ContaBancaria>" +
				  	"<NomeTitular>" +
				  		conta.getNomeTitular()+
				  	"</NomeTitular>" +
				  	"<Saldo>" +
				  		Double.toString(conta.getSaldo())+
				  	"</Saldo>" +
				  "</ContaBancaria>"; 
			return xml;

		}else{
			return proximoFormato.retorno(conta, formato);
		}
	}

	public String nomeFormato() {
		return NOME_FORMATO;
	}

}
