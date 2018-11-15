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
public class MergeSort {
    
    public static ArrayList metodoMergeSort(ArrayList array){
        if(array.size() <= 1){
            return array;
        }
            ArrayList MergedList = new ArrayList();

            ArrayList izq = new ArrayList();
            ArrayList der = new ArrayList();
            int medio = array.size()/2;
            //Splits the array into unsortedList size lists of size one
            for(int i = 0; i < array.size(); i++){
                if(i < medio){
                    izq.add(array.get(i));
                }else{
                    der.add(array.get(i));
                }
            }
            izq = metodoMergeSort(izq); 
            der = metodoMergeSort(der);
            //combines the lists
            MergedList = merge(izq, der);
            return MergedList;
    }
    public static ArrayList merge(ArrayList izq, ArrayList der)
    {
            ArrayList subArreglo = new ArrayList();
            while(izq.size() > 0 || der.size() > 0)
            {
                    if(izq.size() > 0 && der.size() > 0)
                    {
                            if((Integer)izq.get(0) < (Integer)der.get(0))
                            {
                                    subArreglo.add(izq.get(0));
                                    izq.remove(0);
                            }
                            else
                            {
                                    subArreglo.add(der.get(0));
                                    der.remove(0);
                            }
                    }
                    else if(izq.size() > 0)
                    {
                            subArreglo.add(izq.get(0));
                            izq.remove(0);
                    }
                    else if(der.size() > 0)
                    {
                            subArreglo.add(der.get(0));
                            der.remove(0);
                    }
            }
            return subArreglo;
    }   
}
