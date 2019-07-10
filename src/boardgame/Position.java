package boardgame;

public class Position {

	private int row;
	private int colums;

	public Position(int row, int colums) {
		this.row = row;
		this.colums = colums;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColums() {
		return colums;
	}

	public void setColums(int colums) {
		this.colums = colums;
	}

	public void setValues(int row, int column) {
		this.row = row;
		this.colums = column;
	}

	@Override
	public String toString() {
		return row + ", " + colums;
	}

}
