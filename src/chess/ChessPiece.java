package chess;
import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece {
    //Attributes
        private Color color;

    //Constructors
        public ChessPiece(Board board, Color color) {
            super(board);
        }

    //Methods
        //Getters and Setters
        public Color getColor() {
            return color;
        }
}
