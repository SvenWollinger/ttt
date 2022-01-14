package de.swm;

import java.util.Scanner;

public class Spielfeld {
   private static char[][] spielfeld = new char[8][8];
   private static int figurX = 0;
   private static int figurY = 0;

   public static void main(String[] args) {
      figurX = (int)(Math.random() * spielfeld.length);
      figurY = (int)(Math.random() * spielfeld.length);
      initialisiereSpielfeld();

      do {
         druckeSpielfeld();
      } while(eingabeBewegung());
   }

   private static void initialisiereSpielfeld() {
      for(int i = 0; i < spielfeld.length; i++) {
         for(int j = 0; j < spielfeld.length; j++) {
            if (i == figurY && j == figurX) {
               spielfeld[i][j] = 'X';
            } else {
               spielfeld[i][j] = 'O';
            }
         }
      }
   }

   private static void druckeSpielfeld() {
      for(int i = 0; i < spielfeld.length; i++) {
         for(int j = 0; j < spielfeld.length; j++) {
            System.out.print(spielfeld[i][j]);
         }
         System.out.println();
      }
      System.out.println();
   }

   private static boolean eingabeBewegung() {
      System.out.print("Bewegung nach (wasd): ");
      Scanner scanner = new Scanner(System.in);
      String eingabe = scanner.nextLine();

      spielfeld[figurY][figurX] = 'O';
      switch(eingabe) {
         case "w" -> figurY--;
         case "a" -> figurX--;
         case "s" -> figurY++;
         case "d" -> figurX++;
         case "b" -> {
            return false;
         }
      }

      // über den Rand des Spielfelds bewegen
      if (figurY < 0) {
         figurY = spielfeld.length - 1;
      } else if (figurY >= spielfeld.length) {
         figurY = 0;
      } else if (figurX < 0) {
         figurX = spielfeld.length - 1;
      } else if (figurX >= spielfeld.length) {
         figurX = 0;
      }

      spielfeld[figurY][figurX] = 'X';
      return true;
   }
}
