package application;
import chess.ChessPiece;
import chess.Color;

public class UI {

    // Códigos de Cores ANSI (Cores de Texto/Peças)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Códigos de Cores ANSI (Cores de Fundo/Tabuleiro)
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; // Fundo claro (Branco)
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m"; // Fundo escuro (Preto)

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            // Imprime o número da linha
            System.out.print(ANSI_PURPLE + (8 - i) + " " + ANSI_RESET);

            // Itera e imprime cada célula da linha
            for (int j = 0; j < pieces[i].length; j++) {
                printPiece(pieces[i][j], i, j);
            }

            // IMPORTANTE: Reseta a cor no final de cada linha para evitar que a cor de fundo "vaze"
            System.out.println(ANSI_RESET);
        }
        // Imprime as letras das colunas, com espaçamento duplo para alinhar com o centro das casas
        System.out.println(ANSI_PURPLE + "  a  b  c  d  e  f  g  h" + ANSI_RESET);
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