/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author rxsh96
 */
public class NumberGenerator {
 
    private int min;
    private int max;
    private int amount;
    private Random r;
    
    /**
     * Constructor por defecto. Setea los atributos para que se generen 10 números aleatorios entre 0 y 100.
     */
    public NumberGenerator(){
        min = 0;
        max = 100;
        amount = 10;
        r = new Random();
    }
    
    /**
     * Constructor. Setea los atributos para que se generen 10 números aleatorios entre un valor mínimo y máximo.
     * @param min, valor mínimo.
     * @param max, valor máximo.
     */
    public NumberGenerator(int min, int max){
        this.min = min;
        this.max = max;
        amount = 10;
        r = new Random();
    }
    
    /**
     * Constructor. Setea los atributos para que se generen n números aleatorios entre un valor mínimo y máximo.
     * @param min, valor mínimo.
     * @param max, valor máximo.
     * @param amount, cantidad de números a generar.
     */
    public NumberGenerator(int min, int max, int amount){
        this.min = min;
        this.max = max;
        this.amount = amount;
        r = new Random();
    }
    
    /**
     * Método que genera números aleatorios considerando los atributos del objeto.
     * @return un número aleatorio.
     */
    public int generateNumber(){
        return r.nextInt((max-min)+1)+min;
    }
    
    public int getAmount(){
        return amount;
    }
       
}
