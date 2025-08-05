package chess;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMatch {
    //Attributes
        private int turn;
        private Color currentPlayer;
        private Board board;
        private boolean check;
        private boolean checkMate;
        private ChessPiece enPassantVulnerable;
        private ChessPiece promoted;

        private List<Piece> piecesOnTheBoard = new ArrayList<>();
        private List<Piece> capturedPieces = new ArrayList<>();


    //Constructors
    public ChessMatch(){
        this.board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.RED;
        initialSetup();
    }

    //Methods
        private void nextTurn(){
            turn++;
            currentPlayer = (currentPlayer == Color.RED) ? Color.BLUE : Color.RED;
        }

        public ChessPiece[][] getPieces(){
            ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColum()];
            for (int i = 0; i < board.getRow(); i++) {
                for (int j = 0; j < board.getColum(); j++) {
                    mat[i][j] = (ChessPiece)  board.piece(i, j);
                }
            }
            return mat;
        }
        public ChessPiece performaChessMove(ChessPosition sourcePosition,  ChessPosition targetPosition){
            Position source = sourcePosition.toPosition();
            Position target = targetPosition.toPosition();
            validateSourcePosition(source);
            validateTargetPosition(source, target);
            Piece capturedPiece = makeMove(source, target);
            if (testCheck(currentPlayer)) {
                unduMove(source,target,capturedPiece);
                throw new ChessException("You can't put yourself in check");
            }
            ChessPiece movedPiece = (ChessPiece) board.piece(target);

            // #specialmove promotion
            promoted = null;
            if (movedPiece instanceof Pawn) {
                if ((movedPiece.getColor() == Color.RED && target.getRow() == 0) || (movedPiece.getColor() == Color.BLUE && target.getRow() == 7)) {
                    promoted =  (ChessPiece)board.piece(target);
                    promoted = replacePromotedPiece("Q");
                }
            }

            check = (testCheck(opponent(currentPlayer))) ? true : false;
            if (testCheck(opponent(currentPlayer))) {
                checkMate = true;
            } else {nextTurn();}

            // #specialmove en passant
            if (movedPiece instanceof Pawn && (target.getRow() == source.getRow() - 2 ||  target.getRow() == source.getRow() + 2)) {
                enPassantVulnerable = movedPiece;
            } else {enPassantVulnerable = null;}
            return (ChessPiece)  capturedPiece;
        }

        public ChessPiece replacePromotedPiece(String type) {
            if (promoted == null) {
                throw new IllegalStateException("There is no piece to be promoted");
            }
            if (!type.equalsIgnoreCase("B") && !type.equalsIgnoreCase("N") && !type.equalsIgnoreCase("R") && !type.equalsIgnoreCase("Q")) {
                throw new InvalidParameterException("Invalid type for promotion");
            }

            Position pos = promoted.getChessPosition().toPosition();
            Piece p = board.removePiece(pos);
            piecesOnTheBoard.remove(p);

            ChessPiece newPiece = newPiece(type, promoted.getColor());
            board.placePiece(newPiece, pos);
            piecesOnTheBoard.add(newPiece);
            return newPiece;
        }

        private ChessPiece newPiece(String type, Color color) {
            if (type.equalsIgnoreCase("B")) return new Bishop(board, color);
            if (type.equalsIgnoreCase("N")) return new Knight(board, color);
            if (type.equalsIgnoreCase("R")) return new Rook(board, color);
            return new Queen(board, color);
        }

        public boolean[][] possibleMoves(ChessPosition sourcePosition){
            Position position = sourcePosition.toPosition();
            validateSourcePosition(position);
            return board.piece(position).possibleMoves();
        }

        private Piece makeMove(Position source, Position target){
            ChessPiece p = (ChessPiece)board.removePiece(source);
            p.increaseMoveCount();
            Piece capturedPiece = board.removePiece(target);
            board.placePiece(p, target);
            if (capturedPiece != null) {
                piecesOnTheBoard.remove(capturedPiece);
                capturedPieces.add(capturedPiece);
            }
            // #specialmove castling kingside rook
            if (p instanceof King && target.getColum() == source.getColum() + 2) {
                Position sourceT = new Position(source.getRow(), source.getColum() + 3);
                Position targetT = new Position(source.getRow(), source.getColum() + 1);
                ChessPiece rook = (ChessPiece)board.removePiece(sourceT);
                board.placePiece(rook, targetT);
                rook.increaseMoveCount();
            }
            // #specialmove castling queenside rook
            if (p instanceof King && target.getColum() == source.getColum() - 2) {
                Position sourceT = new Position(source.getRow(), source.getColum() - 4);
                Position targetT = new Position(source.getRow(), source.getColum() - 1);
                ChessPiece rook = (ChessPiece)board.removePiece(sourceT);
                board.placePiece(rook, targetT);
                rook.increaseMoveCount();
            }

            // #specialmove en passant
            if (p instanceof Pawn) {
                if (source.getColum() != target.getColum() && capturedPiece == null) {
                    Position pawnPosition;
                    if (p.getColor() == Color.RED) {
                        pawnPosition = new Position(target.getRow() + 1, target.getColum());
                    } else  {
                        pawnPosition = new Position(target.getRow() - 1, target.getColum());
                    }
                    capturedPiece = board.removePiece(pawnPosition);
                    capturedPieces.add(capturedPiece);
                    piecesOnTheBoard.remove(capturedPiece);
                }
            }
            return capturedPiece;
        }

        private void unduMove(Position source, Position target, Piece capturedPiece) {
            ChessPiece p = (ChessPiece)board.removePiece(target);
            p.decreaseMoveCount();
            board.placePiece(p, source);
            if (capturedPiece != null) {
                board.placePiece(capturedPiece, target);
                capturedPieces.remove(capturedPiece);
                piecesOnTheBoard.add(capturedPiece);
            }
            // #specialmove castling kingside rook
            if (p instanceof King && target.getColum() == source.getColum() + 2) {
                Position sourceT = new Position(source.getRow(), source.getColum() + 3);
                Position targetT = new Position(source.getRow(), source.getColum() + 1);
                ChessPiece rook = (ChessPiece)board.removePiece(targetT);
                board.placePiece(rook, sourceT);
                rook.decreaseMoveCount();
            }
            // #specialmove castling queenside rook
            if (p instanceof King && target.getColum() == source.getColum() - 2) {
                Position sourceT = new Position(source.getRow(), source.getColum() - 4);
                Position targetT = new Position(source.getRow(), source.getColum() - 1);
                ChessPiece rook = (ChessPiece)board.removePiece(targetT);
                board.placePiece(rook, sourceT);
                rook.decreaseMoveCount();
            }

            // #specialmove en passant
            if (p instanceof Pawn) {
                if (source.getColum() != target.getColum() && capturedPiece == enPassantVulnerable) {
                    ChessPiece pawn = (ChessPiece)board.removePiece(target);
                    Position pawnPosition;
                    if (p.getColor() == Color.RED) {
                        pawnPosition = new Position(3, target.getColum());
                    } else  {
                        pawnPosition = new Position(4, target.getColum());
                    }
                    board.placePiece(pawn, pawnPosition);
                }
            }
        }

        private void validateSourcePosition(Position position){
            if(!board.thereIsPiece(position)){
                throw new ChessException("There is no piece on source position");
            }
            if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
                throw new ChessException("The chosen piece is not yours");
            }
            if (!board.piece(position).isThereAnyPossibleMove()) {
                throw new ChessException("There is no possible moves for the chosen piece");
            }
        }

        private void validateTargetPosition(Position source, Position target){
            if (!board.piece(source).possibleMove(target)) {
                throw new ChessException("there chosen piece can't move to target position");
            }
        }

        private Color opponent(Color color) {
            return color == Color.RED ? Color.BLUE : Color.RED;
        }

        private ChessPiece king(Color color) {
            List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color).toList();
            for (Piece p : list){
                if (p instanceof King) {
                    return (ChessPiece) p;
                }
            }
            throw new IllegalStateException("There is no " + color + " king on the board");
        }

        private boolean testCheck(Color color) {
            Position kingPosition = king(color).getChessPosition().toPosition();
            List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).toList();
            for (Piece p : opponentPieces){
                boolean[][] mat = p.possibleMoves();
                if (mat[kingPosition.getRow()][kingPosition.getColum()] == true) {
                    return true;
                }
            }
            return false;
        }

        private boolean testCheckMate(Color color) {
            if (!testCheck(color)) {
                return false;
            }
            List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).toList();
            for (Piece p : list){
                boolean[][] mat = p.possibleMoves();
                for (int i = 0; i < board.getRow(); i++) {
                    for (int j = 0; j < board.getColum(); j++) {
                        if (mat[i][j]) {
                            Position source = ((ChessPiece)p).getChessPosition().toPosition();
                            Position target = new Position(i, j);
                            Piece capturedPiece = makeMove(source, target);
                            boolean testCheck = testCheck(color);
                            unduMove(source, target, capturedPiece);
                            if (!testCheck) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

        private void placeNewPiece(char colum, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(colum,row).toPosition());
            piecesOnTheBoard.add(piece);
        }


        private void initialSetup() {
            placeNewPiece('a', 8, new Rook(board, Color.BLUE));
            placeNewPiece('c', 8, new Bishop(board, Color.BLUE));
            placeNewPiece('f', 8, new Bishop(board, Color.BLUE));
            placeNewPiece('h', 8, new Rook(board, Color.BLUE));
            placeNewPiece('e', 8, new King(board, Color.BLUE, this));
            placeNewPiece('d', 8, new Queen(board, Color.BLUE));
            placeNewPiece('b', 8, new Knight(board, Color.BLUE));
            placeNewPiece('g', 8, new Knight(board, Color.BLUE));
            placeNewPiece('a', 7, new Pawn(board, Color.BLUE,this));
            placeNewPiece('b', 7, new Pawn(board, Color.BLUE,this));
            placeNewPiece('c', 7, new Pawn(board, Color.BLUE,this));
            placeNewPiece('d', 7, new Pawn(board, Color.BLUE,this));
            placeNewPiece('e', 7, new Pawn(board, Color.BLUE,this));
            placeNewPiece('f', 7, new Pawn(board, Color.BLUE,this));
            placeNewPiece('g', 7, new Pawn(board, Color.BLUE,this));
            placeNewPiece('h', 7, new Pawn(board, Color.BLUE,this));

            placeNewPiece('a', 1, new Rook(board, Color.RED));
            placeNewPiece('c', 1, new Bishop(board, Color.RED));
            placeNewPiece('f', 1, new Bishop(board, Color.RED));
            placeNewPiece('h', 1, new Rook(board, Color.RED));
            placeNewPiece('e', 1, new King(board, Color.RED, this));
            placeNewPiece('d', 1, new Queen(board, Color.RED));
            placeNewPiece('b', 1, new Knight(board, Color.RED));
            placeNewPiece('g', 1, new Knight(board, Color.RED));
            placeNewPiece('a', 2, new Pawn(board, Color.RED,this));
            placeNewPiece('b', 2, new Pawn(board, Color.RED,this));
            placeNewPiece('c', 2, new Pawn(board, Color.RED,this));
            placeNewPiece('d', 2, new Pawn(board, Color.RED,this));
            placeNewPiece('e', 2, new Pawn(board, Color.RED,this));
            placeNewPiece('f', 2, new Pawn(board, Color.RED,this));
            placeNewPiece('g', 2, new Pawn(board, Color.RED,this));
            placeNewPiece('h', 2, new Pawn(board, Color.RED,this));
        }

        //Getters
        public Color getCurrentPlayer() {
            return currentPlayer;
        }

        public int getTurn() {
            return turn;
        }

        public boolean getCheck() {
            return check;
        }

        public boolean getCheckMate() {
            return checkMate;
        }

        public ChessPiece getEnPassantVulnerable() {
            return enPassantVulnerable;
        }

        public ChessPiece getPromoted() {
            return promoted;
        }
}
