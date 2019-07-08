package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessExeception;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();

		while (true) {
			try {
				UI.clearScren();
				UI.printBoard(chessMatch.getPiece());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPsoition(sc);
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScren();
				UI.printBoard(chessMatch.getPiece(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPsoition(sc);
				ChessPiece capturedPiece = chessMatch.perfomeChessMove(source, target);
			} catch (ChessExeception e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}

	}

}
