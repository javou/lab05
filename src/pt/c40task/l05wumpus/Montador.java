package pt.c40task.l05wumpus;

public class Montador {
	private Caverna caverna;
	private Componente componente; // trocar por variável local de criarComponente?
	
	
	public Montador(String[][] estadoInicial) {
		caverna = new Caverna();
		
		for (int i = 0; i < estadoInicial.length; i++) { // implementar verificações.
			int linha = Integer.parseInt(estadoInicial[i][0]);
			int coluna = Integer.parseInt(estadoInicial[i][1]);
			char tipo = estadoInicial[i][2].charAt(0);
			criarComponente(coluna - 1, linha - 1, tipo, caverna);  // linha e coluna iniciam no 1 na entrada.
		}
	}
	
	
	private void criarComponente(int coluna, int linha, char tipo, Caverna caverna) {
		if (tipo == 'B') {
			componente = new Buraco(coluna, linha);
			componente.criarBrisa(); // usar cast?
			
		} else if (tipo == 'W') {
			componente = new Wumpus(coluna, linha);
			componente.criarFedor();
			
		} else if (tipo == 'P') {
			componente = new Heroi(coluna, linha);
			
		} else if (tipo == 'O') {
			componente = new Ouro(coluna, linha);
		}
		componente.conecta(caverna);
		componente.solicitarCaverna();
	}
	
	private void verificar() {
		
	}
}
