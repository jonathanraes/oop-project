package Controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.util.ArrayList;

import Gui.View;
import OOP.Cell;
import OOP.Spreadsheet;

public class Controller extends MouseAdapter implements ActionListener, KeyListener, HierarchyBoundsListener{
	View view;
	Spreadsheet spreadsheet;

	public Controller(View view, Spreadsheet spreadsheet){
		this.view = view;
		this.spreadsheet = spreadsheet;
	}
		
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
			File file =	view.getFileChooser().getSelectedFile();
			loadFile(file);
			view.closeFileChooser();
	}
	}

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
	
	public void loadFile(File file){
		Spreadsheet.readXML(file.toString());
		ArrayList<Cell> list = spreadsheet.getCells();
		for(int i =0; i < list.size(); i++){
			int row = list.get(i).getRow() - 1;
			int col = list.get(i).getCol() - 1;
			String value = list.get(i).getContent();
			view.setCell(row, col, value);
		}
	}
}
