package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	/**
	 * It is necessary that the coordinate values ​​are between a1 and h8 to make the instance.
	 * @param column From a to h.
	 * @param row From 1 to 8.
	 */
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8."); 
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
	
	/**
	 * Convert matrix position to chess position
	 */
	protected Position toPosition() {
		return new Position (8 - row, column - 'a');
	}
	
	/**
	 * Convert chess position to matrix position
	 */
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
