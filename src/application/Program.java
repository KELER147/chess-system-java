package application;
import chess.ChessMatch;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // MOSTRA A LEGENDA INICIAL DE PEÇAS
        GameInfo.printLegend();

        // PERGUNTA SE O USUÁRIO QUER VER O TUTORIAL
        System.out.print( UI.ANSI_PURPLE + "\nDeseja ver o tutorial de como jogar? (s/n): " + UI.ANSI_RESET);
        char response = sc.next().charAt(0);
        if (response == 's' || response == 'S') {
            System.out.print("Escolha o idioma (pt/en): " + UI.ANSI_RESET);
            String lang = sc.next();
            GameInfo.showTutorial(lang); // Chama o tutorial no idioma escolhido
        }
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());

        sc.close();
    }
}
