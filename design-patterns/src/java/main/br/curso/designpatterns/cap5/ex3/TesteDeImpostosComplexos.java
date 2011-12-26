package br.curso.designpatterns.cap5.ex3;

public class TesteDeImpostosComplexos {
 
  public static void main(String[] args) {
      Imposto impostoComplexo = new ImpostoICPP(new ICMS());
 
      Orcamento orcamento = new Orcamento(500.0);
 
      double valor = impostoComplexo.calcula(orcamento);
       
      System.out.println(valor);
      
      
      Imposto impostoComplexo2 = new ImpostoIKCV(new ImpostoMuitoAlto());
      
      double valor2 = impostoComplexo2.calcula(orcamento);
       
      System.out.println(valor2);
      
      Imposto impostoComplexo3 = new ImpostoMuitoAlto(new ImpostoIKCV()) ;
      
      double valor3 = impostoComplexo3.calcula(orcamento);
       
      System.out.println(valor3);
      
      
  }
}