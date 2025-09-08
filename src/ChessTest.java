package hw3.chess;

import org.junit.Test;

public class ChessTest {

	@Test
	public void test() {
		Piece knight = new Knight(Color.BLACK);
		assert knight.algebraicName().equals("N");
		assert knight.fenName().equals("n");
		Square[] attackedSquares = knight.movesFrom(new Square("f6"));
		for (int i = 0; i < attackedSquares.length; i++)
			System.out.println(attackedSquares[i].name());
		// test that attackedSquares contains e8, g8, etc.
		Square a1 = new Square("a1");
		Square otherA1 = new Square('a', '1');
		Square h8 = new Square("h8");
		assert a1.equals(otherA1);
		assert !a1.equals(h8);
	}

}
