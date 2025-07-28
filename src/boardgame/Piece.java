package boardgame;

public class Piece {
    //Attributes
        protected Position position;
        private Board board;

    //Constructors
        public Piece() {
        }
        public Piece(Board board) {
            this.board = board;
            position = null;
        }

    //Methods
    //Getters and Setters
        protected Board getBoard() {
            return board;
        }
}
