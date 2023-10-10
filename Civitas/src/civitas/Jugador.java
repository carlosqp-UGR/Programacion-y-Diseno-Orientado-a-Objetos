package civitas;
import java.util.ArrayList;

public class Jugador implements Comparable<Jugador> {

    protected static int CasasMax=4;
    protected static int CasasPorHotel=4;
    protected static int HotelesMax=4;
    protected static float PasoPorSalida=1000f;
    private static float SaldoInicial=7500f; 
    
    private int casillaActual;
    private String nombre;
    private boolean puedeComprar;
    private float saldo;
    protected ArrayList<CasillaCalle> propiedades;
    
    int cantidadCasasHoteles() {
        int total=0;
        if (this.tieneAlgoQueGestionar()) {
            for (int i=0; i<this.propiedades.size(); i++)
                total+=this.propiedades.get(i).cantidadCasasHoteles();
        }
        return total;
    }
    
    @Override
    public int compareTo(Jugador o) {
        return Float.compare(o.saldo, this.saldo);
    }
    
    boolean comprar(CasillaCalle titulo){
        boolean result = false;
        if (this.puedeComprar) {
            float precio = titulo.getPrecioCompra();
            if (this.puedoGastar(precio)) {
                result = titulo.comprar(this);
                this.propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + this.nombre
                        + " compra la propiedad " + titulo.toString() );
                this.puedeComprar = false;
            }
        } else
            Diario.getInstance().ocurreEvento("El jugador " + this.ToString()
                    + "no tiene saldo para comprar la propiedad " + titulo.toString() );
        
        return result;
    }
    
    boolean construirCasa(int ip){
        boolean result = false;
        boolean existe = this.existeLaPropiedad(ip);
        if (existe) {
            CasillaCalle propiedad = this.propiedades.get(ip);
            boolean puedoEdificar = this.puedoEdificarCasa(propiedad);
            if (puedoEdificar) {
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + this.getNombre() 
                       + " construye casa en propiedad " + ip );
            }
        }
        return result;
    }

    boolean construirHotel(int ip) {
        boolean result = false;
        if (this.existeLaPropiedad(ip)) {
            CasillaCalle propiedad = this.propiedades.get(ip);
            boolean puedoEdificarHotel = this.puedoEdificarHotel(propiedad);
            if (puedoEdificarHotel) {
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(Jugador.CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + this.getNombre()
                        + " construye hotel en la propiedad " + ip);
            }
        }
        return result;
    }
    
    boolean enBancarrota(){
        return this.saldo<0;
    }
    
    private boolean existeLaPropiedad(int ip){
        return (0<=ip && ip<this.propiedades.size());
    }
    
    int getCasasMax(){
        return Jugador.CasasMax;
    }
    
    int getCasasPorHotel(){
        return Jugador.CasasPorHotel;
    }

    int getHotelesMax(){
        return Jugador.HotelesMax;
    }
    
    public int getCasillaActual(){
        return this.casillaActual;
    }

    public String getNombre(){
        return this.nombre;
    }
    
    private float getPremioPasoSalida(){
        return Jugador.PasoPorSalida;
    }
    
    //¿protected?
    public ArrayList<CasillaCalle> getPropiedades() {
        return this.propiedades;
    }
    
    boolean getPuedeComprar() {
        return this.puedeComprar;
    }
    
    public float getSaldo() {
        return this.saldo;
    }
    
    Jugador(String nombre){
        this.casillaActual=0;
        this.nombre=nombre;
        this.puedeComprar=false;
        this.saldo=Jugador.SaldoInicial;
        this.propiedades=new ArrayList<>();
    }
    
    protected Jugador(Jugador otro){
        this(otro.nombre);
        this.casillaActual=otro.casillaActual;
        this.puedeComprar=otro.puedeComprar;
        this.saldo=otro.saldo;
        this.propiedades=otro.propiedades;
    }
    
    boolean modificarSaldo(float cantidad){
        this.saldo+=cantidad;
        String info = "Saldo de Jugador " + this.nombre + " modificado.";
        Diario.getInstance().ocurreEvento(info);
        return true;
    }
    
    boolean moverACasilla(int numCasilla){
        this.casillaActual=numCasilla;
        this.puedeComprar=false;
        String info = "Jugador " + this.nombre + " avanza hasta la casilla " + numCasilla + ".";
        Diario.getInstance().ocurreEvento(info);
        return true;
    }
    
    boolean paga(float cantidad) {
        return this.modificarSaldo(-cantidad);
    }
    
    boolean pagaAlquiler(float cantidad) {
        return this.paga(cantidad);
    }
    
    boolean pasaPorSalida(){
        String info="Jugador " + this.nombre + " pasa por Salida.";
        Diario.getInstance().ocurreEvento(info);
        this.recibe(Jugador.PasoPorSalida);
        return true;
    }
    
    boolean puedeComprarCasilla(){
        this.puedeComprar=true;
        return this.puedeComprar;
    }
    
    private boolean puedoEdificarCasa(CasillaCalle propiedad){
        boolean puedoEdificar = false;
        float precioEdificar = propiedad.getPrecioEdificar();
        
        if (this.puedoGastar(precioEdificar) && (propiedad.getNumCasas()<this.getCasasMax()) )
            puedoEdificar = true;
        
        return puedoEdificar;
    }
    
    private boolean puedoEdificarHotel(CasillaCalle propiedad){
        boolean puedoEdificarHotel = false;
        float precio = propiedad.getPrecioEdificar();
        
        if (    (this.puedoGastar(precio)) && 
                (propiedad.getNumHoteles()<this.getHotelesMax()) && 
                (propiedad.getNumCasas()>=this.getCasasPorHotel()) ) 
            puedoEdificarHotel = true;
        
        return puedoEdificarHotel;
    }
    
    private boolean puedoGastar(float precio){
        return precio<=this.saldo;
    }
    
    boolean recibe(float cantidad){
        return this.modificarSaldo(cantidad);
    }
    
    boolean tieneAlgoQueGestionar(){
        return this.propiedades!=null;
    }
    
    public String ToString(){
        
        String infoPropiedades = "Propiedades: ";
        if (this.tieneAlgoQueGestionar()) {
            infoPropiedades += this.propiedades.size() + "\n";
            int i = 1;
            for (Casilla p: this.propiedades) {
                infoPropiedades += "\t Propiedad[" + i + "]: " + p.toString() + ".\n";
                i++;
            }
        } else
            infoPropiedades += "0. ";
        
        String infoJugador = "Jugador: " + this.nombre +
                        ". Saldo: " + this.saldo +
                        ". Casilla Actual: " + this.getCasillaActual() +
                        ". " + infoPropiedades; 
        
        
        return infoJugador;
    }
    
    protected Jugador convertir() {
        Jugador nuevo = new JugadorEspeculador(this);
        return nuevo;
    }
    
    public boolean esEspeculador() {
        return false;
    }
    
/*
    // Prueba de jugador
    public static void main (String[] args) {
        Jugador jugador = new Jugador("Julio");
        jugador.casillaActual = 10;
        jugador.saldo = 100000000;
        CasillaCalle propiedad1 = new CasillaCalle("Calle1", 10, 10, 10);
        propiedad1.comprar(jugador);
        
        CasillaCalle propiedad2 = new CasillaCalle("Calle2", 20, 20, 20);
        propiedad2.comprar(jugador);
        
        jugador.propiedades.add(propiedad1);
        jugador.propiedades.add(propiedad2);
        
        Jugador especulador = jugador.convertir();
        System.out.println(especulador.getCasasMax());
    }
*/
}
