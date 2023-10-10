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
public class Hotel {
    private static int NUM_HOTELES=0;
    private String nombre;
    private String ciudad;
    private int estrellas;
    private Director director;
    private ArrayList<Reserva> reservas;
    private ArrayList<Empleado> empleados;
    private ArrayList<Habitacion> habitaciones;
    
    public Hotel(String nombre, String ciudad, int estrellas) {
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.estrellas=estrellas;
        this.reservas=new ArrayList<>();
        this.empleados=new ArrayList<>();
        this.habitaciones=new ArrayList<>();
        Hotel.NUM_HOTELES++;
    }
    
    public static int getNUM_HOTELES() {
        return Hotel.NUM_HOTELES;
    }
        

    public void setDirector(Director director) {
        this.director=director;
    }
    
    public Director getDirector() {
        return this.director;
    }
    
    public void addReserva(Cliente cliente, String fechaEntrada, String fechaSalida) {
        Reserva r=new Reserva (fechaEntrada, fechaSalida, cliente, this);
        this.reservas.add(r);
        cliente.addReserva(r);
    }
    
    public ArrayList<Reserva> getReservas() {
        return this.reservas;
    }
    
    public ArrayList<Empleado> getEmpleados(){
        return this.empleados;
    }
    
    public boolean addEmpleado(Empleado empleado) {
        if (empleado.addTrabajo(this)) {
            this.empleados.add(empleado);
            return true;
        } else
            return false;
    }
  
/*  Version COMPOSICION
    public void addHabitacion(int numero, int capacidad) {
        this.habitaciones.add(new Habitacion(numero, capacidad));
    }
*/
    // Version AGREGACION
    public void addHabitacion(Habitacion h) {
        if (h.addHotel(this))
            this.habitaciones.add(h);
    }
    
    public int buscarHabitacionCapacidad(int capacidad) {
        int num_hab = -1;
        boolean encontrado=false;
        for (int i=0; i<this.habitaciones.size() && !encontrado; i++) {
            if(this.habitaciones.get(i).getCapacidad()>=capacidad) {
                num_hab = this.habitaciones.get(i).getNumero();
                encontrado=true;
            }
        }
        return num_hab;
    }
}
