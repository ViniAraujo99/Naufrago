package Game;

public class Combate {

    private static int errarAtaque;
    private static int danoCritico;
    private static int inimigoSpawnControl = 0;

    public static void inimigo(String tipoInimigo, String nomeBoss) {

    	//VARIAVEIS
        String criatura = "";
        int random = Game.uteis.geraNumeroRandomico(0, 101);

        // SE FOR INIMIGO COMUM
        if (tipoInimigo == "inimigo") {

            // DEFININDO UM NOME ALEATÓRIO PARA O INÍMIGO (TEM % DE CHANCE DE NÃO APARECER)
            if (random >= 10 && random <= 40) {
                criatura = "Macaco-Aranha";
            } else if (random >= 41 && random <= 75) {
                criatura = "Cobra-Voadora";
            } else if (random >= 76) {
                criatura = "Lacraia-Grande";
            } else {
                return;
            }

            // CRIA UM INIMIGO COM OS STATUS ABAIXO
            Game.inimigo = new Inimigo(criatura, Game.jogador.getVidaMaxima() * 0.75, Game.jogador.getForca() * 0.50,
                    Game.jogador.getResistencia() * 0.50, Game.jogador.getNivel());
            System.out.println("Você encontra o inimigo: " + Game.inimigo.getNomeInimigo() + ".\n\n");

            combate(tipoInimigo);
        }

        // SE NÃO FOR INIMIGO COMUM É BOSS
        else {
        	
            // INIMIGO COM MAIS FORÇA
            if (random <= 50) {
                Game.boss = new Boss(nomeBoss, Game.jogador.getVidaMaxima() * 0.75, Game.jogador.getForca() * 0.75,
                        Game.jogador.getResistencia() * 0.50, Game.jogador.getNivel() * 2);
                System.out.println("Você encontra o inimigo: " + Game.boss.getNomeInimigo() + ".\n\n");

                combate(tipoInimigo);
            }

            // INIMIGO COM MAIS RESISTÊNCIA
            else {
                Game.boss = new Boss(nomeBoss, Game.jogador.getVidaMaxima() * 0.75, Game.jogador.getForca() * 0.50,
                        Game.jogador.getResistencia() * 0.75, Game.jogador.getNivel() * 2);
                System.out.println("Você encontra o inimigo: " + Game.boss.getNomeInimigo() + ".\n\n");

                combate(tipoInimigo);
            }
        }
    }

    //MÉTODO DE COMBATE
    public static void combate(String tipoInimigo) {

        String input = "";

        // OPÇÕES QUE IRÃO APARECER PARA O PRIMEIRO ÍNIMIGO - TUTORIAL
        if (inimigoSpawnControl == 0) {
            System.out.println(
                    "||*** O QUE VOCÊ FAZ? ***||\n"
                  + "||=======================||\n"
                  + "|| 1 - Ataca (Atacar)    ||\n"
                  + "||=======================||");

            input = Game.sc.next().toUpperCase();

            switch (input) {
                case "1", "ATACAR":
                    ataqueJogador(tipoInimigo);
                    Game.uteis.setAtaques();;
                    break;

                default:
                    System.out.println("Opção Inválida");
                    combate(tipoInimigo);
            }
        }

        // OPÇÕES QUE IRÃO APARECER PARA O SEGUNDO INIMIGO - TUTORIAL
        else if (inimigoSpawnControl == 1) {
            System.out.println(
                    "||*** O QUE VOCÊ FAZ? ***||\n"
                  + "||=======================||\n"
                  + "||  1 - Foge (Fugir)     ||\n"
                  + "||=======================||");

            input = Game.sc.next().toUpperCase();

            switch (input) {
                case "1", "FUGIR":
                    if (tipoInimigo == "boss") {
                        System.out.println("Você não pode fugir!\n\n");
                        combate(tipoInimigo);
                    } else {
                        inimigoSpawnControl++;
                        Game.uteis.setFugas();;
                        System.out.println(
                                "||*******************||\n"
                              + "||     VOCÊ FUGIU!   ||\n"
                              + "||*******************||\n");
                    }
                    return;

                default:
                    System.out.println("Opção Inválida");
                    combate(tipoInimigo);
            }
        }

        // OPÇÕES QUE IRÃO APARECER PARA OS DEMAIS INIMIGOS
        else {
            System.out.println(
                    "||*** O QUE VOCÊ FAZ? ***||\n"
                  + "||=======================||\n"
                  + "||  1 - Ataca (Atacar)   ||\n"
                  + "||  2 - Foge  (Fugir)    ||\n"
                  + "||=======================||");

            input = Game.sc.next().toUpperCase();

            switch (input) {
                case "1", "ATACAR":
                    Game.uteis.setAtaques();;
                    ataqueJogador(tipoInimigo);
                    break;
                case "2", "FUGIR":
                    if (tipoInimigo == "boss") {
                        System.out.println("Você não pode fugir!\n\n");
                        combate(tipoInimigo);
                    } else {
                        inimigoSpawnControl++;
                        Game.uteis.setFugas();;
                        System.out.println(
                                "||*******************||\n"
                              + "||     VOCÊ FUGIU!   ||\n"
                              + "||*******************||\n");
                    }
                    return;

                default:
                    System.out.println("Opção Inválida");
                    combate(tipoInimigo);
            }
        }
    }

    // ATAQUE DO JOGADOR
    public static void ataqueJogador(String tipoInimigo) {

        // VARIÁVEL PARA DEFINIR A CHANCE DE ERRO
        errarAtaque = Game.uteis.geraNumeroRandomico(0, 11);

        // PRINTA INFORMAÇÕES DO INIMIGO ATUAL OU DO BOSS
        // INFO INIMIGO
        if (tipoInimigo == "inimigo") {
            System.out.println(
                    "Você tenta atacar o(a) " + Game.inimigo.getNomeInimigo() + ".\n"
                            //+ "Seus Status: \n" + Game.jogador.getStatus() + "\n"
                            + "Status Inimigo: \n" + Game.inimigo.getStatusInimigo() + "\n");
        }

        // INFO BOSS
        else {
            System.out.println(
                    "Você tenta atacar o(a) " + Game.boss.getNomeInimigo() + ".\n"
                            //+ "Seus Status: \n" + Game.jogador.getStatus() + "\n"
                            + "Status Inimigo: \n" + Game.boss.getStatusInimigo() + "\n");
        }

        // SE A VARIÁVEL FOI MENOR QUE 2, ERRA O ATAQUE
        if (errarAtaque < 2) {
            System.out.println("Você errou o ataque");
            ataqueInimigo(tipoInimigo);
        }

        // SE A VARIÁVEL FOR MAIOR OU IGUAL A 2, ACERTA O ATAQUE
        else {

            // VARIÁVEL PARA DEFINIR A CHANCE DE DAR DANO CRÍTICO
            danoCritico = Game.uteis.geraNumeroRandomico(0, 11);

            // DANO INIMIGO
            if (tipoInimigo == "inimigo") {

                // SE A VARIÁVEL FOR MAIOR QUE 8, DÁ O ATAQUE CRÍTICO
                if (danoCritico > 8) {
                    Game.inimigo.setVidaInimigo(Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo()) * 2);
                    System.out.println(
                            		"Você deu "
                                    + Game.dc.format(
                                            Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo()) * 2)
                                    + " de dano.\n"
                                    + "Vida atual do inimigo: " //+ Game.dc.format(Game.inimigo.getVidaInimigo()) + "\n"
                                    + "" + Game.inimigo.printaVidaInimigo() + "\n");
                }

                // SE A VARIÁVEL FOR MENOR OU IGUAL A 8, NÃO DÁ O ATAQUE CRÍTICO
                else {
                    Game.inimigo.setVidaInimigo(Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo()));
                    System.out.println(
                            "Você deu "
                                    + Game.dc.format(Game.jogador.getDanoJogador(Game.inimigo.getResistenciaInimigo()))
                                    + " de dano.\n"
                                    + "Vida atual do inimigo: " //+ Game.dc.format(Game.inimigo.getVidaInimigo()) + "\n"
                                    + "" + Game.inimigo.printaVidaInimigo() + "\n");
                }

                // SE A VIDA DO INIMIGO FOR MAIOR QUE 0 (ESTÁ VIVO, O INIMIGO ATACA APÓS O
                // JOGADOR)
                if (Game.inimigo.getVidaInimigo() > 0) {
                    ataqueInimigo(tipoInimigo);
                }

                // SE A VIDA DO INIMIGO FOR MENOR OU IGUAL A 0, ADICIONA A XP DROPADA PELO
                // INIMIGO AO XP DO JOGADOR E,
                // SE FOR SUFICIENTE O JOGADOR PASSA DE NÍVEL
                else {
                    inimigoSpawnControl++;
                    System.out.println("Você derrotou o(a) " + Game.inimigo.getNomeInimigo() + ".\n");
                    Game.jogador.passaDeNivel(Game.inimigo.dropExperiencia());
                    System.out.println(Game.jogador.getStatus() + "\n");
                }
            }

            // DANO BOSS
            else {

                // SE A VARIÁVEL FOR MAIOR QUE 8, DÁ O ATAQUE CRÍTICO
                if (danoCritico > 8) {
                    Game.boss.setVidaInimigo(Game.jogador.getDanoJogador(Game.boss.getResistenciaInimigo()) * 2);
                    System.out.println(
                            "Você deu "
                                    + Game.dc.format(Game.jogador.getDanoJogador(Game.boss.getResistenciaInimigo()) * 2)
                                    + " de dano.\n"
                                    + "Vida atual do inimigo: " //+ Game.dc.format(Game.boss.getVidaInimigo()) + "\n"
                                    + "" + Game.boss.printaVidaInimigo() + "\n");
                }

                // SE A VARIÁVEL FOR MENOR OU IGUAL A 8, NÃO DÁ O ATAQUE CRÍTICO
                else {
                    Game.boss.setVidaInimigo(Game.jogador.getDanoJogador(Game.boss.getResistenciaInimigo()));
                    System.out.println(
                            "Você deu " + Game.dc.format(Game.jogador.getDanoJogador(Game.boss.getResistenciaInimigo()))
                                    + " de dano.\n"
                                    + "Vida atual do inimigo: " //+ Game.dc.format(Game.boss.getVidaInimigo()) + "\n"
                                    + "" + Game.boss.printaVidaInimigo() + "\n");
                }

                // SE A VIDA DO BOSS FOR MAIOR QUE 0 (ESTÁ VIVO, O BOSS ATACA APÓS O JOGADOR)
                if (Game.boss.getVidaInimigo() > 0) {
                    ataqueInimigo(tipoInimigo);
                }

                // SE A VIDA DO BOSS FOR MENOR OU IGUAL A 0, ADICIONA A XP DROPADA PELO BOSS AO
                // XP DO JOGADOR E,
                // SE FOR SUFICIENTE O JOGADOR PASSA DE NÍVEL
                else {
                    System.out.println("Você derrotou o(a): " + Game.boss.getNomeInimigo());
                    Game.jogador.passaDeNivel(Game.boss.dropExperiencia());
                    System.out.println(Game.jogador.getStatus() + "\n");
                }
            }
        }
    }

    // ATAQUE DO INIMIGO
    public static void ataqueInimigo(String tipoInimigo) {

        // VARIÁVEL PARA DEFINIR A CHANCE DE ERRO
        errarAtaque = Game.uteis.geraNumeroRandomico(0, 11);

        // SE FOR INÍMIGO PRINTA O NOME DO INÍMIGO QUE APARECEU
        if (tipoInimigo == "inimigo") {
            System.out.println("O(A) " + Game.inimigo.getNomeInimigo() + " tenta te atacar");
        }

        // SE FOR BOSS PRINTA O NOME DO BOSS
        else {
            System.out.println("O(A) " + Game.boss.getNomeInimigo() + " tenta te atacar");
        }

        // INIMIGO ERROU O ATAQUE
        if (errarAtaque < 2 && tipoInimigo == "inimigo") {
            System.out.println(Game.inimigo.getNomeInimigo() + " errou o ataque\n");
            combate(tipoInimigo);
        }

        // BOSS ERROU O ATAQUE
        else if (errarAtaque < 2 && tipoInimigo == "boss") {
            System.out.println(Game.boss.getNomeInimigo() + " errou o ataque\n");
            combate(tipoInimigo);
        }

        // SE NÃO ERRAR O ATAQUE
        else {

            // VARIÁVEL PARA DEFINIR A CHANCE DE DAR DANO CRÍTICO
            danoCritico = Game.uteis.geraNumeroRandomico(0, 11);

            // SE FOR O INÍMIGO
            if (tipoInimigo == "inimigo") {

                // SE A VARIÁVEL FOR MAIOR QUE 8, DÁ O ATAQUE CRÍTICO
                if (danoCritico > 8) {
                    Game.jogador.setVidaDano(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador()) * 2);
                    System.out.println(
                                "Você recebeu "
                             +  Game.dc.format(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador()) * 2)
                             +  " de dano.\n"
                             +  "Sua vida atual: " //+ Game.dc.format(Game.jogador.getVida()) + "\n");
                             +  "" + Game.jogador.printaVidaJogador() + "\n");
                }

                // SE A VARIÁVEL FOR MENOR OU IGUAL A 8, NÃO DÁ O CRÍTICO
                else {
                    Game.jogador.setVidaDano(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador()));
                    System.out.println(
                                "Você recebeu " + Game.dc.format(Game.inimigo.danoInimigo(Game.jogador.getDefesaJogador()))
                             +  " de dano.\n"
                             +  "Sua vida atual: " //+ Game.dc.format(Game.jogador.getVida()) + "\n");
                             +  "" + Game.jogador.printaVidaJogador() + "\n");

                }

                // SE A VIDA DO JOGADOR FOR MAIOR QUE 0, RETORNA PARA O MÉTODO DO COMBATE PARA
                // ESCOLHER NOVAMENTE
                if (Game.jogador.getVida() > 0) {
                    combate(tipoInimigo);
                }

                // SE A VIDA DO JOGADOR FOR MENOR OU IGUAL A 0, O JOGO TERMINA
                else {
                    fimDeJogo();
                }
            }

            // SE FOR O BOSS
            else {

                // SE A VARIÁVEL FOR MAIOR QUE 8, DÁ O ATAQUE CRÍTIC
                if (danoCritico > 8) {
                    Game.jogador.setVidaDano(Game.boss.danoInimigo(Game.jogador.getDefesaJogador()) * 2);
                    System.out.println(
                            "Você recebeu " + Game.dc.format(Game.boss.danoInimigo(Game.jogador.getDefesaJogador()) * 2)
                         +  " de dano.\n"
                         +  "Sua vida atual: " //+ Game.dc.format(Game.jogador.getVida()) + "\n");
                         +  "" + Game.jogador.printaVidaJogador() + "\n");

                }

                // SE A VARIÁVEL FOR MENOR OU IGUAL A 8, NÃO DÁ O CRÍTICO
                else {
                    Game.jogador.setVidaDano(Game.boss.danoInimigo(Game.jogador.getDefesaJogador()));
                    System.out.println(
                             "Você recebeu " + Game.dc.format(Game.boss.danoInimigo(Game.jogador.getDefesaJogador()))
                         +   " de dano.\n"
                         +   "Sua vida atual: " //+ Game.dc.format(Game.jogador.getVida()) + "\n");
                         +   "" + Game.jogador.printaVidaJogador() + "\n");
                }

                // SE A VIDA DO JOGADOR FOR MAIOR QUE 0, RETORNA PARA O MÉTODO DO COMBATE PARA
                // ESCOLHER NOVAMENTE
                if (Game.jogador.getVida() > 0) {
                    combate(tipoInimigo);
                }

                // SE A VIDA DO JOGADOR FOR MENOR OU IGUAL A 0, O JOGO TERMINA
                else {
                    fimDeJogo();
                }
            }
        }
    }
    
    // SE O JOGADOR MORRER O JOGO ACABA
    public static void fimDeJogo() {
        System.out.println(
                "||********************||\n"
              + "||    VOCÊ MORREU!    ||\n"
              + "||    FIM DE JOGO     ||\n"
              + "||********************||\n\n");

        Game.uteis.delayParaProximoComando(50);
        Game.menu.sair();
    }
}
