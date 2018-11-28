/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NumberGenerator;
import model.tda.ArrayList;

/**
 *
 * @author rxsh96
 */
public class IOFile {
      
    public static final String FILEPATH = "files/";
    
    /**
     * Método que genera un archivo con números aleatorios línea por línea. 
     * Si el archivo no existe, crea uno y almacena en él números aleatorios.
     * En caso de que el archivo exista, concatena al final del archivo más números aleatorios.
     * @param filename, nombre del archivo.
     * @param ng, objeto NumberGenerator.
     * @return true si el archivo se crea, false en caso de que no se cree el archivo.
     */
    public static boolean generateFile(String filename, NumberGenerator ng){
        File file = new File(FILEPATH+filename);
        try {
            FileWriter writer;
            if (file.exists()){
                writer = new FileWriter(file, true);
            } 
            else{
                writer = new FileWriter(file);
            }
            try(PrintWriter printW = new PrintWriter(writer)){
                for (int i = 0; i < ng.getAmount(); i++) {
                    printW.println(ng.generateNumber());
                }
                writer.close();
            }
            return true;
        } 
        catch(IOException ex){
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Método que lee las líneas de un archivo y almacena el contenido en un ArrayList.
     * @param filename, nombre del archivo.
     * @param amount, cantidad de lineas que se va a leer. 
     * @return ArrayList de elementos del archivo.
     */
    public static ArrayList<Integer> readFile(String filename, int amount){
        File file = new File(FILEPATH+filename);
        ArrayList<Integer> array = null;
        if (!file.exists()) {
            System.out.println("FILE NOT FOUND");
            return array;
        }
        else{
            int fileLines = fileLines(file);
            if(fileLines < amount){
                amount = fileLines;
            }
            try (Scanner lector = new Scanner(file)){
                array = new ArrayList<>();
                for (int i = 0; i < amount; i++) {
                    array.addFirst(Integer.parseInt(lector.nextLine()));
                }
                lector.close();
            } 
            catch (FileNotFoundException ex){
                Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            return array;
        }
    }
    
    /**
     * Método que lee las líneas del archivo y almacena el contenido en un ArrayList.
     * @param filename, nombre del archivo.
     * @return ArrayList de elementos del archivo.
     */
    public static ArrayList<Integer> readFile(String filename){
        File file = new File(FILEPATH+filename);
        ArrayList<Integer> array = null;
        if (!file.exists()) {
            System.out.println("FILE NOT FOUND");
            return array;
        }
        else{
            try (Scanner lector = new Scanner(file)){
                array = new ArrayList<>();
                while(lector.hasNextLine()){
                    array.addFirst(Integer.parseInt(lector.nextLine()));
                }
                lector.close();
            } 
            catch (FileNotFoundException ex){
                Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            return array;
        }
    }
    
    /**
     * Determina la cantidad de líneas de un archivo
     * @param file, descriptor del archivo.
     * @return cantidad de líneas del archivo.
     */
    public static int fileLines(File file){
        int lineN = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.readLine() != null){
                lineN++;
            }
        } catch (IOException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineN;
    }
}
