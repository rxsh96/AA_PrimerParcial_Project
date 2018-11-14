/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tda;

import java.util.Arrays;

/**
 *
 * @author rxsh96
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
    
    private E[] array;
    private int efectivo;
    private int MAX = 10;

    public ArrayList(){
        array = (E[]) new Object[MAX];
        efectivo = 0;
    }
    
    public ArrayList(int initialCapacity){
        MAX = initialCapacity;
        array = (E[]) new Object[MAX];
        efectivo = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return efectivo == 0;
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean addFirst(E element) {
        if(element == null){
            System.out.println("Ingreso no valido!");
            return false;
        }
        else if(this.isEmpty()){
            array[efectivo] = element;
            efectivo++;
            return true;
        }
        else if(efectivo < MAX){
            for(int i = efectivo - 1 ; i >= 0 ; i--){
                array[i+1] = array[i];
            }
            array[0] = element;
            efectivo++;
            return true;
        }
        increaseCapacity(efectivo+1);
        return addFirst(element);
    }  
    
    
    private void increaseCapacity(int capacity){
        if(capacity > array.length){
            MAX *= 2;
            array = Arrays.copyOf(array, MAX);
        }
    }
    
    
    @Override
    public String toString(){
        String elements = "[";
        for(int i = 0 ; i < efectivo ; i++){
            if(i == efectivo - 1){
                elements += array[i];
            }
            else{
                elements += array[i]+",";
            }
        }
        elements += "]";
        return elements;
    }
    
    public void insertionSort(){
        Integer key;
        int j;
        Integer element;
        for (int i = 1; i < efectivo; i++) {
            key = (Integer)array[i];
            j = i-1;
            element = (Integer)array[j];
            while (j >= 0 && element > key) {
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = (E)key;
        }
    }
    
}
