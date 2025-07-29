package chess;
import boardgame.Board;
import chess.pieces.*;

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
            placeNewPiece('a', 8, new Rook(board, Color.RED));
            placeNewPiece('b', 8, new Knight(board, Color.RED));
            placeNewPiece('c', 8, new Bishop(board, Color.RED));
            placeNewPiece('d', 8, new King(board, Color.RED));
            placeNewPiece('e', 8, new Queen(board, Color.RED));
            placeNewPiece('f', 8, new Bishop(board, Color.RED));
            placeNewPiece('g', 8, new Knight(board, Color.RED));
            placeNewPiece('h', 8, new Rook(board, Color.RED));

            placeNewPiece('a', 7, new Pawn(board, Color.RED));
            placeNewPiece('b', 7, new Pawn(board, Color.RED));
            placeNewPiece('c', 7, new Pawn(board, Color.RED));
            placeNewPiece('d', 7, new Pawn(board, Color.RED));
            placeNewPiece('e', 7, new Pawn(board, Color.RED));
            placeNewPiece('f', 7, new Pawn(board, Color.RED));
            placeNewPiece('g', 7, new Pawn(board, Color.RED));
            placeNewPiece('h', 7, new Pawn(board, Color.RED));




            placeNewPiece('a', 1, new Rook(board, Color.BLUE));
            placeNewPiece('b', 1, new Knight(board, Color.BLUE));
            placeNewPiece('c', 1, new Bishop(board, Color.BLUE));
            placeNewPiece('d', 1, new King(board, Color.BLUE));
            placeNewPiece('e', 1, new Queen(board, Color.BLUE));
            placeNewPiece('f', 1, new Bishop(board, Color.BLUE));
            placeNewPiece('g', 1, new Knight(board, Color.BLUE));
            placeNewPiece('h', 1, new Rook(board, Color.BLUE));

            placeNewPiece('a', 2, new Pawn(board, Color.BLUE));
            placeNewPiece('b', 2, new Pawn(board, Color.BLUE));
            placeNewPiece('c', 2, new Pawn(board, Color.BLUE));
            placeNewPiece('d', 2, new Pawn(board, Color.BLUE));
            placeNewPiece('e', 2, new Pawn(board, Color.BLUE));
            placeNewPiece('f', 2, new Pawn(board, Color.BLUE));
            placeNewPiece('g', 2, new Pawn(board, Color.BLUE));
            placeNewPiece('h', 2, new Pawn(board, Color.BLUE));




        }
}
