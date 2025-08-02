package chess.pieces;
import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString() {
        return "♞";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColum()];
        Position p = new Position(0, 0);

        //Above
        p.setValues(position.getRow() - 2, position.getColum() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }
        p.setValues(position.getRow() - 2, position.getColum() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //Right
        p.setValues(position.getRow() - 1, position.getColum() + 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }
        p.setValues(position.getRow() + 1, position.getColum() + 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //Left
        p.setValues(position.getRow() - 1, position.getColum() - 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }
        p.setValues(position.getRow() + 1, position.getColum() - 2);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //Below
        p.setValues(position.getRow() + 2, position.getColum() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }
        p.setValues(position.getRow() + 2, position.getColum() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }
        return mat;
    }
}
