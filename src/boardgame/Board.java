package boardgame;

public class Board {
    //Attributes
        private int rows;
        private int colums;
        private Piece[][] pieces;

    //Constructors
        public Board(int row, int colum) {
            if (row < 1 || colum < 1) {
                throw new BoardException("Error creating board: There must be at least 1 row and 1 column!");
            }
            this.rows = row;
            this.colums = colum;
            this.pieces = new Piece[row][colum];
        }

    //Methods
        public void placePiece(Piece piece, Position position) {

            if (thereIsPiece(position)) {
                throw new BoardException("There is already a piece on position!" + position);
            }
            pieces[position.getRow()][position.getColum()] = piece;
            piece.position = position;
        }

        public Piece piece(int row, int colum) {
            if  (!positionExists(row, colum)) {
                throw new BoardException("Position not on the board!");
            }
            return this.pieces[row][colum];
        }

        public Piece piece(Position position) {
            if  (!positionExists(position)) {
                throw new BoardException("Position not on the board!");
            }
            return pieces[position.getRow()][position.getColum()];
        }

        public Boolean positionExists(Position position) {
            return positionExists(position.getRow(), position.getColum());
        }

        private Boolean positionExists(int row, int colum) {
            return row >= 0 && row < rows && colum >= 0 && colum < colums;
        }

        public Boolean thereIsPiece(Position position) {
            if  (!positionExists(position)) {
                throw new BoardException("Position not on the board!");
            }
            return piece(position) != null;
        }

        //Getters and Setters
        public int getRow() {
            return rows;
        }
        public void setRow(int row) {
            this.rows = row;
        }

        public int getColum() {
            return colums;
        }
        public void setColum(int colum) {
            this.colums = colum;
        }
}
