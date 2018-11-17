/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;
import model.tda.ArrayList;

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
        Random r = new Random();
    
        System.out.println("============================================");
        System.out.println("Creando ArrayList INSERTION");
        ArrayList<Integer> insertion = new ArrayList<>();
        System.out.println(insertion);
        System.out.println("Ingresando Elementos Aleatorios al ArrayList INSERTION");
        for (int i = 0; i < 20; i++) {
            insertion.addFirst(r.nextInt(100));
        }
        System.out.println(insertion);
        System.out.println("Probando InsertionSort");
        insertion.insertionSort();
        System.out.println(insertion);
        System.out.println("============================================");
        System.out.println("");
        System.out.println("============================================");
        System.out.println("Creando ArrayList MERGE");
        ArrayList<Integer>  merge = new ArrayList<Integer>();
        System.out.println(merge);
        System.out.println("Ingresando Elementos Aleatorios al ArrayList MERGE");
        for (int i = 0; i < 20; i++) {
            merge.addFirst(r.nextInt(100));
        }
        System.out.println(merge);
        System.out.println("Probando MergeSort");
        merge.mergeSort();
        System.out.println(merge);
        System.out.println("============================================");
        System.out.println("");
        System.out.println("============================================");
        System.out.println("Creando ArrayList QUICK");
        ArrayList<Integer> quick = new ArrayList<>();
        System.out.println(quick);
        System.out.println("Ingresando Elementos Aleatorios al ArrayList QUICK");
        for (int i = 0; i < 20; i++) {
            quick.addFirst(r.nextInt(100));
        }
        System.out.println(quick);
        System.out.println("Probando QuickSort");
        quick.quickSort();
        System.out.println(quick);
        System.out.println("============================================");
        System.out.println("");
        System.out.println("============================================");
        System.out.println("Creando ArrayList STOOGE");
        ArrayList<Integer> stooge = new ArrayList<>();
        System.out.println(stooge);
        System.out.println("Ingresando Elementos Aleatorios al ArrayList STOOGE");
        for (int i = 0; i < 20; i++) {
            stooge.addFirst(r.nextInt(100));
        }
        System.out.println(stooge);
        System.out.println("Probando StoogeSort");
        stooge.stoogeSort();
        System.out.println(stooge);
        System.out.println("============================================");
        
    }
}
