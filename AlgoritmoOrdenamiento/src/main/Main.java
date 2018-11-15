/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import static model.tda.InsertionSort.metodoInsertionSort;
import static model.tda.MergeSort.metodoMergeSort;
import static model.tda.QuickSort.metodoQuickSort;
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
    
        System.out.println("CREANDO EL ARRAYLIST");
        ArrayList listaDesordenada = new ArrayList();
        ArrayList listaOrdenada = new ArrayList();
        System.out.println(listaDesordenada);
        
        System.out.println("LLENANDO EL ARRAYLIST");
        listaDesordenada.add(100);
        listaDesordenada.add(0);
        listaDesordenada.add(1);
        listaDesordenada.add(5);
        listaDesordenada.add(80);
        listaDesordenada.add(6);
        listaDesordenada.add(200);
        listaDesordenada.add(55);
        
        System.out.println(listaDesordenada);
        System.out.print("\n");
        
        System.out.println("APLICANDO INSERTIONSORT");
        listaOrdenada = metodoInsertionSort(listaDesordenada);
        System.out.println(listaOrdenada);
        
        System.out.println("APLICANDO QUICKSORT");
        listaOrdenada = metodoQuickSort(listaDesordenada, 0, listaDesordenada.size()-1);
        System.out.println(listaOrdenada);
        
        System.out.println("APLICANDO MERGESORT");
        listaOrdenada = metodoMergeSort(listaDesordenada);
        System.out.println(listaOrdenada);
        
    }
}
