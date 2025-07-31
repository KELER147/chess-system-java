package application;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        GameInfo.printLegend();

        System.out.print( UI.ANSI_PURPLE + "\nDeseja ver o tutorial de como jogar? (s/n): " + UI.ANSI_RESET);
        char response = sc.next().charAt(0);
        if (response == 's' || response == 'S') {
            System.out.print("Escolha o idioma (pt/en): " + UI.ANSI_RESET);
            String lang = sc.next();
            GameInfo.showTutorial(lang);
        }
        ChessMatch chessMatch = new ChessMatch();

        while (true){
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                sc.nextLine();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                System.out.print("Destination: ");
                ChessPosition target = UI.readChessPosition(sc);
                ChessPiece capturedPiece = chessMatch.performaChessMove(source, target);
            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
