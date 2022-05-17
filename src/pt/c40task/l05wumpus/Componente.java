package pt.c40task.l05wumpus;

public class Componente {
	protected int linha, coluna;
	protected Caverna caverna; 
	
	public Componente(int coluna,int linha) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public void conecta(Caverna caverna) {
		this.caverna = caverna;
	}
	
	public void solicitarCaverna() { // solicita que caverna inclua este componente na sala de respectivas coordenadas.
		caverna.incluirComponente(this);
	}
	
	public Caverna getCaverna() {
		return caverna;
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}
}
