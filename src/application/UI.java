package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {

	public static final String RESET_COLOR = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";

	public static final String BLACK_BACKGROUND = "\u001B[40m";
	public static final String RED_BACKGROUND = "\u001B[41m";
	public static final String GREEN_BACKGROUND = "\u001B[42m";
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	public static final String BLUE_BACKGROUND = "\u001B[44m";
	public static final String PURPLE_BACKGROUND = "\u001B[45m";
	public static final String CYAN_BACKGROUND = "\u001B[46m";
	public static final String WHITE_BACKGROUND = "\u001B[47m";

	public static void clearScren() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static ChessPosition readChessPsoition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
		}
	}
	
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPiece());
		System.out.println();
		printCaptuPieces(captured);
		System.out.println();
		System.out.println("Turn : " + chessMatch.getTurn());
		System.out.println("Waiting player : " + chessMatch.getCurrentPlayer());
	}

	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print(WHITE + BLACK_BACKGROUND + (8 - i) + BLACK_BACKGROUND + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println(RESET_COLOR);
		}
		System.out.println(WHITE + BLACK_BACKGROUND + "  a b c d e f g h ");
	}

	public static void printBoard(ChessPiece[][] pieces, boolean[][] posibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print(WHITE + BLACK_BACKGROUND + (8 - i) + BLACK_BACKGROUND + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], posibleMoves[i][j]);
			}
			System.out.println(RESET_COLOR);
		}
		System.out.println(WHITE + BLACK_BACKGROUND + "  a b c d e f g h ");
	}
	
	private static void printPiece(ChessPiece piece, boolean background) {
		if (background) {
			System.out.print(RED_BACKGROUND);
		}
		if (piece == null) {
			System.out.print(CYAN + "-" + BLACK_BACKGROUND);
		} else {
			if (piece.getColor() == Color.WHITE) {
				System.out.print(WHITE + piece + BLACK_BACKGROUND);
			} else {
				System.out.print(YELLOW + piece + BLACK_BACKGROUND);
			}
		}
		System.out.print(" " + BLACK_BACKGROUND);
	}
	
	private static void printCaptuPieces(List<ChessPiece> capture) {
		List<ChessPiece> white = capture.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = capture.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		System.out.print("White: ");
		System.out.print(WHITE);
		System.out.println(Arrays.toString(white.toArray()) + RESET_COLOR);
		System.out.print("Black: ");
		System.out.print(YELLOW);
		System.out.println(Arrays.toString(black.toArray()) + RESET_COLOR);
		
	}
	
}