package pt.c40task.l05wumpus;

public class Buraco extends Componente {

	public Buraco(int coluna, int linha) {
		super(coluna, linha);
		this.pontos = -1000;
		if (linha - 1 >= 0) {
			Componente brisa = new Brisa(coluna, linha - 1);
			brisa.conecta(caverna);
			brisa.solicitarCaverna();
		}
		
		if (linha + 1 < 4) {
			Componente brisa = new Brisa(coluna, linha + 1);
			brisa.conecta(caverna);
			brisa.solicitarCaverna();
		}
		
		if (coluna - 1 >= 0) {
			Componente brisa = new Brisa(coluna - 1, linha);
			brisa.conecta(caverna);
			brisa.solicitarCaverna();
		}
		
		if (coluna + 1 < 4) {
			Componente brisa = new Brisa(coluna + 1, linha);
			brisa.conecta(caverna);
			brisa.solicitarCaverna();
		}
	}
	


}
