package civitas;
import java.util.ArrayList;

public abstract class Sorpresa {
    private String texto;
    private int valor;
    
    public Sorpresa(String texto, int valor) {
        this.texto = texto;
        this.valor = valor;
    }
    
    public String getTexto(){
        return this.texto;
    }
    
    public int getValor() {
        return this.valor;
    }
    
    public abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);

    void informe(int actual, ArrayList<Jugador> todos){
        String info= "Se esta aplicando una sorpresa (" + this.toString() + ") al jugador "+ actual + " (" + todos.get(actual).getNombre() + ")";
        Diario.getInstance().ocurreEvento(info);  
   
    }

    @Override
    public String toString(){  
        String info = "Valor: " + this.getValor() + ". Texto: '" + this.getTexto() + "'.";
        return info;
    }
}

/*
// ANTIGUA CLASE SORPRESA
public class Sorpresa {
    
    private String texto;
    private int valor;
    private TipoSorpresa tipo;

    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        switch(this.tipo) {
            case PAGARCOBRAR:
                this.aplicarAJugador_pagarCobrar(actual, todos);
                break;
            case PORCASAHOTEL:
                this.aplicarAJugador_porCasaHotel(actual, todos);
                break;
        }
    }
    
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        // PRE: 1<= todos.size() <=4 
        if(0<=actual && actual<=todos.size()) {
            this.informe(actual, todos);
            todos.get(actual).modificarSaldo(this.valor);
        }    
    }
    
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
        // PRE: 1<= todos.size() <=4 
        if(0<=actual && actual<=todos.size()) {
            this.informe(actual, todos);
            todos.get(actual).modificarSaldo(this.valor*todos.get(actual).cantidadCasasHoteles());
        }      
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        // PRE: 1<= todos.size <=4 
        if(0<actual && actual<=todos.size()) {
            String info= "Se esta aplicando una sorpresa al jugador "+ actual + " (" + todos.get(actual).getNombre() + ").";
            Diario.getInstance().ocurreEvento(info);  
        }    
    }
    
    Sorpresa(TipoSorpresa tipo, String texto, int valor){
        this.tipo=tipo;
        this.valor=valor;
        this.texto=texto;
    }
    
    @Override
    public String toString(){
        return this.texto;
    }
}
*/