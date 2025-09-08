package hw3.chess;

/**
 * The {@link InvalidSquareException} is thrown when a {@link Square} is about
 * to be created but is an invalid {@link Square} for the chess board. The
 * {@link InvalidSquareException} is an unchecked exception that extends class
 * {@link RuntimeException}. The reason for that is because it represents an
 * error condition that should not be caught and handled explicitly as the
 * object created will not be usable for the rest of the program and will be
 * null, resulting to false outputs.
 * 
 * @author Nicolas Constantinou
 * @since 31/03/2024
 */
public class InvalidSquareException extends RuntimeException {

	/**
	 * Creates a new {@link InvalidSquareException} with the specified detail
	 * message.
	 *
	 * @param message The detail message.
	 */
	public InvalidSquareException(String message) {
		super(message);
	}

	/**
	 * Prints the {@link InvalidSquareException} message.
	 *
	 * @param exceptionMessage The {@link InvalidSquareException} message that gets
	 *                         printed.
	 */
	public void getMessage(String exceptionMessage) {
		System.out.println(exceptionMessage);
	}

}
