package br.com.aaas.javafxcrud.service;

import java.util.List;

import br.com.aaas.javafxcrud.enumeration.SexoEnum;
import br.com.aaas.javafxcrud.modelo.Aluno;

public class AlunoService {

  private static AlunoService instance;

  private AlunoRepository     alunoRepository;

  private AlunoService() {
    alunoRepository = AlunoRepository.getInstance();
  }

  public static synchronized AlunoService getInstance() {
    if (instance == null) {
      instance = new AlunoService();
    }
    return instance;
  }

  public List<Aluno> listar() {
    return alunoRepository.listar();
  }

  public Aluno consultar(Long id) {
    return alunoRepository.consultar(id);
  }

  public void incluir(String nome, SexoEnum sexo) {
    Aluno aluno = new Aluno(null, nome, sexo);
    alunoRepository.incluir(aluno);
  }

  public void alterar(Long id, String nome, SexoEnum sexo) {
    Aluno aluno = new Aluno(id, nome, sexo);
    alunoRepository.alterar(aluno);
  }

  public void exluir(Long id) {
    Aluno aluno = alunoRepository.consultar(id);
    alunoRepository.exluir(aluno);
  }
}
