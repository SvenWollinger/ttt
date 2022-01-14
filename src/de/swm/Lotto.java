package de.swm;

public class Lotto {
   private static int gezogeneZahlen[] = new int[6];

   public static void main(String[] args) {
      int i = 0;
      do {
         double rnd = Math.random();
         int gezogeneZahl = (int)(rnd * 49) + 1;
         if (!istInArray(gezogeneZahl)) {
            gezogeneZahlen[i] = gezogeneZahl;
            i = i + 1;
         }
      } while(i < 6);

      int zusatzzahl = (int)(Math.random() * 9) + 1;
      for (int zahl : gezogeneZahlen) {
         System.out.print(zahl + " ");
      }
      System.out.println("Zusatzzahl: " + zusatzzahl);

      int summe = 0;
      for (int j = 0; j < gezogeneZahlen.length; j++) {
         summe += gezogeneZahlen[j];
      }
      System.out.println("Im Durchschnitt haben wir " + summe / gezogeneZahlen.length + " gezogen");
   }

   private static boolean istInArray(int zufallszahl) {
      for(int i = 0; i < gezogeneZahlen.length; i++) {
         if (gezogeneZahlen[i] == zufallszahl) {
            return true;
         }
      }

      return false;
   }
}
