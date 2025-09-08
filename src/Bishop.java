package hw3.chess;

/**
 * Represents a {@link Bishop} chess {@link Piece}. The {@link Bishop} can move
 * diagonally any number of {@link Square}. This class extends the {@link Piece}
 * class and implements the methods of class {@link Piece}.
 * 
 * @author Nicolas Constantinou
 * @since 31/03/2024
 */
public class Bishop extends Piece {

	/**
	 * Creates a {@link Bishop} with a {@link Color}.
	 *
	 * @param color The {@link Color} of the {@link Bishop} ({@link Color#WHITE} or
	 *              {@link Color#BLACK}).
	 */
	public Bishop(Color color) {
		super(color);
	}

	/**
	 * Returns the algebraic name of the {@link Bishop}, which is "B".
	 *
	 * @return The algebraic name of the {@link Bishop}.
	 */
	@Override
	public String algebraicName() {
		return "B";
	}

	/**
	 * Calculates the possible moves for the {@link Bishop} from the given
	 * {@link Square}. The {@link Bishop} can move diagonally any number of
	 * {@link Square}.
	 *
	 * @param square The {@link Square} the {@link Bishop} moves from.
	 * @return An array of {@link Square} that represent the possible moves for the
	 *         {@link Bishop}.
	 */
	@Override
	public Square[] movesFrom(Square square) {
		try {
			int count = 0;
			for (int i = 1; i <= 8; i++) {
				if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + i)))
					count++;
				if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) - i)))
					count++;
			}
			if (count == 0) {
				throw new InvalidSquareException(square.name());
			}
			Square[] s = new Square[count];
			int k = 0;
			for (int i = 1; i <= 8; i++) {
				if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + i))) {
					s[k] = new Square((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + i));
					k++;
				}
				if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) - i))) {
					s[k] = new Square((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) - i));
					k++;
				}
			}
			return s;
		} catch (InvalidSquareException e) {
			System.err.println(e.getMessage());
		}
		Square[] s = { square };
		return s;
	}

	/**
	 * Returns the FEN name of the {@link Bishop}. For white {@link Bishop}, the FEN
	 * name is "B". For black {@link Bishop}, the FEN name is "b".
	 *
	 * @return The FEN name of the {@link Bishop}.
	 */
	@Override
	public String fenName() {
		if (getColor() == Color.BLACK) {
			return "b";
		}
		return "B";
	}

}
