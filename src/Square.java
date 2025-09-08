package hw3.chess;

/**
 * Represents a {@link Square} on a chessboard. Each {@link Square} is
 * identified by its row and column.
 * 
 * @author Nicolas Constantinou
 * @since 31/03/2024
 */
public class Square {

	private char col;
	private char row;

	/**
	 * Creates a {@link Square} object with the given row and column.
	 *
	 * @param row The row of the {@link Square} ('a' to 'h').
	 * @param col The column of the {@link Square} ('1' to '8').
	 * @throws InvalidSquareException If the specified {@link Square} is invalid.
	 */
	public Square(char row, char col) {
		if (checkValidity(row, col)) {
			this.col = col;
			this.row = row;
		} else {
			this.col = '0';
			this.row = '0';
			throw new InvalidSquareException(new String("" + row + col));
		}
	}

	/**
	 * Creates a {@link Square} object with the given name.
	 *
	 * @param name The name of the {@link Square} ("a1" to "h8").
	 * @throws InvalidSquareException If the specified {@link Square} name is
	 *                                invalid.
	 */
	public Square(String name) {
		if (checkValidity(name.charAt(0), name.charAt(1)) && name.length() == 2) {
			this.col = name.charAt(1);
			this.row = name.charAt(0);
		} else {
			throw new InvalidSquareException(name);
		}
	}

	/**
	 * Checks the validity of a {@link Square}. A valid {@link Square} ranges from
	 * "a1" to "h8".
	 *
	 * @param row The row of the {@link Square}.
	 * @param col The column of the {@link Square}.
	 * @return True if the {@link Square} is valid, else false.
	 */
	private boolean checkValidity(char row, char col) {
		if (row < 'a' || row > 'h')
			return false;
		if (col < '1' || col > '8')
			return false;
		return true;
	}

	/**
	 * Returns the name of the {@link Square}.
	 *
	 * @return The name of the {@link Square}.
	 */
	public String name() {
		return "" + row + col;
	}

	/**
	 * Checks if this {@link SecurityException} is equal to another object.
	 *
	 * @param object The object to be compared.
	 * @return True if the {@link Square} are equal, else false.
	 */
	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (object.getClass() != getClass())
			return false;
		Square obj = (Square) object;
		return (name().equals(obj.name()));
	}
	
}
