package pt.c40task.l05wumpus;
import java.util.ArrayList;

public class Sala {
	private ArrayList<Componente> componentes;
	private boolean jaPassou; 
	
	public Sala(){
		componentes = new ArrayList<Componente>();
		jaPassou = false;
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
	
	public boolean contemOuro() {
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
	
	public boolean contemFedor() {
		boolean check = false;
		for(Componente componente:componentes) {
			if (componente instanceof Fedor) {
				check = true;
				break;
			}		
		}
		return check;
	}
	
	public boolean contemBrisa() {
		boolean check = false;
		for(Componente componente:componentes) {
			if (componente instanceof Brisa) {
				check = true;
				break;
			}	
		}
		return check;
	}
	
	public void removerOuro() {
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Ouro)
				componentes.remove(i);
		}
	}
	
	public void removerWumpus() {
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Wumpus) {
				int linha = componentes.get(i).getLinha();
				int coluna = componentes.get(i).getColuna();
				Caverna caverna = componentes.get(i).getCaverna();
				componentes.remove(i);
				if (linha - 1 >= 0) {
					caverna.getSala(coluna, linha - 1).removerFedor();
				}
				if (linha + 1 < 4) {
					caverna.getSala(coluna, linha + 1).removerFedor();
				}	
				if (coluna - 1 >= 0) {
					caverna.getSala(coluna - 1, linha).removerFedor();
				}
				if (coluna + 1 < 4) {
					caverna.getSala(coluna + 1, linha).removerFedor();
				}
			}
		}
	}
	
	public void removerFedor() {
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Fedor)
				componentes.remove(i);	
		}
	}
	
	public Heroi getHeroi() { // temos a garantia que, na posição (0, 0) no início do jogo, onde essa função é chamada, sempre será devolvido um herói (ver método verificarEntrada de Montador).
		for (int i = 0; i < componentes.size(); i++) {
			Componente elemento = componentes.get(i);
			if (elemento instanceof Heroi)
				return (Heroi)elemento;
		}
		return null;
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
}
