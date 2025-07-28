package boardgame;

public class Position {
    //Attributes
        private int row;
        private int colum;

    //Associates
        //

    //Constructors
        public Position() {
        }
        public Position(int row, int colum) {
            this.row = row;
            this.colum = colum;
        }

    //Methods
    //HashCod And Equals
        //Getters and Setters
        public int getColum() {
            return colum;
        }
        public void setColum(int colum) {
            this.colum = colum;
        }

        public int getRow() {
            return row;
        }
        public void setRow(int row) {
            this.row = row;
        }

        //ToString
        @Override
        public String toString() {
            return "Position: ROW["+row+"] COLUM["+colum+"]";
        }
}
