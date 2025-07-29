package application;

// Classe dedicada a imprimir informações, legendas e tutoriais do jogo.
public class GameInfo {

    // Códigos de Cores ANSI para o terminal
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE = "\u001B[97m";
    public static final String ANSI_YELLOW_PIECE = "\u001B[93m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printLegend() {
        System.out.println();
        System.out.println("=======================================");
        System.out.println("         JAVA TERMINAL CHESS");
        System.out.println("=======================================");
        System.out.println();

        System.out.print(ANSI_WHITE_PIECE);
        System.out.printf("%-18s %-18s%n", "--- WHITE ---", "--- BLACK ---");
        System.out.print(ANSI_RESET);

        System.out.printf("%-10s %-5s %s %-10s %s%n", "King:", "♔", "|", "King:", "♚");
        System.out.printf("%-10s %-5s %s %-10s %s%n", "Queen:", "♕", "|", "Queen:", "♛");
        System.out.printf("%-10s %-5s %s %-10s %s%n", "Rook:", "♖", "|", "Rook:", "♜");
        System.out.printf("%-10s %-5s %s %-10s %s%n", "Bishop:", "♗", "|", "Bishop:", "♝");
        System.out.printf("%-10s %-5s %s %-10s %s%n", "Knight:", "♘", "|", "Knight:", "♞");
        System.out.printf("%-10s %-5s %s %-10s %s%n", "Pawn:", "♙", "|", "Pawn:", "♟");

        System.out.println();
        System.out.println("=======================================");
    }
    public static void showTutorial(String language) {
        if ("pt".equalsIgnoreCase(language)) {
            printGeneralRules_PT();
            printPieceRules_PT();
        } else {
            printGeneralRules_EN();
            printPieceRules_EN();
        }
        System.out.println("\n=======================================");
        System.out.println("       TUTORIAL CONCLUÍDO");
        System.out.println("=======================================");
    }

    private static void printGeneralRules_PT() {
        clearScreen();
        System.out.println("=======================================");
        System.out.println("         COMO JOGAR XADREZ");
        System.out.println("=======================================");
        System.out.println("\nOBJETIVO:");
        System.out.println("O objetivo do jogo é dar 'xeque-mate' no Rei adversário. Isso acontece quando o Rei está sob ataque (em 'xeque') e não tem nenhuma jogada legal para escapar.");
        System.out.println("\nTURNOS:");
        System.out.println("O jogo é jogado em turnos alternados. As peças BRANCAS (♔) sempre fazem o primeiro movimento.");
        System.out.println("\nFIM DE JOGO:");
        System.out.println("O jogo termina em uma das seguintes condições:");
        System.out.println(" - Xeque-mate: Um dos jogadores vence.");
        System.out.println(" - Empate: Nenhum jogador pode forçar um xeque-mate. Isso pode acontecer por 'Rei Afogado' (um jogador não tem movimentos legais, mas não está em xeque), repetição de posição, ou acordo entre os jogadores.");
    }

    private static void printPieceRules_PT() {
        System.out.println("\n=======================================");
        System.out.println("        MOVIMENTO DAS PEÇAS");
        System.out.println("=======================================");

        System.out.println("\n--- REI (♔ ♚) ---");
        System.out.println("Move uma casa em qualquer direção (horizontal, vertical ou diagonal). É a peça mais importante, mas também uma das mais fracas.");

        System.out.println("\n--- DAMA (♕ ♛) ---");
        System.out.println("A peça mais poderosa. Move quantas casas quiser em qualquer direção (horizontal, vertical ou diagonal), desde que o caminho esteja livre.");

        System.out.println("\n--- TORRE (♖ ♜) ---");
        System.out.println("Move quantas casas quiser na horizontal ou na vertical, para frente, para trás ou para os lados.");

        System.out.println("\n--- BISPO (♗ ♝) ---");
        System.out.println("Move quantas casas quiser na diagonal. Um bispo sempre permanece nas casas de mesma cor em que começou.");

        System.out.println("\n--- CAVALO (♘ ♞) ---");
        System.out.println("Move em formato de 'L': duas casas em uma direção (horizontal ou vertical) e uma casa na direção perpendicular. É a única peça que pode pular sobre outras peças.");

        System.out.println("\n--- PEÃO (♙ ♟) ---");
        System.out.println(" - Movimento: Move-se sempre uma casa para frente.");
        System.out.println(" - Primeiro Movimento: Em sua primeira jogada, o peão pode optar por mover uma ou duas casas para frente.");
        System.out.println(" - Captura: Captura peças adversárias na diagonal, uma casa à frente.");
        System.out.println(" - Promoção: Ao alcançar a última fileira do tabuleiro, o peão é promovido a qualquer outra peça (exceto o Rei).");
    }

    private static void printGeneralRules_EN() {
        clearScreen(); // Supondo que o clearScreen está na classe UI
        System.out.println("=======================================");
        System.out.println("         HOW TO PLAY CHESS");
        System.out.println("=======================================");
        System.out.println("\nOBJECTIVE:");
        System.out.println("The objective of the game is to 'checkmate' the opponent's King. This happens when the King is under attack (in 'check') and has no legal move to escape.");
        System.out.println("\nTURNS:");
        System.out.println("The game is played in alternating turns. The WHITE (♔) pieces always make the first move.");
        System.out.println("\nEND OF GAME:");
        System.out.println("The game ends in one of the following conditions:");
        System.out.println(" - Checkmate: One of the players wins.");
        System.out.println(" - Stalemate: A draw where a player has no legal moves, but their King is not in check.");
        System.out.println(" - Draw: Can also occur by agreement, threefold repetition, or the fifty-move rule.");
    }

    private static void printPieceRules_EN() {
        System.out.println("\n=======================================");
        System.out.println("        PIECE MOVEMENTS");
        System.out.println("=======================================");

        System.out.println("\n--- KING (♔ ♚) ---");
        System.out.println("Moves one square in any direction (horizontal, vertical, or diagonal). It's the most important piece, but also one of the weakest.");

        System.out.println("\n--- QUEEN (♕ ♛) ---");
        System.out.println("The most powerful piece. Moves any number of squares in any direction (horizontal, vertical, or diagonal), as long as the path is clear.");

        System.out.println("\n--- ROOK (♖ ♜) ---");
        System.out.println("Moves any number of squares horizontally or vertically, forwards, backwards, or sideways.");

        System.out.println("\n--- BISHOP (♗ ♝) ---");
        System.out.println("Moves any number of squares diagonally. A bishop always remains on squares of the same color it started on.");

        System.out.println("\n--- KNIGHT (♘ ♞) ---");
        System.out.println("Moves in an 'L' shape: two squares in one direction (horizontal or vertical) and then one square in a perpendicular direction. It's the only piece that can jump over other pieces.");

        System.out.println("\n--- PAWN (♙ ♟) ---");
        System.out.println(" - Movement: Always moves one square forward.");
        System.out.println(" - First Move: On its first move, a pawn can choose to move either one or two squares forward.");
        System.out.println(" - Capture: Captures opponent's pieces one square diagonally forward.");
        System.out.println(" - Promotion: When a pawn reaches the last rank of the board, it is promoted to any other piece (except the King).");
    }
}