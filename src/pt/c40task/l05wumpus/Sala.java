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

	public boolean isJaPassou() {
		return jaPassou;
	}

	public void setJaPassou(boolean jaPassou) {
		this.jaPassou = jaPassou;
	}

	public boolean isFedor() {
		return fedor;
	}

	public void setFedor(boolean fedor) {
		this.fedor = fedor;
	}

	public boolean isBrisa() {
		return brisa;
	}

	public void setBrisa(boolean brisa) {
		this.brisa = brisa;
	}
	
}
