package boardgame;

public class Board {
    //Attributes
        private int row;
        private int colum;
        private Piece[][] pieces;

    //Constructors
        public Board() {
        }
        public Board(int row, int colum) {
            this.row = row;
            this.colum = colum;
            this.pieces = new Piece[row][colum];
        }

    //Methods
        //Getters and Setters
        public int getRow() {
            return row;
        }
        public void setRow(int row) {
            this.row = row;
        }

        public int getColum() {
            return colum;
        }
        public void setColum(int colum) {
            this.colum = colum;
        }
}
