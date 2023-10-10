/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosjava2;

/**
 *
 * @author carlosqp
 */
public class Reserva {
    
    private String fechaEntrada;
    private String fechaSalida;
    private Hotel hotel;
    private Cliente cliente;
    
    public Reserva (String fechaEntrada, String fechaSalida, Cliente cliente, Hotel hotel) {
        this.fechaEntrada=fechaEntrada; 
        this.fechaSalida=fechaSalida;
        this.cliente=cliente;
        this.hotel=hotel;
    }
    
    public String getFechaEntrada() {
        return this.fechaEntrada;
    }
    
    public String getFechaSalida() {
        return this.fechaSalida;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
}
