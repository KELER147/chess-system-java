package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessMatch {
    //Attributes
        private Board board;

    //Constructors
    public  ChessMatch(){
        this.board = new Board(8, 8);
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

        //Getters and Setters
}
