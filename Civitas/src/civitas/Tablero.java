package civitas;

import java.util.ArrayList; // Para poder usar arrays de java

/**
 *
 * @author carlosqp
 */
public class Tablero {

    private boolean porSalida;
    private ArrayList<Casilla> tablero;
    
    void aniadeCasilla(Casilla casilla){
        this.tablero.add(casilla);
    }
    
    boolean computarPorSalida() {
        return porSalida;
    }
    
    private boolean correcto(int numCasilla){
        return 0<=numCasilla && numCasilla<this.tablero.size();
    }
    
    public Casilla getCasilla(int numCasilla) {
        if(this.correcto(numCasilla))
            return this.tablero.get(numCasilla);
        else
            return null;
    }
    
    public ArrayList<Casilla> getCasillas() {
        return this.tablero;
    }
    
    int nuevaPosicion(int actual, int tirada) {
        int nuevaPosicion=(actual+tirada)%this.tablero.size();
        // Comprueba si ha dado una nueva vuelta al tablero
            if (nuevaPosicion != actual+tirada)
                this.porSalida=true;
            else
                this.porSalida=false;
       
        return nuevaPosicion;
    }
    
    public Tablero() {
        this.tablero=new ArrayList<>();
        this.porSalida=true;
    }

}   
