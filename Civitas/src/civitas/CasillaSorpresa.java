package civitas;

import java.util.ArrayList;

public class CasillaSorpresa extends Casilla {
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;
    
    public CasillaSorpresa (String nombre, MazoSorpresas mazo) {
        super(nombre);
        this.mazo=mazo;
        this.sorpresa = null;
    }
    
    @Override
    void recibeJugador(int actual, ArrayList<Jugador> todos) {
        this.sorpresa = this.mazo.siguiente();
        this.informe(actual, todos);
        this.sorpresa.aplicarAJugador(actual, todos);       
    }
    
    @Override
    public String toString() {
        String info = "Casilla: " + this.getNombre() + " (Sorpresa).";
        return info;
    }
    
}
