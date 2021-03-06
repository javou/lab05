package pt.c40task.l05wumpus;
import java.util.Random;

public class Heroi extends Componente {
	private boolean ouro = false;
	private boolean flechaEquipada = false;
	private int aljava;
	private int pontos;
	private boolean estouVivo = true;

	public Heroi(int coluna, int linha) {
		super(coluna, linha);
		aljava = 1;
		pontos = 0;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public boolean isFlechaEquipada() {
		return flechaEquipada;
	}
	
	public int getAljava() {
		return aljava;
	}
	
	public void mover(char direcao) {
		if (direcao == 'w') {
			if (linha != 0) {
				caverna.removerComponente(coluna, linha, this);
				linha--;
				solicitarCaverna();
				acoesSecundarias();
			}
		} else if (direcao == 'a') {
			if (coluna != 0) {
				caverna.removerComponente(coluna, linha, this);
				coluna--;
				solicitarCaverna();
				acoesSecundarias();
			}
		} else if (direcao == 's') {
			if (linha != 3) {
				caverna.removerComponente(coluna, linha, this);
				linha++;
				solicitarCaverna();
				acoesSecundarias();
			}
		} else {
			if (coluna != 3) {
				caverna.removerComponente(coluna, linha, this);
				coluna++;
				solicitarCaverna();
				acoesSecundarias();
			}
		}
	}
	
	public void equiparFlecha() {
		if (aljava > 0) {
			aljava--;
			flechaEquipada = true;
			
		}
	}
	
	private void acoesSecundarias() { // realiza ações secundárias provenientes de um movimento.
		pontos -= 15;
		Sala sala = caverna.getSala(coluna, linha);
		sala.setJaPassou(true);
		if (sala.contemBuraco() || (flechaEquipada == false && sala.contemWumpus())) {
			pontos -= 1000;
			estouVivo = false;
			// fim de jogo.
		}
		if (flechaEquipada)
			atirar();
	}
	
	private void atirar() {
		pontos -= 100;
		flechaEquipada = false;
		Sala sala = caverna.getSala(coluna, linha);
		if (sala.contemWumpus()) {
			Random rngesus = new Random();
			if (rngesus.nextBoolean() == true) {
				sala.removerWumpus();
				pontos += 500;
			} else {
				pontos -= 1000;
				estouVivo = false;
				// fim de jogo.
			}
		}
	}
	
	public void capturarOuro() {
		Sala sala = caverna.getSala(coluna, linha);
		if (sala.contemOuro()) {
			sala.removerOuro();
			ouro = true;
			pontos += 1000;
		}
	}
	
	public boolean isOuro() {
		return ouro;
	}
	
	public boolean isEstouVivo() {
		return estouVivo;
	}
	
}
