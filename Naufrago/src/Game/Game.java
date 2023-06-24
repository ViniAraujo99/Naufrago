package Game;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Game {

  // INSTANCIA TODAS AS CLASSES E SALVA NUMA VARÍAVEL
  // VARIAVÉIS DO JOGO
  public static final DecimalFormat dc = new DecimalFormat("0.00");

  public static Scanner sc = new Scanner(System.in);
  public static Menu menu = new Menu();
  public static Uteis  uteis = new Uteis();
  public static Inimigo inimigo;
  public static Jogador jogador;
  public static Boss boss;
  public static Historia historia = new Historia();
  public static Combate combate = new Combate();
  public static Game game;

  // INICIA O JOGO CHAMANDO O MÉTODO 'INTRO' DA CLASSE 'MENU'
  public static void main(String[] args) {
    menu.intro();
  }
}
