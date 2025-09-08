package hw3.chess;

/**
 * Represents a chess {@link Piece}. This is an abstract class that extends for
 * every {@link Piece} of chess.
 * 
 * @author Nicolas Constantinou
 * @since 31/03/2024
 */
public abstract class Piece {

	private Color color;

	/**
	 * Creates a {@link Piece} object with the given {@link Color}.
	 *
	 * @param color The {@link Color} of the {@link Piece}.
	 */
	public Piece(Color color) {
		this.color = color;
	}

	/**
	 * Returns the {@link Color} of the {@link Piece}.
	 *
	 * @return The {@link Color} of the {@link Piece}.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Returns the algebraic name of the {@link Piece}. For example, "K" is for a
	 * King.
	 *
	 * @return The algebraic name of the {@link Piece}.
	 */
	public abstract String algebraicName();

	/**
	 * Returns an array of {@link Square} representing the possible moves of a
	 * {@link Piece} from the given {@link Square}.
	 *
	 * @param square The {@link Square} that the {@link Piece} starts to move from.
	 * @return An array of {@link Square} objects with the possible moves.
	 */
	public abstract Square[] movesFrom(Square square);

	/**
	 * Checks the validity of a {@link Square}.
	 *
	 * @param row The row of the {@link Square}.
	 * @param col The column of the {@link Square}.
	 * @return True if the {@link Piece} is valid, else false.
	 */
	protected boolean checkValidity(char row, char col) {
		if (row < 'a' || row > 'h')
			return false;
		if (col < '1' || col > '8')
			return false;
		return true;
	}

	/**
	 * Returns the FEN name of the {@link Piece}. A FEN name (Forsyth–Edwards
	 * Notation) describes the names of chess {@link Piece} in a chess game. If a
	 * {@link Piece} has BLACK {@link Color}, the FEN name is the
	 * {@link Piece#algebraicName()} but in lower-case, else for WHITE
	 * {@link Piece}, the FEN name is the normal {@link Piece#algebraicName()}.
	 *
	 * @return The FEN name of the {@link Piece}.
	 */
	public abstract String fenName();

}
