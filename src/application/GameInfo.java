package application;
public class GameInfo {
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printLegend() {
        System.out.println();
        System.out.println(UI.ANSI_RED + ("=======================================") + UI.ANSI_RESET);
        System.out.println( UI.ANSI_PURPLE + ("         JAVA TERMINAL CHESS") + UI.ANSI_RESET);
        System.out.println(UI.ANSI_BLUE + ("=======================================") + UI.ANSI_RESET);
        System.out.println();

        System.out.printf("%-18s %-18s%n", UI.ANSI_RED + "---> RED <--- " + UI.ANSI_RESET, UI.ANSI_BLUE + "---> BLUE <---" + UI.ANSI_RESET);
        System.out.print(UI.ANSI_RESET);

        System.out.printf("%-10s %-5s %s %-10s %s%n", "King:", UI.ANSI_RED + "♔" + UI.ANSI_RESET, "|", "King:",UI.ANSI_BLUE+ "♔" + UI.ANSI_RESET);
        System.out.printf("%-10s %-5s %s %-10s %s%n", "Queen:", UI.ANSI_RED + "♕" + UI.ANSI_RESET, "|", "Queen:", UI.ANSI_BLUE+ "♕" + UI.ANSI_RESET);
        System.out.printf("%-10s %-5s %s %-10s %s%n", "Rook:", UI.ANSI_RED + "♖" + UI.ANSI_RESET, "|", "Rook:", UI.ANSI_BLUE+ "♖" + UI.ANSI_RESET);
        System.out.printf("%-10s %-5s %s %-10s %s%n", "Bishop:", UI.ANSI_RED + "♗" + UI.ANSI_RESET, "|", "Bishop:", UI.ANSI_BLUE+ "♗" + UI.ANSI_RESET);
        System.out.printf("%-10s %-5s %s %-10s %s%n", "Knight:", UI.ANSI_RED + "♘" + UI.ANSI_RESET, "|", "Knight:", UI.ANSI_BLUE+ "♘" + UI.ANSI_RESET);
        System.out.printf("%-10s %-5s %s %-10s %s%n", "Pawn:", UI.ANSI_RED + "♙" + UI.ANSI_RESET, "|", "Pawn:", UI.ANSI_BLUE+ "♙" + UI.ANSI_RESET);

        System.out.println();
    }

    public static void showTutorial(String language) {
        if ("pt".equalsIgnoreCase(language)) {
            printGeneralRules_PT();
            printPieceRules_PT();
            System.out.println("\n=======================================");
            System.out.println("       TUTORIAL CONCLUÍDO");
            System.out.println("=======================================");
        } else {
            printGeneralRules_EN();
            printPieceRules_EN();
            System.out.println("\n=======================================");
            System.out.println("       TUTORIAL COMPLETED");
            System.out.println("=======================================");
        }
    }

    private static void printGeneralRules_PT() {
        clearScreen();
        System.out.println("=======================================");
        System.out.println("         COMO JOGAR XADREZ");
        System.out.println("=======================================");
        System.out.println(ANSI_CYAN + "\nOBJETIVO:" + UI.ANSI_RESET);
        System.out.println("O objetivo do jogo é dar 'xeque-mate' no Rei adversário. Isso acontece quando o Rei está sob ataque (em 'xeque') e não tem nenhuma jogada legal para escapar.");
        System.out.println(ANSI_CYAN + "\nTURNOS:" + UI.ANSI_RESET);
        System.out.println("O jogo é jogado em turnos alternados. As peças BRANCAS (♔) sempre fazem o primeiro movimento.");
        System.out.println(ANSI_CYAN + "\nFIM DE JOGO:" + UI.ANSI_RESET);
        System.out.println("O jogo termina em uma das seguintes condições:");
        System.out.println(" - Xeque-mate: Um dos jogadores vence.");
        System.out.println(" - Empate: Nenhum jogador pode forçar um xeque-mate.");
    }

    private static void printPieceRules_PT() {
        System.out.println("\n=======================================");
        System.out.println("        MOVIMENTO DAS PEÇAS");
        System.out.println("=======================================");

        System.out.println(ANSI_CYAN + "\n--- REI (♔ ♚) ---" + UI.ANSI_RESET);
        System.out.println("Move uma casa em qualquer direção (horizontal, vertical ou diagonal).");
        System.out.println(ANSI_CYAN + "\n--- DAMA (♕ ♛) ---" + UI.ANSI_RESET);
        System.out.println("A peça mais poderosa. Move quantas casas quiser em qualquer direção.");
        System.out.println(ANSI_CYAN + "\n--- TORRE (♖ ♜) ---" + UI.ANSI_RESET);
        System.out.println("Move quantas casas quiser na horizontal ou na vertical.");
        System.out.println(ANSI_CYAN + "\n--- BISPO (♗ ♝) ---" + UI.ANSI_RESET);
        System.out.println("Move quantas casas quiser na diagonal.");
        System.out.println(ANSI_CYAN + "\n--- CAVALO (♘ ♞) ---" + UI.ANSI_RESET);
        System.out.println("Move em formato de 'L' e pode pular sobre outras peças.");
        System.out.println(ANSI_CYAN + "\n--- PEÃO (♙ ♟) ---" + UI.ANSI_RESET);
        System.out.println(" - Movimento: Move-se uma casa para frente. Pode mover duas no primeiro lance.");
        System.out.println(" - Captura: Captura peças adversárias na diagonal.");
        System.out.println(ANSI_CYAN + "\n\n--- JOGADAS ESPECIAIS ---" + UI.ANSI_RESET);
        System.out.println(" - Roque (Castling): Movimento especial entre o rei e a torre, onde o rei se move duas casas em direção à torre e a torre salta por cima do rei.");
        System.out.println(" - Promoção: Quando um peão alcança a última fileira do tabuleiro, ele é promovido a qualquer outra peça.");
        System.out.println(" - En Passant: Um peão pode capturar um peão adversário que acabou de avançar duas casas, passando por uma casa ameaçada.");
    }

    private static void printGeneralRules_EN() {
        clearScreen();
        System.out.println("=======================================");
        System.out.println("         HOW TO PLAY CHESS");
        System.out.println("=======================================");
        System.out.println(ANSI_CYAN + "\nOBJECTIVE:" + UI.ANSI_RESET);
        System.out.println("The objective of the game is to 'checkmate' the opponent's King.");
        System.out.println(ANSI_CYAN + "\nTURNS:" + UI.ANSI_RESET);
        System.out.println("The game is played in alternating turns. The WHITE (♔) pieces always make the first move.");
        System.out.println(ANSI_CYAN + "\nEND OF GAME:" + UI.ANSI_RESET);
        System.out.println("The game ends in either Checkmate (a player wins) or a Draw.");
    }

    private static void printPieceRules_EN() {
        System.out.println("\n=======================================");
        System.out.println("        PIECE MOVEMENTS");
        System.out.println("=======================================");

        System.out.println(ANSI_CYAN + "\n--- KING (♔) ---" + UI.ANSI_RESET);
        System.out.println("Moves one square in any direction.");
        System.out.println(ANSI_CYAN + "\n--- QUEEN (♕) ---" + UI.ANSI_RESET);
        System.out.println("The most powerful piece. Moves any number of squares in any direction.");
        System.out.println(ANSI_CYAN + "\n--- ROOK (♖) ---" + UI.ANSI_RESET);
        System.out.println("Moves any number of squares horizontally or vertically.");
        System.out.println(ANSI_CYAN + "\n--- BISHOP (♗) ---" + UI.ANSI_RESET);
        System.out.println("Moves any number of squares diagonally.");
        System.out.println(ANSI_CYAN + "\n--- KNIGHT (♘) ---" + UI.ANSI_RESET);
        System.out.println("Moves in an 'L' shape and can jump over other pieces.");
        System.out.println(ANSI_CYAN + "\n--- PAWN (♙) ---" + UI.ANSI_RESET);
        System.out.println(" - Movement: Moves one square forward. Can move two on its first move.");
        System.out.println(" - Capture: Captures opponent's pieces diagonally.");
        System.out.println(ANSI_CYAN + "\n\n--- SPECIAL MOVES ---" + UI.ANSI_RESET);
        System.out.println(" - Castling: A special move between the king and a rook, where the king moves two squares toward the rook and the rook jumps over the king.");
        System.out.println(" - Promotion: When a pawn reaches the opposite end of the board, it is promoted to another piece.");
        System.out.println(" - En Passant: A pawn may capture an opponent's pawn that just moved two squares forward from its starting position.");
    }
}