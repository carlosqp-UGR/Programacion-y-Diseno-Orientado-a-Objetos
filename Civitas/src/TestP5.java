import GUI.CivitasView;
import GUI.CapturaNombres;

import controladorCivitas.Controlador;

import civitas.CivitasJuego;

import GUI.Dado;

import java.util.ArrayList;
/**
 *
 * @author carlosqp
 */
public class TestP5 {
    
    public static void main(String[] args) {
        
        CivitasView vista = new CivitasView();
        
        CapturaNombres capturaNombres = new CapturaNombres(vista, true);
                
        ArrayList<String> nombres = new ArrayList<>();
        nombres = capturaNombres.getNombres();
        
        Dado.createInstance(vista);
        
        CivitasJuego juego = new CivitasJuego(nombres, false);
        
        Controlador controlador = new Controlador(juego, vista);
        
        vista.setCivitasJuego(juego);
        
        controlador.juega();
    }
    
}
