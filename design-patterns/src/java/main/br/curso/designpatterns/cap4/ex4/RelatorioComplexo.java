package br.curso.designpatterns.cap4.ex4;

import java.util.Date;
import java.util.List;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class RelatorioComplexo extends TemplateRelatorio {

	
	/* cabe�alhos que informam o nome do banco, endere�o, telefone, 
	 * e rodap�s que informam e-mail, e a data atual. (non-Javadoc)
	 */
	@Override
	protected String imprimeCabecalho(Banco banco) {
		String espaco10 = "..........";
		return banco.getNome()+espaco10+banco.getEndere�o()+espaco10+banco.getTelefone();
	}

	@Override
	protected String imprimeRodape(Banco banco) {
		String espaco10 = "..........";
		Date dataAtual = new Date();
		return banco.getEmail()+espaco10+banco.getEndere�o()+espaco10+dataAtual;
	}

	@Override
	protected String imprimeCorpo(List<ContaBancaria> relacaoDeContas) {
		String espacos40 = "....................";
		String corpo = "";
		corpo +="NOME"+espacos40+"SALDO"+"\n";
		for (ContaBancaria c : relacaoDeContas){
			corpo +=c.getNomeTitular()+espacos40+Double.toString(c.getSaldo())+"\n";
		}
		return corpo;
	}

}
