/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author carlosqp
 */
public class SorpresaConvertirme extends Sorpresa {
    
    SorpresaConvertirme(String nombre) {
        super(nombre, 0);
    }

    @Override
    public void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        // Crea un jugador especulador y lo sustituye en el array de jugadores
        this.informe(actual, todos);
        Jugador nuevo = todos.get(actual).convertir();
        todos.set(actual, nuevo);
    }
    
    @Override
    public String toString(){
        String info = super.toString() + " Tipo: Conversion.";
        return info;
    }
    
}
