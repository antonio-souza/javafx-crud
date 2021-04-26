package br.com.aaas.javafxcrud.infra;

import java.util.ArrayList;

import br.com.aaas.javafxcrud.enumeration.TelaEnum;

public class Navegacao {

  private Navegacao() {}

  private static ArrayList<ObservadorNavegacao> observadores = new ArrayList<>();

  public static void adicionarObservador(ObservadorNavegacao observador) {
    observadores.add(observador);
  }

  public static void notificarObservadores(TelaEnum tela, Object objeto) {
    for (ObservadorNavegacao observador : observadores) {
      observador.aoHaverNavegacao(tela, objeto);
    }
  }
}
