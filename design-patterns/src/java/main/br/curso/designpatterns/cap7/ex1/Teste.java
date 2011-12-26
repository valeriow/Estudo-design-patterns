package br.curso.designpatterns.cap7.ex1;

class Teste {
	   
	  public static void main(String[] args) {
	    NotaFiscal nf = new NotaFiscalBuilder().paraEmpresa("Caelum")
	                      .comCnpj("123.456.789/0001-10")
	                      .comItem(new ItemDaNota("item 1", 100.0))
	                      .comItem(new ItemDaNota("item 2", 200.0))
	                      .comItem(new ItemDaNota("item 3", 300.0))
	                      .comObservacao("entregar nf pessoalmente")
	                      .naDataAtual()
	                      .constroi();
	    System.out.println(nf.getCnpj());
	  }
	 
	}