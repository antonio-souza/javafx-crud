package br.com.aaas.javafxcrud.service;

import java.util.ArrayList;
import java.util.List;

import br.com.aaas.javafxcrud.enumeration.SexoEnum;
import br.com.aaas.javafxcrud.modelo.Aluno;

public class AlunoRepository {

  private static AlunoRepository instance;

  private List<Aluno>            alunos;

  private Long                   ultimoId;

  private AlunoRepository() {
    ultimoId = 0L;
    alunos = new ArrayList<>();
    alunos.add(new Aluno(++ultimoId, "Antonio Souza", SexoEnum.MASCULINO));
    alunos.add(new Aluno(++ultimoId, "Michele Ortiz", SexoEnum.FEMININO));
  }

  public static synchronized AlunoRepository getInstance() {
    if (instance == null) {
      instance = new AlunoRepository();
    }
    return instance;
  }

  public List<Aluno> listar() {
    return alunos;
  }

  public Aluno consultar(Long id) {
    return alunos.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
  }

  public void incluir(Aluno aluno) {
    alunos.add(new Aluno(++ultimoId, aluno.getNome(), aluno.getSexo()));
  }

  public void alterar(Aluno aluno) {
    Aluno alunoExistente = this.consultar(aluno.getId());
    alunos.set(alunos.indexOf(alunoExistente), aluno);
  }

  public void exluir(Aluno aluno) {
    Aluno alunoExistente = this.consultar(aluno.getId());
    alunos.remove(alunoExistente);
  }
}
