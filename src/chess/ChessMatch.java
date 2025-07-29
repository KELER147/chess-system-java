package chess;
import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    //Attributes
        private Board board;

    //Constructors
    public ChessMatch(){
        this.board = new Board(8, 8);
        initialSetup();
    }

    //Methods
        public ChessPiece[][] getPieces(){
            ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColum()];
            for (int i = 0; i < board.getRow(); i++) {
                for (int j = 0; j < board.getColum(); j++) {
                    mat[i][j] = (ChessPiece)  board.piece(i, j);
                }
            }
            return mat;
        }

        private void placeNewPiece(char colum, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(colum,row).toPosition());
        }

        private void initialSetup() {
            placeNewPiece('b', 6, new Rook(board, Color.WHITE));
            placeNewPiece('a', 3, new King(board, Color.BLACK));
        }
}
