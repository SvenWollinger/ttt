package de.swm;

import java.util.Scanner;

public class TTT {
    private static char game[][] = new char[3][3];
    private static Scanner scanner = new Scanner(System.in);
    private static int programCounter = 0;

    public static void main(String[] args) {
        System.out.println("Guten Tag bei TTT 2022 Pre Release 0.0.0.2!");

        while(!isGameWon()) {
            if(placeStone()) {
                paintGame();

                if (isGameWon()) {
                    System.out.println("Spiel gewonnen.");
                    break;
                }
                programCounter++;
            }
        }
    }

    public static void paintGame() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                char stone = game[row][col];

                if (stone != 0) {
                    System.out.print(" " + stone + " ");
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
    }

    public static boolean placeStone() {
        System.out.println("Bitte setze deinen Stein.");

        System.out.print("In welcher Zeile möchtest du deinen Stein setzen? (1 - 3) ");
        int row = scanner.nextInt();
        --row;

        System.out.print("In welcher Spalte möchtest du deinen Stein setzen? (1 - 3) ");
        int col = scanner.nextInt();
        --col;

        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (game[row][col] == 0) {
                if (programCounter % 2 == 0) {
                    game[row][col] = 'X';
                } else {
                    game[row][col] = 'O';
                }

                return true;
            }
        }

        return false;
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