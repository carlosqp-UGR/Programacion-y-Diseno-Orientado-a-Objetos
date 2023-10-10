/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;
import java.util.ArrayList;

/**
 *
 * @author carlosqp
 */
public class MazoSorpresas {

    private boolean barajada;
    private int usadas;
    private boolean debug;
    private ArrayList<Sorpresa> sorpresas;

    
    void alMazo(Sorpresa s) {
        if (!this.barajada)
            this.sorpresas.add(s);
    }
    
    private void init() {
        this.sorpresas = new ArrayList<>();
        this.barajada = false;
        this.usadas = 0;
    }

    MazoSorpresas(boolean debug) {
        this.init();
        this.debug=debug;
    }

    MazoSorpresas(){
        this(false); // Llamada al constructor con parámetros
    }
    
    Sorpresa siguiente() {
        if (!this.debug) {
            if (!this.barajada||this.usadas==this.sorpresas.size()) {
                this.usadas=0;
                this.barajada=true;
            }
        }
        
        this.usadas++; // Se incrementa el valor de usadas
        
        // Se almacena el valor de la primera carta en una variable local
        Sorpresa local = null;
        local = this.sorpresas.get(0);
        
        // Se quita la primera carta y se añade al final
        this.sorpresas.remove(0);
        this.sorpresas.add(local);
        
        // Se devuelve la referencia a la variable local
        return local;
    }
}   
