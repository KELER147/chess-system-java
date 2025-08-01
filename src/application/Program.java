package application;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.*;

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
        List<ChessPiece> captured = new ArrayList<>();

        while (true){
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                sc.nextLine();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.print("Destination: ");
                ChessPosition target = UI.readChessPosition(sc);
                ChessPiece capturedPiece = chessMatch.performaChessMove(source, target);
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }
            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
