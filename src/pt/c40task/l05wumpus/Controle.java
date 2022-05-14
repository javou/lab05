package pt.c40task.l05wumpus;

public class Controle {
	private Heroi heroi;
	
	public Controle(Componente heroi) {
		this.heroi = ((Heroi)heroi);
	}

	public void comando(char comando) {
		if (comando == 'w' || comando == 'a' || comando == 's' || comando == 'd') {
			heroi.mover(comando);
		}
		else if (comando == 'k') { // pontos s�o perdidos ao equipar, ou ao atirar?
			heroi.equiparFlecha();
		}
		else if (comando == 'c') {
			heroi.capturarOuro();
		}		
		/*tratado na main()
		 * 
		 * else if (comando == 'q') {
			System.exit(0); // mudar?
		}*/
	}
	
	// como tratar impress�o?
}
