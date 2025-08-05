package chess.pieces;
import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color,  ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "♚";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColum()];
        Position p = new Position(0, 0);
        //N
        p.setValues(position.getRow() - 1, position.getColum());
            if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //S
        p.setValues(position.getRow() + 1, position.getColum());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //O
        p.setValues(position.getRow(), position.getColum() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }
        //L
        p.setValues(position.getRow(), position.getColum() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        //NO
        p.setValues(position.getRow() - 1, position.getColum() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }
        //NE
        p.setValues(position.getRow() - 1, position.getColum() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }
        //SO
        p.setValues(position.getRow() + 1, position.getColum() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }
        //SE
        p.setValues(position.getRow() + 1, position.getColum() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColum()] = true;
        }

        // #SpecialMove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // #specialmove castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColum() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColum()  + 1);
                Position p2 = new Position(position.getRow(), position.getColum()  + 2);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColum() + 2] = true;
                }
            }
            // #specialmove castling queenside rook
            Position posT2 = new Position(position.getRow(), position.getColum() - 4);
            if (testRookCastling(posT2)) {
                Position p1 = new Position(position.getRow(), position.getColum()  - 1);
                Position p2 = new Position(position.getRow(), position.getColum()  - 2);
                Position p3 = new Position(position.getRow(), position.getColum()  - 3);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getColum() - 2] = true;
                }
            }
        }
        return mat;
    }
}


