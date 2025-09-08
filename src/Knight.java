package hw3.chess;

/**
 * Represents a {@link Knight} chess {@link Piece}. The {@link Knight} can move
 * in an L pattern, two {@link Square} in one direction and one {@link Square}
 * left or right to it. This class extends the {@link Piece} class and
 * implements the methods of class {@link Piece}.
 * 
 * @author Nicolas Constantinou
 * @since 31/03/2024
 */
public class Knight extends Piece {

	/**
	 * Creates a {@link Knight} with a {@link Color}.
	 *
	 * @param color The {@link Color} of the {@link Knight} ({@link Color#WHITE} or
	 *              {@link Color#BLACK}).
	 */
	public Knight(Color color) {
		super(color);
	}

	/**
	 * Returns the algebraic name of the {@link Knight}, which is "N".
	 *
	 * @return The algebraic name of the {@link Knight}.
	 */
	@Override
	public String algebraicName() {
		return "N";
	}

	/**
	 * Calculates the possible moves for the {@link Knight} from the given
	 * {@link Square}. The {@link Knight} can move in an L pattern, two
	 * {@link Square} in one direction and one {@link Square} left or right to it.
	 *
	 * @param square The {@link Square} the {@link Knight} moves from.
	 * @return An array of {@link Square} that represent the possible moves for the
	 *         {@link Knight}.
	 */
	@Override
	public Square[] movesFrom(Square square) {
		try {
			int count = 0;
			for (int i = 1; i <= 2; i++) {
				if (i == 2) {
					if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) + 1)))
						count++;
					if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) - 1)))
						count++;
					if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + 1)))
						count++;
					if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) - 1)))
						count++;
				}
				if (i == 1) {
					if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) + 2)))
						count++;
					if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) - 2)))
						count++;
					if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + 2)))
						count++;
					if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) - 2)))
						count++;
				}
			}
			if (count == 0) {
				throw new InvalidSquareException(square.name());
			}
			Square[] s = new Square[count];
			int k = 0;
			for (int i = 1; i <= 2; i++) {
				if (i == 2) {
					if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) + 1))) {
						s[k] = new Square((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) + 1));
						k++;
					}
					if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) - 1))) {
						s[k] = new Square((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) - 1));
						k++;
					}
					if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + 1))) {
						s[k] = new Square((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + 1));
						k++;
					}
					if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) - 1))) {
						s[k] = new Square((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) - 1));
						k++;
					}
				}
				if (i == 1) {
					if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) + 2))) {
						s[k] = new Square((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) + 2));
						k++;
					}
					if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) - 2))) {
						s[k] = new Square((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1) - 2));
						k++;
					}
					if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + 2))) {
						s[k] = new Square((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + 2));
						k++;
					}
					if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) - 2))) {
						s[k] = new Square((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) - 2));
						k++;
					}
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
	 * Returns the FEN name of the {@link Knight}. For white {@link Knight}, the FEN
	 * name is "N". For black {@link Knight}, the FEN name is "n".
	 *
	 * @return The FEN name of the {@link Knight}.
	 */
	@Override
	public String fenName() {
		if (getColor() == Color.BLACK) {
			return "n";
		}
		return "N";
	}
}
