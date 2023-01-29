package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	public int position;

	public Board(int rows, int colums) {
		if (rows < 1 || colums < 1) {
			throw new BoardException("Erro na criação do tabuleiro, é necessário que tenha pelo menos uma linha e uma coluna");
		}
		this.rows = rows;
		this.columns = colums;
		pieces = new Piece[rows][colums];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row,column)) {
			throw new BoardException("Posição fora do tabuleiro ");
		}
		return pieces[row][column];
	}

	// método retorna a posição da peça pelo método get da classe Position sobre
	// linhas e colunas

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição fora do tabuleiro ");
		}
		return pieces[position.getRow()][position.getColumn()];

	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma peça na posição" + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;

	}

	// validação para verificar se posição no tabuleiro existe
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posição fora do tabuleiro ");
		}
		return piece(position) != null;
	}
}
