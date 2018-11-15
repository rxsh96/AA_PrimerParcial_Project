/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tda;

import java.util.ArrayList;

/**
 *
 * @author Israel
 */
public class QuickSort {
    
    public static ArrayList metodoQuickSort(ArrayList array,int izq, int der){
        ArrayList QuickedList = new ArrayList();
        QuickedList=(ArrayList) array.clone();
        int i=izq;
        int d=der;
        try{
            if(izq!=der){
                int pivote;
                int aux;
                pivote=izq;
                while(izq!=der){
                    while(((Integer)QuickedList.get(der)>=(Integer)QuickedList.get(pivote))&&izq<der){
                        der--;                   
                        while((Integer)QuickedList.get(izq)<(Integer)QuickedList.get(pivote) && izq<der){
                            izq++;
                        }
                    }
                    if(der!=izq){
                        aux=(Integer)QuickedList.get(der);
                        QuickedList.set(der, QuickedList.get(izq));
                        QuickedList.set(izq, aux);
                    }
                    if(izq==der){
                        //QuickSort(array,i,izq);
                        metodoQuickSort(QuickedList,i+1,d);
                    }
                }            
            } 
        }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Error");
        }
        return QuickedList;
    }
}
