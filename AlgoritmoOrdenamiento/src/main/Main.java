/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
    
        System.out.println("CREANDO EL ARRAYLIST");
        ArrayList<Integer> a = new ArrayList<>();
        System.out.println(a);
        
        System.out.println("LLENANDO EL ARRAYLIST");
        a.addFirst(100);
        a.addFirst(0);
        a.addFirst(1);
        a.addFirst(5);
        a.addFirst(80);
        a.addFirst(6);
        a.addFirst(200);
        a.addFirst(55);
        System.out.println(a);
        
        System.out.println("APLICANDO INSERTIONSORT");
        a.insertionSort();
        System.out.println(a);
    }
    
}
