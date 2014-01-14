package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.jfree.chart.JFreeChart;

import Formules.Formule;
import Gui.Graph;
import Gui.View;
import OOP.Cell;
import OOP.Spreadsheet;
/**
 * The Controller class takes care of any listener methods. It listens for all changes and takes care of them.
 * It also contains methods for parsing, loading files and retrieving cell data.
 *
 */
public class Controller implements ActionListener, KeyListener, HierarchyBoundsListener, DocumentListener, TableModelListener, ListSelectionListener{
	private View view;
	private Spreadsheet spreadsheet;
	private int currentSearchRow = 0;
	private int currentSearchColumn = 0;

	public Controller(View view, Spreadsheet spreadsheet){
		this.view = view;
		this.spreadsheet = spreadsheet;
	}
	
//	ActionListener-----------------------------------------------------------------------------------------------------------
	
	/**
	 * ActionPerformed handles all the actionevents that are thrown by any components that have the Actionlistener added.
	 * It handles what should be done when any button, or any menu item is clicked
	 */
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
		String command = e.getActionCommand();
	
		if(e.getActionCommand().equals("ApproveSelection")){
			//user presses open in the filechooser menu
			if(view.getFileChooser().getDialogType() == JFileChooser.OPEN_DIALOG){
				spreadsheet.clearSheet();
				view.clearTable();
				loadFile(view.getFileChooser().getSelectedFile());
			}
		}
		if(e.getActionCommand().equals("Graph")){
			view.graphChooser();
			view.resetGraphChooser();

		}
		if(e.getActionCommand().equals("CreateGraph")){
			if(view.getSelectedGraph().equals("Pie Chart")){
				String graphname = view.getGraphTitle();
				String[] columnNames = view.getColumnNames().split(";");
				String[] data = parseCellData(view.getStartCell(), view.getEndCell());
				double[] parsedData = new double[data.length];
				boolean legend = view.getLegendSetting();
				boolean d3 = view.get3DSetting();
				String type = view.getPieChartType();
				for(int i = 0; i < data.length; i++){
					try{
						parsedData[i] = Double.parseDouble(data[i]);
					}
					catch(NumberFormatException ex){
					}
				}
				Graph newGraph = new Graph(parsedData, graphname);
				JFreeChart chart = newGraph.createPieChart(legend, d3, type, columnNames);
				view.closeGraphChooser();
			}
			else if(view.getSelectedGraph().equals("Bar Chart")){
				int startColumn = view.getStartCell().substring(0, 1).toLowerCase().charAt(0) - 'a' +  1;
				int startRow = Integer.parseInt(view.getStartCell().substring(1));
				int lastColumn = view.getEndCell().substring(0, 1).toLowerCase().charAt(0) - 'a' +  1;
				int lastRow = Integer.parseInt(view.getEndCell().substring(1));
				int rowsAmount = lastRow - startRow;
				int columnsAmount = lastColumn - startColumn;
				String graphName = view.getGraphTitle();
				String xAxisName = view.getXAxisName();
				String yAxisName = view.getYAxisName();
				String orientation = view.getOrientation();
				String[] columnNames = view.getColumnNames().split(";");
				String[] rowNames = view.getRowNames().split(";");
				String[] data = parseCellData(view.getStartCell(), view.getEndCell());
				double[] parsedData = new double[data.length];
				boolean legend = view.getLegendSetting();
				boolean d3 = view.get3DSetting();
				boolean stacked = view.getStackedSetting();
				for(int i = 0; i < data.length; i++){
					try{
						parsedData[i] = Double.parseDouble(data[i]);
					}
					catch(NumberFormatException ex){
					}
				}
				Graph newGraph = new Graph(parsedData, graphName);
				newGraph.createBarChart(legend, d3, rowsAmount, columnsAmount, rowNames, columnNames, xAxisName, yAxisName, orientation, stacked);
				view.closeGraphChooser();
			}
			else if(view.getSelectedGraph().equals("Line Graph")){
				int startColumn = view.getStartCell().substring(0, 1).toLowerCase().charAt(0) - 'a' +  1;
				int startRow = Integer.parseInt(view.getStartCell().substring(1));
				int lastColumn = view.getEndCell().substring(0, 1).toLowerCase().charAt(0) - 'a' +  1;
				int lastRow = Integer.parseInt(view.getEndCell().substring(1));
				int rowsAmount = lastRow - startRow;
				int columnsAmount = lastColumn - startColumn;
				String graphName = view.getGraphTitle();
				String xAxisName = view.getXAxisName();
				String yAxisName = view.getYAxisName();
				String orientation = view.getOrientation();
				String[] columnNames = view.getColumnNames().split(";");
				String[] rowNames = view.getRowNames().split(";");
				String[] data = parseCellData(view.getStartCell(), view.getEndCell());
				double[] parsedData = new double[data.length];
				boolean legend = view.getLegendSetting();
				boolean d3 = view.get3DSetting();
				for(int i = 0; i < data.length; i++){
					try{
						parsedData[i] = Double.parseDouble(data[i]);
					}
					catch(NumberFormatException ex){
					}
				}
				Graph newGraph = new Graph(parsedData, graphName);
				newGraph.createLineGraph(legend, d3, rowsAmount, columnsAmount, rowNames, columnNames, xAxisName, yAxisName, orientation);
				view.closeGraphChooser();
			}
		}
		if(e.getSource() instanceof JComboBox){
			view.resetGraphChooser();
		}
		if(e.getActionCommand().equals("CancelGraph")){
			//User presses the cancel button in the graph chooser window
			view.closeGraphChooser();
		}
		if(e.getActionCommand().equals("Ring")){
			view.enable3D(false);
		}
		if(e.getActionCommand().equals("Pie")){
			view.enable3D(true);
		}
		if(e.getSource() instanceof JMenuItem){
			if(e.getActionCommand().equals("Copy")){
				String contents = view.getTable().getValueAt(view.getTable().getSelectedRow(), view.getTable().getSelectedColumn()).toString();
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(new StringSelection(contents), null);
			}
			else if(e.getActionCommand().equals("Cut")){
				String contents = view.getTable().getValueAt(view.getTable().getSelectedRow(), view.getTable().getSelectedColumn()).toString();
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(new StringSelection(contents), null);
				view.getTable().setValueAt("", view.getTable().getSelectedRow(), view.getTable().getSelectedColumn());
			}
			else if(e.getActionCommand().equals("Paste")){
				String result = "";
			    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			    Transferable contents = clipboard.getContents(null);
			    if (contents != null) {
			      try {
			        result = (String)contents.getTransferData(DataFlavor.stringFlavor);
			      }
			      catch (UnsupportedFlavorException | IOException ex){
			      }
			    }
			    view.getModel().setValueAt(result, view.getTable().getSelectedRow(), view.getTable().getSelectedColumn());
			}
			else if(e.getActionCommand().equals("Select All")){
				view.getTable().selectAll();
			}
			else if(e.getActionCommand().equals("Find")){
				view.openSearchWindow();
			}
			else if(e.getActionCommand().equals("Delete Contents")){
				int[] rows = view.getTable().getSelectedRows();
				int[] cols = view.getTable().getSelectedColumns();
				for(int row = 0; row < rows.length; row++){
					for (int col = 0; col < cols.length; col++) {
						view.getModel().setValueAt("", rows[row], cols[col]);
					}
				}
			}
			else if(e.getActionCommand().equals("Save")){
				int actionDialog = view.getFileChooser().showSaveDialog(view);
				if(actionDialog == JFileChooser.APPROVE_OPTION){
					File fileName;
					if(view.getFileChooser().getSelectedFile().toString().endsWith(".xml")){
						fileName = new File(view.getFileChooser().getSelectedFile().toString());
					}
					else{
						fileName = new File(view.getFileChooser().getSelectedFile() + ".xml");
					}
					if(fileName.exists()){
				        actionDialog = JOptionPane.showConfirmDialog(view,
				                           "Replace existing file?");
				        if (actionDialog == JOptionPane.NO_OPTION || actionDialog == JOptionPane.CANCEL_OPTION){
				            return;
				        }
				    }
				    spreadsheet.writeXML(fileName.toString());
				}
			}
			else if(e.getActionCommand().equals("openfilechooser")){
					//the open button from the menubar is pressed
					view.getFileChooser().showOpenDialog(view);
			}
		}
		if(e.getActionCommand().equals("Search")){
			String value = view.getSearchText();

            for (int row = 0; row <= view.getTable().getRowCount() - 1; row++) {
                for (int col = 0; col <= view.getTable().getColumnCount() - 1; col++) {
                    if (value.equals(view.getTable().getValueAt(row, col))) {
                    	view.getTable().scrollRectToVisible(view.getTable().getCellRect(row, col, true));

                    	view.getTable().setRowSelectionInterval(row, row);
                    	view.getTable().setColumnSelectionInterval(col, col);
                    	currentSearchRow = row;
                    	currentSearchColumn = col;
                    	return;
                    }
                }
            }
		}
		if(e.getActionCommand().equals("Next")){
			String value = view.getSearchText();

            for (int row = currentSearchRow; row <= view.getTable().getRowCount() - 1; row++) {
                for (int col = currentSearchColumn+1; col <= view.getTable().getColumnCount() - 1; col++) {
                    if (value.equals(view.getTable().getValueAt(row, col))) {
                    	view.getTable().scrollRectToVisible(view.getTable().getCellRect(row, col, true));

                    	view.getTable().setRowSelectionInterval(row, row);
                    	view.getTable().setColumnSelectionInterval(col, col);
                    	currentSearchRow = row;
                    	currentSearchColumn = col;
                    	return;
                    }
                }
            }
		}
		if(e.getActionCommand().equals("Previous")){
			String value = view.getSearchText();

            for (int row = currentSearchRow; row > 0; row--) {
                for (int col = currentSearchColumn-1; col > 0; col--) {
                    if (value.equals(view.getTable().getValueAt(row, col))) {
                    	view.getTable().scrollRectToVisible(view.getTable().getCellRect(row, col, true));

                    	view.getTable().setRowSelectionInterval(row, row);
                    	view.getTable().setColumnSelectionInterval(col, col);
                    	currentSearchRow = row;
                    	currentSearchColumn = col;
                    	return;
                    }
                }
            }
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
	
	/**
	 * The TableChanged method is called when a  change is made to the JTable, it responds by adding the cell to the 
	 * internal ArrayList containing all the cells, as long as the cell is not empty.
	 */
	@Override
	public void tableChanged(TableModelEvent e) {
		try{
			String cellcontents = view.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString();
			String parsedcontents = parseFunction(cellcontents);
			if(parsedcontents != null){
				Cell newCell = new Cell(e.getFirstRow()+1, e.getColumn()+1, parsedcontents, cellcontents);
				view.setCell(e.getFirstRow(), e.getColumn(), parsedcontents);
				spreadsheet.add(newCell);
			}
			else{
				int row = e.getFirstRow()+1;
				int col = e.getColumn()+1;
				Cell newCell = new Cell(e.getFirstRow()+1, e.getColumn()+1, cellcontents);
				spreadsheet.add(newCell);
			}
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException ex){
		}
	}
	
//	ListSelectionListener-----------------------------------------------------------------------------------------------------
	
	/**
	 * The valueChanged method listens to changed in the selection model of the table, when there is a change it will place the text or function from the 
	 * selected cell into the textfield
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		//getting selected cells
		int[] rows = view.getTable().getSelectedRows();
		int[] columns = view.getTable().getSelectedColumns();
		try{
			if(rows.length == 1 && columns.length == 1){
				//if only one cell is selected the value or function is send to the textfield
				if(spreadsheet.getCellAt(rows[0]+1, columns[0]+1).getFunction() != null){
					view.setTextFieldText(spreadsheet.getCellAt(rows[0]+1, columns[0]+1).getFunction());
				}
				else{
					view.setTextFieldText(spreadsheet.getCellAt(rows[0]+1, columns[0]+1).getContent());
				}
	
			}
		}catch(NullPointerException ex){
			view.setTextFieldText("");
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
			if(function.substring(0, 1).equals("=")){ //Check to see if there is a function at all
				//getting the required function
				function = function.substring(1).toUpperCase();
				String[] formula = function.split("\\(|\\)");
				String functionname = "Formules."+formula[0];
				Class c = Class.forName(functionname);
				Object o = c.newInstance();
				Formule f = (Formule)o;
				
				//getting the range of cells
				/*
				String[] cellrange = formula[1].split(":");
				String firstcell = cellrange[0];
				String lastcell = cellrange[1];
			
				//retrieving the cells contents
				String[] values = parseCellData(firstcell,lastcell);
				*/
				ArrayList<String> valuesList = new ArrayList<String>();
				String[] parameters = formula[1].split(", |,");
				int counter = 0;
				ArrayList<String> expressieList = new ArrayList<String>();
				for(int i=0; i<parameters.length; i++){
					if(parameters[i].contains(":")){
						String[] cellrange = parameters[i].split(":");
						String firstcell = cellrange[0];
						String lastcell = cellrange[1];
						String[] interval = parseCellData(firstcell, lastcell);
						for(int j = 0; j<interval.length;j++){
							/*
							if(i==0&&j==0){
								valuesList.add("");
								valuesList.add("");
								valuesList.add("");
							}
							*/
							valuesList.add(interval[j]);
						}
					}else if(parameters[i].matches("[a-zA-Z]+[0-9]+")){
						String[] celvalue = parseCellData(parameters[i],parameters[i]);
						/*
						if(i==0){
							valuesList.add("");
							valuesList.add("");
							valuesList.add("");
						}
						*/
						valuesList.add(celvalue[0]);
						
					}else{
						try{
							Double.parseDouble(parameters[i]);
							/*
							if(i==0){
								valuesList.add("");
								valuesList.add("");
								valuesList.add("");
							}
							*/
							valuesList.add(parameters[i]);
						}catch(NumberFormatException NFE){
							/*
							if(i==0){
								valuesList.add("");
								valuesList.add("");
								valuesList.add("");
							}
							
							valuesList.set(0, parameters[i]);
							*/

							// expressieList.add(parameters[i]);
							
							// Hier moet ik zijn <------------------------------------------------------
							
							// Split de String met een operator. 
							String[] cellen = parameters[i].split("<>|<=|>=|<|>|=");
							/* Als het geen logische expressie is, krijg je maar een array van 1 lang, hierop controleren we hier.
							 * Als het namelijk wel een logische expressie is, ontstaat er een array met een lengte van 2.
							 */
							if(cellen.length == 2){

								expressieList.add(parameters[i]);
								
								// Echter als de expressie een 1 cellige expressie is, bijv "<B4", dan is de eerste leeg of een aantal spaties afhankelijk van de invoer.
									for(int count = 0; count<cellen.length;count++){
										if(cellen[count].matches("[a-zA-Z]+[0-9]+")){
											expressieList.add(parseCellData(cellen[count],cellen[count])[0]);
											// valuesList.set(count+1, parseCellData(cellen[count],cellen[count])[0]);
										}else{
											expressieList.add(cellen[count]);
										}
										
									}
								
							}else{
								valuesList.add(parameters[i]);
							}
							
						}
					}
				}
				// valuesList -> values
				String[] values;
				values = new String[valuesList.size() + expressieList.size()];
				for(int i = 0; i<expressieList.size();i++){
					values[i] = expressieList.get(i);
				}
				for(int i=0; i<valuesList.size();i++){
					values[i+expressieList.size()] = valuesList.get(i);
				}
				/*
				if(valuesList.get(0).isEmpty()){
					values = new String[valuesList.size() -3];
					for(int i=0;i<valuesList.size()-3;i++){
						values[i] = valuesList.get(i+3);
					}
				}else{
					values = new String[valuesList.size()];
					for(int i=0;i<valuesList.size();i++){
						values[i] = valuesList.get(i);
					}
				}
				*/
	// --------------------------------Einde nieuwe code------------------------------------------------
				for(int i=0; i<values.length; i++){
					System.out.println(values[i]);
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
		catch(ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException | NumberFormatException ex){ 
			//The cell was empty or function was wrong format or incomplete, return null
		}
		return null; //this is reached if the input string was not a (complete) function
	}
	
	/**
	 * ParseCellData gets two cells as parameter. It retrieves the cells' locations and then retrieves all the cells' contents that are 
	 * in between the two cells specified. This is stored in a String array and returned.
	 * @param firstCell String: Sting representation of the first cell
	 * @param lastCell String: String representation of the second cell
	 * @return values String[] Strings with all the cells contents
	 */
	public String[] parseCellData(String firstCell, String lastCell){
		int startColumn = firstCell.substring(0, 1).toLowerCase().charAt(0) - 'a' +  1;
		int startRow = Integer.parseInt(firstCell.substring(1));
		int lastColumn = lastCell.substring(0, 1).toLowerCase().charAt(0) - 'a' +  1;
		int lastRow = Integer.parseInt(lastCell.substring(1));
		
		//retrieving the cells contents
		String[] values = null;
		try{
			values = new String[(lastColumn - startColumn + 1)*(lastRow - startRow + 1)];
		}
		catch(NegativeArraySizeException e){
			values = new String[1];
			values[0] = "";
			return values;
		}
		int i = 0;
		for(int row = startRow; row <= lastRow; row++){
			for(int col = startColumn; col <= lastColumn; col++){
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
		return values;
	}
}
