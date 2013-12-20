package Controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import Formules.Formule;
import Gui.View;
import OOP.Cell;
import OOP.Spreadsheet;

public class Controller implements ActionListener, KeyListener, HierarchyBoundsListener, DocumentListener, TableModelListener{
	private View view;
	private Spreadsheet spreadsheet;

	public Controller(View view, Spreadsheet spreadsheet){
		this.view = view;
		this.spreadsheet = spreadsheet;
	}
	
//	ActionListener-----------------------------------------------------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals("+10 Rows")){
//			view.updateRowHeader();
//			view.addRows();
//		}
//		if(e.getActionCommand().equals("+10 Columns")){
//			view.addColumns();
//		}
//		above is not needed as long as the buttons are disabled
		
		if(e.getActionCommand().equals("openfilechooser")){
			//the open button from the menubar is pressed
			view.openFileChooser();
		}
		if(e.getActionCommand().equals("ApproveSelection")){
			//user presses open in the filechooser menu
			loadFile(view.getFileChooser().getSelectedFile());
			view.closeFileChooser();
		}
		if(e.getActionCommand().equals("CancelSelection")){
			//user presses cancel in the filechooser menu
			view.closeFileChooser();
		}
	}

//	KeyListener--------------------------------------------------------------------------------------------------------------
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getExtendedKeyCode() == 39){
			if(view.getTable().getSelectedColumn() == view.getTable().getColumnCount()-1){
				//Executed if right arrow is pressed while right most column is selected
				view.addColumns();
			}
		}
		if(e.getExtendedKeyCode() == 40){
			if(view.getTable().getSelectedRow() == view.getTable().getRowCount()-1){
				//Executed if the down arrow is pressed while the bottom row is selected
				view.updateRowHeader();
				view.addRows();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
	
//	HierarchyBoundsListener----------------------------------------------------------------------------------------------------
	
	@Override
	public void ancestorMoved(HierarchyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ancestorResized(HierarchyEvent e) {
		Dimension size = view.getSize();
		while(view.isActive() && view.getRowCount() < (size.height / 18)){
			view.updateRowHeader();
			view.addRows();
		}
		while(view.isActive() && view.getColumnCount() < (size.width / 75)){
			view.addColumns();
		}
	}
	
//	DocumentListener--------------------------------------------------------------------------------------------------------

	@Override
	public void insertUpdate(DocumentEvent e) {
		try{
			//Insert the TextField's contents to the selected cell.
			int col = view.getTable().getSelectedColumn();				
			int row = view.getTable().getSelectedRow();
			view.setCell(row, col, view.getTextField().getText());			
		}
		catch(ArrayIndexOutOfBoundsException ex){
			//No cell was selected while text was put in the TextField: the first cell will be used.
			view.getTable().setColumnSelectionInterval(0, 0);
			view.getTable().setRowSelectionInterval(0, 0);
			int col = view.getTable().getSelectedColumn();				
			int row = view.getTable().getSelectedRow();
			view.setCell(row, col, view.getTextField().getText());			
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		//When text is removed from the TextField the selected cell is also updated.
		int col = view.getTable().getSelectedColumn();				
		int row = view.getTable().getSelectedRow();
		view.setCell(row, col, view.getTextField().getText());			
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		//Event is never fired
	}

//	TableModelListener-------------------------------------------------------------------------------------------------------

	@Override
	public void tableChanged(TableModelEvent e) {
		try{
			String formule = view.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString();
			String content = parseFunction(formule);
			if(content != null){
				Cell newCell = new Cell(e.getFirstRow(), e.getColumn(), content, formule);
				view.setCell(e.getFirstRow(), e.getColumn(), content);
				spreadsheet.add(newCell);
			}
			else{
				Cell newCell = new Cell(e.getFirstRow(), e.getColumn(), view.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
				spreadsheet.add(newCell);
			}
		}
		catch(ArrayIndexOutOfBoundsException ex){
		}
	}
	
	
//	-------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * This method will take a file, use the readXML method to parse the file, then it will use the Spreadsheet list to add all the values to the Table
	 * @param file File: File to be loaded into the application
	 */
	public void loadFile(File file){
		view.getModel().removeTableModelListener(this);
		Spreadsheet.readXML(file.toString());
		ArrayList<Cell> list = spreadsheet.getCells();
		for(int i =0; i < list.size(); i++){
			int row = list.get(i).getRow() - 1;
			int col = list.get(i).getCol() - 1;
			String value = list.get(i).getContent();
			
			if(row >= view.getTable().getRowCount()){
				//If the amount of rows in the table is not enough
				int extraRowsNeeded = row - view.getModel().getRowCount();
				for(int j = 0; j <= extraRowsNeeded; j++){
					view.updateRowHeader();
					view.getModel().setRowCount(view.getRowCount()+1);
				}
			}
			view.setCell(row, col, value);
		}
		view.getModel().addTableModelListener(this);
	}
	
	/**
	 * This method takes a String. It will try to parse this string into a function and, when succeeded, call the function to calculate the requested value and return it.
	 * When it fails, it will either return null, when there was no function in the first place,
	 * or it will return a string indicating that the function is not recognized.
	 * @param function String: String to be parsed
	 */
	public String parseFunction(String function){
		try{
			String formule = function;
			if(formule.substring(0, 1).equals("=")){ //Check to see if there is a function at all
				//getting the required function
				function = function.substring(1);
				String[] formula = function.split("\\(|\\)");
				String functionname = "Formules."+formula[0];
				Class c = Class.forName(functionname);
				Object o = c.newInstance();
				Formule f = (Formule)o;
				
				//getting the range of cells
				String[] cellrange = formula[1].split(":");
				String firstcell = cellrange[0];
				String lastcell = cellrange[1];
				int startColumn = firstcell.substring(0, 1).toLowerCase().charAt(0) - 'a' +  1;
				int startRow = Integer.parseInt(firstcell.substring(1));
				int lastColumn = lastcell.substring(0, 1).toLowerCase().charAt(0) - 'a' +  1;
				int lastRow = Integer.parseInt(lastcell.substring(1));
				
				//retrieving the cell contents'
				String[] values = new String[(lastColumn - startColumn + 1)*(lastRow - startRow + 1)];
				int i = 0;
				for(int row = 0; row < (lastRow - startRow + 1); row++){
					for(int col = 0; col < (lastColumn - startColumn + 1); col++){
						try{
							values[i] = spreadsheet.getCellAt(row, col).getContent();
						}catch(NullPointerException ex){ 
							//The cell did not exist, empty string is inserted
							values[i] = "";
						}finally{
							i++;
						}
					}
				}
				String content = f.executable(values);
				return content;
			}
	} 
	catch (ClassNotFoundException ex) { //The function class was not found
		return "No such function";
	} 
	catch (InstantiationException | IllegalAccessException ex) {
		//There was an error in initiating the class.
		return "Error";
	} 
	catch(ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException ex ){ 
		//The call was empty, so a substring could not be created
	}
		return null; //this is reached if the input string was not a function (did not start with '=')
}
}
