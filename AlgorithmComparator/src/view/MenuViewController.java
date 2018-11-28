/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Constants;
import model.NumberGenerator;
import model.io.IOFile;

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
    }
    
}
