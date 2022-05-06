package pt.c40task.l05wumpus;

public class Caverna {
	private Sala[][] salas;
	
	Caverna() {
		salas = new Sala[4][4];
		System.out.println(salas[0][0]);
	}
	public void incluirComponente(Componente componente) {
		salas[componente.getLinha()][componente.getColuna()].adicionarComponente(componente);
		
		if(componente.getClass() == Heroi.class) {
			salas[componente.getLinha()][componente.getColuna()].setJaPassou(true);
		}
		// adiciona componente na sala de mesmas coordenadas.
		
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
	public void moverComponente() {
		
	}
}
