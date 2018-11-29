/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Israel
 */
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

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
        "GRÁFICA",
        "Número de Elementos",
        "Tiempo(ns)",
        dataset,
        PlotOrientation.VERTICAL,
        true, true, false);

    // Create Panel
    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }
}
