package pt.c40task.l05wumpus;

public class Componente {
	//private char id;//HerÃ³i: â€œPâ€� Wumpus: â€œWâ€� Buraco: â€œBâ€� Ouro: â€œOâ€� Fedor: â€œfâ€� Brisa: â€œbâ€�

	protected int linha, coluna;
	protected Caverna caverna; 
	// removi pontos como sendo um atributo de componente. Seria necessário somar o valor de pontos da sala destino sempre que o herói se movesse.
	// Porém, o herói não tem acesso direto aos componentes da sala destino, causando muito trabalho. Além disso, o Wumpus pode valer tanto 500 quanto -1000.
	// E se houvesse, por exemplo, brisa e ouro na mesma sala?
	// Pontos virou um atributo de herói.
	
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
	
	public void setLinha(int linha) {
		this.linha = linha;
	}
	
	public int getColuna() {
		return coluna;
	}
	
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
}
