package civitas;

import java.util.ArrayList;

public class CasillaCalle extends Casilla {
    private static final float FACTORALQUILERCALLE = 1;
    private static final float FACTORALQUILERCASA = 1;
    private static final float FACTORALQUILERHOTEL = 4;    
    
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private int numCasas;
    private int numHoteles;
    private Jugador propietario;
    
    public CasillaCalle (String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler) {
        super(nombre);
        
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        
        this.numCasas = 0;
        this.numHoteles = 0;
        this.propietario = null;
    }

    public int getNumCasas() {
        return this.numCasas;
    }
    
    public int getNumHoteles() {
        return this.numHoteles;
    }
    
    public int cantidadCasasHoteles() {
        return this.numCasas+this.numHoteles;
    }

    public boolean tienePropietario() {
        return this.propietario!=null;
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        return (this.propietario==jugador);
    }
    
    public float getPrecioCompra() {
        return precioCompra;
    }

    public float getPrecioEdificar() {
        return precioEdificar;
    } 
    
    public float getPrecioAlquilerCompleto() {
        float precioAlquilerCompleto=this.precioBaseAlquiler*(CasillaCalle.FACTORALQUILERCALLE
                                     +CasillaCalle.FACTORALQUILERCASA*this.numCasas+CasillaCalle.FACTORALQUILERHOTEL
                                     *this.numHoteles);
        return precioAlquilerCompleto;
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

    
    public void tramitarAlquiler(Jugador jugador){       
        if (this.tienePropietario() && !this.esEsteElPropietario(jugador)) {
            jugador.pagaAlquiler(this.getPrecioAlquilerCompleto());
            this.propietario.recibe(this.getPrecioAlquilerCompleto());
        }        
    }
    
    @Override
    void recibeJugador(int actual, ArrayList<Jugador> todos) {
        this.informe(actual, todos);
        Jugador jugador = todos.get(actual);

        if (!this.tienePropietario())
            jugador.puedeComprarCasilla();
        else {
            this.tramitarAlquiler(jugador);
        } 
    }
    
    @Override
    public String toString() {
        String info =   "Casilla: "+ this.getNombre() + " (Calle)." + 
                        " Precios: Compra: " + this.precioCompra + 
                        ", Edificar: " + this.precioEdificar +
                        ", Alquiler Completo: " + this.getPrecioAlquilerCompleto()+
                        ". Casas: " + this.numCasas + 
                        ", Hoteles: " + this.numHoteles;
        
        if(this.propietario!=null)
            info += ". Propietario: " + this.propietario.getNombre();
        
        return info;
    }
    
    void actualizaPropietarioPorConversion(JugadorEspeculador especulador) {
        this.propietario = especulador;
    }
    
}
