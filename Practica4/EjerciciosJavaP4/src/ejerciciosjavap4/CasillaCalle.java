package ejerciciosjavap4;

// Clase hijo de Casilla: CasillaCalle ES UNA Casilla
public class CasillaCalle extends Casilla {
    private int numCasas;
    
    // Se deben de construir tanto los atributos propios como los heredados.
    public CasillaCalle(String nombre, int numCasas) {
        // Para construir los atributos heredados, en la primera línea del 
        // constructor del hijo se llama al constructor del padre con super().
        super(nombre);
        this.numCasas = numCasas;
    }
    
    @Override
    boolean recibeJugador() {
        // Reutilizando código del padre
        if (super.recibeJugador()) {
            System.out.println("\tY además soy una casilla calle.");
            return true;
        } else
            return false;
    }
    
    void construirCasa() {
        this.numCasas++;
        System.out.println("Número de casas: " + this.numCasas);
    }

}
