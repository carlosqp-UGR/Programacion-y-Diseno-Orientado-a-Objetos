package civitas;

import java.util.ArrayList;

public class SorpresaPorCasaHotel extends Sorpresa {
    
    public SorpresaPorCasaHotel(String texto, int valor) {
        super(texto, valor);
    }
    
    public void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        this.informe(actual, todos);
        todos.get(actual).modificarSaldo(this.getValor()*todos.get(actual).cantidadCasasHoteles());
    }
    
    @Override
    public String toString(){
        String info = super.toString() + " Tipo: PorCasaHotel.";
        return info;
    }
}
