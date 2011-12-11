package br.curso.designpatterns.cap4.ex5;

import java.util.Date;
import java.util.List;

import br.curso.designpatterns.cap2.ex4.ContaBancaria;

public class RelatorioDiario implements Relatorio{

	private Relatorio proximo;

	public void setProximo(Relatorio proximo) {
		this.proximo = proximo;
	}

	public Relatorio getProximo() {
		if (this.proximo != null){
			return this.proximo;
		}else{
			throw new RuntimeException("Não foi selecionado nenhum relatório");
		}
	}

	public String gera(Banco banco, List<ContaBancaria> relacaoDeContas) {
		Date dataAtual = new Date();
		if (dataAtual.getDay()!=1) {
			TemplateRelatorio rel = new RelatorioSimples();
			return rel.imprime(banco, relacaoDeContas);
		}else{
			return getProximo().gera(banco, relacaoDeContas);
		}
	}

}
