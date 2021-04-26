package br.com.aaas.javafxcrud.enumeration;

public enum SexoEnum {
  MASCULINO("Masculino", "o"),
  FEMININO("Feminino", "a");
  
  private String nome;
  
  private String artigo;

  private SexoEnum(String nome, String artigo) {
    this.nome = nome;
    this.artigo = artigo;
  }

  public String getNome() {
    return nome;
  }
  
  public String getArtigo() {
    return artigo;
  }

  @Override
  public String toString() {
    return nome;
  }
  
  public static SexoEnum getInstance(String nome) {
    for (SexoEnum e : SexoEnum.values()) {
      if (e.nome.equals(nome)) {
        return e;
      }
    }
    return null;
  }
}
