package br.curso.designpatterns.cap4.ex3;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.curso.designpatterns.Imposto;
import br.curso.designpatterns.Orcamento;
import br.curso.designpatterns.cap3.ex1.Item;

public class IHITTest extends ImpostoIHIT {

  @Test
  public void deveUsarMaximaTaxacao() {
    //throw new RuntimeException("Test not implemented");
  }

  
  @Test
  public void existemDoisItemComMesmoNome() {
    //throw new RuntimeException("Test not implemented");
	Orcamento orcamento = new Orcamento(1000);
	orcamento.adicionaItem(new Item("Caneta",10));
	orcamento.adicionaItem(new Item("Papel",20));
	
	Imposto imposto = new ImpostoIHIT();

	assertEquals(false,((ImpostoIHIT) imposto).existemDoisItemComMesmoNome(orcamento));

	orcamento.adicionaItem(new Item("Papel",20));
	
	assertEquals(true,((ImpostoIHIT) imposto).existemDoisItemComMesmoNome(orcamento));
	
	
  }

  @Test
  public void maximaTaxacao() {
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void minimaTaxacao() {
    //throw new RuntimeException("Test not implemented");
  }
}
