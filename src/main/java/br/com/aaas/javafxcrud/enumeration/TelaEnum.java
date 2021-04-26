package br.com.aaas.javafxcrud.enumeration;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public enum TelaEnum {
  ALUNO_LIST("/fxml/AlunoList.fxml", "Tabela de Alunos"), 
  ALUNO_FORM("/fxml/AlunoForm.fxml", "Formulário de Aluno");

  private String titulo;

  private Scene  sena;

  private TelaEnum(String fxml, String titulo) {
    this.titulo = titulo;
    Parent telaList;
    try {
      telaList = FXMLLoader.load(getClass().getResource(fxml));
      sena = new Scene(telaList, 600, 500);
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  public Scene getSena() {
    return sena;
  }

  public String getTitulo() {
    return titulo;
  }
}
