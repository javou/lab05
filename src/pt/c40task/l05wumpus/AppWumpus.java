package pt.c40task.l05wumpus;

import java.util.Scanner;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
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
      //Controle controle = new Controle();
      movements = "";
      if(movements.isEmpty()) {
    	  char comando = lerTeclado();
    	  while (comando!= 'q') {
    		  System.out.println();
    		  
    	  }
    	  comando = lerTeclado();
    	  
      }
      else {
    	  //ler movements
    	  for(int i = 0; i < movements.length(); i++) {
    		  //controle.comando(movements.charAt(i));
    		  
    	  }
      }
      
      
      System.out.println("=== Movimentos");
      System.out.println(movements);
      System.out.println("=== Caverna Intermediaria");
      char partialCave[][] = montador.showCaverna();
      int score = -120;
      char status = 'x'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
      tk.writeBoard(partialCave, score, status);
      System.out.println("=== Última Caverna");
      char finalCave[][] = {
         {'#', '#', 'b', '-'},
         {'#', 'b', '#', 'f'},
         {'b', '-', '-', 'w'},
         {'#', '-', '-', '-'}
      };
      score = -1210;
      status = 'n'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
      tk.writeBoard(finalCave, score, status);
   }
   public static char lerTeclado() {
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
	   keyboard.close();
	   return comandoVerificado;
   }

}
