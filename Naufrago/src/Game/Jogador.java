package Game;

public class Jogador {

	//VARIAVEIS DO JOGADOR
    private int vidaMaxima = 25;
    private double vida = 25;
    private int forca = 1;
    private int resistencia = 1;
    private int nivel = 1;
    private double xp = 0.0;
    private double xpParaUpar = 10.0;
    private String nome = "";
    private String profissao = "";
    private String arma = "Mãos";
    private String armadura = "";

    //CONSTRUTOR DO JOGADOR, É OBRIGATÓRIO NOME PROFISSÃO
    public Jogador(String nome, String profissao) {

        this.nome = nome;

        //A PROFISSÃO VAI DETERMINAR OS STATUS INICIAIS DO JOGADOR
        switch (profissao) {
            case "MÉDICO":
                this.profissao = "Médico";
                //atribuindoValoresBaseadoNaProfissao(this.profissao);
                setVidaMaxima(5);
                setResistencia(5);
                setVida(vidaMaxima);
                break;

            case "SOLDADO":
                this.profissao = "Soldado";
                //atribuindoValoresBaseadoNaProfissao(this.profissao);
                setVidaMaxima(5);
                setVida(vidaMaxima);
                setForca(5);
                break;

            case "PROFESSOR":
                this.profissao = "Professor";
                //atribuindoValoresBaseadoNaProfissao(this.profissao);
                setVidaMaxima(2.5);
                setVida(vidaMaxima);
                setForca(3);
                setResistencia(3);
                break;
        }
    }

    
    //STATUS DO JOGADOR
    public String getStatus() {

        String txt = "NOME: " 		+ getNome() + ""
                + " | PROFISSÃO: " 	+ getProfissao() + "\n"
                //+	"Vida Máxima: " 	+ vidaMaxima					+ "\n"
                + "VIDA: " 			+  Game.dc.format(getVida()) + " | " + printaVidaJogador() + "\n" 
                + "FORÇA: " 		+ getForca() + "\n"
                + "RESISTÊNCIA: " 	+ getResistencia() + "\n"
                + "NÍVEL: " 		+ getNivel() + "\n"
                + "XP: " 			+ Game.dc.format(xp) + "\n"
                + "ARMA: " 			+ getArma() + "\n"
                + "ARMADURA: " 		+ getArmadura() + "\n";
        //+ 	"XP p/ Upar: "  	+ Game.dc.format(xpParaUpar)    + "\n";

        return txt;
    }
    
    //MÉTODO PARA O JOGADOR PASSAR DE NÍVEL (SE O XP ATUAK DO JOGADOR + O XP DROPADO PELO INÍMIGO/ BOSS FOR MAIOR QUE O XP PARA UPAR O JOGADOR PASSA DE NÍVEL,
    	//SE NÃO O XP DROPADO É ADICIONADO AO XP ATUAL DO JOGADOR).
    public void passaDeNivel(double experiencia) {

        if (getXp() + experiencia >= getXpParaUpar()) {
            setXp(getXp() + experiencia - getXpParaUpar());
            setXpParaUpar(getXpParaUpar() * 0.25);
            setNivel(1);
            melhoraStatus();
        } else {
            setXp(getXp() + experiencia);
        }
    }

    
    //SE O JOGADOR PASSAR DE NÍVEL MELHORA OS STATUS DO JOGADOR E PRINTA COMO FICOU O STATUS ATUAL, SUBIR DE NÍVEL TAMBÉM RESTAURA A VIDA DO JOGADOR TOTALMENTE
    public void melhoraStatus() {
        
        setVidaMaxima(2.5);
        setForca(3);
        setResistencia(3);
        setVida(vidaMaxima);
       
        System.out.println(
                  "||********** SUBIU DE NÍVEL ***********||\n"
                + "|| Suas estatísticas subiram de nível! ||\n"
                + "|| VIDA MÁXIMA:  + 2,5                 ||\n"
                + "|| FORÇA:        +  3                  ||\n"
                + "|| RESISTÊNCIA:  +  3                  ||\n"
                + "||*************************************||\n");
        
        getStatus();
    }

    
    //RETORNA O DANO DA ARMA BASEADO NA ARMA ATUAL DO JOGADOR
    public int getDanoArma(String arma) {

        switch (arma) {
            case "Mãos":
                return 5;

            case "Braço do Assento":
                return 10;

            case "Pedaço de Madeira":
                return 10;

            case "Osso Humano", "Faca":
                return 15;

            case "Pinças de Formiga Gigante":
                return 30;

            default:
                System.out.println("Esta arma é inválida!");
                return 0;
        }
    }

    
    //CÁLCULO PARA RETORNAR O DANO QUE O JOGADOR DARÁ NO INIMIGO/ BOSS (USANDO DE BASE A DEFESA DO INÍMIGO/ BOSS)
    public double getDanoJogador(double defesaInimigo) {
        double danoJogador = (getForca() + getDanoArma(arma)) / defesaInimigo;
        return danoJogador;
    }

  //RETORNA A DEFESA DA ARMADURA BASEADO NA ARMADURA ATUAL DO JOGADOR
    public int getDefesaArmadura(String armadura) {

        switch (armadura) {
            case "":
                return 0;

            case "Boné":
                return 5;

            case "Capacete de Coco", "Capacete de Ossos":
                return 10;

            case "Capacete de Ferro":
                return 15;

            case "Exoesqueleto de Cupim":
                return 30;

            default:
                System.out.println("Esta armadura é inválida!");
                return 0;
        }
    }
    
    public String printaVidaJogador() {
    	
    	String l;
    	
    	if (getVida() >= getVidaMaxima())
    	{
    		l = "[♥   ♥   ♥   ♥   ♥   ♥   ♥   ♥   ♥   ♥]";
    	}
    	
    	else if (getVida() >= getVidaMaxima() * 0.90)
    	{
    		l = "[♥   ♥   ♥   ♥   ♥   ♥   ♥   ♥   ♥]";
    	}
    	
    	else if (getVida() >= getVidaMaxima() * 0.80)
    	{
    		l = "[♥   ♥   ♥   ♥   ♥   ♥   ♥   ♥]";
    	}
    	
    	else if (getVida() >= getVidaMaxima() * 0.70)
    	{
    		l = "[♥   ♥   ♥   ♥   ♥   ♥   ♥]";
    	}
    	
    	else if (getVida() >= getVidaMaxima() * 0.60)
    	{
    		l = "[♥   ♥   ♥   ♥   ♥   ♥]";
    	}
    	
    	else if (getVida() >= getVidaMaxima() * 0.50)
    	{
    		l = "[♥   ♥   ♥   ♥   ♥]";
    	}
    	
    	else if (getVida() >= getVidaMaxima() * 0.40)
    	{
    		l = "[♥   ♥   ♥   ♥]";
    	}
    	
    	else if (getVida() >= getVidaMaxima() * 0.30)
    	{
    		l = "[♥   ♥   ♥]";
    	}
    	
    	else if (getVida() >= getVidaMaxima() * 0.20)
    	{
    		l = "[♥   ♥]";
    	}
    	
    	else if (getVida() >= getVidaMaxima() * 0.01)
    	{
    		l = "[♥]";
    	}
    	
    	else {
    		l = "[]";
    	}
    	
		return l;
    }

    //CÁLCULO PARA RETORNAR A DEFESA DO JOGADOR
    public int getDefesaJogador() {
        return getResistencia() + getDefesaArmadura(armadura);
    }

    //RETORNA A VIDA MÁXIMA
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    //DEFINE A NOVA VIDA MÁXIMA DO JOGADOR 
    public void setVidaMaxima(double vidaMaxima) {
        this.vidaMaxima += vidaMaxima;
    }

    //RETORNA A VIDA ATUAL DO JOGADOR
    public double getVida() {
        return vida;
    }

    //DEFINE A NOVA VIDA ATUAL DO JOGADOR
    public void setVida(double vida) {
        this.vida = vida;
    }

    //DEFINE A NOVA VIDA ATUAL DO JOGADOR BASEADO NO DANO QUE ELE LEVOU
    public void setVidaDano(double dano) {
        this.vida -= dano;
    }

    //DEFINE A NOVA VIDA ATUAL DO JOGADOR CASO ELE SE CURE
    public void setVidaCura(double vida) {
        this.vida += vida;
    }

    //RETORNA A FORÇA DO JOGADOR
    public int getForca() {
        return forca;
    }

    //DEFINE A NOVA FORÇA DO JOGADOR (QUANDO PASSA DE NÍVEL)
    public void setForca(int forca) {
        this.forca += forca;
    }

    //RETORNA A NOVA RESISTÊNCIA DO JOGADOR
    public int getResistencia() {
        return resistencia;
    }
    
    //DEFINE A NOVA RESISTÊNCIA DO JOGADOR (QUANDO PASSA DE NÍVEL)
    public void setResistencia(int resistencia) {
        this.resistencia += resistencia;
    }

    //RETORNA O NÍVEL DO JOGADOR
    public int getNivel() {
        return nivel;
    }

    //DEFINE O NOVO NÍVEL DO JOGADOR (QUANDO PASSA DE NÍVEL)
    public void setNivel(int nivel) {
        this.nivel += nivel;
    }

    //RETORNA O XP ATUAL DO JOGADOR
    public double getXp() {
        return xp;
    }

    //DEFINE O NOVO XP DO JOGADOR ACRESCENTANDO A NOVA EXPERIÊNCIA DROPADA (APÓS DERROTAR O INÍMIGO, UPANDO DE NÍVEL OU NÃO)
    public void setXp(double xp) {
        this.xp = xp;
    }

    //RETORNA O XP NECESSÁRIO PARA UPAR
    public double getXpParaUpar() {
        return xpParaUpar;
    }

    //APÓS UPAR DEFINE O NOME XP PARA UPAR, SENDO 25% MAIOR QUE O NECESSÁRIO DO NÍVEL ANTERIOR (PARÂMETRO PASSADO NO MÉTODO 'PASSA NÍVEL')
    public void setXpParaUpar(double xpParaUpar) {
        this.xpParaUpar += xpParaUpar;
    }

    //RETORNA O NOME DO JOGADOR
    public String getNome() {
        return nome;
    }

    //RETORNA A PROFISSÃO DO JOGADOR
    public String getProfissao() {
        return profissao;
    }
    
    //RETORNA O NOME DA ARMA ATUAL DO JOGADOR
    public String getArma() {
        return arma;
    }

    //DEFINE A NOVA ARMA DO JOGADOR
    public void setArma(String arma) {
        this.arma = arma;
    }

    //RETORNA O NOME DA ARMADURA ATUAL DO JOGADOR
    public String getArmadura() {
        return armadura;
    }

    
    //DEFINE A NOVA ARMADURA DO JOGADOR
    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }

}
