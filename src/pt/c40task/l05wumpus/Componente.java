package pt.c40task.l05wumpus;

public class Componente {
	//private char id;//Herói: “P” Wumpus: “W” Buraco: “B” Ouro: “O” Fedor: “f” Brisa: “b”
	
	protected int pontos;//indica quantos pontos o componente vale. se não aplicável, ele vale zero
	protected int linha, coluna;
	protected Caverna caverna;
	public Componente(int coluna,int linha) {
		this.linha = linha;
		this.coluna = coluna;
		
	}
	public void conecta (Caverna caverna) {
		this.caverna = caverna;
	}
	public Caverna getCaverna() {
		return caverna;
	}
	public int getPontos() {
		return pontos;
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
