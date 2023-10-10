/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosjava2;

/**
 *
 * @author carlosqp
 */
public class Habitacion {
    
    private int numero;
    private int capacidad;
    private Hotel hotel; // Por agregación, doble visibilidad
    
    public Habitacion(int numero, int capacidad) {
        this.numero=numero;
        this.capacidad=capacidad;
        this.hotel=null;
    }
    
    // Version AGREGACIÓN: doble visibilidad
    public Boolean addHotel(Hotel h){
        if (hotel==null) {
            this.hotel=h;
            return true;
        } else 
            return false;
    }
    
    public int getCapacidad() {
        return this.capacidad;
    }
    
    public int getNumero() {
        return this.numero;        
    }
}
