package br.com.aaas.javafxcrud.controller;

import br.com.aaas.javafxcrud.app.JavaFxCrud;
import br.com.aaas.javafxcrud.enumeration.SexoEnum;
import br.com.aaas.javafxcrud.enumeration.TelaEnum;
import br.com.aaas.javafxcrud.infra.AbstractController;
import br.com.aaas.javafxcrud.modelo.Aluno;
import br.com.aaas.javafxcrud.service.AlunoService;
import br.com.aaas.javafxcrud.util.AlertaUtil;
import br.com.aaas.javafxcrud.util.StringUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AlunoFormController extends AbstractController {

  @FXML
  private TextField          txtNome;

  @FXML
  private ComboBox<SexoEnum> cboSexo;

  @FXML
  private Button             btnGravar;

  @FXML
  private Button             btnExcluir;

  @FXML
  private Button             btnCancelar;

  private AlunoService       alunoService = AlunoService.getInstance();

  private Aluno              aluno;

  private Boolean            isInclusao;

  @Override
  public void aoInicializar() {
    cboSexo.setItems(FXCollections.observableArrayList(SexoEnum.values()));
  }

  @Override
  public void aoReceberNavegacao(TelaEnum tela, Object objeto) {
    if (TelaEnum.ALUNO_FORM.equals(tela)) {
      aluno = (Aluno) objeto;
      isInclusao = aluno == null;
      if (isInclusao) {
        inicializarInclusao();
      } else {
        inicializarEdicao();
      }
    }
  }

  private void inicializarInclusao() {
    btnGravar.setText("Incluir");
    btnExcluir.setVisible(false);
    txtNome.setText(null);
    cboSexo.setValue(null);
  }

  protected void inicializarEdicao() {
    btnGravar.setText("Alterar");
    btnExcluir.setVisible(true);
    txtNome.setText(aluno.getNome());
    cboSexo.setValue(aluno.getSexo());
  }

  @FXML
  public void gravar(ActionEvent event) {
    try {
      if (isInclusao) {
        this.incluir();
      } else {
        this.alterar();
      }
    } catch (Exception e) {
      AlertaUtil.exibirErro(e.getMessage());
    }
  }

  private void incluir() {
    String nome = StringUtil.pegarTexto(txtNome.getText());
    alunoService.incluir(nome, cboSexo.getValue());
    AlertaUtil.exibirInformacao("Aluno(a) incluído(a) com sucesso.");
    JavaFxCrud.navegar(TelaEnum.ALUNO_LIST);
  }

  private void alterar() {
    String nome = StringUtil.pegarTexto(txtNome.getText());
    alunoService.alterar(this.aluno.getId(), nome, cboSexo.getValue());
    AlertaUtil.exibirInformacao("Aluno(a) alterado(a) com sucesso.");
    JavaFxCrud.navegar(TelaEnum.ALUNO_LIST);
  }

  @FXML
  public void excluir(ActionEvent event) {
    if (!AlertaUtil.solicitarConfirmacao("Deseja realmente excluir o(a) aluno(a)?")) {
      return;
    }
    alunoService.exluir(aluno.getId());
    AlertaUtil.exibirInformacao("Aluno(a) excluído(a) com sucesso.");
    JavaFxCrud.navegar(TelaEnum.ALUNO_LIST);
  }

  @FXML
  public void cancelar(ActionEvent event) throws Throwable {
    JavaFxCrud.navegar(TelaEnum.ALUNO_LIST);
  }
}
