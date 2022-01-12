package de.swm;

import java.util.Scanner;

public class TTT {
    private static char game[][] = new char[3][3];
    private static Scanner scanner = new Scanner(System.in);
    private static int programCounter = 0;

    public static void main(String[] args) {
        System.out.println("Guten Tag bei TTT 2022 Pre Release 0.0.0.1.");

        // Schritt 1: Eingabe Player 1
        while(programCounter < 9) {
            placeStone();
            paintGame();
            if (isGameWon()) {
                System.out.println("Spiel gewonnen.");
                Math.round(3.31);
                return;
            }
            programCounter++;
        }




        // Schritt 2: Ausgabe Spielfeld
        // Schritt 3: Eingabe Player 2
        // Schritt 4: Ausgabe Spielfeld
        // Schritt 5: Eingabe Player 1
        // Schritt 6: Ausgabe Spielfeld
        // Schritt 7...
    }

    public static void generateFakeGame() {
        //        X | X | O
        //        X | O | X
        //        X | O | X
        game[0][0] = 'X';
        game[1][0] = 'O';
        game[2][0] = 'X';
        game[0][1] = 'X';
        game[1][1] = 'O';
        game[2][1] = 'O';
        game[0][2] = 'O';
        game[1][2] = 'X';
        game[2][2] = 'X';
    }

    public static void paintGame() {
        // TODO empty elements
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                System.out.print(" " + game[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void placeStone() {
        // TODO - validation
        //  is field empty?
        //  is field on board?
        System.out.println("Bitte setze deinen Stein.");

        System.out.print("In welcher Zeile möchtest du deinen Stein setzen? (1 - 3) ");
        int row = scanner.nextInt();
        --row;

        System.out.print("In welcher Spalte möchtest du deinen Stein setzen? (1 - 3) ");
        int col = scanner.nextInt();
        --col;

        if (programCounter % 2 == 0) {
            game[row][col] = 'X';
        } else {
            game[row][col] = 'O';
        }
    }

    public static boolean isGameWon() {
        for (int i = 0; i < 3; i++) {
            // check each row
            if (game[i][0] == game[i][1] && game[i][2] == game[i][0]) { // überprüft, ob waagrecht 3 gleich zu finden sind
                if (game[i][0] == 'X' || game[i][0] == 'O') { // damit bei leeren feldern nicht gewonnen wird
                    return true;
                }
            // check each col
            } else if (game[0][i] == game[1][i] && game[2][i] == game[0][i]) { // überprüft, ob senkrecht 3 gleich zu finden sind
                if (game[0][i] == 'X' || game[0][i] == 'O') { // damit bei leeren feldern nicht gewonnen wird
                    return true;
                }
            }
        }

        // diagonal
        if (game[1][1] == 'X' || game[1][1] == 'O') {
            if (game[0][0] == game[1][1] && game[1][1] == game[2][2]) {
                return true;
            } else if (game[0][2] == game[1][1] && game[1][1] == game[2][0]) {
                return true;
            }
        }

        return false;
    }
}