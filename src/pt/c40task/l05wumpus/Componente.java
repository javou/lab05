package pt.c40task.l05wumpus;

public class Componente {
	//private char id;//HerÃ³i: â€œPâ€� Wumpus: â€œWâ€� Buraco: â€œBâ€� Ouro: â€œOâ€� Fedor: â€œfâ€� Brisa: â€œbâ€�

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
