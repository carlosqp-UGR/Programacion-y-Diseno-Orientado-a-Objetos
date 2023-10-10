/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosjava2;

/**
 *
 * @author carlosqp
 */
public class EjerciciosJava2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // SESION 1
        
        /**
        * Prueba   la   clase   creando   dos   hoteles   diferentes   y   
        * mostrando   por   pantalla   el   número   de   hoteles creados 
        * consultando la variable NUM_HOTELES.
        */
       
       System.out.println("\nNumero de Hoteles:\t" +Hotel.getNUM_HOTELES());
       Hotel h1 = new Hotel ("Hotel1", "Almeria", 1);
       Hotel h2 = new Hotel ("Hotel2", "Granada", 2);
       System.out.println("Numero de Hoteles:\t" +Hotel.getNUM_HOTELES() + "\n");
       
       /**
        * Prueba la nueva implementación creando un objeto de la clase  Director
        * y asociándolo al primer hotel creado en el ejercicio 1; muestra un 
        * mensaje por pantalla con el nombre del director del primer hotel, 
        * teniendo en cuenta que debes partir del objeto de la clase  Hotel  
        * para recuperar la información.
        */
       
       Director dir = new Director ("Manolo", 670111999);
       h1.setDirector(dir);
       System.out.println("Director del Hotel 1:\t" + h1.getDirector().getNombre() + "\n");

       /**
        * Prueba la nueva implementación creando un cliente y una reserva de ese
        * cliente en el segundo hotel que creaste en el ejercicio 1; Luego 
        * recorre todas las reservas de este hotel y muestra por pantalla el 
        * nombre del cliente y la fecha de entrada de cada reserva (sólo habrá 
        * una); Luego recorre todas las reservas de ese cliente y muestra por 
        * pantalla la fecha de entrada de cada reserva (sólo habrá una).
        */ 
       String entrada = "2021.10.05";
       String salida = "2021.10.07";
       Cliente cliente = new Cliente ("00000000X", "Antonio");
       Reserva r1 = new Reserva (entrada, salida, cliente, h2);
       h2.addReserva(r1.getCliente(), r1.getFechaEntrada(), salida);
       
       System.out.println("Reservas Hotel 2:");
       for (int i=0; i<h2.getReservas().size(); i++)
           System.out.println("\tReserva " + i+1 + " ->\tNombre Cliente: " +
                               h2.getReservas().get(i).getCliente().getNombre() +
                               "\tFecha Entrada: " + h2.getReservas().get(i).getFechaEntrada());
       
       System.out.println("\nReservas cliente " + cliente.getNombre() + ":");
       for (int i=0; i<cliente.getReservas().size(); i++)
           System.out.println("\tReserva " + i+1 + " ->\tFecha Entrada: " + 
                              cliente.getReservas().get(i).getFechaEntrada());
       
       /**
        * Prueba sesion 1.
        */
       
       // SESION 2
       
       /**
        * Prueba la nueva implementación creando un empleado y añadiéndolo al 
        * primer hotel creado en la sesión anterior; Partiendo del objeto 
        * correspondiente a ese hotel, muestra por pantalla el número de 
        * empleados que tiene.
        */ 
       
       Empleado empleado = new Empleado("Juan");
       h1.addEmpleado(empleado);
       System.out.println("\nNumero empleados Hotel 1:\t" + h1.getEmpleados().size());
    
        /**
         * Para probar la nueva implementación debes añadir dos habitaciones, con 
         * capacidades diferentes, a uno de los dos hoteles que ya tienes creados y 
         * mostrar por pantalla el número de habitación con capacidad para un número
         * de huéspedes determinado (utilizando el método buscarHabitacionCapacidad).
         */
        
        Habitacion hab1=new Habitacion(202,2);// h1.addHabitacion(202, 2);
        Habitacion hab2=new Habitacion(121,4); // h1.addHabitacion(121, 4);
        
        h1.addHabitacion(hab1);    
        h1.addHabitacion(hab2);
        
        h2.addHabitacion(hab2);
        
        int num_huespedes=4;
        System.out.println("\nBuscando habitacion para " + num_huespedes + 
                           " huesped(es):\tHabitacion " + h1.buscarHabitacionCapacidad(num_huespedes));
    
    }
    
}
