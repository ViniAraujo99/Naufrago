package Game;

public class Boss extends Inimigo {

	//CONSTRUTOR DO BOSS
    public Boss(String nome, double vida, double forca, double resistencia, int nivel) {
		super(nome, vida, forca, resistencia, nivel);
	}

	//OVERRIDE PARA RETORNAR MAIS XP QUANDO DERROTAR O BOSS, POIS OS INÍMIGOS COMUM DROPAM MENOS XP 
	@Override
	public double dropExperiencia() {
		
		if(getForcaInimigo() > getResistenciaInimigo()) {
			double exp = (double) (getVidaInicialInimigo() / getResistenciaInimigo()) * 2;
			return exp;
		} 
		else {
			double exp = (double) (getVidaInicialInimigo() / getForcaInimigo()) * 2;
			return exp;
		}
	}
}
