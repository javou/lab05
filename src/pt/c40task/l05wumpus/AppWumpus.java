package pt.c40task.l05wumpus;

import java.util.Scanner;

public class AppWumpus {

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
      Controle controle = new Controle(montador.getCaverna().getHeroi());
      // movements = "";
      
      if(movements.isEmpty()) {
    	  informarJogador(montador, tk, true);
    	  char comando = lerTeclado();
    	  while (comando != 'q') {
    		  controle.lerComando(comando);
    		  if((checkStatus((Heroi)montador.getCaverna().getHeroi())) == 'x') {
    			  informarJogador(montador, tk, false);
    			  comando = lerTeclado();
    		  }
    		  else {
    			  informarJogador(montador, tk, false);
    			  comando = 'q';
    		  }
    	  }
		  char status = checkStatus((Heroi)montador.getCaverna().getHeroi());
	      if(status == 'w') 
	    	  System.out.println("Você ganhou!");
	      else if(status == 'n')
	    	  System.out.println("Você perdeu!");
	      else
	    	  System.out.println("Volte sempre!");
      }
      else {
    	  informarJogador(montador, tk, true);
    	  char comando, status;
    	  for (int i = 0; i < movements.length(); i++) {
    		  status = checkStatus((Heroi)montador.getCaverna().getHeroi());
    		  if (status == 'w') {
    			  System.out.println("Você ganhou!");
    			  break;
    		  } else if (status == 'n') {
    			  System.out.println("Você perdeu!");
    			  break;
    		  } else {
    			  comando = movements.charAt(i);
    			  controle.lerComando(comando);
    			  if (comando == 'q') { // passar para Controle?
    				  System.out.println("Volte sempre!");
    				  break;
    			  }
    			  informarJogador(montador, tk, false);
    		  }
    	  }
      }  
   }
   
   private static char lerTeclado() {
	   Scanner keyboard = new Scanner(System.in);
	   String comando = keyboard.nextLine();
	   char comandoVerificado = ' ';
	   if(comando.charAt(0) == 'w' || comando.charAt(0) == 's' 
			                       || comando.charAt(0) == 'd'
			                       || comando.charAt(0) == 'a'
			                       || comando.charAt(0) == 'k'
			                       || comando.charAt(0) == 'c'
			                       || comando.charAt(0) == 'q') {
		   comandoVerificado = comando.charAt(0);
	   }
	   //keyboard.close(); should I close the scanner here???
	   return comandoVerificado;
   }
   
   private static void informarJogador(Montador montador, Toolkit tk, boolean firstboard) {
	      Heroi heroi = (Heroi)montador.getCaverna().getHeroi();
	      
	      int score = ((Heroi)montador.getCaverna().getHeroi()).getPontos();
	      char status = checkStatus((Heroi)montador.getCaverna().getHeroi()); // 'w' para venceu; 'n' para perdeu; 'x' intermedi�rias
	      int posHeroiColuna = ((Heroi)montador.getCaverna().getHeroi()).getColuna();
	      int posHeroiLinha = ((Heroi)montador.getCaverna().getHeroi()).getLinha();
	      if (firstboard) {
	    	  System.out.println("\n\n=== Caverna do Diabo");
	    	  firstboard = false;
	      }
	      else if(status == 'x')
	    	  System.out.println("\n\n=== Caverna Intermediária");
	      else 
	    	  System.out.println("\n\n=== última caverna");  
	      char partialCave[][] = montador.getCaverna().showCaverna();
	      System.out.println("");
	      checkBrisaFedor(montador.getCaverna().getSala(posHeroiColuna,posHeroiLinha));	  
	      tk.writeBoard(partialCave, score, status);
		  System.out.println("Inventário:");
		  if(heroi.getAljava() > 0)
		  System.out.println("- Flechas: " + Integer.toString(heroi.getAljava()));
		  if(heroi.isOuro())
			System.out.println("- Barra de ouro");
		  System.out.println("");
		  if(heroi.isFlechaEquipada())
		  	System.out.println("Flecha equipada!");
		  
	      //teste
	      System.out.println("Pontuação: " + score);
	      // System.out.println("Status: " + (status == 'x' ? "Estou vivo." : (status == 'n' ? "Aaaah!" : "Ufa!")));
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
