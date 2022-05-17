package pt.c40task.l05wumpus;

public class Controle {
	private Heroi heroi;
	
	public Controle(Componente heroi) {
		this.heroi = ((Heroi)heroi);
	}

	public void lerComando(char comando) {
		if (comando == 'w' || comando == 'a' || comando == 's' || comando == 'd') {
			heroi.mover(comando);
		}
		else if (comando == 'k') {
			heroi.equiparFlecha();
		}
		else if (comando == 'c') {
			heroi.capturarOuro();
		}		
	}
	
	public Heroi getHeroi() {
		return heroi;
	}
}
