# Lab05 - Mundo de Wumpus
## Arquivos Java sobre Mundo de Wumpus

[Arquivos](src/pt/c40task/l05wumpus)

Nesse laboratório foram desenvolvidos os conceitos de orientados à objetos abordados em aula.

Este jogo foi projetado da seguinte forma:
  Inicialmente, um objeto da classe Montador é responsável por instanciar os objetos da classe Caverna, Sala, Componentes com base no arquivo de entrada. Ao mesmo tempo, **estabelecer um link** entre os objetos se necessário. Ex: criar os componentes que irão pedir para a caverna colocá-los nas salas corretas. 
```java
public class Montador {
	private Caverna caverna;
	public Montador(String[][] estadoInicial) {
		//a caverna irá ser criada somente se a entrada for válida
		if (verificarEntrada(estadoInicial)) {
			caverna = new Caverna();
			for (int i = 0; i < estadoInicial.length; i++) {
				int linha = Integer.parseInt(estadoInicial[i][0]);
				int coluna = Integer.parseInt(estadoInicial[i][1]);
				char tipo = estadoInicial[i][2].charAt(0);
				System.out.println(tipo);
				if(tipo != '_')
					criarComponente(coluna - 1, linha - 1, tipo, caverna);  // linha e coluna iniciam no 1 no arquivo de entrada. Logo o index 0 no programa, representa posição 1.
			}
		}
		else
			System.out.println("entrada inválida");
	}
```
  O objeto controle será o responsável por executar as ações do jogo(seguindo a **architetura proposta**) que podem vir de um arquivo ou a leitura do teclado caso a entrada seja válida. Ex: Comando andar para cima (w) > entrada válida > comunica ao personagem a ação > personagem comunica com a Caverna > Caverna comunica com a salas envolvidas > próxima ação que pode ser um movimento ou ação secundária como o conflito com o Wampus
  
```java
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
 
``` 
  
No design apresentado, o uso de **sobrecarga** não foi necessário. Ou seja, os métodos criados na classse mãe não sofreram modificações na classe filha.

A utilização do **polimorfismo** facilitou a gestão dos objetos criados no jogo. Todos os componentes do jogo (Herói, Wampus...) são classes filhas de uma classe Componente. Dessa forma, atributos e métodos em comum foram reutilizados. **No futuro, isso facilatará a criação de novos tipos de componentes**, ou seja, a expansão do jogo. Além disso, um **arraylist do tipo Componente** foi criado em cada sala e então todos os componentes puderam ser listados em uma única lista nos casos onde a sala tem mais de um componente. 

```java
public class Heroi extends Componente{...}
public class Wumpus extends Componente{...}
```
```java
public class Sala {
  private ArrayList<Componente> componentes;
	private boolean jaPassou; 
	
	public Sala(){
		componentes = new ArrayList<Componente>();
		jaPassou = false;
	}
...}
```
Nesse jogo, o **herói tem conciência de suas ações e estado**. Então, todas as ações (méthodos) e estado(atributos) estão armazenados no objeto herói, o que pode facilitar uma **expanção das habilidades do herói no futuro**. No entanto, o herói é um componente especial pois ele executa ações que os outros componentes não tem. Para evitar a implementação desses métodos na classe mãe e evitar que todos os componentes herdem esses métodos, um cast foi utilizado para poder utilizar esses métodos especiais(Ex: atirar() e capturarOuro()). Finalmente, esses dados foram **encapsulados** para evitar acessos indevidos. 
```java
public class Heroi extends Componente {
	private boolean ouro = false;
	private boolean flechaEquipada = false;
	private int aljava;
	private int pontos;
	private boolean estouVivo = true;
	public Heroi(int coluna, int linha) {
		super(coluna, linha);
		aljava = 1;
		pontos = 0;
	}
	private void atirar() {
		pontos -= 100;
		flechaEquipada = false;
		Sala sala = caverna.getSala(coluna, linha);
		if (sala.contemWumpus()) {
			Random rngesus = new Random();
			if (rngesus.nextBoolean() == true) {
				sala.removerWumpus();
				pontos += 500;
			} else {
				pontos -= 1000;
				estouVivo = false;
			}
		}
	}
	public void capturarOuro() {
		Sala sala = caverna.getSala(coluna, linha);
		if (sala.contemOuro()) {
			sala.removerOuro();
			ouro = true;
			pontos += 1000;
		}
	}

```
