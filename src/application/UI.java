package application;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8");
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print(ANSI_PURPLE + (8 - i) + " " + ANSI_RESET);
            for (int j = 0; j < pieces[i].length; j++) {
                printPiece(pieces[i][j], i, j);
            }
            System.out.println(ANSI_RESET);
        }
        System.out.println(ANSI_PURPLE + "   a  b  c  d  e  f  g  h" + ANSI_RESET);
    }

    private static void printPiece(ChessPiece piece, int row, int col) {

        if ((row + col) % 2 == 0) {
            System.out.print(ANSI_WHITE_BACKGROUND);
        } else {
            System.out.print(ANSI_BLACK_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("   ");
        } else {
            if (piece.getColor() == Color.RED) {
                System.out.print(ANSI_RED + "  " + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_BLUE + "  " + piece + ANSI_RESET);
            }
        }
    }
}