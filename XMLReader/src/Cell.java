
import java.io.File;

public class Cell {
	private int row;
	private int col;
	private String content;
	//color

	public Cell(int row, int col, String content){
		this.row = row;
		this.col = col;
		this.content = content;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public String toString(){
		return "Rij: " + row + "\nKolom: " + col + "\nContents: " + content;
	}

}

