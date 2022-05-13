package pt.c40task.l05wumpus;

public class Wumpus extends Componente {

	public Wumpus(Caverna caverna, int coluna, int linha) {
		super(coluna, linha);
		if (linha - 1 >= 0) {
			Componente fedor = new Fedor(coluna, linha - 1);
			fedor.conecta(caverna);
			fedor.solicitarCaverna();
		}
		
		if (linha + 1 < 4) {
			Componente fedor = new Fedor(coluna, linha + 1);
			fedor.conecta(caverna);
			fedor.solicitarCaverna();
		}
		
		if (coluna - 1 >= 0) {
			Componente fedor = new Fedor(coluna - 1, linha);
			fedor.conecta(caverna);
			fedor.solicitarCaverna();
		}
		
		if (coluna + 1 < 4) {
			Componente fedor = new Fedor(coluna + 1, linha);
			fedor.conecta(caverna);
			fedor.solicitarCaverna();
		}
	}


}
