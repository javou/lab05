package pt.c40task.l05wumpus;

public class Caverna {
	private Sala[][] salas = new Sala[4][4];
	
	public void incluirComponente(Componente componente) {
		salas[componente.getLinha()][componente.getColuna()].adicionarComponente(componente);
		// adiciona componente na sala de mesmas coordenadas.
	}
	
	public void moverComponente() {
		
	}
}
