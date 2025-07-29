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
            placeNewPiece('c', 1, new Rook(board, Color.RED));
            placeNewPiece('c', 2, new Rook(board, Color.RED));
            placeNewPiece('d', 2, new Rook(board, Color.RED));
            placeNewPiece('e', 2, new Rook(board, Color.RED));
            placeNewPiece('e', 1, new Rook(board, Color.RED));
            placeNewPiece('d', 1, new King(board, Color.RED));

            placeNewPiece('c', 7, new Rook(board, Color.BLUE));
            placeNewPiece('c', 8, new Rook(board, Color.BLUE));
            placeNewPiece('d', 7, new Rook(board, Color.BLUE));
            placeNewPiece('e', 7, new Rook(board, Color.BLUE));
            placeNewPiece('e', 8, new Rook(board, Color.BLUE));
            placeNewPiece('d', 8, new King(board, Color.BLUE));
        }
}
