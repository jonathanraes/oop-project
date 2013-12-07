package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Gui.View;
import OOP.Spreadsheet;

public class Controller extends MouseAdapter implements ActionListener{
	View view;
	Spreadsheet spreadsheet;

	public Controller(View view, Spreadsheet spreadsheet){
		this.view = view;
		this.spreadsheet = spreadsheet;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("+10 Rows")){
			view.updateRowHeader();
			view.add10Rows();
		}
		if(e.getActionCommand().equals("+10 Columns")){
			view.add10Columns();
		}
	}
}
