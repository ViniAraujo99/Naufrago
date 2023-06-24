package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Uteis {

	// VARIAVÉIS
	private Random random = new Random();

	private List<String> relatorio = new ArrayList<String>();
	private int ataques = 0;
	private int fugas = 0;

	// PRINTA O TEXTO LETRA POR LETRA, PARA FAZER UMA 'ANIMAÇÃO' AO INVÉS DO PRINT
	// PADRÃO
	public void printaTexto(String texto, int tempo) {
		for (int i = 0; i < texto.length(); i++) {
			System.out.print(texto.charAt(i));
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// "LIMPA O CONSOLE", PRINTANDO 50 LINHAS EM BRANCO.
	public void limpaConsole() {

		for (int i = 0; i <= 50; i++) {
			System.out.println();
		}
	}

	// GERA UM NÚMERO 'ALEATÓRIO' ENTRE OS VALORES PASSADOS
	public int geraNumeroRandomico(int valorMin, int valorMax) {
		return random.nextInt(valorMin, valorMax);
	}

	// EXECUTA O PRÓXIMO COMANDO APÓS X PERÍODO DE TEMPO, 25 = 2500 = 2 SEGUNDOS E 5
	// MILÉSSIMOS
	public void delayParaProximoComando(int tempo) {

		tempo *= 100;
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ADIÇÃO RELATÓRIOS
	public void addRelatorios(String text) {
		relatorio.add(text);
	}

	public void mostraRelatorio() {

		Game.uteis.limpaConsole();

		String rel = "▪——————————————————————————————————————————————— ⟦ RELATÓRIO ⟧ ———————————————————————————————————————————————▪: \n\n";

		printaTexto(rel, 5);

		for (int i = 0; i < relatorio.size(); i++) {
			System.out.print(" ✓ " + relatorio.get(i) + "\n");
			System.out.println();
		}

		System.out.println("");

		if (ataques == 1 && fugas > 1) {
			System.out.println(" ——————————————————————————————————— VOCÊ ATACOU " + ataques + " VEZ E FUGIU " + fugas
					+ " VEZES. ———————————————————————————————————");
		} else if (ataques > 1 && fugas == 1) {
			System.out.println(" ——————————————————————————————————— VOCÊ ATACOU " + ataques + " VEZES E FUGIU " + fugas
					+ " VEZ. ———————————————————————————————————");
		} else if (ataques > 1 && fugas > 1) {
			System.out.println(" ——————————————————————————————————— VOCÊ ATACOU " + ataques + " VEZES E FUGIU " + fugas
					+ " VEZES. ———————————————————————————————————");
		}

		if (ataques > 30) {
			System.out.println("\nClaramente você é uma pessoa que não foge de confusão!\n\n\n\n\n");
		} 
		
		else {
			System.out.println(
					"\nVocê optou por fazer parte do caminho de forma mais pacífica, parabéns!\n\n\n\n\n");
		}
	}

	public void setAtaques() {
		this.ataques += 1;
	}

	public void setFugas() {
		this.fugas += 1;
	}
}
