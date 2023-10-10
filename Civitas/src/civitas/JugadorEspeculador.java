package civitas;

// Sólo pagan la mitad de lo que les corresponde cuando se les solicita
public class JugadorEspeculador extends Jugador {
    private static int FactorEspeculador = 2;
    
    protected JugadorEspeculador(Jugador especulador) {
        super(especulador); // Constructor copia de jugador
        this.actualizaPropiedadesPorConversion();
    }
    
    @Override
    int getCasasMax(){
        return Jugador.CasasMax*JugadorEspeculador.FactorEspeculador;
    }
    
    @Override
    int getCasasPorHotel(){
        return Jugador.CasasPorHotel/JugadorEspeculador.FactorEspeculador;
    }
    
    @Override
    int getHotelesMax(){
        return Jugador.HotelesMax*JugadorEspeculador.FactorEspeculador;    
    }
    
    private void actualizaPropiedadesPorConversion() {
        for(CasillaCalle propiedad: this.propiedades)
            propiedad.actualizaPropietarioPorConversion(this);
    }
    
    @Override
    public String ToString(){
        String infoJugador = "(ESPECULADOR) " + super.ToString();
        return infoJugador;
    }
    
    @Override
    boolean paga(float cantidad) {
        return this.modificarSaldo(-cantidad/(float)JugadorEspeculador.FactorEspeculador);
    }
    
    @Override
    public boolean esEspeculador() {
        return true;
    }
    
}
