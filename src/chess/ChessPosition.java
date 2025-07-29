package chess;

import boardgame.Position;

public class ChessPosition {
    //Attributes
        private char colum;
        private int row;

    //Constructors
        public ChessPosition(char colum, int row) {
            if (colum < 'a' || colum > 'h' || row < 1 || row > 8) {
                throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
            }
            this.colum = colum;
            this.row = row;
        }

    //Methods
        protected Position toPosition() {
            return new Position(8 - row, colum - 'a');
        }

        protected static ChessPosition fromPosition(Position position) {
            return new ChessPosition((char)('a' + position.getColum()), 8 - position.getRow());
        }

        //Getters and Setters
        public char getColum() {
            return colum;
        }

        public int getRow() {
            return row;
        }
        //ToString
        @Override
        public String toString() {
            return "" + colum + row;
        }
}
