package pt.c40task.l05wumpus;

public class Componente {
	private char id;//Herói: “P” Wumpus: “W” Buraco: “B” Ouro: “O” Fedor: “f” Brisa: “b”
	private boolean status; //morto ou vivo, ativo ou não, usado para mostrar
	private int pontos;
	private int posX, posY;
	
	public boolean getStatus() {
		return this.status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public char getId() {
		return id;
	}
	public int getPontos() {
		return pontos;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
}
