package chess.pieces;
import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString() {
        return "♝";
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColum()];
        Position p= new Position(0, 0);

        //NE
        p.setValues(position.getRow() - 1, position.getColum() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum() + 1);
        }
        if (getBoard().positionExists(p) && getBoard().thereIsPiece(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //NO
        p.setValues(position.getRow() - 1, position.getColum() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() - 1, p.getColum() - 1);
        }
        if (getBoard().positionExists(p) && getBoard().thereIsPiece(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //SE
        p.setValues(position.getRow() + 1, position.getColum() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum() + 1);
        }
        if (getBoard().positionExists(p) && getBoard().thereIsPiece(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //SO
        p.setValues(position.getRow() + 1, position.getColum() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
            p.setValues(p.getRow() + 1, p.getColum() - 1);
        }
        if (getBoard().positionExists(p) && getBoard().thereIsPiece(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        return mat;
    }
}
