package pt.c40task.l05wumpus;

import java.util.ArrayList;

public class Sala {

	private ArrayList<Componente> componentes;
	private boolean jaPassou = false; 
	private boolean fedor = false;
	private boolean brisa = false;
	
	public void adicionarComponente(Componente componente) {
		componentes.add(componente);
	}
}
