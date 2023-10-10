package ejerciciosjavap4;

// Clase padre
public class Casilla {
    private String nombre;
    
    public Casilla(String nombre){
        this.nombre=nombre;
    }
    
    boolean recibeJugador() {
        System.out.println("He recibido un jugador.");
        return true;
    }
}
