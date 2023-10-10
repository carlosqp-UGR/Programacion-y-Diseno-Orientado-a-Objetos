/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;


public class Modelo {
    private static final int PORDEFECTO=4;
    private Random generador;
    private ArrayList<Integer> coleccion1, coleccion2;
    
    public Modelo() {
        generador=new Random();
        coleccion1=new ArrayList<>();
        coleccion2=new ArrayList<>();
        this.añadeElemento1(PORDEFECTO);
        this.añadeElemento2(PORDEFECTO);
    }

    public ArrayList<Integer> getColeccion1() {
        return coleccion1;
    }
    
    public ArrayList<Integer> getColeccion2() {
        return coleccion2;
    }
    
    public void añadeElemento1(Integer i) {
        coleccion1.add(i);
        //coleccion2.add(i);
    }
    
    public void añadeElemento2(Integer i) {
//        coleccion1.add(i);
        coleccion2.add(i);
    }
    
    public void quitaUno() {
        if (coleccion1.size()>0) {
            int pos=generador.nextInt(coleccion1.size());
            coleccion1.remove(pos);
        }
    }
    
    public void resta() {
        int index = 0;
        for(int i:coleccion2) {
            coleccion2.set(index, i-1);
            index++;
        }
    }
    
}
