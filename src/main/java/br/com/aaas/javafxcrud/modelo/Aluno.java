package br.com.aaas.javafxcrud.modelo;

import br.com.aaas.javafxcrud.enumeration.SexoEnum;
import br.com.aaas.javafxcrud.infra.AbstractModel;

public class Aluno extends AbstractModel {

  private Long     id;

  private String   nome;

  private SexoEnum sexo;

  public Aluno(Long id, String nome, SexoEnum sexo) {
    super();
    this.id = id;
    this.nome = nome;
    this.sexo = sexo;

    super.exigir(nome, "Informe o nome.");
    super.exigir(sexo, "Informe o sexo.");
  }

  public Aluno() {
    
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public SexoEnum getSexo() {
    return sexo;
  }
}
