package chess;

import java.awt.Color;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}

	//retorna matriz com as peças no tabuleiro
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++)
				mat[i][j] = (ChessPiece) board.piece(i, j);
		}
		return mat;
	}

	// irá posicionar uma nova peça de acordo com o sistema de coordenadas
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	//setup inicial para posicionamento das peças
	public void initialSetup() {
		placeNewPiece('b', 7, new Rook(board, Color.WHITE));
		placeNewPiece('a', 1, new King(board, Color.BLACK));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
	}
}
