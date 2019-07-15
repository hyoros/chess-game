package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import boardgame.BoardException;
import chess.ChessExeception;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();

		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScren();
				UI.printMatch(chessMatch, captured);
				System.out.println(UI.RESET_COLOR);
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScren();
				UI.printBoard(chessMatch.getPiece(), possibleMoves);
				System.out.println(UI.RESET_COLOR);
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				ChessPiece capturedPiece = chessMatch.perfomeChessMove(source, target);
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
			} catch (ChessExeception e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (BoardException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScren();
		UI.printMatch(chessMatch, captured);

	}

}
