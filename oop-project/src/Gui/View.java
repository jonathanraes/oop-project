package Gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.JTableHeader;

public class View extends JFrame {
	private JMenuBar menubar;
	private JPanel panel;
	private JTable table;
	private JTableHeader header;
	private JScrollPane pane;
	
	public View(){
		final String headers[] = new String[100];
		
		for(int i = 0; i < 100; i++){
			headers[i] = "" + (i+1);
		}
		createPanel();
		createPane();
		createMenu();
		setVisible(true);
		ListModel lm = new AbstractListModel() {
			String[] headerf = headers;

			public int getSize() {
				return headers.length;
			}

			public Object getElementAt(int index) {
				return headers[index];
			}
		};
		JList rowHeader = new JList(lm);
		rowHeader.setFixedCellWidth(30);
		rowHeader.setFixedCellHeight(16);		
	    rowHeader.setCellRenderer(new RowHeaderRenderer(table));
	    pane.setRowHeaderView(rowHeader);
	    getContentPane().add(pane, BorderLayout.CENTER);
	}

	public void createPanel(){
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createMenu(){
		//Create menubar
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu fileMenu = new JMenu("File");
	    JMenu editMenu = new JMenu("Edit");
	    menubar.add(fileMenu);
	    menubar.add(editMenu);
		//menuitems
		JMenuItem newfile = new JMenuItem("New");
	    JMenuItem open = new JMenuItem("Open");
	    JMenuItem save = new JMenuItem("Save");
	    JMenuItem close = new JMenuItem("Close");
	    JMenuItem exit = new JMenuItem("Exit");
	    
	    JMenuItem cut = new JMenuItem("Cut");
	    JMenuItem copy = new JMenuItem("Copy");
	    JMenuItem paste = new JMenuItem("Paste");
	    JMenuItem selectall = new JMenuItem("Select All");
	    JMenuItem find = new JMenuItem("Find");
	    JMenuItem deletecontents = new JMenuItem("Delete Contents");
	    JMenuItem deletecells = new JMenuItem("Delete Cells");
	    
	    fileMenu.add(newfile);
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(close);
		fileMenu.add(exit);
		
		editMenu.add(cut);
		editMenu.add(copy);
		editMenu.add(paste);
		editMenu.add(selectall);
		editMenu.add(find);
		editMenu.add(deletecontents);
		editMenu.add(deletecells);	
	}
	
	public void createTable(){
		table = new JTable(100,100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
	}
	
	public void createPane(){
		createTable();
		createHeader();
		pane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(pane);
	}
	
	public void createHeader(){
		header = table.getTableHeader();
		header.setOpaque(true);
		header.setBackground(Color.yellow);
	}
}
