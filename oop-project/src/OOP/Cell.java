package OOP;


public class Cell {
	private int row;
	private int col;
	private String content;
	//color

	
	/**
	 * Constructor.
	 * @param row
	 * @param col
	 * @param content
	 */
	public Cell(int row, int col, String content){
		setRow(row);
		setCol(col);		
		setContent(content);
	}
	/**
	 * This methode returns the private row.
	 * @return int row
	 */
	public int getRow(){
		return row;
	}
	
	/**
	 * This methode returns the private col.
	 * @return int col
	 */
	public int getCol(){
		return col;
	}
	
	/**
	 * This methode returns the private content of the cell
	 * @return String content
	 */
	public String getContent(){
		return content;
	}
	
	/**
	 * This methode sets the content of Cell this.
	 * @param String content
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * This methode sets the value of row of Cell this.
	 * @param int row
	 */
	public void setRow(int row){
		this.row = row;
	}
	
	/**
	 * This methode sets the value of col of Cell this.
	 * @param int col
	 */
	public void setCol(int col){
		this.col = col;
	}
	
	/**
	 * This methode makes a String representation of the Cell this.
	 * @return String
	 */
	public String toString(){
		return "Rij: " + row + "\nKolom: " + col + "\nContents: " + content;
	}

	public boolean equals(Object other){
		if(other instanceof Cell){
			Cell that = (Cell) other;
			if(this.row == that.row && this.col == that.col && this.content.equals(that.content)){
				return true;
			}
		}
		return false;
	}
}

