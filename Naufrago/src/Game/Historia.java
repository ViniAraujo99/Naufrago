package Game;

public class Historia {

        // VARIÁVEIS DE CONTROLE DA HISTÓRIA
        private boolean control, agua, comida, folhas, madeira, corda, caminhoFumacaArvore = true,
                        caminhoFumacaCachoeira = true;
        private String input = "";

        // INTRO
        public void intro() {

                String intro = "||******************************************** INTRO ********************************************||\n"
                                + "|| Uma tempestade torrencial cai dos céus sobre o jato Praetor 600, enquanto os raios e trovões  ||\n"
                                + "|| intermitentes cortam as nuvens e os ouvidos da tripulação e seus passageiros. Que era apenas  ||\n"
                                + "|| constituída por dois pilotos e uma comitiva de pesquisadores destinada a ilha Vostok, que     ||\n"
                                + "|| ainda não tinha sido mapeada.                                                                 ||\n"
                                + "|| A turbulência estava fora do comum e o comandante já não possuía mais forças para segurar o   ||\n"
                                + "|| manche, que agora parecia pesar uma tonelada. Como uma força sobrenatural, o avião dá um      ||\n"
                                + "|| solavanco abrupto para baixo quando uma das turbinas explode e a aeronave parece ser “sugada” ||\n"
                                + "|| em direção ao mar, como se não fosse meramente a força da gravidade.                          ||\n"
                                + "|| Agora despencando em uma queda livre, avançando metros e metros em poucos segundos em direção ||\n"
                                + "|| a água, um breve vislumbre de um imenso buraco negro no meio do nada, é visto através de uma  ||\n"
                                + "|| pequena janela por um dos tripulantes que ainda mantinha o pouco de sua sanidade intacta.     ||\n"
                                + "|| E então, a colisão.                                                                           ||\n"
                                + "||***********************************************************************************************||\n\n";

                Game.uteis.printaTexto(intro, 5);

                try {
                        Thread.sleep(2000);
                        apresentacao();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }

        // APRESENTAÇÃO
        public void apresentacao() {

                String apresentacaoNome = "||**********************************************************||\n"
                                + "|| Você acorda numa ilha no meio do Pacífico.               ||\n"
                                + "|| Olhando ao redor você nota que todos os outros           ||\n"
                                + "|| membros da comitiva não tiveram a mesma sorte que você.  ||\n"
                                + "|| Você tenta se lembrar de coisas básicas como o seu nome. ||\n"
                                + "||**********************************************************||\n\n";

                Game.uteis.printaTexto(apresentacaoNome, 5);

                System.out.println(
                                "||*********************||\n"
                              + "|| COMO VOCÊ SE CHAMA: ||\n"
                              + "||*********************||\n");

                // ESCOLHE O NOME
                String nome = Game.sc.next().toUpperCase();

                String apresentacaoProfissao = "\n"
                                + "||***********************************************************||\n"
                                + "|| Você também tenta lembrar de outras coisas                ||\n"
                                + "|| básicas da sua vida para garantir que está tudo bem,      ||\n"
                                + "|| você tenta se recordar do que fazia:                      ||\n"
                                + "||***********************************************************||\n\n"

                                + "||****************** ESCOLHA SUA PROFISSÃO ******************||\n"
                                + "||===========================================================||\n"
                                + "||   PROFI/STATUS  |   VIDA    |    FORÇA   |   RESISTÊNCIA  ||\n"
                                + "||===========================================================||\n"
                                + "||   1 - MÉDICO    |    +5     |      +0    |        +5      ||\n"
                                + "||===========================================================||\n"
                                + "||   2 - SOLDADO   |    +5     |      +5    |        +0      ||\n"
                                + "||===========================================================||\n"
                                + "||   3 - PROFESSOR |   +2,5    |      +3    |        +3      ||\n"
                                + "||===========================================================||\n"
                                + "||***********************************************************||\n\n";

                Game.uteis.printaTexto(apresentacaoProfissao, 5);

                System.out.println(
                                "||**********************||\n"
                              + "|| QUAL SUA PROFISSÃO?: ||\n"
                              + "||**********************||\n");

                // ESCOLHE A PROFISSÃO
                input = Game.sc.next().toUpperCase();
                String profissao = "";

                // INSTANCIA O JOGADOR
                switch (input) {
                        case "1", "MEDICO", "MÉDICO":
                                profissao = "MÉDICO";
                                Game.jogador = new Jogador(nome, profissao);
                                Game.uteis.addRelatorios(
                                                "Você escolheu ser um Médico. Definitivamente você é uma pessoa que gosta de estar preparada para os problemas, com ou sem kits médicos.");
                                break;

                        case "2", "SOLDADO":
                                profissao = "SOLDADO";
                                Game.jogador = new Jogador(nome, profissao);
                                Game.uteis.addRelatorios(
                                                "Você escolheu ser um Soldado. Você já passou por várias guerras, esse teste com certeza foi fácil pra você.");
                                break;

                        case "3", "PROFESSOR":
                                profissao = "PROFESSOR";
                                Game.jogador = new Jogador(nome, profissao);
                                Game.uteis.addRelatorios(
                                                "Você escolheu ser um Professor. Para você, a estratégia é fundamental para resolver qualquer problema. Muito esperto!");
                                break;

                        default:
                                Game.uteis.limpaConsole();
                                System.out.println("Opção inválida!");
                                apresentacao();
                }

                String lembranca = 
                					"||*************************************************************************||\n"
                                + 	"|| Apesar de atordoado, você se levanta e dá alguns passos lentos na areia ||\n"
                                + 	"|| tentando encontrar algum sinal de vida ou esperança.                    ||\n"
                                + 	"|| Caminhando pela orla, você avista o que parece ser algum                ||\n"
                                + 	"|| objeto útil um pouco atolado na areia.                                  ||\n"
                                + 	"||*************************************************************************||\n\n";

                Game.uteis.printaTexto(lembranca, 5);

                primeiroAto();
        }

        // PRIMEIRO ATO
        public void primeiroAto() {

                // A VARIÁVEL DE CONTROLE SERVE PARA NÃO PRINTAR O TEXTO NOVAMENTE CASO O
                // JOGADOR SELECIONE UMA OPÇÃO INVÁLIDA
                if (!control) {
                        double random = Game.uteis.geraNumeroRandomico(0, 101);

                        // SE MAIOR OU IGUAL A 50, ACHA O ITEM
                        if (random >= 50) {
                                caminhoItem();
                                control = true;
                        }

                        // SE FOR MENOR VAI PELA CAMINHO NORMAL
                        else {
                                caminhoNormal();
                                control = true;
                        }
                }

                System.out.println(
                                "||********** O QUE VOCÊ FAZ? ***********||\n"
                                                + "||======================================||\n"
                                                + "|| 1 - Seguir pela Praia    (Praia)     ||\n"
                                                + "|| 2 - Seguir pela Floresta (Floresta)  ||\n"
                                                + "||======================================||\n");

                // ESCOLHA DO JOGADOR
                input = Game.sc.next().toUpperCase();

                switch (input) {
                        case "1", "PRAIA":
                                control = false;
                                Game.uteis.addRelatorios(
                                                "Você decidiu seguir pela Praia. Com certeza esse é o seu roteiro preferido de férias!");
                                caminhoPraia();
                                break;

                        case "2", "FLORESTA":
                                control = false;
                                Game.uteis.addRelatorios(
                                                "Você decidiu seguir pela Floresta. Com certeza é uma pessoa que gosta de se conectar com a natureza.");
                                caminhoFloresta();
                                break;

                        default:
                                System.out.println("Opção Inválida!");
                                primeiroAto();
                }

        }

        // CAMINHO COM ITEM
        public void caminhoItem() {

                Game.jogador.setResistencia(1);
                String caminhoItem = "";
                caminhoItem = "||****************************************************************************||\n"
                                + "|| Apesar da queda, você encontra um item que pode te auxiliar naquele lugar. ||\n"
                                + "|| Um boné! Vai ser bom para se proteger do sol!                              ||\n"
                                + "|| Você aumentou sua resistência!                                             ||\n"
                                + "||****************************************************************************||\n\n"
                                + "  RESISTÊNCIA: +" + Game.jogador.getResistencia() + "\n\n"
                                + "||****************************************************************************||\n"
                                + "|| Andando mais a frente, você nota uma mata fechada ao norte,                ||\n"
                                + "|| mas também nota que a praia se estende ao redor de toda a ilha.            ||\n"
                                + "||****************************************************************************||\n\n";

                Game.uteis.printaTexto(caminhoItem, 5);
                Game.jogador.setArmadura("Boné");
        }

        // CAMINHO SEM ITEM
        public void caminhoNormal() {
                String caminhoNormal = "";
                caminhoNormal = "||*******************************************************************||\n"
                                + "|| Era apenas um pedaço de folha atolado na areia, que pena.         ||\n"
                                + "|| Aparentemente, tudo de útil que estava no avião se perdeu.        ||\n"
                                + "|| Andando mais a frente, você nota uma mata fechada ao norte,       ||\n"
                                + "|| mas também nota que a praia se estende ao redor de toda a ilha.   ||\n"
                                + "||*******************************************************************||\n\n";

                Game.uteis.printaTexto(caminhoNormal, 5);
        }

        // CAMINHO DA PRAIA
        public void caminhoPraia() {

                String caminhoPraia = "||***********************************************************************************************||\n"
                                + "|| Andando pela praia, você encontra parte dos destroços do avião, não parece ter nada útil,     ||\n"
                                + "|| exceto por um encosto de braço de um dos assentos do avião que se partiu exatamente após a    ||\n"
                                + "|| curvatura, gerando um punhal praticamente perfeito. Você analisa e decide utilizar o encosto  ||\n"
                                + "|| como arma.                                                                                    ||\n"
                                + "||***********************************************************************************************||\n\n";

                String continuacaoPraia = 
                					"||***********************************************************************************************||\n"
                                + 	"|| Você se depara com uma montanha de rochas que impede que você siga pela praia, sua única      ||\n"
                                + 	"|| opção é entrar na floresta e é exatamente isso que você faz.                                  ||\n"
                                + 	"|| Entrando na floresta você se depara com uma cobra no tronco de uma árvore, porém você nota    ||\n"
                                + 	"|| alguma coisa brotando do que seriam as costas do réptil, mas também nota que ela aparenta     ||\n"
                                + 	"|| ser um filhote pelo seu tamanho. Quando você percebe a peculiaridade deste animal, ela já     ||\n"
                                + 	"|| está avançando em sua direção com um par de asas abertas e por mais jovem que seja, é um      ||\n"
                                + 	"|| animal extremamente violento. Você já notou que as histórias sobre esse lugar aparentavam     ||\n"
                                + 	"|| ser verdadeiras.                                                                              ||\n"
                                + 	"||***********************************************************************************************||\n\n";

                Game.uteis.printaTexto(caminhoPraia, 5);

                // DEFINE A NOVA ARMA
                Game.jogador.setArma("Braço do Assento");

                // PRINTA A NOVA ARMA E A DEFESA QUE ELA DÁ
                System.out.println("Arma Atualizada: " + Game.jogador.getArma() + " | Dano: "
                                + Game.jogador.getDanoArma(Game.jogador.getArma()) + "\n");
                Game.uteis.printaTexto(continuacaoPraia, 5);

                // GERA O INÍMIGO DE FORMA MANUAL, POIS SEMPRE QUEREMOS QUE SEJA ESSE
                Game.inimigo = new Inimigo("Cobra-Voadora", Game.jogador.getVida() * 0.25,
                                3 * Game.jogador.getNivel(),
                                3 * Game.jogador.getNivel(),
                                Game.jogador.getNivel());
                Combate.combate("inimigo");

                // CHAMA O PRÓXIMO ATO AO DERROTAR O INÍMIGO
                segundoAto();
        }

        // CAMINHO DA FLORESTA
        public void caminhoFloresta() {

                // VARIÁVEIS CONTENDO OS TEXTOS DO MÉTODO
                String caminhoFloresta = "||**************************************************************************************************||\n"
                                + "|| Ao entrar na floresta você é quase atingido por um coco, vindo do alto.                          ||\n"
                                + "|| Tentando entender o que poderia ter jogado aquilo, você avista um pequeno macaco, porém,         ||\n"
                                + "|| ele possui características que te deixam bem amedrontado                                         ||\n"
                                + "|| Apesar de sua estatura, o macaco possui 6 braços e 4 olhos vermelhos no rosto que te encaram     ||\n"
                                + "|| com bastante raiva. Você já notou que as histórias sobre esse lugar aparentavam ser verdadeiras. ||\n"
                                + "||**************************************************************************************************||\n\n";

                String continuacaoFloresta = "||*************************************************************************************************||\n"
                                + "|| Você pega o coco que o macaco havia jogado em você. Parece seguro comer. Você se sente renovado.||\n"
                                + "|| Além disso, o coco tem uma tamanho maior que o normal e parece servir como um ótimo capacete.   ||\n"
                                + "||*************************************************************************************************||\n\n";

                Game.uteis.printaTexto(caminhoFloresta, 5);

                // SPAWNA O INÍMIGO DE FORMA MANUAL, POIS SEMPRE QUEREMOS QUE SEJA ESSE
                Game.inimigo = new Inimigo("Macaco-Aranha", Game.jogador.getVida() * 0.25,
                                3 * Game.jogador.getNivel(),
                                3 * Game.jogador.getNivel(),
                                Game.jogador.getNivel());
                Combate.combate("inimigo");

                Game.uteis.printaTexto(continuacaoFloresta, 15);

                // SE A VIDA DO JOGADOR FOR DIFERENTE DA VIDA MÁXIMA, RESTAURA A VIDA DO JOGADOR
                if (Game.jogador.getVida() != Game.jogador.getVidaMaxima()) {
                        Game.jogador.setVida(Game.jogador.getVidaMaxima());
                        System.out.println("Vida Atual: " + Game.jogador.getVida() + "\n");
                }

                // DEFINE A NOVA ARMADURA
                Game.jogador.setArmadura("Capacete de Coco");

                // PRINTA A NOVA ARMADURA E A DEFESA QUE ELA DÁ
                System.out.println("Armadura Atualizada: " + Game.jogador.getArmadura() + " | Defesa: "
                                + Game.jogador.getDefesaArmadura(Game.jogador.getArmadura()) + "\n");

                // CHAMA O PRÓXIMO ATO AO DERROTAR O INÍMIGO
                segundoAto();
        }

        // SEGUNDO ATO - INTRODUÇÃO AO SISTEMA DE FUGA.
        public void segundoAto() {

                if (!control) {
                        String caminhosUnificados = "||***********************************************************************************************||\n"
                                        + "|| Você continua floresta adentro, ao retirar alguns galhos e folhas do caminho, você            ||\n"
                                        + "|| acidentalmente se depara com um, ou melhor, centenas de patas pertencentes a uma Lacraia      ||\n"
                                        + "|| Gigante, com aproximadamente 3,50m de comprimento bem próximo a você. Ela não gostou de você  ||\n"
                                        + "|| por ter descoberto o esconderijo dela, expondo-a à luz do dia. Enquanto ela se contorce para  ||\n"
                                        + "|| cima para te amedrontar, a única coisa que vem a sua mente é que este inseto aparentava ser   ||\n"
                                        + "|| bem mais forte do que a última criatura que enfrentou.                                        ||\n"
                                        + "||***********************************************************************************************||\n\n";

                        String caminhosUnificadosContinuacao = "||***********************************************************************************************||\n"
                                        + "|| Diante de uma criatura aterrorizante daquela, você decide fugir. Você corre até uma clareira, ||\n"
                                        + "|| onde seus passos desesperados conseguiram te levar, pois percebeu que aquela criatura não     ||\n"
                                        + "|| gostava muito da luz do sol portanto ela não te seguiu.                                       ||\n"
                                        + "|| Chegando naquele espaço aberto, você começa a raciocinar sobre seu real estado, onde você se  ||\n"
                                        + "|| encontra e o que mais aquela ilha poderia estar guardando para você.                          ||\n"
                                        + "|| Diante desse cenário você decide traçar um plano para fugir, porém você não sabe quanto tempo ||\n"
                                        + "|| exatamente isso pode levar e por instinto, você sabe que vai escurecer em algumas horas.      ||\n"
                                        + "|| Tentando aumentar suas chances de sobrevivência você decide procurar por água, comida e       ||\n"
                                        + "|| abrigo. Porém, duas coisas chamam sua atenção.                                                ||\n"
                                        + "|| Ao leste você ouve um som de água, aparentemente vindo de uma cachoeira. E, ao oeste você     ||\n"
                                        + "|| consegue ver um sinal de fumaça entre a copa das árvores.                                     ||\n"
                                        + "||***********************************************************************************************||\n\n";

                        Game.uteis.printaTexto(caminhosUnificados, 5);

                        // SPAWNA O INÍMIGO DE FORMA MANUAL, POIS SEMPRE QUEREMOS QUE SEJA ESSE
                        Game.inimigo = new Inimigo("Lacraia-Gigante", 50 * Game.jogador.getNivel(),
                                        10 * Game.jogador.getNivel(),
                                        10 * Game.jogador.getNivel(),
                                        12 + Game.jogador.getNivel());
                        Combate.combate("inimigo");

                        Game.uteis.printaTexto(caminhosUnificadosContinuacao, 5);

                        control = true;
                }

                System.out.println(
                                "||*************  O QUE VOCÊ FAZ? *************||\n"
                                                + "||============================================||\n"
                                                + "|| 1 - Anda em direção ao Leste (Cachoeira)   ||\n"
                                                + "|| 2 - Anda em direção ao Oeste (Fumaça)      ||\n"
                                                + "||============================================||\n");

                // ESCOLHAS DO JOGADOR
                input = Game.sc.next().toUpperCase();

                switch (input) {

                        case "1", "CACHOEIRA":
                                control = false;
                                Game.uteis.addRelatorios(
                                                "Você seguiu em direção a Cachoeira. É um sinal que talvez você precise relaxar.");
                                Game.uteis.limpaConsole();
                                Combate.inimigo("inimigo", "");
                                caminhoCachoeira();
                                break;

                        case "2", "FUMAÇA":
                                control = false;
                                Game.uteis
                                                .addRelatorios("Você seguiu em direção a Fumaça. É um sinal que talvez você odeie ficar sozinho!");
                                Game.uteis.limpaConsole();
                                Combate.inimigo("inimigo", "");
                                caminhoFumaca();
                                break;

                        default:
                                Game.uteis.limpaConsole();
                                System.out.println("Opção inválida!");
                                segundoAto();
                }
        }

        // CAMINHO DA CACHOEIRA
        public void caminhoCachoeira() {

                agua = true;

                if (!control) {
                        String caminhoCachoeira = "||************************************************************************************************||\n"
                                        + "|| Ao chegar na cachoeira você se depara com um local lindo e estaria ainda mais maravilhado se   ||\n"
                                        + "|| não lembrasse das possíveis lacraias gigantes que poderiam existir por ali, te deixando        ||\n"
                                        + "|| alerta. Além disso você consegue ver a extensão do rio levando até a praia, você está          ||\n"
                                        + "|| morrendo de sede e precisa se hidratar, mesmo com os riscos você decide beber a água.          ||\n"
                                        + "||************************************************************************************************||\n\n";

                        String continuacaoCachoeira = "||************************************************************************************************||\n"
                                        + "|| A água parece boa, você se sente renovado.                                                     ||\n"
                                        + "|| Olhando a frente, você verifica que numa das “paredes” da cachoeira possui uma abertura.       ||\n"
                                        + "|| Aparentemente uma caverna que poderia servir de abrigo durante a noite, mas ela pode abrigar   ||\n"
                                        + "|| criaturas desconhecidas como as vistas até aqui.                                               ||\n"
                                        + "|| Você pode ir para a caverna ou você pode voltar para a clareira e seguir o sinal de fumaça que ||\n"
                                        + "|| viu mais cedo.                                                                                 ||\n"
                                        + "||************************************************************************************************||\n\n";

                        Game.uteis.printaTexto(caminhoCachoeira, 5);

                        // SE A VIDA DO JOGADOR FOR DIFERENTE DA VIDA MÁXIMA, RESTAURA A VIDA DO JOGADOR
                        if (Game.jogador.getVida() != Game.jogador.getVidaMaxima()) {
                                Game.jogador.setVida(Game.jogador.getVidaMaxima());
                                System.out.println("Vida Atual: " + Game.jogador.getVida() + ".\n");
                        }

                        Game.uteis.printaTexto(continuacaoCachoeira, 5);

                        control = true;
                }

                System.out.println(
                                "||********* O QUE VOCÊ FAZ? *********||\n"
                                                + "||===================================||\n"
                                                + "||  1 - Entra na caverna   (Caverna) ||\n"
                                                + "||  2 - Volta para o Oeste (Fumaça)  ||\n"
                                                + "||===================================||\n");

                // ESCOLHAS DO JOGADOR
                input = Game.sc.next().toUpperCase();

                switch (input) {

                        case "1", "CAVERNA":
                                control = false;
                                Game.uteis.addRelatorios(
                                                "Você decidiu ir primeiro para a Caverna. Isso mostra que após qualquer momento de descanso, você se renova e consegue correr qualquer maratona.");
                                Game.uteis.limpaConsole();
                                caminhoCaverna();
                                break;

                        case "2", "FUMAÇA":
                                control = false;
                                if (caminhoFumacaCachoeira) {
                                        Game.uteis.addRelatorios(
                                                        "Você decidiu ir primeiro para a Cachoeira, mas preferiu voltar. Certamente é uma pessoa muito indecisa... Ou cautelosa?");
                                }
                                caminhoFumacaCachoeira = false;
                                Game.uteis.limpaConsole();
                                caminhoFumaca();
                                break;

                        default:
                                Game.uteis.limpaConsole();
                                System.out.println("Opção inválida!");
                                caminhoCachoeira();
                }

        }

        // CAMINHO DA CAVERNA
        public void caminhoCaverna() {

                if (!control) {
                        String caminhoCaverna = "||************************************************************************************************||\n"
                                        + "|| Se esgueirando pelos cantos até entrar na caverna, você acha estranho o fato dela ser quente e ||\n"
                                        + "|| pensa que passar a noite ali seria realmente bem agradável, afinal, você já estaria protegido  ||\n"
                                        + "|| do frio, porém, não é só você que teve essa ideia...                                           ||\n"
                                        + "|| No teto da caverna, de cabeça para baixo, está pendurado o que parece ser uma família          ||\n"
                                        + "|| enorme de morcegos fluorescentes e no meio deles, existe um que se destaca, aparentemente a    ||\n"
                                        + "|| mãe de todos aqueles animais exóticos.                                                         ||\n"
                                        + "|| Ela acorda com um grito amedrontador e feroz quando te vê, abre as asas iluminando ainda mais  ||\n"
                                        + "|| toda a caverna e avança na sua direção.                                                        ||\n"
                                        + "||************************************************************************************************||\n\n";

                        Game.uteis.printaTexto(caminhoCaverna, 5);

                        control = true;
                }

                System.out.println(
                                "||*************** O QUE VOCÊ FAZ? ***************||\n"
                                                + "||===============================================||\n"
                                                + "||    1 - Ataca (Atacar)                         ||\n"
                                                + "||    2 - Foge  (Fugir - Volta para a Cachoeira) ||\n"
                                                + "||===============================================||\n");

                // ESCOLHAS DO JOGADOR
                input = Game.sc.next().toUpperCase();

                switch (input) {

                        case "1", "ATACA":
                                control = false;
                                Game.uteis.setAtaques();
                                ;
                                Game.uteis.limpaConsole();

                                // SPAWNA BOSS
                                Combate.inimigo("boss", "Morcego-Fluorescentes");

                                // SE DERROTAR O BOSS:
                                // DEFINE A NOVA ARMADURA
                                Game.jogador.setArma("Osso Humano");

                                String continuacaoCaverna = "||***********************************************************************************************||\n"
                                                + "|| Após você enfrentar e matar a mãe de todos, seus filhotes voam para fora da caverna,          ||\n"
                                                + "|| fugindo com medo, agora que sua mãe está morta.                                               ||\n"
                                                + "|| Agora mais calmo, você consegue notar alguns objetos do que um dia pertenceram a um humano    ||\n"
                                                + "|| que não teve tanta sorte quanto você. Pela insígnia em sua roupa desgastada, ele parecia um   ||\n"
                                                + "|| piloto.                                                                                       ||\n"
                                                + "|| Avaliando mais de perto vê que o osso fêmural daquele pobre piloto poderia ser útil.          ||\n"
                                                + "||***********************************************************************************************||\n\n";

                                Game.uteis.printaTexto(continuacaoCaverna, 5);

                                // PRINTA A NOVA ARMADURA E A DEFESA QUE ELA DÁ
                                System.out.println("Arma Atualizada: " + Game.jogador.getArma()
                                                + " | Dano: " + Game.jogador.getDanoArma(Game.jogador.getArma())
                                                + ".\n");

                                // CHAMA O PRÓXIMO ATO
                                terceiroAto();
                                break;

                        case "2", "FOGE":
                                control = false;
                                Game.uteis.setFugas();
                                ;
                                Game.uteis.limpaConsole();
                                caminhoCachoeira();
                                break;

                        default:
                                Game.uteis.limpaConsole();
                                System.out.println("Opção inválida!");
                                caminhoCaverna();
                }
        }

        // CAMINHO DA FUMAÇA
        public void caminhoFumaca() {

                comida = true;

                if (!control) {
                        String caminhoFumaca = "||************************************************************************************************||\n"
                                        + "|| Ao chegar no local da fumaça, além de ter o que te chamou atenção a distância, você nota que   ||\n"
                                        + "|| há muitas abóboras, de variados tamanhos, até mesmo algumas gigantes e bem maduras espalhadas  ||\n"
                                        + "|| no chão, como uma plantação bem sucedida. Porém, você nota que aquela fumaça está emergindo    ||\n"
                                        + "|| do chão envolvendo os legumes e não há sinal de fogo aparente, apenas aquela nuvem branca.     ||\n"
                                        + "|| Você se aproxima e percebe que elas estão quentes, assim como o chão, e os legumes devidamente ||\n"
                                        + "|| assados. Essa ilha é realmente mágica! Você decide comê-las antes que desmaie de fome.         ||\n"
                                        + "||************************************************************************************************||\n\n";

                        String continuacaoFumaca = "||***********************************************************************************************||\n"
                                        + "|| As abóboras estavam deliciosas, você se sente saciado e mais disposto.                        ||\n"
                                        + "|| Olhando ao redor, você percebe que a vegetação muda um pouco, as árvores aqui se assemelham a ||\n"
                                        + "|| baobás, com a copa e os troncos largos o bastante para acomodarem um humano deitado,          ||\n"
                                        + "|| com folhagens densas o bastante para impedir a chuva, além disso alguns galhos menores estão  ||\n"
                                        + "|| dispostos nas árvores de madeira que formam perfeitamente degraus até o topo.                 ||\n"
                                        + "|| Você precisa de um lugar para passar a noite e, para se proteger do frio, poderia colocar     ||\n"
                                        + "|| algumas abóboras quentinhas e folhagens sob você.                                             ||\n"
                                        + "||***********************************************************************************************||\n\n";

                        Game.uteis.printaTexto(caminhoFumaca, 5);
                        Game.uteis.printaTexto(continuacaoFumaca, 5);

                        // SE A VIDA DO JOGADOR FOR DIFERENTE DA VIDA MÁXIMA, RESTAURA A VIDA DO JOGADOR
                        if (Game.jogador.getVida() != Game.jogador.getVidaMaxima()) {
                                Game.jogador.setVida(Game.jogador.getVidaMaxima());
                                System.out.println("Vida Atual: " + Game.jogador.getVida() + ".\n");
                        }

                        control = true;
                }

                System.out.println(
                                "||************** O QUE VOCÊ FAZ? *************||\n"
                                                + "||============================================||\n"
                                                + "|| 1 - Vai em direção a Cachoeira (Cachoeira) ||\n"
                                                + "|| 2 - Fica e sobe na Árvore      (Arvore)    ||\n"
                                                + "||============================================||\n");

                // ESCOLHAS DO JOGADOR
                input = Game.sc.next().toUpperCase();

                switch (input) {

                        case "1", "CACHOEIRA":
                                control = false;
                                Game.uteis.limpaConsole();
                                caminhoCachoeira();
                                break;

                        case "2", "ARVORE":
                                control = false;
                                if (caminhoFumacaArvore) {
                                        Game.uteis.addRelatorios(
                                                        "Você decidiu ir primeiro até a fumaça, subir e ficar na árvore. Certamente é uma pessoa que preza pela segurança.");
                                        caminhoFumacaArvore = false;
                                }
                                Game.uteis.limpaConsole();
                                caminhoArvore();
                                break;

                        default:
                                Game.uteis.limpaConsole();
                                System.out.println("Opção inválida!");
                                caminhoFumaca();
                }
        }

        // CAMINHO DA ÁRVORE
        public void caminhoArvore() {

                if (!control) {
                        String caminhoArvore = "||***********************************************************************************************||\n"
                                        + "|| Você colocou algumas folhagens e abóboras na base da árvore e irá subi-las pouco a pouco.     ||\n"
                                        + "|| Na primeira leva de materiais, você se depara com um ninho do que aparenta ser alguma ave,    ||\n"
                                        + "|| você até pensa por um instante que pode ser inabitado, entretanto, este pensamento não dura   ||\n"
                                        + "|| muito, pois você sente um vulto passando no céu atrás de você, ao se virar o que parece ser   ||\n"
                                        + "|| um cavalo, com cabeça e asas de àguia está voando a toda velocidade na sua direção,           ||\n"
                                        + "|| aparentemente aquele ninho pertence a ela. Você se lembra de histórias antigas e de um animal ||\n"
                                        + "|| assim... Um Hipogrifo, é isso que você enfrentará.                                            ||\n"
                                        + "||***********************************************************************************************||\n\n";

                        Game.uteis.printaTexto(caminhoArvore, 5);
                        control = true;
                }

                System.out.println(
                                "||*************** O QUE VOCÊ FAZ? ***************||\n"
                                                + "||===============================================||\n"
                                                + "||    1 - Ataca (Atacar)                         ||\n"
                                                + "||    2 - Foge  (Fugir - Desce para as abóboras) ||\n"
                                                + "||===============================================||\n");

                // ESCOLHAS DO JOGADOR
                input = Game.sc.next().toUpperCase();

                switch (input) {

                        case "1", "ATACAR":
                                control = false;
                                Game.uteis.setAtaques();
                                ;
                                Game.uteis.limpaConsole();

                                // SPAWNA BOSS
                                Combate.inimigo("boss", "Hipogrifo de Ónix");

                                // SE DERROTAR O BOSS:
                                // DEFINE A NOVA ARMA
                                // DEFINE A NOVA ARMADURA
                                Game.jogador.setArma("Faca");
                                Game.jogador.setArmadura("Capacete de Ossos");

                                String continuacaoArvore = "||*********************************************************************************||\n"
                                                + "|| Após você enfrentar e matar o Hipogrifo, agora mais calmo, você consegue notar  ||\n"
                                                + "|| alguns objetos que um dia pertenceram a um ser humano, que não teve tanta sorte ||\n"
                                                + "|| quanto você. Você consegue uma faca e usa os ossos como proteção.               ||\n"
                                                + "||*********************************************************************************||\n\n";

                                Game.uteis.printaTexto(continuacaoArvore, 5);

                                // PRINTA A NOVA ARMADURA E A DEFESA QUE ELA DÁ E A NOVA ARMA E O DANO QUE ELA
                                // DÁ
                                System.out.println("Arma Atualizada: " + Game.jogador.getArma() + " | Dano: "
                                                + Game.jogador.getDanoArma(Game.jogador.getArma()) + "\n\n");

                                System.out.println("Armadura Atualizada: " + Game.jogador.getArmadura() + " | Defesa: "
                                                + Game.jogador.getDefesaArmadura(Game.jogador.getArmadura()) + "\n\n");

                                // CHAMA O PRÓXIMO ATO
                                terceiroAto();

                                break;

                        case "2", "FUGIR":
                                control = false;
                                Game.uteis.setFugas();
                                ;
                                Game.uteis.limpaConsole();
                                caminhoFumaca();
                                break;

                        default:
                                Game.uteis.limpaConsole();
                                System.out.println("Opção inválida!");
                                caminhoArvore();
                }
        }

        // TERCEIRO ATO
        public void terceiroAto() {

                if (!control) {

                        // SE NÃO ACHAR ÀGUA OU COMIDA, O JOGADOR ACORDA PERDENDO UM POUCO DE VIDA,
                        // DIFICULTANDO A PRÓXIMA BATALHA
                        if (agua == false || comida == false) {
                                System.out.println(
                                                "||***********************************************************||\n"
                                                                + "|| Você dormiu sem achar uma fonte de água ou comida,        ||\n"
                                                                + "|| você acorda se sentindo um pouco mais fraco.              ||\n"
                                                                + "|| ⟦ -15 DE VIDA.⟧                                            ||\n"
                                                                + "||***********************************************************||\n");

                                Game.jogador.setVidaDano(15);
                                System.out.println("Vida Atual: " + Game.jogador.getVida() + ".\n");
                        }

                        String caminhosUnificados2 = "||***********************************************************************************************||\n"
                                        + "|| Após acordar, você decide ir até a outra extremidade da ilha para explorar um pouco mais e    ||\n"
                                        + "|| decidir quais serão os próximos passos. Chegando na praia você elabora uma lista na areia dos ||\n"
                                        + "|| itens que precisa para construir sua jangada:                                                 ||\n"
                                        + "||  • FOLHAS DE PALMEIRA                                                                         ||\n"
                                        + "||  • MADEIRAS                                                                                   ||\n"
                                        + "||  • CORDAS                                                                                     ||\n"
                                        + "||***********************************************************************************************||\n\n";

                        control = true;

                        Game.uteis.printaTexto(caminhosUnificados2, 5);
                }

                // MÉTODO COM AS ESCOLHAS DISPONÍVEIS
                caminhosJangada();
        }

        // FOLHAS DE PALMEIRA
        public void folhasDePalmeira() {

                folhas = true;

                String formigasGigantes = "||*****************************************************************************************************||\n"
                                + "|| ⌜ VOCÊ DECIDE IR ATRÁS DE FOLHAS DE PALMEIRA. ⌟                                                    ||\n"
                                + "|| Você sabe que achar tecidos por aqui seria pedir demais, já é incrível ter permanecido vivo.        ||\n"
                                + "|| Então, você se lembra do coco que o macaco-aranha havia arremessado em você, então, deviam          ||\n"
                                + "|| haver palmeiras por perto, você anda um pouco até encontrá-las, mas o som de outros                 ||\n"
                                + "|| macaco-aranhas te ajudou a achar o que procurava. Você vê uma trilha que te leva para uma           ||\n"
                                + "|| espécie de “montanha”, como se algo passasse ali com bastante frequência, a sua esquerda uma        ||\n"
                                + "|| montanha de terra é um cenário diferente das árvores do local, à sua direita você vê uma folha      ||\n"
                                + "|| bem grande, o suficiente para te cobrir, sendo carregada por uma formiga tão grande quanto a folha. ||\n"
                                + "|| Ao detectar sua presença e proximidade do que agora você sabe ser um formigueiro, o inseto          ||\n"
                                + "|| exala um odor diferente, o que atrai outra formiga tão grande quanto ela, essa outra formiga        ||\n"
                                + "|| porém possuía pinças bem maiores, claramente era responsável pela defesa do formigueiro e das       ||\n"
                                + "|| demais formigas, você se prepara para atacar, pois agora aquelas formigas estão logo a frente       ||\n"
                                + "|| das palmeiras que você tanto precisa.                                                               ||\n"
                                + "||*****************************************************************************************************||\n\n";

                String continuacaoFormigasGigantes = "||************************************************************************************||\n"
                                + "|| VOCÊ CONSEGUIU DERROTÁ-LO!                                                         ||\n"
                                + "|| Você pega todas as folhas necessárias para sua jangada e leva para a praia.        ||\n"
                                + "|| Além disso você decide remover as pinças da formiga, aparentam ser uma ótima arma. ||\n"
                                + "||************************************************************************************||\n\n";

                Game.uteis.printaTexto(formigasGigantes, 5);

                // SPAWNA BOSS
                Combate.inimigo("boss", "Formiga Gigante");

                Game.uteis.printaTexto(continuacaoFormigasGigantes, 5);

                // DEFINE A NOVA ARMA
                // PRINTA A NOVA ARMA E O DANO QUE ELA DÁ
                Game.jogador.setArma("Pinças de Formiga Gigante");
                System.out.println("Arma Atualizada: " + Game.jogador.getArma() + " | Dano: "
                                + Game.jogador.getDanoArma(Game.jogador.getArma()) + "\n");

                // MÉTODO COM AS ESCOLHAS DISPONÍVEIS
                caminhosJangada();
        }

        // MADEIRAS
        public void madeira() {

                madeira = true;

                String cupimGigante = 
                					"||************************************************************************************************||\n"
                                + 	"|| ⌜ VOCÊ DECIDE IR ATRÁS DE MADEIRA. ⌟                                                       ﾠ    ||\n"
                                + 	"|| Você encontra madeiras que servirão perfeitamente para a jangada, com o diâmetro bom o         ||\n"
                                + 	"|| suficiente para subir com uns 5 troncos, que ficarão firmes com as cordas.                     ||\n"
                                + 	"|| Contente, você olha ao redor das árvores e nota alguns montes de barro gigante, como se todos  ||\n"
                                + 	"|| os cupinzeiros do mundo tivessem se juntado num só e criado várias ‘bases’ nos arredores.      ||\n"
                                +	"|| Além disso, várias árvores estão derrubadas/podres e algumas tem fumaça saindo da base onde    ||\n"
                                + 	"|| foi feito o corte, como se tivesse derrubado a árvore utilizando algum ácido, além disso       ||\n"
                                + 	"|| o cheiro do ambiente te deixa um pouco nauseado. Você aproveita as árvores já caídas e que     ||\n"
                                + 	"|| ainda parecem boas, porém, ao tocar na primeira delas, vindo de um dos montes de barro,        ||\n"
                                + 	"|| um cupim gigante brota, disparando um ácido na sua direção, você desvia e sabe que terá que    ||\n"
                                + 	"|| lutar pelas madeiras.                                                                          ||\n"
                                + 	"||************************************************************************************************||\n\n";

                String continuacaoCupimGigante = 
                					"||****************************************************************************************||\n"
                                + 	"|| VOCÊ CONSEGUIU DERROTÁ-LO!                                                             ||\n"
                                + 	"|| Você pega todas as madeiras necessárias para sua jangada e leva para a praia.          ||\n"
                                + 	"|| Além dsso você decide pegar a exoesqueleto duro daquele cupim e usar para se proteger, ||\n"
                                + 	"|| definitivamente esse exoesqueleto é melhor do que o que você está usando atualmente.   ||\n"
                                + 	"||****************************************************************************************||\n\n";

                Game.uteis.printaTexto(cupimGigante, 5);

                // SPAWNA BOSS
                Combate.inimigo("boss", "Cupim-Ácido Gigante");

                Game.uteis.printaTexto(continuacaoCupimGigante, 5);

                // DEFINE A NOVA ARMADURA
                // PRINTA A NOVA ARMADURA E A DEFESA QUE ELA DÁ
                Game.jogador.setArmadura("Exoesqueleto de Cupim");
                System.out.println("Armadura Atualizada: " + Game.jogador.getArmadura() + " | Defesa: "
                                + Game.jogador.getDefesaArmadura(Game.jogador.getArmadura()) + "\n");

                caminhosJangada();
        }

        // CORDAS
        public void corda() {

                corda = true;

                String louvaDeusGigante = 
                					"||***********************************************************************************************||\n"
                                + 	"|| ⌜ VOCÊ DECIDE IR ATRÁS DE CORDAS. ⌟                                                           ﾠ||\n"
                                + 	"|| Andando pela praia você encontra uma extensão da floresta contendo diversas trepadeiras.      ||\n"
                                + 	"|| Não são cordas propriamente ditas, mas os cipós das árvores irão servir perfeitamente para a  ||\n"
                                + 	"|| jangada. Porém, ao se aproximar da vegetação, um Louva-Deus Gigante aparece cortando parte dos||\n"
                                + 	"|| cipós com as suas patas dianteiras que aparentam ser revestidas com algum metal que se        ||\n"
                                + 	"|| assemelham a facas de serra. Você só consegue pensar nos diversos vídeos de louva-deuses      ||\n"
                                + 	"|| atacando lagartos ou outros animais e como os louva-deus fêmeas comem as cabeças dos machos   ||\n"
                                + 	"|| após a reprodução. Você sente calafrios por toda a espinha, seu corpo grita para que você     ||\n"
                                + 	"|| fuja, mas não tem como fugir, você precisa dos cipós.                                         ||\n"
                                + 	"||***********************************************************************************************||\n\n";

                String continuacaoLouvaDeusGigante = 
                					"||*****************************************************************************||\n"
                                + 	"|| VOCÊ CONSEGUIU DERROTÁ-LO!                                                  ||\n"
                                + 	"|| Você pega todas as cordas necessárias para sua jangada e leva para a praia. ||\n"
                                + 	"||*****************************************************************************||\n\n";

                Game.uteis.printaTexto(louvaDeusGigante, 5);

                // SPAWNA BOSS
                Combate.inimigo("boss", "Louva-Deus Gigante");

                Game.uteis.printaTexto(continuacaoLouvaDeusGigante, 5);

                // ESCOLHAS DO JOGADOR
                caminhosJangada();
        }

        public void penultimoAto() {

                if (!control) {
                        String finalBoss = 
                        					"||***********************************************************************************************||\n"
                                        + 	"|| Após conseguir todos os itens da lista, você começa a montar sua jangada...                   ||\n"
                                        + 	"|| Você utiliza as madeiras, folhas de palmeira e os cipós para construir a jangada que te       ||\n"
                                        + 	"|| levará para longe desta ilha. Você aproveita também para confeccionar uma arma mais forte     ||\n"
                                        + 	"|| utilizando a pata de metal do Louva-Deus Gigante e a pinça da Formiga Gigante.                ||\n"
                                        + 	"|| Algumas horas depois você termina a jangada, não é muito, mas vai funcionar para sair da ilha ||\n"
                                        + 	"|| e com sorte chegar até o continente ou um lugar sem tantas criaturas bizarras.                ||\n"
                                        +	"|| Você coloca a jangada na água e parte dando adeus àquela ilha maldita, você olha para trás e  ||\n"
                                        + 	"|| sorri, agradecendo por ter sobrevivido e pensando em tudo que faria a partir dali, quando     ||\n"
                                        + 	"|| estivesse realmente são e salvo, porém sua esperança dura pouco.                              ||\n"
                                        + 	"|| Diante de você uma criatura enorme emerge das águas, os tentáculos da criatura envolvem toda  ||\n"
                                        + 	"|| a jangada. Um olho do tamanho da sua cabeça está diante de você, te olhando fixamente.        ||\n"
                                        + 	"|| VOCÊ PRECISA TOMAR UMA ATITUDE RÁPIDA.                                                        ||\n"
                                        + 	"||***********************************************************************************************||\n\n";

                        Game.uteis.printaTexto(finalBoss, 5);
                        control = true;
                }

                System.out.println(
                                "||******************** O QUE VOCÊ FAZ? ******************||\n"
                              + "||=======================================================||\n"
                              + "||     1 - Bate com a arma nos Tentáculos (Tentaculos)   ||\n"
                              + "||     2 - Fura o olho da Criatura        (Olho)         ||\n"
                              + "||=======================================================||\n");

                input = Game.sc.next().toUpperCase();

                switch (input) {

                        case "1", "TENTACULOS":
                                Game.uteis.limpaConsole();

                                System.out.println(
                                                "||============================================================================||\n"
                                              + "|| Você atinge os tentáculos da Lula, ela está prestando mais atenção em você ||\n"
                                              + "|| e parece proteger melhor seus tentátulos.                                  ||\n"
                                              + "||============================================================================||\n");

                                // INSTANCIA O BOSS DE FORMA MANUAL POIS NESSE MODO ELE TEM MAIS DEFESA
                                // --MODO COMBATE - TENTÁCULOS--
                                Game.boss = new Boss("Lula Colossal",
                                                // vidaInimigo
                                                Game.jogador.getVidaMaxima() * 0.75,
                                                // forcaInimigo
                                                Game.jogador.getForca() * 0.50,
                                                // resistenciaInimigo
                                                Game.jogador.getResistencia() * 0.90,
                                                Game.jogador.getNivel() * 2);
                                Combate.combate("boss");
                                break;

                        case "2", "OLHO":
                                Game.uteis.limpaConsole();

                                System.out.println(
                                                "||=================================================================================||\n"
                                              + "|| Você atinge o olho da Lula, ela está enfurencida e como sua visão está limitada ||\n"
                                              + "|| parece que ela quer garantir que cada ataque te machuque bastante.              ||\n"
                                              + "||=================================================================================||\n");

                                // INSTANCIA O BOSS DE FORMA MANUAL POIS NESSE MODO ELE TEM MAIS ATAQUE
                                // --MODO COMBATE - OLHO DA CRIATURA--
                                Game.boss = new Boss("Lula Colossal",
                                                // vidaInimigo
                                                Game.jogador.getVidaMaxima() * 0.75,
                                                // forcaInimigo
                                                Game.jogador.getForca() * 0.90,
                                                // resistenciaInimigo
                                                Game.jogador.getResistencia() * 0.50,
                                                Game.jogador.getNivel() * 2);

                                Combate.combate("boss");
                                break;

                        default:
                                System.out.println("Opção inválida!");
                                Game.uteis.limpaConsole();
                                penultimoAto();

                }

                // CHAMA O PRÓXIMO ATO
                control = false;
                ultimoAto();
        }

        // ÚLTIMO ATO
        public void ultimoAto() {

                // VARIÁVEL PARA O FINAL DO JOGO BASEADO NA ESCOLHA DO JOGADOR
                String finalDoJogo = "";

                if (!control) {

                        String ultimaDecisao = 
                        					"||**************************************************************************************************||\n"
                                        + 	"|| VOCÊ VENCEU! Garantindo suas chances de sobrevivência e podendo fugir sem maiores obstáculos.    ||\n"
                                        + 	"|| Você vê a Lula Gigante ainda próxima, mas ela já está fraca e bastante ferida, se você deixá-la  ||\n"
                                        + 	"|| em paz, ela irá sobreviver. Mas você quiser, pode decidir terminar o 'serviço'...                ||\n"
                                        + 	"||**************************************************************************************************||\n\n";

                        control = true;
                        Game.uteis.printaTexto(ultimaDecisao, 5);
                }

                System.out.println(
                					"||******** O QUE VOCÊ FAZ? *******||\n"
                                + 	"||================================||\n"
                                + 	"||     1 - Ir Embora (Ir)         ||\n"
                                + 	"||     2 - Matar     (Matar)      ||\n"
                                + 	"||================================||\n");

                input = Game.sc.next().toUpperCase();

                switch (input) {

                        case "1", "IR":
                                finalDoJogo = 		"||*********************************************************************************************||\n"
                                                + 	"|| ⌜ VOCÊ POUPA O ANIMAL. ⌟                                                                    ﾠ||\n"
                                                + 	"|| Por pior que aquela situação tenha sido, você ainda manteve parte da sua humanidade e,      ||\n"
                                                + 	"|| atacar um animal que não oferecia mais riscos parecia errado.                               ||\n"
                                                +	"|| Você senta na sua jangada contemplando o horizonte e sentindo a brisa do mar, enquanto a    ||\n"
                                                + 	"|| criatura foge para longe.                                                                   ||\n"
                                                + 	"|| Você sorri enquanto lágrimas escorrem em seu rosto, com um alívio e esperança de um         ||\n"
                                                + 	"|| novo recomeço...                                                                            ||\n"
                                                + 	"||*********************************************************************************************||\n\n";
                                Game.uteis.printaTexto(finalDoJogo, 5);
                                Game.uteis.delayParaProximoComando(30);
                                fim();
                                break;

                        case "2", "MATAR":
                                finalDoJogo = 		"||*********************************************************************************************||\n"
                                                + 	"|| ⌜ VOCÊ MATA O ANIMAL SEM PIEDADE. ⌟                                                         ﾠ||\n"
                                                + 	"|| Você finca a arma em um só golpe no olho gigante a sua frente.                              ||\n"
                                                + 	"|| Você se tornou tão selvagem quanto as criaturas que te atacaram enquanto estava na ilha.    ||\n"
                                                + 	"|| Sem remorso, você segue seu caminho. Você senta na jangada e se pergunta...                 ||\n"
                                                + 	"|| 'Será que a vida será a mesma daqui em diante?'                                             ||\n"
                                                + 	"||*********************************************************************************************||\n\n";

                                Game.uteis.printaTexto(finalDoJogo, 5);
                                Game.uteis.setAtaques();
                                ;
                                Game.uteis.delayParaProximoComando(30);
                                fim();
                                break;

                        default:
                                Game.uteis.limpaConsole();
                                System.out.println("Opção inválida!");
                                ultimoAto();
                }
        }

        // FIM
        public void fim() {
                String fim = 		"||******************||\n"
                                + 	"||      F I M       ||\n"
                                + 	"||******************||\n\n\n";

                Game.uteis.printaTexto(fim, 25);
                Game.uteis.delayParaProximoComando(50);
                Game.uteis.mostraRelatorio();
                Game.uteis.delayParaProximoComando(150);

                Game.menu.creditos(true);
                // Runtime.getRuntime().exit(0);
                // Game.game = new Game();
                // Game.game.main(null);
        }

        // MÉTODO QUE USA AS VARIÁVEIS DE CONTROLE PARA PRINTAR OS CAMINHOS RESTANTES
        // PARA O JOGADOR
        public void caminhosJangada() {

                if (folhas == false && madeira == false && corda == false) {
                        System.out.println(
                                        "||************** O QUE VOCÊ FAZ PRIMEIRO? ************||\n"
                                      + "||====================================================||\n"
                                      + "||     1 - Vou procurar Folhas de Palmeira (Folhas)   ||\n"
                                      + "||     2 - Vou procurar as Madeiras        (Madeiras) ||\n"
                                      + "||     3 - Vou procurar as Cordas          (Cordas)   ||\n"
                                      + "||====================================================||\n");

                        // ESCOLHAS DO JOGADOR
                        input = Game.sc.next().toUpperCase();

                        switch (input) {

                                case "1", "FOLHAS":
                                        control = false;
                                        Game.uteis.addRelatorios(
                                                        "Você preferiu construir a jangada começando pelas Folhas de Palmeira. Para você, a direção é o mais importante. Excelente escolha!");
                                        Game.uteis.limpaConsole();
                                        folhasDePalmeira();
                                        break;

                                case "2", "MADEIRAS":
                                        control = false;
                                        Game.uteis
                                                        .addRelatorios("Você preferiu construir a jangada começando pelas Madeiras. Para você, a  base é o mais importante. Excelente escolha!");
                                        Game.uteis.limpaConsole();
                                        madeira();
                                        break;

                                case "3", "CORDAS":
                                        control = false;
                                        Game.uteis
                                                        .addRelatorios("Você preferiu construir a jangada começando pelas Cordas primeiro.  Para você, a união é o importante. Excelente escolha!");
                                        Game.uteis.limpaConsole();
                                        corda();
                                        break;

                                default:
                                        System.out.println("Opção inválida!");
                                        Game.uteis.limpaConsole();
                        }
                }

                if (folhas == false && madeira == false && corda == true) {
                        System.out.println(
                                        "||****************** O QUE VOCÊ FAZ ? ****************||\n"
                                      + "||====================================================||\n"
                                      + "||     1 - Vou procurar Folhas de Palmeira (Folhas)   ||\n"
                                      + "||     2 - Vou procurar as Madeiras        (Madeiras) ||\n"
                                      + "||====================================================||\n");

                        input = Game.sc.next().toUpperCase();

                        switch (input) {

                                case "1", "FOLHAS":
                                        Game.uteis.limpaConsole();
                                        control = false;
                                        madeira();
                                        break;

                                case "2", "MADEIRAS":
                                        Game.uteis.limpaConsole();
                                        control = false;
                                        folhasDePalmeira();
                                        break;
                                default:
                                        System.out.println("Opção inválida!");
                                        Game.uteis.limpaConsole();
                                        caminhosJangada();
                        }
                }

                else if (folhas == false && madeira == true && corda == false) {
                        System.out.println(
                                        "||**************** O QUE VOCÊ FAZ ? ****************||\n"
                                      + "||==================================================||\n"
                                      + "||     1 - Vou procurar Folhas de Palmeira (Folhas) ||\n"
                                      + "||     2 - Vou procurar as Cordas          (Cordas) ||\n"
                                      + "||==================================================||\n");

                        input = Game.sc.next().toUpperCase();

                        switch (input) {

                                case "1", "FOLHAS":
                                        Game.uteis.limpaConsole();
                                        control = false;
                                        corda();
                                        break;

                                case "2", "CORDAS":
                                        Game.uteis.limpaConsole();
                                        control = false;
                                        folhasDePalmeira();
                                        break;

                                default:
                                        System.out.println("Opção inválida!");
                                        Game.uteis.limpaConsole();
                                        caminhosJangada();
                        }
                }

                else if (folhas == true && madeira == false && corda == false) {
                        System.out.println(
                                        "||************** O QUE VOCÊ FAZ ? *************||\n"
                                      + "||=============================================||\n"
                                      + "||     1 - Vou procurar as Madeiras (Madeiras) ||\n"
                                      + "||     2 - Vou procurar as Cordas   (Cordas)   ||\n"
                                      + "||=============================================||\n");

                        input = Game.sc.next().toUpperCase();

                        switch (input) {

                                case "1", "MADEIRAS":
                                        Game.uteis.limpaConsole();
                                        control = false;
                                        madeira();
                                        break;

                                case "2", "CORDAS":
                                        Game.uteis.limpaConsole();
                                        control = false;
                                        corda();
                                        break;

                                default:
                                        System.out.println("Opção inválida!");
                                        Game.uteis.limpaConsole();
                                        caminhosJangada();
                        }
                }

                else if (folhas == true && madeira == true && corda == false) {
                        System.out.println(
                                        "||*************************************************||\n"
                                      + "|| Só restaram as CORDAS e é para lá que você vai. ||\n"
                                      + "||*************************************************||\n");
                        corda();
                }

                else if (folhas == true && madeira == false && corda == true) {
                        System.out.println(
                                        "||***************************************************||\n"
                                      + "|| Só restaram as MADEIRAS e é para lá que você vai. ||\n"
                                      + "||***************************************************||\n");

                        madeira();
                }

                else if (folhas == false && madeira == true && corda == true) {
                        System.out.println(
                                        "||*************************************************||\n"
                                      + "|| Só restaram as FOLHAS e é para lá que você vai. ||\n"
                                      + "||*************************************************||\n");
                        folhasDePalmeira();
                }

                // SE TODAS AS VARIÁVEIS FOREM TRUE, CHAMA O PRÓXIMO ATO
                else {

                        System.out.println(
                                        "||******************************************************||\n"
                                      + "|| Parece que você tem tudo que precisa para continuar. ||\n"
                                      + "||******************************************************||\n");
                        control = false;
                        penultimoAto();
                }
        }
}
