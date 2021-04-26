package br.com.aaas.javafxcrud.controller;

import java.io.IOException;
import java.util.List;

import br.com.aaas.javafxcrud.app.JavaFxCrud;
import br.com.aaas.javafxcrud.enumeration.TelaEnum;
import br.com.aaas.javafxcrud.infra.AbstractController;
import br.com.aaas.javafxcrud.modelo.Aluno;
import br.com.aaas.javafxcrud.service.AlunoService;
import br.com.aaas.javafxcrud.util.AlertaUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlunoListController extends AbstractController {

  @FXML
  private TableView<Aluno>           tabAlunos;

  @FXML
  private TableColumn<Aluno, String> colNome;

  @FXML
  private TableColumn<Aluno, String> colSexo;

  @FXML
  private Button                     btnIncluir;

  @FXML
  private Button                     btnEditar;

  @FXML
  private Button                     btnSair;

  private List<Aluno>                alunos;

  private AlunoService               alunoService = AlunoService.getInstance();

  @Override
  public void aoInicializar() {
    colNome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
    colSexo.setCellValueFactory(new PropertyValueFactory<Aluno, String>("sexo"));

    tabAlunos.setRowFactory(t -> {
      TableRow<Aluno> linha = new TableRow<>();
      linha.setOnMouseClicked(event -> {
        if (event.getClickCount() == 2 && (!linha.isEmpty())) {
          Aluno aluno = linha.getItem();
          this.editar(aluno);
        }
      });
      return linha;
    });
  }

  @Override
  public void aoReceberNavegacao(TelaEnum tela, Object objeto) {
    if (TelaEnum.ALUNO_LIST.equals(tela)) {
      alunos = alunoService.listar();
      tabAlunos.setItems(FXCollections.observableArrayList(alunos));
    }
  }

  @FXML
  public void incluir(ActionEvent event) throws IOException {
    JavaFxCrud.navegar(TelaEnum.ALUNO_FORM);
  }

  @FXML
  public void editar(ActionEvent event) throws IOException {
    Aluno aluno = tabAlunos.getSelectionModel().getSelectedItem();
    this.editar(aluno);
  }

  private void editar(Aluno aluno) {
    if (aluno == null) {
      AlertaUtil.exibirErro("Selecione um(a) aluno(a).");
      return;
    }
    JavaFxCrud.navegar(TelaEnum.ALUNO_FORM, aluno);
  }

  @FXML
  public void sair(ActionEvent event) {
    JavaFxCrud.fecharJanela();
  }
}
