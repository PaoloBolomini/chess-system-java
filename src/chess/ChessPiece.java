package chess;

import boardgame.Board;
import boardgame.Piece;

// classe extendida por ser uma sub classe

public class ChessPiece extends Piece {
	
	private Color color;
	
//método construtor - passa chamada para classe Piece
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	
	
	
}
