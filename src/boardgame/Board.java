package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	//programa��o defensiva, lan�a exce��o se a cria��o do tabuleiro for imposs�vel para um jogo Ex.: rows = 1 && columns = 1
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	//programa��o defensiva, lan�a exce��o se a posi��o estiver fora do tabuleiro
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}

		return pieces[row][column];
	}

	//programa��o defensiva, lan�a exce��o se a posi��o estiver fora do tabuleiro
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("position not on the board");
		}

		return pieces[position.getRow()][position.getColumn()];
	}

	//programa��o defensiva, lan�a exce��o se j� existir uma pe�a no local que o usu�rio escolheu
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on this position " + position);
		}

		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	//programa��o defensiva, lan�a exce��o se a verifica��o de pe�a estiver fora do tabuleiro
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("position not on the board");
		}

		return piece(position) != null;

	}

}
