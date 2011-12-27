package br.curso.designpatterns.cap8.ex1;

class Teste {
	   
	  public static void main(String[] args) {
		  
	    NotaFiscalBuilder nfb = new NotaFiscalBuilder();
	    
	    nfb.adicionaAcao(new EnviadorDeEmail());
	    nfb.adicionaAcao(new NotaFiscalDao());
	    nfb.adicionaAcao(new EnviadorDeSms());
	    nfb.adicionaAcao(new Impressora());
	    nfb.adicionaAcao(new Multiplicador(5));
	  
	    NotaFiscal nf = nfb.paraEmpresa("Caelum")
	                      .comCnpj("123.456.789/0001-10")
	                      .comItem(new ItemDaNota("item 1", 100.0))
	                      .comItem(new ItemDaNota("item 2", 200.0))
	                      .comItem(new ItemDaNota("item 3", 300.0))
	                      .comObservacao("entregar nf pessoalmente")
	                      .naDataAtual()
	                      .constroi();
	    System.out.println(nf.getValorBruto());
	  }
	 
	}