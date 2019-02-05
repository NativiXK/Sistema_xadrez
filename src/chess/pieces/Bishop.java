package chess.pieces;

import java.awt.Color;

import boardgame.Board;
import chess.ChessPiece;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "B";
	}

}
