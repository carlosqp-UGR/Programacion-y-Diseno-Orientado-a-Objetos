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
    private ArrayList<Integer> coleccion1;
    
    public Modelo() {
        generador=new Random();
        coleccion1=new ArrayList<>();
        coleccion1.add(PORDEFECTO);
        
    }

    public ArrayList<Integer> getColeccion1() {
        return coleccion1;
    }

    
    public void añadeElemento(Integer i) {
        coleccion1.add(i);
    }
    
    public void quitaUno() {
        if (coleccion1.size()>0) {
            int pos=generador.nextInt(coleccion1.size());
            coleccion1.remove(pos);
        }
    }
    
}
