package hw3.chess;

/**
 * Represents a {@link Rook} chess {@link Piece}. The {@link Rook} can move
 * horizontally or vertically any number of {@link Square}. This class extends
 * the {@link Piece} class and implements the methods of class {@link Piece}.
 * 
 * @author Nicolas Constantinou
 * @since 31/03/2024
 */
public class Rook extends Piece {

	/**
	 * Creates a {@link Rook} with a {@link Color}.
	 *
	 * @param color The {@link Color} of the {@link Rook} ({@link Color#WHITE} or
	 *              {@link Color#BLACK}).
	 */
	public Rook(Color color) {
		super(color);
	}

	/**
	 * Returns the algebraic name of the {@link Rook}, which is "R".
	 *
	 * @return The algebraic name of the {@link Rook}.
	 */
	@Override
	public String algebraicName() {
		return "R";
	}

	/**
	 * Calculates the possible moves for the {@link Rook} from the given
	 * {@link Square}. The {@link Rook} can move horizontally or vertically any
	 * number of {@link Square}.
	 *
	 * @param square The {@link Square} the {@link Rook} moves from.
	 * @return An array of {@link Square} that represent the possible moves for the
	 *         {@link Rook}.
	 */
	@Override
	public Square[] movesFrom(Square square) {
		try {
			int count = 0;
			for (int i = 1; i <= 8; i++) {
				if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1))))
					count++;
				if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1))))
					count++;
				if (checkValidity((char) (square.name().charAt(0)), (char) (square.name().charAt(1) + i)))
					count++;
				if (checkValidity((char) (square.name().charAt(0)), (char) (square.name().charAt(1) - i)))
					count++;
			}
			if (count == 0) {
				throw new InvalidSquareException(square.name());
			}
			Square[] s = new Square[count];
			int k = 0;
			for (int i = 1; i <= 8; i++) {
				if (checkValidity((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1)))) {
					s[k] = new Square((char) (square.name().charAt(0) + i), (char) (square.name().charAt(1)));
					k++;
				}
				if (checkValidity((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1)))) {
					s[k] = new Square((char) (square.name().charAt(0) - i), (char) (square.name().charAt(1)));
					k++;
				}
				if (checkValidity((char) (square.name().charAt(0)), (char) (square.name().charAt(1) + i))) {
					s[k] = new Square((char) (square.name().charAt(0)), (char) (square.name().charAt(1) + i));
					k++;
				}
				if (checkValidity((char) (square.name().charAt(0)), (char) (square.name().charAt(1) - i))) {
					s[k] = new Square((char) (square.name().charAt(0)), (char) (square.name().charAt(1) - i));
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
	 * Returns the FEN name of the {@link Rook}. For white {@link Rook}, the FEN
	 * name is "R". For black {@link Rook}, the FEN name is "r".
	 *
	 * @return The FEN name of the {@link Rook}.
	 */
	@Override
	public String fenName() {
		if (getColor() == Color.BLACK) {
			return "r";
		}
		return "R";
	}

}
