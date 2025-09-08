package hw3.chess;

/**
 * Represents a {@link King} chess {@link Piece}. The {@link King} can move one
 * square in any direction. This class extends the {@link Piece} class and
 * implements the methods of class {@link Piece}.
 * 
 * @author Nicolas Constantinou
 * @since 31/03/2024
 */
public class King extends Piece {

	/**
	 * Creates a {@link King} with a {@link Color}.
	 *
	 * @param color The {@link Color} of the {@link King} ({@link Color#WHITE} or
	 *              {@link Color#BLACK}).
	 */
	public King(Color color) {
		super(color);
	}

	/**
	 * Returns the algebraic name of the {@link King}, which is "K".
	 *
	 * @return The algebraic name of the {@link King}.
	 */
	@Override
	public String algebraicName() {
		return "K";
	}

	/**
	 * Calculates the possible moves for the {@link King} from the given
	 * {@link Square}. The {@link King} can move one square in any direction.
	 *
	 * @param square The {@link Square} the {@link King} moves from.
	 * @return An array of {@link Square} that represent the possible moves for the
	 *         {@link King}.
	 */
	@Override
	public Square[] movesFrom(Square square) {
		try {
			int count = 0;
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i != 0 || j != 0) {
						if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + j)))
							count++;
					}
				}
			}
			if (count == 0) {
				throw new InvalidSquareException(square.name());
			}
			Square[] s = new Square[count];
			int k = 0;
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i != 0 || j != 0) {
						if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1) + j))) {
							s[k] = new Square((char) (square.name().charAt(0) + i),
									(char) (square.name().charAt(1) + j));
							k++;
						}
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
	 * Returns the FEN name of the {@link King}. For white {@link King}, the FEN
	 * name is "K". For black {@link King}, the FEN name is "k".
	 *
	 * @return The FEN name of the {@link King}.
	 */
	@Override
	public String fenName() {
		if (getColor() == Color.BLACK) {
			return "k";
		}
		return "K";
	}
}
