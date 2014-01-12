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
	
	double[] data;
	String title;
	
	public Graph(double[] values, String title){
		this.data = values;
		this.title = title;
	}

	
	public JFreeChart createPieChart(boolean legend, boolean d3, String style, String[] names){
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
	              true //urls
	          );
	     }
	     else{
	    	 if(style.equals("ring")){
	    		 chart = ChartFactory.createRingChart(title, dataset, legend,              
	   	              true, //tooltips
	   	              true //urls
	   	              );
	    	 }else{
	    	 chart = ChartFactory.createPieChart(title, dataset, legend,               
		              true, //tooltips
		              false //urls
		          );
	    	 }	
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
	        return chart;
	}

	public void createBarChart(boolean legend, boolean d3, int rows, int columns, String[] series, String[] categories, String horizontalAxis, String verticalAxis, String orientation, boolean stacked){
		JFrame chartFrame = new JFrame();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int count = 0;
		//rows = series
		//cols = categories
		
		for(int row = 0; row <= rows; row++){
			for(int col = 0; col <= columns; col++){
				dataset.setValue(data[count], series[row], categories[col]);
				count++;
			}			
		}
		 JFreeChart chart = null;
		if(d3){
			if(stacked){
				chart = ChartFactory.createStackedBarChart3D(
			            title,         			       // chart title
			            horizontalAxis,               // domain axis label
			            verticalAxis,                  // range axis label
			            dataset,                  // data
			            orientation.equals("horizontal") ? PlotOrientation.HORIZONTAL : PlotOrientation.VERTICAL, // orientation
			            legend,                     // include legend
			            true,                     // tooltips?
			            false                     // URLs?
			        );
			}
			else{
				chart = ChartFactory.createBarChart3D(
			            title,         			       // chart title
			            horizontalAxis,               // domain axis label
			            verticalAxis,                  // range axis label
			            dataset,                  // data
			            orientation.equals("horizontal") ? PlotOrientation.HORIZONTAL : PlotOrientation.VERTICAL, // orientation
			            legend,                     // include legend
			            true,                     // tooltips?
			            false                     // URLs?
		        );
			}
		}
		else{
			if(stacked){
				chart = ChartFactory.createStackedBarChart(
			            title,         // chart title
			            horizontalAxis,               // domain axis label
			            verticalAxis,                  // range axis label
			            dataset,                  // data
			            orientation.equals("horizontal") ? PlotOrientation.HORIZONTAL : PlotOrientation.VERTICAL, // orientation
			            legend,                     // include legend
			            true,                     // tooltips?
			            false                     // URLs?
			       );
			}
			else{
				chart = ChartFactory.createBarChart(
			            title,         // chart title
			            horizontalAxis,               // domain axis label
			            verticalAxis,                  // range axis label
			            dataset,                  // data
			            orientation.equals("horizontal") ? PlotOrientation.HORIZONTAL : PlotOrientation.VERTICAL, // orientation
			            legend,                     // include legend
			            true,                     // tooltips?
			            false                     // URLs?
		        );
			}
		}
        JPanel panel = new ChartPanel(chart);
        chartFrame.add(panel);
        chartFrame.setSize(400, 400);
        chartFrame.setVisible(true);
	}
	
}
