/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import model.Constants;
import model.NumberGenerator;
import model.XYLineChart;
import model.io.IOFile;
import model.tda.ArrayList;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * FXML Controller class
 *
 * @author rxsh96
 */
public class MenuViewController implements Initializable {

    @FXML
    private AnchorPane pMenu;
    @FXML
    private AnchorPane pAlgorithm;
    @FXML
    private AnchorPane pSummary;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton bHome;
    @FXML
    private JFXButton bSelectAlgorithm;
    @FXML
    private JFXButton bGenerateData;
    @FXML
    private JFXButton bSelectData;
    @FXML
    private JFXButton bSummary;
    @FXML
    private JFXButton bExit;
    @FXML
    private AnchorPane pHome;
    @FXML
    private AnchorPane pSelectData;
    @FXML
    private JFXButton bSelectFile;
    @FXML
    private JFXTextField tElementNumber;
    @FXML
    private JFXButton bShowGraphic;
    @FXML
    private JFXCheckBox cbInsertionSort;
    @FXML
    private JFXCheckBox cbMergeSort;
    @FXML
    private JFXCheckBox cbQuickSort;
    @FXML
    private JFXCheckBox cbStoogeSort;
    @FXML
    private AnchorPane pGenerateData;
    @FXML
    private JFXTextField tGenerateFileName;
    @FXML
    private JFXTextField tSince;
    @FXML
    private JFXTextField tUntil;
    @FXML
    private JFXTextField tGenerateElementNumbers;
    @FXML
    private JFXButton bGenerateFile;
    @FXML
    private Label lGenerateMessage;
    @FXML
    private Label lSelectFileMessage;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event){
        if (event.getSource() == bHome) {
            pHome.toFront();
        }
        else if(event.getSource() == bSelectAlgorithm){
            pAlgorithm.toFront();
        }
        else if(event.getSource() == bGenerateData){
            pGenerateData.toFront();
        }
        else if(event.getSource() == bSelectData){
            pSelectData.toFront();
        }
        else if(event.getSource() == bSummary){
            pSummary.toFront();
        }
        else if(event.getSource() == bExit){
            System.exit(0);
        }
    }
    

    @FXML
    private void fileChooser(ActionEvent event) {
        Window mainStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        if (selectedFile != null) {
            lSelectFileMessage.setText(selectedFile.toString());
        }
        else{
            lGenerateMessage.setText(Constants.LOADFILE_FAIL);
        }
    }


    @FXML
    private void generateFile(ActionEvent event){
        
        int since = Integer.parseInt(tSince.getText());
        int until = Integer.parseInt(tUntil.getText());
        int elementNumber = Integer.parseInt(tGenerateElementNumbers.getText());
        NumberGenerator ng = new NumberGenerator(since, until, elementNumber);
        boolean fileStatus = IOFile.generateFile(tGenerateFileName.getText(), ng);
        if (fileStatus) {
            lGenerateMessage.setText(Constants.FILE_GOOD);
        }
        else{
            lGenerateMessage.setText(Constants.FILE_ERROR);
        }
    }

    @FXML
    private void showGraphic(ActionEvent event) {
        
        //CARGAR ARCHIVO EN UN ARRAYLIST
        ArrayList<Integer> listaDesordenada = new ArrayList<>();
        ArrayList<Integer> listaAUsar = new ArrayList<>();

        int numeroEntero;
        File f = new File(lSelectFileMessage.getText());

        try  (Scanner entrada = new Scanner(f)) {
            while (entrada.hasNextInt()) {
                numeroEntero = entrada.nextInt(); 
                listaDesordenada.addLast(numeroEntero);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
       
        //FIN DE CARGAR ARCHIVO EN UN ARRAYLIST
        
        //CREACIÓN LAS COORDENADAS XY Y APLICANDO ALGORITMOS
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries insertion = new XYSeries("InsertionSort");
        XYSeries quick = new XYSeries("QuickSort");
        XYSeries merge = new XYSeries("MergeSort");
        XYSeries stooge = new XYSeries("StoogeSort");
        
        long TInicioIns=0, TFinIns=0, tiempoIns=0;
        long TInicioQui=0, TFinQui=0, tiempoQui=0;
        long TInicioMer=0, TFinMer=0, tiempoMer=0;
        long TInicioSto=0, TFinSto=0, tiempoSto=0;
        
        int tamanoAUsar;
        
        if ("".equals(tElementNumber.getText())){
            tamanoAUsar = listaDesordenada.size();
        }else if(Integer.parseInt(tElementNumber.getText())<0 || Integer.parseInt(tElementNumber.getText())>listaDesordenada.size()){
            tamanoAUsar = listaDesordenada.size();
        }else{
            tamanoAUsar = Integer.parseInt(tElementNumber.getText());
        }
        
        for(int nelement =10; nelement <= tamanoAUsar; nelement+=10){;
            if(cbInsertionSort.isSelected()){
                listaAUsar = listaDesordenada.slicing(0,nelement-1);
                TInicioIns = System.nanoTime();
                listaAUsar.insertionSort();
                TFinIns = System.nanoTime();
                tiempoIns = TFinIns - TInicioIns;
                insertion.add(nelement,tiempoIns);
            }
            if(cbQuickSort.isSelected()){
                listaAUsar = listaDesordenada.slicing(0,nelement-1);
                TInicioQui = System.nanoTime();
                listaAUsar.quickSort();
                TFinQui = System.nanoTime();
                tiempoQui = TFinQui - TInicioQui;
                quick.add(nelement,tiempoQui);
            }
            if(cbMergeSort.isSelected()){
                listaAUsar = listaDesordenada.slicing(0,nelement-1);
                TInicioMer = System.nanoTime();
                listaAUsar.mergeSort();
                TFinMer = System.nanoTime();
                tiempoMer = TFinMer - TInicioMer;
                merge.add(nelement,tiempoMer);
            }
            if(cbStoogeSort.isSelected()){
                listaAUsar = listaDesordenada.slicing(0,nelement-1);
                TInicioSto = System.nanoTime();
                listaAUsar.stoogeSort();
                TFinSto = System.nanoTime();
                tiempoSto = TFinSto - TInicioSto;
                stooge.add(nelement,tiempoSto);
            }
            double t1 = TimeUnit.MILLISECONDS.convert(tiempoIns, TimeUnit.NANOSECONDS);  
            double t2 = TimeUnit.MILLISECONDS.convert(tiempoQui, TimeUnit.NANOSECONDS);  
            double t3 = TimeUnit.MILLISECONDS.convert(tiempoMer, TimeUnit.NANOSECONDS);  
            double t4 = TimeUnit.MILLISECONDS.convert(tiempoSto, TimeUnit.NANOSECONDS);  
            IOFile.generateScore(tamanoAUsar, nelement,t1,t2,t3,t4);
        }
        
        dataset.addSeries(insertion);
        dataset.addSeries(quick);
        dataset.addSeries(merge);
        dataset.addSeries(stooge);
        
        SwingUtilities.invokeLater(() -> {
        XYLineChart grafica = new XYLineChart("Gráfica", dataset);
        grafica.setSize(1000, 600);
        grafica.setLocationRelativeTo(null);
        grafica.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        grafica.setVisible(true);
        });
    }
    //FIN CREACIÓN LAS COORDENADAS XY Y APLICANDO ALGORITMOS
}
