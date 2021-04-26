package br.com.aaas.javafxcrud.infra;

import br.com.aaas.javafxcrud.enumeration.TelaEnum;
import javafx.fxml.FXML;

public abstract class AbstractController {
  
  @FXML
  public void initialize() {
    this.aoInicializar();
    Navegacao.adicionarObservador(new ObservadorNavegacao() {
      @Override
      public void aoHaverNavegacao(TelaEnum tela, Object objeto) {
        aoReceberNavegacao(tela, objeto);        
      }
    });
  }

  public abstract void aoInicializar();

  public abstract void aoReceberNavegacao(TelaEnum tela, Object objeto);
}
