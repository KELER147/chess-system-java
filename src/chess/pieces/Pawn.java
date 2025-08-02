package chess.pieces;
import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString() {
        return "♟";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColum()];
        Position p = new Position(0, 0);

        if (getColor() == Color.RED) {
            p.setValues(position.getRow() - 1, position.getColum());
            if (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
                mat[p.getRow()][p.getColum()] = true;
                p.setValues(position.getRow() - 2, position.getColum());
                if (getBoard().positionExists(p) && !getBoard().thereIsPiece(p) && getMoveCount() == 0) {
                    mat[p.getRow()][p.getColum()] = true;
                }
            }

            p.setValues(position.getRow() - 1, position.getColum() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColum()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColum() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColum()] = true;
            }

        } else {
            p.setValues(position.getRow() + 1, position.getColum());
            if (getBoard().positionExists(p) && !getBoard().thereIsPiece(p)) {
                mat[p.getRow()][p.getColum()] = true;
                p.setValues(position.getRow() + 2, position.getColum());
                if (getBoard().positionExists(p) && !getBoard().thereIsPiece(p) && getMoveCount() == 0) {
                    mat[p.getRow()][p.getColum()] = true;
                }
            }

            p.setValues(position.getRow() + 1, position.getColum() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColum()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColum() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColum()] = true;
            }
        }
        return mat;
    }
}
