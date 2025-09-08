package hw3.chess;

/**
 * Represents a {@link Pawn} chess {@link Piece}. The {@link Pawn} can move
 * forward one or two {@link Square} on its first move and one {@link Square}
 * otherwise. This class extends the {@link Piece} class and implements the
 * methods of class {@link Piece}.
 * 
 * @author Nicolas Constantinou
 * @since 31/03/2024
 */
public class Pawn extends Piece {

	/**
	 * Creates a {@link Pawn} with a {@link Color}.
	 *
	 * @param color The {@link Color} of the {@link Pawn} ({@link Color#WHITE} or
	 *              {@link Color#BLACK}).
	 */
	public Pawn(Color color) {
		super(color);
	}

	/**
	 * Returns the algebraic name of the {@link Pawn}, which is an empty string.
	 * 
	 * @return The algebraic name of the {@link Pawn}.
	 */
	@Override
	public String algebraicName() {
		return "";
	}

	/**
	 * Calculates the possible moves for the {@link Pawn} from the given
	 * {@link Square}. The {@link Pawn} can move forward one or two {@link Square}
	 * on its first move and one {@link Square} otherwise.
	 *
	 * @param square The {@link Square} the {@link Pawn} moves from.
	 * @return An array of {@link Square} that represent the possible moves for the
	 *         {@link Pawn}.
	 */
	@Override
	public Square[] movesFrom(Square square) {
		try {
			if (getColor() == Color.WHITE) {
				if (square.name().charAt(1) == '2') {
					Square[] s = { new Square((char) (square.name().charAt(0)), (char) (square.name().charAt(1) + 1)),
							new Square((char) (square.name().charAt(0)), (char) (square.name().charAt(1) + 2)) };
					return s;
				} else if (checkValidity((char) (square.name().charAt(0)), (char) (square.name().charAt(1) + 1))) {
					Square[] s = { new Square((char) (square.name().charAt(0)), (char) (square.name().charAt(1) + 1)) };
					return s;
				} else {
					throw new InvalidSquareException(square.name());
				}
			} else if (getColor() == Color.BLACK) {
				if (square.name().charAt(1) == '7') {
					Square[] s = { new Square((char) (square.name().charAt(0)), (char) (square.name().charAt(1) - 1)),
							new Square((char) (square.name().charAt(0)), (char) (square.name().charAt(1) - 2)) };
					return s;
				} else if (checkValidity((char) (square.name().charAt(0)), (char) (square.name().charAt(1) - 1))) {
					Square[] s = { new Square((char) (square.name().charAt(0)), (char) (square.name().charAt(1) - 1)) };
					return s;
				} else {
					throw new InvalidSquareException(square.name());
				}
			} else {
				throw new InvalidSquareException(square.name());
			}
		} catch (InvalidSquareException e) {
			System.err.println(e.getMessage());
		}
		Square[] s = { square };
		return s;
	}

	/**
	 * Returns the FEN name of the {@link Pawn}. For white {@link Pawn}, the FEN
	 * name is "P". For black {@link Pawn}, the FEN name is "p".
	 *
	 * @return The FEN name of the {@link Pawn}.
	 */
	@Override
	public String fenName() {
		if (getColor() == Color.BLACK) {
			return "p";
		}
		return "P";
	}

}
