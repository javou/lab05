package pt.c40task.l05wumpus;

public class Heroi extends Componente {

	public Heroi(int coluna, int linha) {
		super(coluna, linha);
		this.pontos = 0;
	}
	public void addPontos(int pontos) { //verificar se isso irá funcionar; é necessário adicionar um método desse na classe Componente para funcionar???
		this.pontos += pontos;
	}

}
