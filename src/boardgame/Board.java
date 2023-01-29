package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	public int position;

	public Board(int rows, int colums) {
		if (rows < 1 || colums < 1) {
			throw new BoardException("Erro na cria��o do tabuleiro, � necess�rio que tenha pelo menos uma linha e uma coluna");
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
			throw new BoardException("Posi��o fora do tabuleiro ");
		}
		return pieces[row][column];
	}

	// m�todo retorna a posi��o da pe�a pelo m�todo get da classe Position sobre
	// linhas e colunas

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posi��o fora do tabuleiro ");
		}
		return pieces[position.getRow()][position.getColumn()];

	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma pe�a na posi��o" + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;

	}

	// valida��o para verificar se posi��o no tabuleiro existe
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Posi��o fora do tabuleiro ");
		}
		return piece(position) != null;
	}
}
