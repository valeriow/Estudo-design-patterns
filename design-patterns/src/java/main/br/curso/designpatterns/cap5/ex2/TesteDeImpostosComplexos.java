package br.curso.designpatterns.cap5.ex2;

public class TesteDeImpostosComplexos {
 
  public static void main(String[] args) {
      Imposto impostoComplexo = new ImpostoMuitoAlto(new ICMS());
 
      Orcamento orcamento = new Orcamento(500.0);
 
      double valor = impostoComplexo.calcula(orcamento);
       
      System.out.println(valor);
      
      
      Imposto impostoComplexo2 = new ICMS(new ImpostoMuitoAlto());
      
      double valor2 = impostoComplexo2.calcula(orcamento);
       
      System.out.println(valor2);
      
      
  }
}