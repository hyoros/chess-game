package chess.pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;

public class Pawn extends ChessPiece {

	ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	private boolean[][] equalsMoves(Color color) {
		Piece p = chessMatch.king(chessMatch.opponent(color));
		boolean[][] mat = p.possibleMoves();
		return mat;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		Position p2 = new Position(0, 0);
		boolean[][] m = equalsMoves(getColor());

		if (getColor() == Color.WHITE) { // White Pieces
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 2, position.getColumn());
			p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			} else if (getBoard().positionExists(p) && m[p.getRow()][p.getColumn()]) {
				mat[p.getRow()][p.getColumn()] = true;
			} 

			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			} else if (getBoard().positionExists(p) && m[p.getRow()][p.getColumn()]) {
				mat[p.getRow()][p.getColumn()] = true;
			} 

			p2 = new Position(position.getColumn() - 1, position.getColumn());
			p.setValues(position.getRow() - 2, position.getColumn() - 1);
			if (getBoard().positionExists(p) && getBoard().positionExists(p2) && isThereOpponentPiece(p)
					&& getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			} else if (getBoard().positionExists(p) && getBoard().positionExists(p2) && m[p.getRow()][p.getColumn()]
					&& getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 2, position.getColumn() + 1);
			if (getBoard().positionExists(p) && getBoard().positionExists(p2) && isThereOpponentPiece(p)
					&& getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			} else if (getBoard().positionExists(p) && getBoard().positionExists(p2) && m[p.getRow()][p.getColumn()]
					&& getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

		} else { // Black Pieces
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() + 2, position.getColumn());
			p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			} else if (getBoard().positionExists(p) && m[p.getRow()][p.getColumn()]) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			} else if (getBoard().positionExists(p) && m[p.getRow()][p.getColumn()]) {
				mat[p.getRow()][p.getColumn()] = true;
			} 

			p2 = new Position(position.getColumn() + 1, position.getColumn());
			p.setValues(position.getRow() + 2, position.getColumn() - 1);
			if (getBoard().positionExists(p) && getBoard().positionExists(p2) && isThereOpponentPiece(p)
					&& getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			} else if (getBoard().positionExists(p) && getBoard().positionExists(p2) && m[p.getRow()][p.getColumn()]
					&& getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() + 2, position.getColumn() + 1);
			if (getBoard().positionExists(p) && getBoard().positionExists(p2) && isThereOpponentPiece(p)
					&& getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			} else if (getBoard().positionExists(p) && getBoard().positionExists(p2) && m[p.getRow()][p.getColumn()]
					&& getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

		}
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}

}
