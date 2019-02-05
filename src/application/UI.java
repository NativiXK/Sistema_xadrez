package application;

import chess.ChessPiece;

public class UI {

	// imprime o tabuleiro atualizado com as peças em suas posições
	public static void printBoard(ChessPiece[][] pieces) {

		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}

		System.out.println("  a b c d e f g h");

	}

	// verifica se existe uma peça na posição verificada, se existir escreve a peça,
	// se não escreve um traço
	private static void printPiece(ChessPiece piece) {
		if (piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}

}
