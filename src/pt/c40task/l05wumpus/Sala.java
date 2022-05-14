package pt.c40task.l05wumpus;
import java.util.ArrayList;
import java.util.Collections;

public class Sala {
	private ArrayList<Componente> componentes;
	private boolean jaPassou; 
	
	public Sala(){
		componentes = new ArrayList<Componente>();
		jaPassou = true;
	}
	
	public void adicionarComponente(Componente componente) {
		this.componentes.add(componente);
	}
	
	public void removerComponente(Componente componente) {
		componentes.remove(componente);
	}
	
	public boolean contemBuraco() {
		boolean contem = false;
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Buraco)
				contem = true;
		}
		return contem;
	}
	
	public boolean contemOuro() { // � poss�vel fazer um m�todo para substituir esses 3?
		boolean contem = false;
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Ouro)
				contem = true;
		}
		return contem;
	}
	
	public boolean contemWumpus() {
		boolean contem = false;
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Wumpus)
				contem = true;
		}
		return contem;
	}

	public boolean isJaPassou() {
		return jaPassou;
	}

	public void setJaPassou(boolean jaPassou) {
		this.jaPassou = jaPassou;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	
	public void removerOuro() { // � poss�vel fazer um m�todo para substituir esses 2?
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Ouro)
				componentes.remove(i);
		}
	}
	
	public void removerWumpus() {
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Wumpus)
				componentes.remove(i);
		}
	}
	public boolean temFedor() {
		boolean check = false;
		for(Componente componente:componentes) {
			if(componente instanceof Fedor ) {
				check = true;
				break;
			}		
		}
		return check;
	}
	public boolean temBrisa() {
		boolean check = false;
		for(Componente componente:componentes) {
			if(componente instanceof Brisa ) {
				check = true;
				break;
			}	
		}
		return check;
	}
}
