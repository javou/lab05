package pt.c40task.l05wumpus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Montador {
	private Caverna caverna;
	private Componente componente; // trocar por vari�vel local de criarComponente?
	
	public Montador(String[][] estadoInicial) {
		//a caverna irá ser criada somente se a entrada for válida
		if (verificarEntrada(estadoInicial)) {
			caverna = new Caverna();
			for (int i = 0; i < estadoInicial.length; i++) {
				int linha = Integer.parseInt(estadoInicial[i][0]);
				int coluna = Integer.parseInt(estadoInicial[i][1]);
				char tipo = estadoInicial[i][2].charAt(0);
				System.out.println(tipo);
				if(tipo != '_')
					criarComponente(coluna - 1, linha - 1, tipo, caverna);  // linha e coluna iniciam no 1 no arquivo de entrada. Logo o index 0 no programa, representa posição 1.
			}
		}
		else
			System.out.println("entrada inválida");
	}
	
	public boolean verificarEntrada(String[][] estadoInicial) {
		boolean v1 = false, //jogador está na posição 1?
				v2 = false;//não foram criados mais componentes do que o permitido?
		
		ArrayList<String> lista = new ArrayList<>();
		for (int i = 0; i < estadoInicial.length; i++) {
			lista.add(estadoInicial[i][2]); //será usado para vericar
			if(estadoInicial[i][2].equals("P") && estadoInicial[i][0].equals("1") && estadoInicial[i][1].equals("1")) {
				v1 = true;
			}
		}
		if(Collections.frequency(lista,"P") == 1 && Collections.frequency(lista,"O") == 1 
				                 				 && Collections.frequency(lista,"W") == 1
				                 				 && Collections.frequency(lista,"B") >= 2 //mudar para 2???? mínimo 2 mas a entrada só tem 1
				                 				 && Collections.frequency(lista,"B") <= 3) {
			v2 = true;
		}
		return v1&&v2;
	}
	
	private void criarComponente(int coluna, int linha, char tipo, Caverna caverna) {
		if (tipo == 'B') {
			componente = new Buraco(caverna,coluna, linha); // Brisas estão sendo criadas no construtor
		} else if (tipo == 'W') {
			componente = new Wumpus(caverna,coluna, linha); // Fedor está sendo criado no construtor
		} else if (tipo == 'P') {
			componente = new Heroi(coluna, linha);
		} else if (tipo == 'O') {
			componente = new Ouro(coluna, linha);
		}
		//System.out.println(componente.getClass());
		componente.conecta(caverna);
		componente.solicitarCaverna();
	}

	public Caverna getCaverna() {
		return caverna;
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
				//System.out.println(caverna.getSala(j,i).getComponentes().isEmpty());
				//System.out.println(caverna.getSala(j,i).isJaPassou());
				if(caverna.getSala(j,i).isJaPassou() && !caverna.getSala(j,i).getComponentes().isEmpty()) {
					ArrayList<Componente> componentes = caverna.getSala(j,i).getComponentes();
					Iterator it = componentes.iterator();
					while(it.hasNext()) {
						Object c = it.next().getClass();
						
						if(c  == Wumpus.class) 
							cave[i][j] = 'W';
						else if(c == Ouro.class)
							cave[i][j] = 'O';
						else if(c == Buraco.class) 
							cave[i][j] = 'B';
						else if(c == Heroi.class) 
							cave[i][j] = 'P';
						else if(c == Fedor.class) 
							cave[i][j] = 'f';
						else if(c == Brisa.class && cave[i][j] != 'f') 
							cave[i][j] = 'b';
						else
							cave[i][j] = '#';
							
					}
					
				}
				System.out.print(cave[i][j]);
				
			}
			System.out.println();
		}
		
		return cave;
	}
	
	
	
}
