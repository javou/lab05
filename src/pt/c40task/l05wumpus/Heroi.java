package pt.c40task.l05wumpus;
import java.util.Random;

public class Heroi extends Componente {
	private boolean ouro = false;
	private boolean flechaEquipada = false;
	private int aljava = 1;
	private int pontos = 0;

	public Heroi(int coluna, int linha) {
		super(coluna, linha);
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void mover(char direcao) {
		if (direcao == 'w') {
			if (linha != 0) {
				caverna.removerComponente(coluna, linha, this);
				linha--;
				caverna.incluirComponente(this); // isso ou solicitarCaverna()?
				acoesSecundarias();
			}
		} else if (direcao == 'a') {
			if (coluna != 0) {
				caverna.removerComponente(coluna, linha, this);
				coluna--;
				caverna.incluirComponente(this);
				acoesSecundarias();
			}
		} else if (direcao == 's') {
			if (linha != 3) {
				caverna.removerComponente(coluna, linha, this);
				linha++;
				caverna.incluirComponente(this);
				acoesSecundarias();
			}
		} else {
			if (coluna != 3) {
				caverna.removerComponente(coluna, linha, this);
				coluna++;
				caverna.incluirComponente(this);
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
		Sala sala = caverna.getSala(coluna, linha); // posso fazer isso, ou devo criar método em Caverna?
		caverna.getSala(coluna, linha).setJaPassou(true);
		if (sala.contemBuraco() || (flechaEquipada == false && sala.contemWumpus())) {
			pontos -= 1000;
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
}
