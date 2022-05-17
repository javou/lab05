package pt.c40task.l05wumpus;

import java.util.ArrayList;
import java.util.Iterator;

public class Caverna {
	private Sala[][] salas;
	private Componente heroi; // global no app, global no controle, chamar sempre ou global no montador?
	
	public Caverna() {
		salas = new Sala[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				salas[i][j] = new Sala();
			}
		}
	}
	
	public void incluirComponente(Componente componente) {
		salas[componente.getLinha()][componente.getColuna()].adicionarComponente(componente);
		if(componente.getClass() == Heroi.class) {
			salas[componente.getLinha()][componente.getColuna()].setJaPassou(true);
			heroi = componente;
		}
		// adiciona componente na sala de mesmas coordenadas.
	}
	
	public void removerComponente(int coluna, int linha, Componente componente) {
		salas[linha][coluna].removerComponente(componente);
	}
	
	public char[][] estadoCaverna() {
		char[][] caverna = new char[4][4];
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; i++) {
				if(salas[i][j].isJaPassou()) {
					caverna[i][j] = 'm';
				}
			}
		}
		return caverna;
	}
	
	public Sala getSala(int coluna, int linha) {
		return salas[linha][coluna];
	}
	
	public char[][] showCaverna() {
		char cave[][] = {
		         {'-', '-', '-', '-'},
		         {'-', '-', '-', '-'},
		         {'-', '-', '-', '-'},
		         {'-', '-', '-', '-'}
		      };
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				//System.out.println(salas[i][j].getComponentes().isEmpty());
				//System.out.println(salas[i][j].isJaPassou());
				if(salas[i][j].isJaPassou() && !salas[i][j].getComponentes().isEmpty()) {
					ArrayList<Componente> componentes = salas[i][j].getComponentes();
					Iterator<Componente> it = componentes.iterator();
					while(it.hasNext()) {
						Object c = it.next().getClass();
						
						if(c  == Wumpus.class) { 
							cave[i][j] = 'W';
							break;
						}
						else if(c == Ouro.class) {
							cave[i][j] = 'O';
							break;
						}
						else if(c == Buraco.class) { 
							cave[i][j] = 'B';
							break;
						}
						else if(c == Heroi.class) {
							cave[i][j] = 'P';
						}
						else if(c == Fedor.class && cave[i][j] != 'P') {
							cave[i][j] = 'f';	
						}
						else if(c == Brisa.class && cave[i][j] != 'f' && cave[i][j] != 'P') {
							cave[i][j] = 'b';
						}		
					}
				}
				if(salas[i][j].isJaPassou() && salas[i][j].getComponentes().isEmpty())
					cave[i][j] = '#';
				System.out.print(cave[i][j]);
			}
			System.out.println();
		}
		return cave;
	}
	
	public Componente getHeroi() {
		return heroi;
	}
}
