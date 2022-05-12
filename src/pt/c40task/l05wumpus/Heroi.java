package pt.c40task.l05wumpus;

public class Heroi extends Componente {

	public Heroi(int coluna, int linha) {
		super(coluna, linha);
		this.pontos = 0;
	}
	
	public void addPontos(int pontos) { //verificar se isso irá funcionar; é necessário adicionar um método desse na classe Componente para funcionar???
		this.pontos += pontos;
	}
	
	public void mover(char direcao) {
		if (direcao == 'w') {
			if (linha != 0) {
				caverna.removerComponente(coluna, linha, this);
				linha--;
				caverna.incluirComponente(this);
			}
		} else if (direcao == 'a') {
			if (coluna != 0) {
				caverna.removerComponente(coluna, linha, this);
				coluna--;
				caverna.incluirComponente(this);
			}
		} else if (direcao == 's') {
			if (linha != 3) {
				caverna.removerComponente(coluna, linha, this);
				linha++;
				caverna.incluirComponente(this);
			}
		} else {
			if (coluna != 3) {
				caverna.removerComponente(coluna, linha, this);
				coluna++;
				caverna.incluirComponente(this);
			}
		}
		
		
	}
}
