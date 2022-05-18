package pt.c40task.l05wumpus;
import java.util.Scanner;

public class AppWumpus {
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		AppWumpus.executaJogo(
				(args.length > 0) ? args[0] : null,
				(args.length > 1) ? args[1] : null,
				(args.length > 2) ? args[2] : null);
	}
	
	private static void executaJogo(String arquivoCaverna, String arquivoSaida,
	                               String arquivoMovimentos) {
		Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
		String cave[][] = tk.retrieveCave();
		System.out.println("=== Caverna");
		for (int l = 0; l < cave.length; l++) {
			for (int c = 0; c < cave[l].length; c++)
				System.out.print(cave[l][c] + ((c < cave[l].length-1) ? ", " : ""));
			System.out.println();
		}
		
		Montador montador = new Montador(cave);    
		String movements = tk.retrieveMovements();
		Controle controle = new Controle(montador.getCaverna().getSala(0, 0).getHeroi());
		Heroi heroi = controle.getHeroi();
		// movements = ""; // para testar teclado.
		
		if(movements.isEmpty()) { // para ler informações do teclado.
			informarJogador(montador, controle, tk, true);
			char comando = lerTeclado();
			while (comando != 'q') {
			  controle.lerComando(comando);
			  if((checkStatus(heroi)) == 'x') {
				  informarJogador(montador, controle, tk, false);
				  comando = lerTeclado();
			  }
			  else { // caso o status seja 'w' ou 'n' (jogo acabou) faz com que o próximo comando seja q, quebrando o loop.
				  informarJogador(montador, controle, tk, false);
				  comando = 'q';
			  }
			}
			char status = checkStatus(heroi);
		    if(status == 'w') 
		   	  System.out.println("Você ganhou!");
		    else if(status == 'n')
		   	  System.out.println("Você perdeu!");
		    else // se o status é 'x' e o loop acabou, então o jogador passou o comando q.
		    	System.out.println("Volte sempre!");
		}
		else { // para ler informações do arquivo.
			  informarJogador(montador, controle, tk, true);
			  char comando, status;
			  for (int i = 0; i < movements.length(); i++) {
				  status = checkStatus(heroi);
				  if (status == 'w') {
					  System.out.println("Você ganhou!");
					  break;
				  } else if (status == 'n') {
					  System.out.println("Você perdeu!");
					  break;
				  } else { // se o status do jogo for 'x', lê o próximo comando.
					  comando = movements.charAt(i);
					  controle.lerComando(comando);
					  if (comando == 'q') {
						  System.out.println("Volte sempre!");
						  break;
					  }
					  informarJogador(montador, controle, tk, false); // se o último comando não foi q, mostra o estado do jogo para o jogador após executar o comando.
				  }
			  }
		} 
		tk.stop();
	}
	
	private static char lerTeclado() {
		   String comando = keyboard.nextLine();
		   char comandoVerificado = ' '; // garante que só passarão comandos válidos.
		   if(comando.charAt(0) == 'w' || comando.charAt(0) == 's' 
				                       || comando.charAt(0) == 'd'
				                       || comando.charAt(0) == 'a'
				                       || comando.charAt(0) == 'k'
				                       || comando.charAt(0) == 'c'
				                       || comando.charAt(0) == 'q') {
			   comandoVerificado = comando.charAt(0);
		   }
		   return comandoVerificado;
	}
	
	private static void informarJogador(Montador montador, Controle controle, Toolkit tk, boolean firstboard) {
				// Mostra informações ao jogador.
		      
				Heroi heroi = controle.getHeroi();
		      
		      int score = heroi.getPontos();
		      char status = checkStatus(heroi); // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
		      int posHeroiColuna = (heroi).getColuna();
		      int posHeroiLinha = (heroi).getLinha();
		      if (firstboard) {
		    	  System.out.println("\n\n=== Caverna do Diabo");
		    	  firstboard = false;
		      }
		      else if(status == 'x')
		    	  System.out.println("\n\n=== Caverna Intermediária");
		      else 
		    	  System.out.println("\n\n=== Última caverna");  
		      char partialCave[][] = montador.getCaverna().showCaverna();
		      System.out.println("");
			  if(heroi.isFlechaEquipada())
				  	System.out.println("Flecha equipada!\n");
		      checkBrisaFedor(montador.getCaverna().getSala(posHeroiColuna,posHeroiLinha));	  
		      tk.writeBoard(partialCave, score, status);
			  System.out.println("Inventário:");
			  if(heroi.getAljava() > 0)
			  System.out.println("- Flechas: " + Integer.toString(heroi.getAljava()));
			  if(heroi.isOuro())
				System.out.println("- Barra de ouro");
			  System.out.println("");
			  
		      //teste
		      System.out.println("Pontuação: " + score);
	}
	
	private static char checkStatus(Heroi heroi) {
		   char status;
		   if(heroi.getColuna() == 0 && heroi.getLinha() == 0 && heroi.isOuro())
			   status = 'w';
		   else if (!heroi.isEstouVivo())
			   status = 'n';
		   else
			   status = 'x';
		   return status;
	}
	
	private static void checkBrisaFedor(Sala sala) {
		   if(sala.contemBrisa() && sala.contemFedor())
			   System.out.println("Status: Sinto uma brisa e um leve cheiro de peido...\n"); 
		   else if(sala.contemBrisa())
			   System.out.println("Status: Sinto uma brisa...\n");
		   else if(sala.contemFedor())
			   System.out.println("Status: Quem peidou?\n");   
	}
	
}
