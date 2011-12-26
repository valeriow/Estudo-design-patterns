package br.curso.designpatterns.cap7.ex1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {
	private String razaoSocial;
    private String cnpj;
    private Calendar dataDeEmissao;
    private double valorBruto;
    private double impostos;
    private List<ItemDaNota> itens = new ArrayList<ItemDaNota>();
    private String observacoes;
    
	public NotaFiscal constroi(){
		if (this.dataDeEmissao==null) 
			naDataAtual();
		return new NotaFiscal(this.razaoSocial,this.cnpj,this.dataDeEmissao,this.valorBruto,this.impostos,this.itens,this.observacoes);
	}

	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this; 
	}
	
	public NotaFiscalBuilder naDataAtual() {
		naData(Calendar.getInstance());
		return this;
	}

	public NotaFiscalBuilder naData(Calendar dataDeEmissao) {
		this.dataDeEmissao = dataDeEmissao;
		return this;
	}

	public NotaFiscalBuilder comValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
		return this;
	}

	public NotaFiscalBuilder comImpostos(double impostos) {
		this.impostos = impostos;
		return this;
	}

	public NotaFiscalBuilder comObservacao(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}

	public NotaFiscalBuilder comItem(ItemDaNota itemDaNota) {
		this.itens.add(itemDaNota);
		return this;
	}
}
