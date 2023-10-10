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
public class Cliente {
    
    private String dni;
    private String nombre;
    private ArrayList<Reserva> reservas;
    
    public Cliente(String dni, String nombre){
        this.dni=dni;
        this.nombre=nombre;
        this.reservas= new ArrayList<> ();
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public ArrayList<Reserva> getReservas() {
        return this.reservas;
    }
    
    public void addReserva(Reserva nueva) {
        this.reservas.add(nueva);
    }
    
}
