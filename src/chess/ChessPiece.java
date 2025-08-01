package chess;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    //Attributes
    private Color color;

    //Constructors
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    //Methods
        protected boolean isThereOpponentPiece(Position position) {
            ChessPiece p = (ChessPiece) getBoard().piece(position);
            return p != null && p.getColor() != color;
        }

        //Getters
        public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
        }
        public Color getColor() {
            return color;
        }

}
