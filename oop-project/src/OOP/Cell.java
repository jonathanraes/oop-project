package OOP;


/**
 * The Class Cell represents a Cell object.
 * It contains an integer representing the row number, and one representing the column number.
 * It also contains a String holding the content
 * @author Jonathan
 *
 */
public class Cell {
	private int row;
	private int col;
	private String content;
	private String formule;
	//color
	
	/**
	 * Constructor for the Cell.
	 * @param row int - row number
	 * @param col int - column number
	 * @param content String - contents 
	 */
	public Cell(int row, int col, String content){
		setRow(row);
		setCol(col);		
		setContent(content);
	}
	
	public Cell(int row, int col, String content, String function){
		setRow(row);
		setCol(col);		
		setContent(content);
		this.formule = function;
	}
	/**
	 * This method returns the private row.
	 * @return int row
	 */
	public int getRow(){
		return row;
	}
	
	/**
	 * This method returns the private col.
	 * @return int col
	 */
	public int getCol(){
		return col;
	}
	
	/**
	 * This method returns the private content of the cell
	 * @return String content
	 */
	public String getContent(){
		return content;
	}
	
	/**
	 * This method sets the content of Cell this.
	 * @param String content
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * This method sets the value of row of Cell this.
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
	 * This method makes a String representation of the Cell 'this'.
	 * @return String - String representation of the Cell.
	 */
	public String toString(){
		return "Rij: " + row + "\nKolom: " + col + "\nContents: " + content;
	}

	/**
	 * The equals method checks if the Cell is the same as an other Cell by checking if the cell contents match
	 * @param Object other - The cell that 'this' is compared to
	 */
	public boolean equals(Object other){
		if(other instanceof Cell){
			Cell that = (Cell) other;
			if(this.row == that.row && this.col == that.col){
				return true;
			}
		}
		return false;
	}
	
	public void addFunction(String function){
		this.formule = function;
	}
	
	public String getFunction(){
		return formule;
	}
}

