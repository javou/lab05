package pt.c40task.l05wumpus;

public class Caverna {
	private Sala[][] salas = new Sala[4][4];
	
	public void incluirComponente(Componente componente) {
		salas[componente.getLinha()][componente.getColuna()].adicionarComponente(componente);
		// adiciona componente na sala de mesmas coordenadas.
	}
	public void setFedorSala(int coluna, int linha) {
		if (coluna - 1 >= 0) {
			salas[linha][coluna - 1].setFedor(true);
		}
		if (coluna + 1 <= 3){
			salas[linha][coluna + 1].setFedor(true);
		}
		if (linha - 1 >= 0) {
			salas[linha - 1][coluna].setFedor(true);
		}
		if (linha + 1 <= 3){
			salas[linha + 1][coluna].setFedor(true);
		}
		
	}
	
	public void setBrisaSala(int coluna, int linha) {
		if (coluna - 1 >= 0) {
			salas[linha][coluna - 1].setBrisa(true);
		}
		if (coluna + 1 <= 3){
			salas[linha][coluna + 1].setBrisa(true);
		}
		if (linha - 1 >= 0) {
			salas[linha - 1][coluna].setBrisa(true);
		}
		if (linha + 1 <= 3){
			salas[linha + 1][coluna].setBrisa(true);
		}
	}
	public void moverComponente() {
		
	}
}
