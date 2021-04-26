package br.com.aaas.javafxcrud.app;

import br.com.aaas.javafxcrud.enumeration.TelaEnum;
import br.com.aaas.javafxcrud.infra.Navegacao;
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFxCrud extends Application {

  private static Stage                          estagio;

  @Override
  public void start(Stage primeiroEstagio) throws Exception {
    estagio = primeiroEstagio;
    JavaFxCrud.navegar(TelaEnum.ALUNO_LIST);
    estagio.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  public static void navegar(TelaEnum tela, Object objeto) {
    estagio.setScene(tela.getSena());
    estagio.setTitle(tela.getTitulo());
    Navegacao.notificarObservadores(tela, objeto);
  }

  public static void navegar(TelaEnum tela) {
    navegar(tela, null);
  }

  public static void fecharJanela() {
    estagio.getScene().getWindow().hide();
  }
}
