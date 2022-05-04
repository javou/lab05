package pt.c40task.l05wumpus;
import java.util.*;

public class Montador {
	private Caverna caverna;
	private Componente componente;
	
	
	public Montador(String[][] estadoInicial) {
		caverna = new Caverna();
		
		for (int i = 0; i < estadoInicial.length; i++) { // implementar verifica��es.
			int linha = Integer.parseInt(estadoInicial[i][0]);
			int coluna = Integer.parseInt(estadoInicial[i][1]);
			char tipo = estadoInicial[i][2].charAt(0);
			criarComponente(coluna, linha, tipo, caverna);
			
			
			
		}
	}
	
	public void criarComponente(int coluna, int linha, char tipo, Caverna caverna) {
		if (tipo == 'B') {
			componente = new Buraco(coluna, linha);
			caverna.setBrisaSala(coluna, linha);
			// append componente na lista componentes.
		} else if (tipo == 'W') {
			componente = new Wumpus(coluna, linha);
			caverna.setFedorSala(coluna, linha);
			
			// append componente na lista componentes.
		} else if (tipo == 'P') {
			componente = new Heroi(coluna, linha);
			
			// append componente na lista componentes.
		} else if (tipo == 'O') {
			componente = new Ouro(coluna, linha);
			// append componente na lista componentes.
		}
		componente.conecta(caverna); // criar atributo est�tico Caverna caverna em Componente, assim como os m�todos conecta(Caverna caverna) e getCaverna();
		componente.getCaverna().incluirComponente(componente);
	}
	
}
