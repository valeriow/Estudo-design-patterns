package br.curso.designpatterns.cap4.ex5;

import java.util.List;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class RelatorioSimples extends TemplateRelatorio {

	@Override
	protected String imprimeCabecalho(Banco banco) {
		return banco.getNome();
	}

	@Override
	protected String imprimeRodape(Banco banco) {
		return banco.getTelefone();
	}

	
	@Override
	protected String imprimeCorpo(List<ContaBancaria> relacaoDeContas) {
		String espacos40 = "........................................";
		String corpo = "";
		corpo +="NOME"+espacos40+"SALDO"+"\n";
		for (ContaBancaria c : relacaoDeContas){
			corpo +=c.getNomeTitular()+espacos40+Double.toString(c.getSaldo())+"\n";
		}
		return corpo;
	}

}
