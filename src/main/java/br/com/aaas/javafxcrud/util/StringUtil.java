package br.com.aaas.javafxcrud.util;

public class StringUtil {
  
  private StringUtil() {}
  
  public static String pegarTexto(String texto) {
    if (texto == null) {
      return null;
    }
    return texto.isEmpty() ? null : texto;
  }
}
