package Gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Controller.ColorEditor;
import Controller.Controller;
import OOP.Spreadsheet;

public class View extends JFrame{
	Spreadsheet spreadsheet;
	private JMenuBar menubar;
	private JPanel tablePanel;
	JPanel topPanel;
	private JTable table;
	private JTableHeader header;
	private JScrollPane pane;
	private DefaultTableModel model;
	JColorChooser colorChooser;
	JDialog dialog;
	Controller controller;
	ColorEditor colorEditor;
	final String headers[];
	JList rowHeader;
	JFrame fileChooserFrame;
	final JFileChooser fileChooser = new JFileChooser();
	public JTextField f;
	
	
	public View(Spreadsheet spreadsheet){
		controller = new Controller(this, spreadsheet);
		colorEditor = new ColorEditor(this);
		headers = new String[100000];
		
		setLayout(new BorderLayout());
		
		createTable();
		createPane();
		createColumnHeader();
		createRowHeader();
		createMenu();
		createTopPanel();
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	//Dit moet aan het eind blijven!!!
		
	}
	
	/**
	 * createTopPanel creates a panel with a textpane and buttons to be displayed above the JTable.
	 * The textpane in the TopPanel is used for entering text and formulas in the table's cells.
	 * The buttons are used to set a cell's background color and to add additional rows and columns in the table
	 */
	public void createTopPanel(){
		topPanel = new JPanel();
		JButton colorbutton = new JButton("Set Color");
//		JButton addRows = new JButton("+10 Rows");
//		JButton addColumns = new JButton("+10 Columns");
				

		f = new JTextField();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		
//		addRows.addActionListener(controller);
//		addColumns.addActionListener(controller);
		colorbutton.addActionListener(colorEditor);
		colorbutton.setActionCommand("edit");
		colorbutton.setBorderPainted(false);
//		addRows.setBorderPainted(false);
//		addColumns.setBorderPainted(false);
		
		topPanel.add(f);
		topPanel.add(colorbutton);
//		topPanel.add(addRows);
//		topPanel.add(addColumns);
		add(topPanel, BorderLayout.NORTH);
		f.getDocument().addDocumentListener(controller);
	}
	
	/**
	 * createTable creates a panel, table, and tablemodel.
	 * The model is used for the table which is added into the panel.
	 */
	public void createTable(){
		tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		model = new DefaultTableModel(15,10000);
		table = new JTable(1,5);
		table.setAutoCreateColumnsFromModel(false);
		table.addHierarchyBoundsListener(controller);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.setRowSelectionAllowed(true);
	    table.setCellSelectionEnabled(true);
	    table.setColumnSelectionAllowed(true);
	    add(tablePanel);
	    	    
	    table.addKeyListener(controller);
	}
	
	/**
	 * createPane creates a scroll pane for the table.
	 */
	public void createPane(){
		pane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		tablePanel.add(pane);
	}
	
	/**
	 * createColumnHeader creates a TableHeader to act as a column header for the JTable.
	 */
	public void createColumnHeader(){
		header = table.getTableHeader();
		header.setBackground(Color.yellow);
	}

	/**
	 * createMenu creates a JMenuBar including a filemenu and an editmenu containing some menu items.
	 */
	public void createMenu(){
		//Creating and setting the menubar
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu fileMenu = new JMenu("File");
	    JMenu editMenu = new JMenu("Edit");
	    menubar.add(fileMenu);
	    menubar.add(editMenu);
	    
		//creating the menu items
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
	    JMenuItem changecolor = new JMenuItem("Set Color");

	    //adding the menu items to the right JMenu
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
		editMenu.add(changecolor);
		
		//TODO add actionlisteners to all the menu items
		open.setActionCommand("openfilechooser");
		open.addActionListener(controller);
	}
	
	/**
	 * addColumns adds a new column object to the JTable passing in the table's current column as parameter to set the header correctly
	 */
	public void addColumns(){
		table.addColumn(new TableColumn(table.getColumnCount()));
	}
	
	/**
	 * addRows updates the table's model to add an extra row
	 */
	public void addRows(){
		model.setRowCount(model.getRowCount() + 1);
	}
	
	/**
	 * createRowHeader creates a Row Header using an anonymous Abstract List Model and an array of strings representing the line numbers.
	 */
	public void createRowHeader(){
		for(int i = 0; i < model.getRowCount(); i++){
			headers[i] = "" + (i+1);
		}
		
		ListModel lm = new AbstractListModel() {
			String[] headerf = headers;
			public int getSize() {
				return headers.length;
			}
			
			public Object getElementAt(int index) {
				return headers[index];
			}
			
		};
		rowHeader = new JList(lm);
		rowHeader.setFixedCellWidth(30);
		rowHeader.setFixedCellHeight(16);		
		rowHeader.setCellRenderer(new RowHeaderRenderer(table));
		pane.setRowHeaderView(rowHeader);
		getContentPane().add(pane, BorderLayout.CENTER);
	}

	/**
	 * updateRowHeader updates the headers array to include the newly added rows in the tablemodel. 
	 * It assumes an addition of 10 rows and adds 10 line numbers to the row header.
	 */
	public void updateRowHeader(){
		for(int i = model.getRowCount(); i < model.getRowCount()+1; i++){
			headers[i] = "" + (i+1);
		}
		rowHeader.repaint();
	}
	
	/**
	 * setCell sets the value of a cell as specified
	 * @param row int: Row number of the cell that is edited
	 * @param col int: Column number of the cell that is edited
	 * @param value String: String containing the cell's contents.
	 */
	public void setCell(int row, int col, String value){
		model.setValueAt(value, row, col);
	}
	
	/**
	 * returns the JTable of the view
	 * @return JTable
	 */
	public JTable getTable(){
		return table;
	}
	
	/**
	 * openFileChooser creates a JFrame for the JFileChooser, adds it and sets visible.
	 */
	public void openFileChooser(){
		fileChooserFrame = new JFrame();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
		fileChooser.setFileFilter(filter);
		fileChooserFrame.add(fileChooser);
		fileChooser.addActionListener(controller);
		fileChooserFrame.setSize(800, 500);
		fileChooserFrame.setVisible(true);
		
	}
	
	/**
	 * returns the amount of columns currently in the table.
	 */
	public int getColumnCount(){
		return table.getColumnCount();
	}
	
	/**
	 * returns the amount of rows currently in the table
	 */
	public int getRowCount(){
		return model.getRowCount();
	}
	
	/**
	 * Closes the file chooser's frame.
	 */
	public void closeFileChooser(){
		fileChooserFrame.dispose();
	}
	
	/**
	 * returns the file chooser
	 */
	public JFileChooser getFileChooser(){
		return fileChooser;
	}
	
}
