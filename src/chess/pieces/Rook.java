package chess.pieces;
import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "♜" ;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColum()];
        Position p = new Position(0, 0);

        //Above
        p.setValues(position.getRow() - 1, position.getColum());
        while (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum());
        }
        if (getBoard().positionExists(p) && getBoard().thereIsPiece(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //Left
        p.setValues(position.getRow(), position.getColum() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow(), p.getColum() - 1);
        }
        if (getBoard().positionExists(p) && getBoard().thereIsPiece(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //Right
        p.setValues(position.getRow(), position.getColum() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow(), p.getColum() + 1);
        }
        if (getBoard().positionExists(p) && getBoard().thereIsPiece(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //Below
        p.setValues(position.getRow() + 1, position.getColum());
        while (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum());
        }
        if (getBoard().positionExists(p) && getBoard().thereIsPiece(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        return mat;
    }
}
