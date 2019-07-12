package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessmatch) {
		super(board, color);
		this.chessMatch = chessmatch;
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		// above
		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// nw
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// ne
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// sw
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// se
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {

			// right
			Position c01 = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(c01)) {
				Position c1 = new Position(position.getRow(), position.getColumn() + 1);
				Position c2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(c1) == null && getBoard().piece(c2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}

			// left
			Position c02 = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(c02)) {
				Position c1 = new Position(position.getRow(), position.getColumn() - 1);
				Position c2 = new Position(position.getRow(), position.getColumn() - 2);
				Position c3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(c1) == null && getBoard().piece(c2) == null && getBoard().piece(c3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}

			}
		}
		return mat;
	}

	@Override
	public String toString() {
		return "R";
	}
}
