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
public class InsertionSort {
    
    public static ArrayList metodoInsertionSort(ArrayList array){
        ArrayList InsertionedList = new ArrayList();
        InsertionedList=(ArrayList) array.clone();
        int aux;
        int contador1;
        int contador2;        

        for(contador1=1; contador1<InsertionedList.size();contador1++){
            aux = (Integer)InsertionedList.get(contador1);
            for(contador2=contador1-1;contador2>=0 && (Integer)InsertionedList.get(contador2)>aux;contador2--){
                InsertionedList.set(contador2+1, InsertionedList.get(contador2) );
                InsertionedList.set(contador2, aux);
            }
        }
        return InsertionedList;
    }     
}
