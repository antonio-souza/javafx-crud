package br.com.aaas.javafxcrud.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class AlertaUtil {
  
  private AlertaUtil() {}

  public static void exibirInformacao(String mensagem) {
    Alert informacao = new Alert(AlertType.INFORMATION);
    informacao.setTitle("Informação");
    informacao.setContentText(mensagem);
    informacao.showAndWait();
  }

  public static void exibirErro(String mensagem) {
    Alert erro = new Alert(AlertType.ERROR);
    erro.setTitle("Erro");
    erro.setContentText(mensagem);
    erro.showAndWait();
  }

  public static boolean solicitarConfirmacao(String mensagem) {
    Alert confirmacao = new Alert(AlertType.CONFIRMATION, mensagem, ButtonType.YES, ButtonType.NO);
    confirmacao.setTitle("Confirmação");
    confirmacao.showAndWait();
    return confirmacao.getResult() == ButtonType.YES;
  }
}
