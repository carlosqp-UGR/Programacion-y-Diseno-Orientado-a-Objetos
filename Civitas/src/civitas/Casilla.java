package civitas;
import java.util.ArrayList;

public class Casilla {
    private String nombre;

    public Casilla(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    @Override
    public String toString() {
        String info = "Casilla: " + this.getNombre() + " (Descanso).";
        return info;
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        // PRE: 1<= todos.size <=4 
        if(0<=actual && actual<=todos.size()) {
            String info="Jugador " + actual + " (" + todos.get(actual).getNombre() +
                        ") pasa por " + this.toString();    
            Diario.getInstance().ocurreEvento(info);  
        }
    }
    
    void recibeJugador(int actual, ArrayList<Jugador> todos) {
        this.informe(actual, todos);
    }
    
}

/**
// CASILLA ANTIGUO
public class Casilla {

    private static final float FACTORALQUILERCALLE = 1;
    private static final float FACTORALQUILERCASA = 1;
    private static final float FACTORALQUILERHOTEL = 4;
    

    private String nombre;
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private int numCasas;
    private int numHoteles;
    private Jugador propietario;
    private TipoCasilla tipo;
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;
    
    public int cantidadCasasHoteles() {
        return this.numCasas+this.numHoteles;
    }
    
    Casilla(TipoCasilla tipo, String nombre) {
        this.init();
        this.tipo=tipo;
        this.nombre=nombre;
    }
    
    Casilla(TipoCasilla unTipo, String unNombre, float unPrecioCompra, 
            float unPrecioEdificar, float unPrecioAlquilerBase) {
        this.init();
        this.tipo=unTipo.CALLE;
        this.nombre=unNombre;
        this.precioCompra=unPrecioCompra;
        this.precioEdificar=unPrecioEdificar;
        this.precioBaseAlquiler=unPrecioAlquilerBase;
    }
    
    Casilla(TipoCasilla tipo, String nombre, MazoSorpresas mazo) {
        this.init();
        this.tipo=tipo.SORPRESA;
        this.nombre=nombre;
        this.mazo=mazo;
    }
    
    boolean comprar(Jugador jugador) {
        this.propietario = jugador;
        return this.propietario.paga(this.getPrecioCompra());
    }
    
    boolean construirCasa(Jugador jugador) {
        boolean result = jugador.paga(this.precioEdificar);
        
        if (result)
            numCasas++;
        return result;
    }
    
    // ¿? Parámetro jugador
    boolean construirHotel(Jugador jugador) {
        this.propietario.paga(this.precioEdificar);
        this.numHoteles++;
        return true;
    }
    
    boolean derruirCasas(int numero, Jugador jugador) {
        boolean realizaOperacion= this.esEsteElPropietario(jugador) && this.numCasas>=numero;
        if (realizaOperacion)
            this.numCasas-=numero;
        return realizaOperacion;
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        return (this.propietario==jugador);
    }
    
    int getNumCasas() {
        return this.numCasas;
    }
    
    int getNumHoteles() {
        return this.numHoteles;
    }
    
    float getPrecioAlquilerCompleto() {
        float precioAlquilerCompleto=this.precioBaseAlquiler*(Casilla.FACTORALQUILERCALLE
                                     +Casilla.FACTORALQUILERCASA*this.numCasas+Casilla.FACTORALQUILERHOTEL
                                     *this.numHoteles);
        return precioAlquilerCompleto;
    }
    
    float getPrecioCompra() {
        return precioCompra;
    }

    float getPrecioEdificar() {
        return precioEdificar;
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        // PRE: 1<= todos.size <=4 
        if(0<actual && actual<=todos.size()) {
            String info="Jugador " + actual + " (" + todos.get(actual).getNombre() +
                        ") pasa por " + this.toString();    
            Diario.getInstance().ocurreEvento(info);  
        }
    }
    
    private void init() {
        this.nombre="";
        this.precioCompra=0;
        this.precioEdificar=0;
        this.precioBaseAlquiler=0;
        this.numCasas=0;
        this.numHoteles=0;
        this.propietario=null;
        this.tipo=null;
        this.mazo=null;
        this.sorpresa=null;
    }

    void recibeJugador(int actual, ArrayList<Jugador> todos) {
        switch (this.tipo) {
            case CALLE:
                this.recibeJugador_calle(actual, todos);
            break;
            case SORPRESA:
                this.recibeJugador_sorpresa(actual, todos);
            break;
            case DESCANSO:
                this.informe(actual, todos);
            break;
        }
    }
    
    void recibeJugador_calle(int actual, ArrayList<Jugador> todos) {
        this.informe(actual, todos);
        Jugador jugador = todos.get(actual);
        
        if (!this.tienePropietario())
            jugador.puedeComprarCasilla();
        else
            this.tramitarAlquiler(jugador);
    }   
    
    void recibeJugador_sorpresa(int actual, ArrayList<Jugador> todos) {
        this.sorpresa = this.mazo.siguiente();
        this.informe(actual, todos);
        this.sorpresa.aplicarAJugador(actual, todos);       
    }
    
    public boolean tienePropietario() {
        if (this.propietario==null)
            return false;
        else
            return true;
    }
    
    @Override
    public String toString() {
        // Define el tipo de casilla para añadir al string completo
        String tipoCasilla = "Calle";
        if (this.tipo==TipoCasilla.DESCANSO)
            tipoCasilla = "Descanso";
        else if (this.tipo==TipoCasilla.SORPRESA)
            tipoCasilla = "Sorpresa";  
        
        String info =   "Casilla: "+ this.nombre +
                        ". Tipo : " +tipoCasilla + 
                        ". Precios: Compra: " + this.precioCompra + 
                        ", Edificar: " + this.precioEdificar +
                        ", Alquiler Completo: " + this.getPrecioAlquilerCompleto()+
                        ". Casas: " + this.numCasas + 
                        ", Hoteles: " + this.numHoteles;
        
        if(this.propietario!=null)
            info += ". Propietario: " + this.propietario.getNombre();
        
        return info;
    }
    
    public void tramitarAlquiler(Jugador jugador){       
        if (this.tienePropietario() && !this.esEsteElPropietario(jugador)) {
            jugador.pagaAlquiler(this.getPrecioAlquilerCompleto());
            this.propietario.recibe(this.getPrecioAlquilerCompleto());
        }        
    }
}
*/