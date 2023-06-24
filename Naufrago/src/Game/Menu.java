package Game;

public class Menu {
	
	//INTRO - COM O NOME DO GRUPO + JOGO
	public void intro() {
		String texto = 	
						"||****************************************||\n" 
				+ 		"||         By The Code - Apresenta        ||\n"
				+ 		"||========================================||\n"
				+ 		"||                                        ||\n"
				+ 		"||                NÁUFRAGO                ||\n"
				+   	"||                                        ||\n"
				+ 		"||****************************************||\n";
		
		Game.uteis.printaTexto(texto, 5);
		Game.uteis.delayParaProximoComando(30);
		Game.uteis.limpaConsole();
		menu();
	}

	//MENU
	public void menu() {
		
		 String menu = 	
						"||****************************************||\n" 
				+ 		"||                  Menu                  ||\n"
				+ 		"||========================================||\n"
				+ 		"||                                        ||\n"
				+ 		"||               1 - Jogar                ||\n"
				+   	"||               2 - Instruções           ||\n"
				+   	"||               3 - Créditos             ||\n"
				+   	"||               4 - Sair                 ||\n"
				+ 		"||                                        ||\n"
				+ 		"||****************************************||\n\n";
		
		Game.uteis.printaTexto(menu, 5);
		 
		//OPÇÕES
		System.out.println(
				  		"||****************************************||\n"
				+ 		"||            DIGITE UMA OPÇÃO!           ||\n"
				+ 		"||****************************************||\n");
		
		String opcao = Game.sc.next().toUpperCase();
		
		switch (opcao) {
		case "1", "JOGAR":
			Game.uteis.limpaConsole();
			Game.historia.intro();
			break;
		case "2", "INSTRUCOES":
			Game.uteis.limpaConsole();
			instrucoes();
			break;
		case "3", "CREDITOS":
			Game.uteis.limpaConsole();
			creditos(false);
			break;
		case "4", "SAIR":
			Game.uteis.limpaConsole();
			sair();
			break;
		default:
			System.out.println("Opção inválida!");
			Game.uteis.limpaConsole();
			menu();	
		}
	}
	
	//INSTRUÇÕES
	public void instrucoes() {
		String instrucoes 	= 
								"||****************************************** INSTRUÇÕES *******************************************||\n"
							+ 	"|| VIDA MÁXIMA: Vida máxima do jogador;                                                            ||\n"
							+ 	"|| VIDA: Vida atual do jogador;                                                                    ||\n"
							+ 	"|| FORÇA: Força atual do jogador, utilizada para o cálculo de dano;                                ||\n"
							+ 	"|| RESISTÊNCIA: Resistência atual do jogador, utilizada para o cálculo de defesa;                  ||\n"
							+ 	"|| XP: Experiência atual do jogador, utilizada para subir de nível;                                ||\n"
							+ 	"|| ARMA: Arma atual do jogador, utilizada para o cálculo de dano;                                  ||\n"
							+ 	"|| ARMADURA: Armadura atual do jogador, utilizada para o cálculo de defesa;                        ||\n"
							+ 	"|| ESCOLHAS: Para definir o que deseja fazer, digite o número correspondente a cada uma das opções ||\n"
							+ 	"||                                                                                                 ||\n"
							+ 	"|| EXEMPLO: 1 - Jogar | 2 - Sair, se quiser jogar, digite 1, se quiser sair digite 2.              ||\n"
							+ 	"||*************************************************************************************************||\n\n";
		
		Game.uteis.printaTexto(instrucoes, 5);
		
		voltar();	
	}
	
	
	//CRÉDITOS
	public void creditos(boolean b) {
		String creditos = 
							"||************** CRÉDITOS **************||\n"
						+ 	"||               NAUFRAGO               ||\n"
						+ 	"||======================================||\n"
						+ 	"||        Uma produção By The Code      ||\n"
						+ 	"||                                      ||\n"
						+ 	"|| Uma criação de:                      ||\n"
						+ 	"|| Eduardo Ribeiro Torquato             ||\n"
						+ 	"|| Eliana Moura de Lima                 ||\n"
						+ 	"|| Nathalia Narumi Nakamura             ||\n"
						+ 	"|| Paulo Garcia Santos                  ||\n"
						+ 	"|| Vinicius Araujo da Silveira          ||\n"
						+ 	"||**************************************||\n\n";
	
		Game.uteis.printaTexto(creditos, 25);

		if (!b) {
			voltar();
		}
		else {
			Game.uteis.delayParaProximoComando(50);
			System.out.println();
			sair();
		}
	}
	
	//SAIR
	public void sair() {
		System.out.println(
							"||**************************************||\n"
						+ 	"||          OBRIGADO POR JOGAR!         ||\n"
						+ 	"||**************************************||\n");
		System.exit(1);
	}
	
	
	//VOLTAR - INFORMA AO JOGADOR PARA DIGITAR 1 PARA VOLTAR
	public void voltar() {
		System.out.println(
							"||**************************************||\n"
						+ 	"||          DIGITE 1 PARA VOLTAR!       ||\n"
						+ 	"||**************************************||\n");
		int opcao = Game.sc.nextInt();
		
		if(opcao == 1)  {
			Game.uteis.limpaConsole();
			menu();
		} else {
			System.out.println("Opção Inválida!");
			voltar();	
		}
	}
}