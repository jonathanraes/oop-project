package Gui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Graph extends JFrame{
	
	String[] names;
	double[] data;
	String title;
	
	public Graph(String[] names, double[] values, String title){
		this.names = names;
		this.data = values;
		this.title = title;
	}

	
	public void createPieChart(boolean legend, boolean d3){
		JFrame chartFrame = new JFrame();
		 DefaultPieDataset dataset = new DefaultPieDataset();
	      for(int i = 0 ; i < data.length; i++){
	    	  try{
	    		  dataset.setValue(names[i], data[i]);
	    	  }
	    	  catch(ArrayIndexOutOfBoundsException e){
	    		  dataset.setValue("", data[i]);
	    	  }
	      }
	      JFreeChart chart = null;
	     if(d3){
	    	 chart = ChartFactory.createPieChart3D(title, dataset, legend,              
	              true, //tooltips
	              false //urls
	          );
	     }
	     else{
	    	 chart = ChartFactory.createPieChart(title, dataset, legend,               
		              true, //tooltips
		              false //urls
		          );
	     }
	     	PiePlot plot = (PiePlot) chart.getPlot();
	        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
	        plot.setNoDataMessage("No data available");
	        plot.setCircular(false);
	        plot.setLabelGap(0.02);
	        JPanel panel = new ChartPanel(chart);
	        chartFrame.add(panel);
	        chartFrame.setSize(400, 400);
	        chartFrame.setVisible(true);
	}

	public void createBarChart(int rows, int columns){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int count = 0;
		
		for(int row = 0; row < rows; row++){
			for(int col = 0; col < columns; col++){
				dataset.setValue(data[count], ""+row, ""+col);
				count++;
			}			
		}
		JFreeChart chart = ChartFactory.createBarChart(
		            title,         // chart title
		            "Category",               // domain axis label
		            "Value",                  // range axis label
		            dataset,                  // data
		            PlotOrientation.VERTICAL, // orientation
		            true,                     // include legend
		            true,                     // tooltips?
		            false                     // URLs?
		        );
		
	}
	
}
