/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosjava2;

import java.util.ArrayList;

/**
 *
 * @author carlosqp
 */
public class Empleado {
    
    private String nombre;
    private ArrayList<Hotel> trabaja;
    
    public Empleado(String nombre) {
        this.nombre=nombre;
        trabaja = new ArrayList<>();
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public boolean addTrabajo(Hotel hotel) {
        if (this.trabaja.size()<2) {
            this.trabaja.add(hotel);
            return true;
        } else
            return false;
    }
    
}
