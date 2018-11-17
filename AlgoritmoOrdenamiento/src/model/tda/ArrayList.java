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
    
    @Override
    public boolean addLast(E element) {
        if(element == null){
            return false;
        }
        else if(this.isEmpty() || efectivo < MAX){
            array[efectivo] = element;
            efectivo++;
            return true;
        }
        increaseCapacity(efectivo+1);
        return addLast(element);
    }
    
    private void increaseCapacity(int capacity){
        if(capacity > array.length){
            MAX *= 2;
            array = Arrays.copyOf(array, MAX);
        }
    }


    @Override
    public E getFirst() {
        if(isEmpty()){
            return null;
        }
        return array[0];
    }

    @Override
    public E getLast() {
        if(isEmpty()){
            return null;
        }
        return array[efectivo-1];
    }

    @Override
    public E get(int index) {
        if(isEmpty()){
            return null;
        }
        else if(index >= 0 && index <= efectivo-1){
            for(int i = 0 ; i < efectivo ; i++){
                if(i == index){
                    return array[i];
                }
            }
        }
        return null;
    }

    @Override
    public boolean contains(E element) {
        if(isEmpty()){
            return false;
        }
        for(int i = 0 ; i < efectivo ; i++){
            if(array[i] == element){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeFirst() {
        if(isEmpty()){
            return false;
        }
        for(int i = 0 ; i < efectivo ; i++){
            array[i] = array[i+1];
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if(isEmpty()){
            return false;
        }
        array[efectivo-1] = null;
        efectivo--;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if(isEmpty()){
            return false;
        }
        else if(index >= 0 && index < efectivo){
            for(int i = 0 ; i < efectivo-1 ; i++){
                if(i >= index){
                    array[i] = array[i+1];
                }
            }
            efectivo--;
            return true;
        }
        return false;
    }
    
    @Override
    public List<E> slicing(int inicio, int fin) {
        if(isEmpty()){
            return null;
        }
        else if(inicio >= 0 && fin < efectivo){
            List<E> newArray = new ArrayList<>();
            for(int i = inicio ; i < fin ; i++){
                newArray.addLast(array[i]);         
            }
            return newArray;
        }
        return null;
    }


    @Override
    public E set(int index, E element) {
        if(isEmpty()){
            return null;
        }
        else if(index >= 0 && index < efectivo){
            E temp = array[index];
            array[index] = element;
            return temp;
        }
        return null;
    }

    @Override
    public boolean add(int index, E element) {
        if(isEmpty()){
            return false;
        }
        else if(index >= 0 && index < efectivo){
            increaseCapacity(efectivo+1);
            for(int i = efectivo - 1 ; i >= index ; i--){
                array[i+1] = array[i];
                if(index == i){
                    array[index] = element;
                    break;
                }
            }
            efectivo++;
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(E element) {
        if(isEmpty()){
            return -1;
        }
        for(int i = 0 ; i < efectivo ; i++){
            if(array[i] == element){
                return i;
            }
        }
        return -1;
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
    
    //METODOS PARA INSERTIONSORT
    public void insertionSort(){
        Integer key;
        int j;
        for (int i = 1; i < efectivo; ++i) {
            key = (Integer)array[i];
            j = i-1;
            while (j >= 0 && (Integer)array[j] > key) {
                array[j+1] = array[j];
                j -= 1;
            }
            array[j+1] = (E)key;
        }
    }
    //FIN METODOS INSERTIONSORT
    
    //METODOS PARA MERGESORT
    public void mergeSort(){
        mergeSort(array, efectivo);
    }
    
    private void mergeSort(E[] a, int size){
        if (size < 2) {
            return;
        }
        int mid = size/2;
        Integer[] leftArray = new Integer[mid];
        Integer[] rigthArray = new Integer[size-mid];
        
        for (int i = 0; i < mid; i++) {
            leftArray[i] = (Integer)a[i];
        }
        for (int i = mid; i < size; i++) {
            rigthArray[i-mid] = (Integer)a[i];
        }
        mergeSort((E[])leftArray, mid);
        mergeSort((E[])rigthArray, size-mid);
        merge(a, (E[])leftArray, (E[])rigthArray, mid, size-mid);
    }
    
    private void merge(E[] original, E[] left, E[] rigth, int sizeLeft, int sizeRigth){
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < sizeLeft && j < sizeRigth) {
            if ((Integer)left[i] < (Integer)rigth[j]) {
                original[k++] = left[i++];
            }
            else{
                original[k++] = rigth[j++];
            }
        }
        
        while (i < sizeLeft) {
           original[k++] = left[i++];
        }
        
        while (j < sizeRigth) {
            original[k++] = rigth[j++];
        }
    }
    //FIN METODOS MERGESORT
    
    
    //METODOS QUICKSORT
    public void quickSort(){
        quickSort(array, 0, efectivo-1);
    }
    
    private void quickSort(E[] a, int first, int last){
        if(first < last){ 
            int partition = partition(a, first, last); 
            quickSort(a, first, partition-1); 
            quickSort(a, partition+1, last); 
        } 
    }
        
    int partition(E[] a, int first, int last){ 
        int pivot = (Integer)a[last];  
        int i = (first-1); 
        for (int j = first; j < last; j++){
            if ((Integer)a[j] <= pivot){ 
                i++;  
                E temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp; 
            } 
        } 
        E temp = a[i+1]; 
        a[i+1] = a[last]; 
        a[last] = temp; 
        return i+1; 
    }
    //FIN METODOS QUICKSORT
    
    //METODOS STOOGESORT
    public void stoogeSort(){
        stoogeSort(array, 0, efectivo-1);
    }
    
    private void stoogeSort(E[] a, int first, int last){
        if (first >= last) {
            return;
        }
        if ((Integer)a[first] > (Integer)a[last]) {
            E temp = a[first];
            a[first] = a[last];
            a[last] = temp;
        }
        if ((last - first + 1) > 2) {
            int temp = (last - first + 1)/3;
            stoogeSort(a, first, last - temp);
            stoogeSort(a, first + temp, last);
            stoogeSort(a, first, last - temp);
        }
    } 
    //FIN METODOS STOOGESORT
}
