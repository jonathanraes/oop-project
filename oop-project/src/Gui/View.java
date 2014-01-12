package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Controller.CellRenderer;
import Controller.ColorEditor;
import Controller.Controller;
import OOP.Spreadsheet;
/**
 * The View class contains all the items that relate to the GUI of the application. 
 * It contains all the methods that are used to build the complete GUI and all its components, 
 * including any methods to create separate dialogs such as the search frame and the graph creator.
 * Next to this it contains all the methods for setting and getting contents from the user interface.
 *
 */
public class View extends JFrame{
	private JMenuBar menubar;
	private JPanel tablePanel;
	private JPanel topPanel;
	private JTable table;
	private JTableHeader header;
	private JScrollPane pane;
	private DefaultTableModel model;
	private Controller controller;
	private ColorEditor colorEditor;
	private final String headers[];
	private JList rowHeader;
	private JFrame fileChooserFrame;
	private final JFileChooser fileChooser = new JFileChooser();
	
	//Graph Chooser window attributes
	private JTextField textfield;
	private JFrame graphchooserframe;
	private JPanel graphpanel;
	private JTextField columnNames;
	private JTextField rowNames;
	private JCheckBox includeLegend;
	private JCheckBox d3Graph;
	private JCheckBox stacked;
	private JTextField titlefield;
	private JTextField enternamefield;
	private JTextField fromcell;
	private JTextField untilcell;
	private JComboBox<String> graphlist;
	private JTextField namefield;
	private JTextField cellrange;
	private JButton ok;
	private JButton cancel;
	private JTextField xAxisName;
	private JTextField yAxisName;
	private JRadioButton horizontal;
	private JRadioButton vertical;	
	private JRadioButton ring;
	private JRadioButton pie;
	private JFrame searchframe;
	private JTextField searchfield;
	
	CellRenderer cellrenderer;
	public View(Spreadsheet spreadsheet){
//		cellrenderer = new CellRenderer();
		controller = new Controller(this, spreadsheet, cellrenderer);
		colorEditor = new ColorEditor(this);
		headers = new String[100000];
		setLayout(new BorderLayout());
		createTable();
		createPane();
		createColumnHeader();
		createRowHeader();
		createMenu();
		createTopPanel();
		createFileChooser();
		
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
//	Creation Methods----------------------------------------------------------------------------------------------
	
	/**
	 * createTopPanel creates a panel with a textfield and buttons to be displayed above the JTable.
	 * The textfield in the TopPanel is used for entering text and formulas in the table's cells.
	 * The buttons are used to set a cell's background color and to add additional rows and columns in the table
	 */
	public void createTopPanel(){
		JButton graph = new JButton("Graph");
		JButton colorbutton = new JButton("Set Color");
				
		textfield = new JTextField();
		topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
		colorbutton.setActionCommand("edit");
		colorbutton.setBorderPainted(false);
		graph.setBorderPainted(false);
		
		topPanel.add(textfield);
//		topPanel.add(colorbutton);
		topPanel.add(graph);
		add(topPanel, BorderLayout.NORTH);
//		colorbutton.addActionListener(colorEditor);
		graph.addActionListener(controller);
		textfield.getDocument().addDocumentListener(controller);
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
//		{
//			public TableCellRenderer getCellRenderer(int row, int column) {
//				return cellrenderer;
//			}
//		};
		table.setAutoCreateColumnsFromModel(false);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.setRowSelectionAllowed(true);
	    table.setCellSelectionEnabled(true);
	    table.setColumnSelectionAllowed(true);
	    tablePanel.add(table);
	    add(tablePanel);
	    
	    table.addHierarchyBoundsListener(controller);
	    table.addKeyListener(controller);
	    model.addTableModelListener(controller);
	    table.getSelectionModel().addListSelectionListener(controller);
	    table.getColumnModel().getSelectionModel().addListSelectionListener(controller);
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
		header.setBackground(new Color(95,170,246));
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
		editMenu.add(changecolor);
		
		open.setActionCommand("openfilechooser");
		open.addActionListener(controller);
		copy.addActionListener(controller);
		paste.addActionListener(controller);
		cut.addActionListener(controller);
		selectall.addActionListener(controller);
		find.addActionListener(controller);
		deletecontents.addActionListener(controller);
		save.addActionListener(controller);
	}
	
	/**
	 * createRowHeader creates a Row Header using an anonymous Abstract List Model and an array of strings representing the line numbers.
	 */
	public void createRowHeader(){
		for(int i = 0; i < model.getRowCount(); i++){
			headers[i] = "" + (i+1);
		}
		ListModel lm = new AbstractListModel() {
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
	}
	
//	Adding Methods----------------------------------------------------------------------------------------------------------------
	
	/**
	 * addColumns adds a new column object to the JTable passing in the table's current column as parameter to set the header correctly
	 */
	public void addColumns(){
		TableColumn col = new TableColumn(table.getColumnCount());
		table.addColumn(col);
	}
	
	/**
	 * addRows updates the table's model to add an extra row
	 */
	public void addRows(){
		model.setRowCount(model.getRowCount() + 1);
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
	
	//	Setters---------------------------------------------------------------------------------------------------------------------
	
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
	 * This sets the text for the Graph Name in the graph chooser window. 
	 * This is automatically set when a graph kind is chosen but can be edited.
	 * @param text String: Graph name
	 */
	public void setTextFieldText(String text){
		try{
			textfield.setText(text);
		}
		catch(IllegalStateException e){
			
		}
	}
	
	/**
	 * This deletes all cell's contents in the table.
	 */
	public void clearTable(){
		for (int row = 0; row < table.getRowCount(); row++) {
			for (int column = 0; column < table.getColumnCount(); column++) {
				table.setValueAt(null, row, column);				
			}
		}
	}
	
//	Getters---------------------------------------------------------------------------------------------------------------------

	/**
	 * returns the JTable of the view
	 * @return JTable
	 */
	public JTable getTable(){
		return table;
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
	 * returns the file chooser
	 */
	public JFileChooser getFileChooser(){
		return fileChooser;
	}
	
	/**
	 * Returns the TopPanel's JTextField
	 */
	public JTextField getTextField(){
		return textfield;
	}
	
	/**
	 * returns the DefaultTableModel
	 */
	public DefaultTableModel getModel(){
		return model;
	}
	
	/**
	 * returns the table's scrollpane.
	 */
	public JScrollPane getPane(){
		return pane;
	}
	
	/**
	 * Returns the current legend setting
	 */
	public boolean getLegendSetting(){
		return includeLegend.isSelected();
	}
	
	/**
	 * Returns the current 3D setting
	 */
	public boolean get3DSetting(){
		return d3Graph.isSelected();
	}
	
	/**
	 * Returns the String value for the graph's title
	 */
	public String getGraphTitle(){
		return enternamefield.getText();
	}
	
	/**
	 * Returns the cell to start parsing.
	 */
	public String getStartCell(){
		return fromcell.getText();
	}
	
	/**
	 * Returns the cell to end parsing.
	 */
	public String getEndCell(){
		return untilcell.getText();
	}
	
	/**
	 * Returns the current graph selected in the JComboBox
	 */
	public String getSelectedGraph(){
		return graphlist.getSelectedItem().toString();
	}
	
	/**
	 * Returns the value put in the textfield for column names.
	 */
	public String getColumnNames(){
		return columnNames.getText();
	}
	
	public String getRowNames(){
		return rowNames.getText();
	}
	
	public String getOrientation(){
		if(horizontal.isSelected()){
			return "horizontal";
		}
		else{
			return "vertical";
		}
	}
	
	public String getXAxisName(){
		return xAxisName.getText();
	}
	
	public String getYAxisName(){
		return yAxisName.getText();
	}
	
	public boolean getStackedSetting(){
		return stacked.isSelected();
	}
	
	public String getPieChartType(){
		if(pie.isSelected()){
			return "pie";
		}
		else{
			return "ring";
		}
	}
	
	public String getSearchText(){
		return searchfield.getText();
	}
	
//	Additional Windows-------------------------------------------------------------------------------------------
	
	/**
	 * This enables or disables the Checkbox to enable the creation of a 3D graph.
	 * This is used for situations when a 3D graph is impossible to create. 
	 * (for example when the RadioButton for creating a ring graph is enabled).
	 * @param enabled boolean
	 */
	public void enable3D(boolean enabled){
		if(enabled){
			d3Graph.setEnabled(true);
			graphpanel.repaint();
		}
		else{
			d3Graph.setSelected(false);
			d3Graph.setEnabled(false);
		}
	}
	
	/**
	 * openFileChooser creates a JFrame for the JFileChooser, adds it and sets visible.
	 */
	public void createFileChooser(){
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
		fileChooser.setFileFilter(filter);
		fileChooser.addActionListener(controller);
	}
	
	public void openFileSaver(){
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML Files", "xml");
		fileChooser.setFileFilter(filter);
		fileChooser.addActionListener(controller);
	}

	/**
	 * This used the JFrame's dispose method to close the graph chooser window.
	 */
	public void closeGraphChooser(){
		graphchooserframe.dispose();
	}
	
	/**
	 * This used the JFrame's dispose method to close the search window.
	 */
	public void closeSearchWindow(){
		searchframe.dispose();
	}
	
	/**
	 * This opens a small window allowing the user to search the Table for strings
	 */
	public void openSearchWindow(){
		searchframe = new JFrame("Search");
		searchframe.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		searchfield = new JTextField();
		JTextField search = new JTextField("What do you want to find?");
		search.setBorder(null);
		JButton find = new JButton("Find");
		find.setActionCommand("Search");
		JButton cancel = new JButton("Cancel");
		JButton next = new JButton("Next");
		JButton previous = new JButton("Previous");
		
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 1;
		constraints.gridwidth = 2;
		searchframe.add(search, constraints);
		constraints.gridy = 1;
		constraints.gridheight = 2;
		searchframe.add(searchfield, constraints);
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.gridy = 3;
		searchframe.add(cancel, constraints);
		constraints.gridx = 1;
		searchframe.add(find, constraints);
		constraints.gridy = 4;
		constraints.gridx = 0;
		searchframe.add(next, constraints);
		constraints.gridx = 1;
		searchframe.add(previous, constraints);
		
		searchframe.setSize(200, 120);
		searchframe.setVisible(true);
		find.addActionListener(controller);
		next.addActionListener(controller);
		previous.addActionListener(controller);
		cancel.addActionListener(controller);
	}
	
	/**
	 * This method creates the GraphChooser on its first run. It creates all the default components and adds them so this does
	 * not have to be done again when the window is reopened or reloaded.
	 */
	public void graphChooser(){
		graphchooserframe = new JFrame();
		graphpanel = new JPanel();
		graphpanel.setLayout(null);
		
		Font font = new Font("Arial", Font.BOLD, 18);
		titlefield = new JTextField();
		titlefield.setFont(font);
		titlefield.setText("What Graph would you like to make?");
		titlefield.setEditable(false);
		titlefield.setBackground(null);
		titlefield.setSize(500, 50);
		titlefield.setBorder(null);
		
		graphlist = new JComboBox<>();
		graphlist.addItem("Pie Chart");
		graphlist.addItem("Bar Chart");
		graphlist.addItem("Line Graph");
		graphlist.setSize(100, 45);
		graphlist.setBounds(0, 50, 485, 40);
		graphlist.addActionListener(controller);
		
		namefield = new JTextField("Enter the name of your graph:");
		namefield.setEditable(false);
		namefield.setBackground(null);
		namefield.setBorder(null);
		namefield.setBounds(0, 90, 485, 40);
		
		enternamefield = new JTextField();
		enternamefield.setBackground(null);
		enternamefield.setBounds(0, 130, 485, 40);
		
		cellrange = new JTextField("Enter range of cells to be in the graph:");
		cellrange.setEditable(false);
		cellrange.setBackground(null);
		cellrange.setBorder(null);
		cellrange.setBounds(0, 170, 485, 35);
		
		int [] columns = table.getSelectedColumns();
		int[] rows = table.getSelectedRows();
		
		fromcell = new JTextField();
		untilcell = new JTextField();
		try{
			char startcol = (char)(columns[0] + 'A');
			char endcol = (char)(columns[columns.length-1] + 'A');
			int startrow = rows[0]+1;
			int endrow = rows[rows.length-1]+1;
			fromcell.setText(startcol + "" +startrow + "");
			untilcell.setText(endcol +"" + endrow + "");
		}
		catch(IndexOutOfBoundsException e){
			
		}
		
		fromcell.setBackground(null);
		fromcell.setBounds(50, 210, 60, 40);
		
		untilcell.setBackground(null);
		untilcell.setBounds(130, 210, 60, 40);
		
		includeLegend = new JCheckBox("Include Legend");
		includeLegend.setBackground(null);
		includeLegend.setBounds(235, 205, 150, 15);
		
		d3Graph = new JCheckBox("3D");
		d3Graph.setBackground(null);
		d3Graph.setBounds(235, 220, 150, 25);
				
		ok = new JButton("OK");
		ok.setActionCommand("CreateGraph");
		ok.setBounds(414, 332, 70, 30);
		ok.addActionListener(controller);
		
		cancel = new JButton("Cancel");
		cancel.setActionCommand("CancelGraph");
		cancel.setBounds(300, 332, 80, 30);
		cancel.addActionListener(controller);
	}
	
	/**
	 * This method resets the graph chooser frame to account for any extra or less settings and or textfields that should be added if
	 * the selection in the JComboBox changes. It removes all components and adds the right ones.
	 */
	public void resetGraphChooser(){
		String graph = graphlist.getSelectedItem().toString();
		graphpanel.removeAll();
		
		JTextField enterColumnNames = null;
		columnNames = null;
		d3Graph.setEnabled(true);
		if(graph.equals("Pie Chart")){
			enterColumnNames = new JTextField("Please enter your column names seperated by a ;");
			enterColumnNames.setEditable(false);
			enterColumnNames.setBackground(null);
			enterColumnNames.setBorder(null);
			enterColumnNames.setBounds(0, 250, 485, 40);
	
			columnNames = new JTextField();
			columnNames.setBackground(null);
			columnNames.setBounds(0, 290, 485, 40);
			
			ok.setBounds(414, 332, 70, 30);
			cancel.setBounds(300, 332, 80, 30);
			graphpanel.setSize(500, 400);
			graphchooserframe.setSize(500, 400);
			
			pie = new JRadioButton("Pie");
			pie.setBackground(null);
			pie.setBounds(385, 205, 150, 15);
			pie.setSelected(true);
			pie.addActionListener(controller);
						
			ring = new JRadioButton("Ring");
			ring.setBackground(null);
			ring.setBounds(385, 220, 150, 15);
			ring.addActionListener(controller);
			
			ButtonGroup group = new ButtonGroup();
			group.add(pie);
			group.add(ring);
		}
		JTextField enterRowNames=null;
		JTextField enterXAxisName=null;
		JTextField enterYAxisName=null;
		if(graph.equals("Bar Chart")){
			enterRowNames = new JTextField("Please enter names for the series (for all the rows) seperated by a ;");
			enterRowNames.setEditable(false);
			enterRowNames.setBackground(null);
			enterRowNames.setBorder(null);
			enterRowNames.setBounds(0, 260, 485, 40);
	
			rowNames = new JTextField();
			rowNames.setBackground(null);
			rowNames.setBounds(0, 300, 485, 40);
			
			enterColumnNames = new JTextField("Please enter names for the categories (for all the columns) seperated by a ;");
			enterColumnNames.setEditable(false);
			enterColumnNames.setBackground(null);
			enterColumnNames.setBorder(null);
			enterColumnNames.setBounds(0, 350, 485, 40);
			
			columnNames = new JTextField();
			columnNames.setBackground(null);
			columnNames.setBounds(0, 390, 485, 40);
			
			enterXAxisName = new JTextField("Enter a name for the x-Axis");
			enterXAxisName.setEditable(false);
			enterXAxisName.setBackground(null);
			enterXAxisName.setBorder(null);
			enterXAxisName.setBounds(0, 430, 485, 40);
			
			xAxisName = new JTextField();
			xAxisName.setBackground(null);
			xAxisName.setBounds(0, 470, 485, 40);
			
			enterYAxisName = new JTextField("Enter a name for the y-Axis");
			enterYAxisName.setEditable(false);
			enterYAxisName.setBackground(null);
			enterYAxisName.setBorder(null);
			enterYAxisName.setBounds(0, 510, 485, 40);
			
			yAxisName = new JTextField();
			yAxisName.setBackground(null);
			yAxisName.setBounds(0, 550, 485, 40);
			
			horizontal = new JRadioButton("Horizontal");
			horizontal.setBackground(null);
			horizontal.setBounds(385, 205, 150, 15);
						
			vertical = new JRadioButton("Vertical");
			vertical.setBackground(null);
			vertical.setBounds(385, 220, 150, 15);
			vertical.setSelected(true);
			
			stacked = new JCheckBox("Stacked");
			stacked.setBackground(null);
			stacked.setBounds(235, 245, 150, 15);
			
			ButtonGroup group = new ButtonGroup();
			group.add(horizontal);
			group.add(vertical);
			
			ok.setBounds(414, 590, 70, 30);
			cancel.setBounds(300, 590, 80, 30);
			graphpanel.setSize(500, 655);
			graphchooserframe.setSize(500, 655);
		}
		enternamefield.setText("New " + graph);
		
		graphpanel.add(graphlist);
		graphpanel.add(titlefield);
		graphpanel.add(ok);
		graphpanel.add(cancel);
		graphpanel.add(namefield);
		graphpanel.add(enternamefield);
		graphpanel.add(cellrange);
		graphpanel.add(fromcell);
		graphpanel.add(untilcell);
		graphpanel.add(includeLegend);
		graphpanel.add(d3Graph);
		graphpanel.setBackground(Color.white);
		if(graph.equals("Pie Chart")){
			graphpanel.add(enterColumnNames);
			graphpanel.add(columnNames);
			graphpanel.add(pie);
			graphpanel.add(ring);
		}
		if(graph.equals("Bar Chart")){
			graphpanel.add(enterColumnNames);
			graphpanel.add(columnNames);
			graphpanel.add(enterRowNames);
			graphpanel.add(rowNames);
			graphpanel.add(xAxisName);
			graphpanel.add(enterXAxisName);
			graphpanel.add(yAxisName);
			graphpanel.add(enterYAxisName);
			graphpanel.add(horizontal);
			graphpanel.add(vertical);
			graphpanel.add(stacked);
		}
		graphchooserframe.add(graphpanel);
		graphchooserframe.setResizable(false);
		graphchooserframe.setVisible(true);
	}


}
