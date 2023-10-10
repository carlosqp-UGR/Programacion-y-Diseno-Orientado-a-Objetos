/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosjava2;

/**
 *
 * @author carlosqp
 */
public class Director {
    private String nombre;
    private long telefono;
    
    public Director(String nombre, long telefono) {
        this.nombre=nombre;
        this.telefono=telefono;
    }
    
    public String getNombre() {
        return this.nombre;
    }

}
