package boardgame;

public abstract class Piece {
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
        public abstract boolean[][] possibleMoves();

        public boolean possibleMove(Position position) {
            return possibleMoves()[position.getRow()][position.getColum()];
        }

        public boolean isThereAnyPossibleMove() {
            boolean[][] mat =  possibleMoves();
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if (mat[i][j]) {
                        return true;
                    }
                }
            }
            return false;
        }

    //Getters and Setters
        protected Board getBoard() {
            return board;
        }
}
