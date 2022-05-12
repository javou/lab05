package pt.c40task.l05wumpus;

public class Controle {
	private Heroi heroi;
	
	public Controle(Componente heroi) {
		this.heroi = ((Heroi)heroi);
	}

	public void comando(char comando) {
		if (comando == 'w' || comando == 'a' || comando == 's' || comando == 'd')
			heroi.mover(comando);
		else if (comando == 'k') {
			//equipar flecha
		}
		else if (comando == 'c') {
			// capturar ouro
		}		
		else if (comando == 'q') {
			//sair do jogo
		}
	}
}
