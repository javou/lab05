package pt.c40task.l05wumpus;

public class Montador {
	private Caverna caverna;
	private Componente[] componentes;
	
	public Montador(String[][] estadoInicial) {
		caverna = new Caverna();
		for (int i = 0; i < estadoInicial.length; i++) { // implementar verificações.
			int linha = Integer.parseInt(estadoInicial[i][0]);
			int coluna = Integer.parseInt(estadoInicial[i][1]);
			char tipo = estadoInicial[i][2].charAt(0);
			if (tipo == 'B') {
				Componente componente = new Buraco(linha, coluna);
				// append componente na lista componentes.
			} else if (tipo == 'W') {
				Componente componente = new Wumpus(linha, coluna);
				// append componente na lista componentes.
			} else if (tipo == 'P') {
				Componente componente = new Heroi(linha, coluna);
				// append componente na lista componentes.
			} else if (tipo == 'O') {
				Componente componente = new Ouro(linha, coluna);
				// append componente na lista componentes.
			}
		}
		Componente.conecta(caverna); // criar atributo estático Caverna caverna em Componente, assim como os métodos conecta(Caverna caverna) e getCaverna();
		for (int i = 0; i < componentes.length; i++)
			componentes[i].getCaverna().incluirComponente(componentes[i]);
	}
}
