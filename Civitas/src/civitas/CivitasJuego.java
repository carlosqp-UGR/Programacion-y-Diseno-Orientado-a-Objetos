/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;
import java.util.Collections;
import GUI.Dado;
/**
 *
 * @author carlosqp
 */
public class CivitasJuego {
    
    private int indiceJugadorActual;
    private EstadoJuego estado;
    private GestorEstados gestor;
    private ArrayList<Jugador> jugadores;
    private Tablero tablero;
    private MazoSorpresas mazo;
    
    private void avanzaJugador(){
        Jugador jugadorActual = this.getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = this.tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = this.tablero.getCasilla(posicionNueva);
        this.contabilizarPasosPorSalida();
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(this.indiceJugadorActual, this.jugadores);
    }
    
    //
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        this.jugadores=new ArrayList<>(); // En caso de que nombres este vacio
        for (int i=0; i<nombres.size(); i++)
            this.jugadores.add(new Jugador(nombres.get(i)));
        this.gestor=new GestorEstados(); // Constructor por defecto
        this.estado=this.gestor.estadoInicial();
        Dado.getInstance().setDebug(debug);
        this.indiceJugadorActual=Dado.getInstance().quienEmpieza(this.jugadores.size());
        this.mazo=new MazoSorpresas(debug);
        this.tablero=new Tablero();
        this.inicializaTablero(mazo);
        this.inicializaMazoSorpresas();
    }
    
    public boolean comprar(){
        Jugador jugadorActual = this.getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        Casilla casilla = this.tablero.getCasilla(numCasillaActual);
        boolean res = jugadorActual.comprar(((CasillaCalle) casilla));
        return res;
    }
    
    public boolean construirCasa(int ip){
        return this.jugadores.get(this.indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        return this.jugadores.get(this.indiceJugadorActual).construirHotel(ip);
    }
    
    private void contabilizarPasosPorSalida() {
        if (this.tablero.computarPorSalida())
            this.getJugadorActual().pasaPorSalida();
    }
    
    public boolean finalDelJuego(){
        boolean existeBancarrota=false;
        for (int i=0; i<this.jugadores.size() &&!existeBancarrota; i++) {
            if (this.jugadores.get(i).enBancarrota())
                existeBancarrota=true;
        }
        return existeBancarrota;
    }
    
    public int getIndiceJugadorActual(){
        return this.indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return this.jugadores.get(this.indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }

    private void inicializaMazoSorpresas(){

        // Total 10 cartas: 5 Pagar_Cobrar + 4 Casa_Hotel + 1 Convertir
        mazo.alMazo(new SorpresaPagarCobrar("Pagar_Cobrar", -100));
        mazo.alMazo(new SorpresaPagarCobrar("Pagar_Cobrar", 100));
        mazo.alMazo(new SorpresaPagarCobrar("Pagar_Cobrar", -100));
        mazo.alMazo(new SorpresaPagarCobrar("Pagar_Cobrar", 100));
        mazo.alMazo(new SorpresaPagarCobrar("Pagar_Cobrar", -100));
        // mazo.alMazo(new SorpresaPagarCobrar("Pagar_Cobrar", 100));

        mazo.alMazo(new SorpresaPorCasaHotel("Casa_Hotel", 200));  
        mazo.alMazo(new SorpresaPorCasaHotel("Casa_Hotel", -200));  
        mazo.alMazo(new SorpresaPorCasaHotel("Casa_Hotel", 200));  
        mazo.alMazo(new SorpresaPorCasaHotel("Casa_Hotel", -200)); 
        
        mazo.alMazo(new SorpresaConvertirme("Convertir"));
    }
  
/*
    // Para la prueba de conversion
    private void inicializaMazoSorpresas(){
        mazo.alMazo(new SorpresaConvertirme("Convertir"));
        mazo.alMazo(new SorpresaPagarCobrar("Pagar_Cobrar", 100));

    }
*/
    
    //
    private void inicializaTablero(MazoSorpresas mazo){
        
        this.tablero.aniadeCasilla(new Casilla("SALIDA"));
        
        // Para la prueba de conversion
        //this.tablero.aniadeCasilla(new CasillaSorpresa("Sorpresa", mazo));
        
        this.tablero.aniadeCasilla(new CasillaCalle("Velazquez", 60, 10, 100));
        this.tablero.aniadeCasilla(new CasillaCalle("Salamanca", 80, 10, 10));
        this.tablero.aniadeCasilla(new CasillaCalle("Castellana", 100, 10, 10));
        this.tablero.aniadeCasilla(new CasillaCalle("Tirso de Molina", 120, 10, 10));

        this.tablero.aniadeCasilla(new CasillaSorpresa("Sorpresa", mazo));
        
        this.tablero.aniadeCasilla(new CasillaCalle("Lavapies", 140, 10, 10));
        this.tablero.aniadeCasilla(new CasillaCalle("Goya", 150, 10, 10));
        
        this.tablero.aniadeCasilla(new CasillaSorpresa("Sorpresa", mazo));

        this.tablero.aniadeCasilla(new CasillaCalle("Mataelpino", 200, 10, 10));

        this.tablero.aniadeCasilla(new Casilla("Puro Relax"));
        
        this.tablero.aniadeCasilla(new CasillaCalle("Leganitos", 220, 10, 10));
        this.tablero.aniadeCasilla(new CasillaCalle("Serrano", 240, 10, 10));
        this.tablero.aniadeCasilla(new CasillaCalle("Paseo del Prado", 260, 10, 10));

        this.tablero.aniadeCasilla(new CasillaSorpresa("Sorpresa", mazo));

        this.tablero.aniadeCasilla(new CasillaCalle("Vendelatas", 280, 10, 10));
        this.tablero.aniadeCasilla(new CasillaCalle("Mendez Alvaro", 300, 10, 10));
        
        this.tablero.aniadeCasilla(new CasillaSorpresa("Sorpresa", mazo));

        this.tablero.aniadeCasilla(new CasillaCalle("O'Donell", 350, 10, 10));
        this.tablero.aniadeCasilla(new CasillaCalle("San Jeronimo", 400, 10, 10));
    }
    
    private void pasarTurno(){
        this.indiceJugadorActual=(this.indiceJugadorActual+1)%this.jugadores.size();
    }
    
    // ¿private?
    public ArrayList<Jugador> ranking(){
        ArrayList<Jugador> rankingJugadores=this.jugadores;
        Collections.sort(rankingJugadores, Jugador::compareTo);
        return rankingJugadores;
    }
    
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = this.getJugadorActual();
        OperacionJuego operacion = this.gestor.siguienteOperacion(jugadorActual, this.estado);
        
        if (operacion == OperacionJuego.PASAR_TURNO) {
            this.pasarTurno();
            this.siguientePasoCompletado(operacion);
        } else if (operacion == OperacionJuego.AVANZAR) {
            this.avanzaJugador();
            this.siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        this.estado=this.gestor.siguienteEstado(this.getJugadorActual(),this.estado, operacion);
    }
    
}
