package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;

	//programa��o defensiva, lan�a excess�o se as coordenadas para posi��o 
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. valid values are from a1 to h8");
		}

		this.column = column;
		this.row = row;

	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	// retorna posi��o baseada nas coordenadas inseridas Ex.: a1 = (8, 0)
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}

	// retorna posi��o baseada na posi��o pela matriz Ex.: (1, 1) = b7
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' + position.getColumn()), 8 - position.getRow());
	}

	@Override
	public String toString() {
		return "" + column + row;
	}

}
