/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Israel
 */
public class XYLineChart extends JFrame{
    private static final long serialVersionUID = 6294689542092367723L;

  public XYLineChart(String title, XYDataset data) {
    super(title);

    // Create dataset
    XYDataset dataset = data;

    // Create chart
    JFreeChart chart = ChartFactory.createXYLineChart(
        "Gráfica",
        "Número de Elementos",
        "Tiempo(ns)",
        dataset,
        PlotOrientation.VERTICAL,
        true, true, false);

    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private XYDataset createDataset() {
    XYSeriesCollection dataset = new XYSeriesCollection();

    XYSeries series = new XYSeries("Y = X + 2");
    series.add(2, 4);
    series.add(8, 10);
    series.add(10, 12);
    series.add(13, 15);
    series.add(17, 19);
    series.add(18, 20);
    series.add(21, 23);

    //Add series to dataset
    dataset.addSeries(series);
    
    return dataset;
  } 
}
