package civitas;

import java.util.ArrayList;

public class SorpresaPagarCobrar extends Sorpresa {
    
    public SorpresaPagarCobrar(String texto, int valor) {
        super(texto, valor);
    }
    
    public void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        this.informe(actual, todos);
        todos.get(actual).modificarSaldo(this.getValor());
    }
    
    @Override
    public String toString(){
        String info = super.toString() + " Tipo: PagarCobrar.";
        return info;
    }
}
