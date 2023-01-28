package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	public int position;
	
	
	public Board(int rows, int colums) {
		this.rows = rows;
		this.columns = colums;
		pieces = new Piece [rows][colums];
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
	
	public Piece piece (int row, int column) {
		
		return pieces [row][column];
	}
	
    //método retorna a posição da peça pelo método get da clase Position sobre linhas e colunas
	
	public Piece piece (Position position) {
	return pieces [position.getRow()][position.getColumn()];
}
	
	

}
