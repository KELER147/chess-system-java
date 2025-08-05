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
        System.out.print( UI.ANSI_PURPLE + "\nDeseja ver o tutorial de como jogar? (s/n):\nDo you want to see the tutorial on how to play? (y/n): " + UI.ANSI_RESET);
        char response = sc.next().toUpperCase().charAt(0);
        if (response == 'S' || response == 'Y') {
            System.out.print("Language: (pt/en): " + UI.ANSI_RESET);
            String lang = sc.next();
            GameInfo.showTutorial(lang);
        }
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()){
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
                if (chessMatch.getPromoted() != null) {
                    System.out.println("Promotion!:");
                    System.out.println("♝ = B");
                    System.out.println("♞ = N");
                    System.out.println("♜ = R");
                    System.out.println("♛ = Q");
                    System.out.print("Enter piece for promotion:");
                    String type = sc.next().toUpperCase();
                    while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
                        System.out.print("Invalid Value!\nEnter piece for promotion:");
                        type = sc.next().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
