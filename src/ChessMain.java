package hw3.chess;

/**
 * This class gives some examples of the chess {@link Piece} and their
 * movements. It creates instances of every chess {@link Piece} and prints out
 * their available moves from specific {@link Square} on a chessboard.
 * 
 * The {@link ChessMain} class contains a main method where the chess
 * {@link Piece} and their starting {@link Square} are created.
 * 
 * @author Nicolas Constantinou
 * @since 31/03/2024
 */
public class ChessMain {

	/**
	 * The start of the program.
	 * 
	 * Creates every chess {@link Piece} and displays their available moves.
	 * 
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {

		Square[] board = new Square[64];
		setBoard(board);

		King K = new King(Color.BLACK);
		Square sK = new Square("e4");
		play(K, sK, board);

		Queen Q = new Queen(Color.WHITE);
		Square sQ = new Square("d2");
		play(Q, sQ, board);

		Rook R = new Rook(Color.BLACK);
		Square sR = new Square("b3");
		play(R, sR, board);

		Knight N = new Knight(Color.WHITE);
		Square sN = new Square("d4");
		play(N, sN, board);

		Bishop B = new Bishop(Color.BLACK);
		Square sB = new Square("c2");
		play(B, sB, board);

		Pawn P = new Pawn(Color.WHITE);
		Square sP = new Square("b2");
		play(P, sP, board);

		Pawn P2 = new Pawn(Color.BLACK);
		Square sP2 = new Square("b2");
		play(P2, sP2, board);
	}

	/**
	 * Displays the available moves for a given chess {@link Piece} from a specific
	 * {@link Square}.
	 * 
	 * @param piece  The chess {@link Piece} to be played.
	 * @param square The {@link Square} from which the chess {@link Piece} will
	 *               move.
	 * @param board  The array representing the chessboard.
	 */
	private static void play(Piece piece, Square square, Square[] board) {
		System.out.println("\nChess Board: " + getFullName(piece) + "\n");
		showChessBoard(board, square, piece);
		System.out.println("A " + piece.getColor() + " " + getFullName(piece) + " moves from " + square.name()
				+ ". Available Moves:");
		Square[] moves = piece.movesFrom(square);
		for (int i = 0; i < moves.length; i++) {
			System.out.println(i + 1 + ". " + moves[i].name());
		}
	}

	/**
	 * Sets up the empty chessboard.
	 * 
	 * @param board The array representing the chessboard.
	 */
	private static void setBoard(Square[] board) {
		int k = 0;
		for (int i = 8; i >= 1; i--) {
			for (char c = 'a'; c <= 'h'; c++) {
				board[k] = new Square(new String("" + c + i));
				k++;
			}
		}
	}

	/**
	 * Prints out the current state of the chessboard that contains a chess
	 * {@link Piece}.
	 * 
	 * @param board  The array representing the chessboard.
	 * @param square The {@link Square} representing the position of the chess
	 *               {@link Piece}.
	 * @param piece  The chess {@link Piece} to be displayed on the board.
	 */
	private static void showChessBoard(Square[] board, Square square, Piece piece) {
		int b = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[b].name().equals(square.name())) {
					System.out.print("  " + piece.fenName() + " ");
				} else {
					System.out.print("    ");
				}
				System.out.print(board[b].name() + "    ");
				b++;
			}
			System.out.println();
			System.out.println();

		}
	}

	/**
	 * Returns the full name of a chess {@link ChessMain} based on its algebraic
	 * name.
	 * 
	 * @param piece The chess {@link Piece} whose full name is returned.
	 * @return The full name of the chess {@link Piece}.
	 */
	private static String getFullName(Piece piece) {
		switch (piece.algebraicName()) {
		case "K":
			return "King";
		case "Q":
			return "Queen";
		case "R":
			return "Rook";
		case "B":
			return "Bishop";
		case "N":
			return "Knight";
		case "":
			return "Pawn";
		}
		return null;
	}

}