package controladorCivitas;

// import GUI.VistaTextual;
import GUI.CivitasView;

import civitas.CivitasJuego;
import civitas.OperacionJuego;
import civitas.OperacionInmobiliaria;
import civitas.GestionInmobiliaria;

/**
 *
 * @author carlosqp
 */
public class Controlador {
    private CivitasJuego juegoModel;
    private CivitasView vista;
    
    // ¿Visibilidad paquete?
    public Controlador(CivitasJuego juego, CivitasView vista) {
        this.juegoModel=juego;
        this.vista=vista;
    }
    
    // Método encargado de todo el desarrollo de la partida
    public void juega() {
        boolean juego_terminado = false;
        while(!juego_terminado) {
            this.vista.actualiza();
            this.vista.pausa();
            OperacionJuego operacion = this.juegoModel.siguientePaso();
            this.vista.mostrarSiguienteOperacion(operacion);
            if (!(operacion==OperacionJuego.PASAR_TURNO))
                this.vista.mostrarEventos();
            juego_terminado = this.juegoModel.finalDelJuego();
            if (!juego_terminado) {
                switch (operacion) {
                    case COMPRAR:
                        Respuesta resp = this.vista.comprar();
                        if (resp==Respuesta.SI) {
                            this.juegoModel.comprar();
                        }
                        this.juegoModel.siguientePasoCompletado(operacion);
                    break;
                    case GESTIONAR:
                        OperacionInmobiliaria opInm = this.vista.elegirOperacion();
                        int ip = -1;
                        //
                        switch (opInm) {
                            case CONSTRUIR_CASA:
                                ip = this.vista.elegirPropiedad();
                                GestionInmobiliaria gestion1 = new GestionInmobiliaria(opInm, ip);
                                this.juegoModel.construirCasa(gestion1.getPropiedad());
                            break;
                            case CONSTRUIR_HOTEL:
                                ip = this.vista.elegirPropiedad();
                                GestionInmobiliaria gestion2 = new GestionInmobiliaria(opInm, ip);
                                this.juegoModel.construirHotel(gestion2.getPropiedad());
                            break;
                            case TERMINAR:
                                this.juegoModel.siguientePasoCompletado(operacion);
                            break;
                        }
                    break;    
                }
            }
        }
       this.vista.actualiza();
    }
}