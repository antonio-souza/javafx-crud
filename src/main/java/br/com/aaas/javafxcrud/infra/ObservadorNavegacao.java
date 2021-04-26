package br.com.aaas.javafxcrud.infra;

import br.com.aaas.javafxcrud.enumeration.TelaEnum;

public interface ObservadorNavegacao {
  void aoHaverNavegacao(TelaEnum tela, Object objeto);
}
