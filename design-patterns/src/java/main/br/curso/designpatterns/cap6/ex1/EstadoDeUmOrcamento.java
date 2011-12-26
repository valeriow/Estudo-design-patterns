package br.curso.designpatterns.cap6.ex1;

interface EstadoDeUmOrcamento {
	  void aplicaDescontoExtra(Orcamento orcamento);
	  void aprova(Orcamento orcamento);
	  void reprova(Orcamento orcamento);
	  void finaliza(Orcamento orcamento);
}