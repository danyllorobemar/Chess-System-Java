package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns <1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	/**
	 * Return a matrix piece with rows and columns if the position exists on the board.
	 * @param row Matrix row.
	 * @param column Matrix column.
	 * @return pieces Board Matrix.
	 */
	public Piece piece(int row, int column) {
		if (!positionExists(row,column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	/**
	 * Return a matrix piece with rows and columns if the position exists on the board.
	 * @param position Object that should contain the board positions.
	 * @return pieces Board Matrix.
	 */
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	/**
	 * Assign the informed piece to the given position in the matrix if there is a piece in that position.
	 * @param piece Piece to be assigned.
	 * @param position Position to be verified and receive a piece.
	 */
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	/**
	 * Check if there is a piece in the informed position.
	 * Remove the piece from the board at the specified position and return the removed piece.
	 * @param position Position of the piece to be removed.
	 * @return null if there isn't piece or Removed piece.
	 */
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()]=null;
		return aux;
	}
	
	/**
	 * Checks if the position on the board exists.
	 * @param row Row to be verified.
	 * @param column Column to be verified.
	 * @return true if it exist or false if it not exist.
	 */
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	/**
	 * Checks if the position on the board exists.
	 * @param position Position to be verified.
	 * @return true if it exist or false if it not exist.
	 */
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getColumn());
	}
	
	/**
	 * Checks if exist a piece in the position on the board.
	 * @param position Position to be verified.
	 * @return true if it exist or false if it not exist. 
	 */
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	} 
	
}
