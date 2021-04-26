package br.com.aaas.javafxcrud.infra;

public abstract class AbstractModel {

  protected void exigir(Object objeto, String mensagem) {
    if (objeto == null) {
      throw new IllegalArgumentException(mensagem);
    }
  }  
}
