/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import model.NumberGenerator;
import model.XYLineChart;
import model.io.IOFile;
import model.tda.ArrayList;
import model.XYLineChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author rxsh96
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Random r = new Random();
//    
//        System.out.println("============================================");
//        System.out.println("Creando ArrayList INSERTION");
//        ArrayList<Integer> insertion = new ArrayList<>();
//        System.out.println(insertion);
//        System.out.println("Ingresando Elementos Aleatorios al ArrayList INSERTION");
//        for (int i = 0; i < 20; i++) {
//            insertion.addFirst(r.nextInt(100));
//        }
//        System.out.println(insertion);
//        System.out.println("Probando InsertionSort");
//        insertion.insertionSort();
//        System.out.println(insertion);
//        System.out.println("============================================");
//        System.out.println("");
//        System.out.println("============================================");
//        System.out.println("Creando ArrayList MERGE");
//        ArrayList<Integer>  merge = new ArrayList<>();
//        System.out.println(merge);
//        System.out.println("Ingresando Elementos Aleatorios al ArrayList MERGE");
//        for (int i = 0; i < 20; i++) {
//            merge.addFirst(r.nextInt(100));
//        }
//        System.out.println(merge);
//        System.out.println("Probando MergeSort");
//        merge.mergeSort();
//        System.out.println(merge);
//        System.out.println("============================================");
//        System.out.println("");
//        System.out.println("============================================");
//        System.out.println("Creando ArrayList QUICK");
//        ArrayList<Integer> quick = new ArrayList<>();
//        System.out.println(quick);
//        System.out.println("Ingresando Elementos Aleatorios al ArrayList QUICK");
//        for (int i = 0; i < 20; i++) {
//            quick.addFirst(r.nextInt(100));
//        }
//        System.out.println(quick);
//        System.out.println("Probando QuickSort");
//        quick.quickSort();
//        System.out.println(quick);
//        System.out.println("============================================");
//        System.out.println("");
//        System.out.println("============================================");
//        System.out.println("Creando ArrayList STOOGE");
//        ArrayList<Integer> stooge = new ArrayList<>();
//        System.out.println(stooge);
//        System.out.println("Ingresando Elementos Aleatorios al ArrayList STOOGE");
//        for (int i = 0; i < 20; i++) {
//            stooge.addFirst(r.nextInt(100));
//        }
//        System.out.println(stooge);
//        System.out.println("Probando StoogeSort");
//        stooge.stoogeSort();
//        System.out.println(stooge);
//        System.out.println("============================================");
        
        //Carga en archivo txt con los números
        /////////////////////////////////////////////////////////////////
        ArrayList<Integer> listaDesordenada = new ArrayList<>();
        ArrayList<Integer> listaParaInsertion = new ArrayList<>();
        ArrayList<Integer> listaParaQuick = new ArrayList<>();
        ArrayList<Integer> listaParaMerge = new ArrayList<>();
        ArrayList<Integer> listaParaStooge = new ArrayList<>();

        int numeroEntero;
        File f = new File("C:\\Users\\Israel\\Desktop\\numeros.txt");

        try  (Scanner entrada = new Scanner(f)) {
            while (entrada.hasNextInt()) {
                numeroEntero = entrada.nextInt(); 
                listaDesordenada.addLast(numeroEntero);
                listaParaInsertion.addLast(numeroEntero);
                listaParaQuick.addLast(numeroEntero);
                listaParaMerge.addLast(numeroEntero);
                listaParaStooge.addLast(numeroEntero);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        /////////////////////////////////////////////////////////////////
        
        //Creando la grafica y los planos XY
        /////////////////////////////////////////////////////////////////
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries insertion = new XYSeries("InsertionSort");
        XYSeries quick = new XYSeries("QuickSort");
        XYSeries merge = new XYSeries("MergeSort");
        //XYSeries stooge = new XYSeries("StoogeSort");
        
        long TInicioIns, TFinIns, tiempoIns;
        long TInicioQui, TFinQui, tiempoQui;
        long TInicioMer, TFinMer, tiempoMer;
        //long TInicioSto, TFinSto, tiempoSto;
        
        
        for(int nelement =1; nelement <= listaDesordenada.size(); nelement++){;
            TInicioIns = System.nanoTime();
            listaParaInsertion.insertionSort();
            TFinIns = System.nanoTime();
            tiempoIns = TFinIns - TInicioIns;
            insertion.add(nelement,tiempoIns);
            
            TInicioQui = System.nanoTime();
            listaParaQuick.quickSort();
            TFinQui = System.nanoTime();
            tiempoQui = TFinQui - TInicioQui;
            quick.add(nelement,tiempoQui);
            
            TInicioMer = System.nanoTime();
            listaParaMerge.mergeSort();
            TFinMer = System.nanoTime();
            tiempoMer = TFinMer - TInicioMer;
            merge.add(nelement,tiempoMer);
            
//            TInicioSto = System.nanoTime();
//            listaParaStooge.stoogeSort();
//            TFinSto = System.nanoTime();
//            tiempoSto = TFinSto - TInicioSto;
//            stooge.add(nelement,tiempoSto);
        }
        
        dataset.addSeries(insertion);
        dataset.addSeries(quick);
        dataset.addSeries(merge);
        //dataset.addSeries(stooge);
        
        SwingUtilities.invokeLater(() -> {
        XYLineChart grafica = new XYLineChart("Gráfica", dataset);
        grafica.setSize(1000, 600);
        grafica.setLocationRelativeTo(null);
        grafica.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        grafica.setVisible(true);
        });
        /////////////////////////////////////////////////////////////////

      
//        System.out.println("PROBANDO EL RANDOM");
//        
//        System.out.println("PROBANDO EL METODO PARA LA CREACION Y ESCRITURA DE FILES");
//        NumberGenerator ng1 = new NumberGenerator(); //ALEATORIOS ENTRE 0 - 100 -> 10 ELEMENTOS
//        NumberGenerator ng2 = new NumberGenerator(100,200); //ALEATORIOS ENTRE 100 - 200 -> 10 ELEMENTOS
//        NumberGenerator ng3 = new NumberGenerator(100,200,20);//ALEATORIOS ENTRE 100 - 200 -> 20 ELEMENTOS
//        IOFile.generateFile("prueba1.txt", ng1);
//        IOFile.generateFile("prueba2.txt", ng2);
//        IOFile.generateFile("prueba3.txt", ng3);
//        
//        System.out.println("PROBANDO EL METODO PARA LA LECTURA DEL ARCHIVO");
//        ArrayList<Integer> array1 = IOFile.readFile("prueba1.txt"); //GUARDO TODAS LAS LINEAS DEL ARCHIVO EN EL ARRAY
//        ArrayList<Integer> array2 = IOFile.readFile("prueba2.txt", 5); //GUARDO LAS PRIMERAS 5 LINEAS DEL ARCHIVO EN EL ARRAY
//        ArrayList<Integer> array3 = IOFile.readFile("prueba3.txt", 14); //GUARDO LAS PRIMERAS 14 LINEAS DEL ARCHIVO EN EL ARRAY
//        ArrayList<Integer> array4 = IOFile.readFile("prueba3.txt", 15); //GUARDO LAS PRIMERAS 15 ...
//        ArrayList<Integer> array5 = IOFile.readFile("prueba3.txt", 60); //COMO 60 > A LA CANTIDAD DE ELEMENTOS DEL ARRAY, SIMPLEMENTE SE GUARDAN TODOS LOS ELEMENTOS DEL ARCHIVO AL ARRAY
//        
//        //ARCHIVOS QUE NO EXISTEN
//        ArrayList<Integer> array6 = IOFile.readFile("prueba100.txt");
//        ArrayList<Integer> array7 = IOFile.readFile("prueba1100.txt", 50);
//        
//        System.out.println(array1);
//        System.out.println(array2);
//        System.out.println(array3);
//        System.out.println(array4);
//        System.out.println(array5);
//        System.out.println(array6);
//        System.out.println(array7);
//        
    }
}
