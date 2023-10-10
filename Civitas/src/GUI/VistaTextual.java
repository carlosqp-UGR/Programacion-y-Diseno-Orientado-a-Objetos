package GUI;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
    private static String separador = "=====================";
    private Scanner in;
    private int iPropiedad;
    private int iGestion;
    CivitasJuego juegoModel;
  
    
    /**
    Muestra información en forma de texto del jugador actual y sus
    propiedades, y de la casilla actual. Si ya se ha llegado al finalDelJuego, muestra la lista
    completa de jugadores, que estará ordenada por orden de saldo, con el ganador en primer
    lugar.
    */ 
    public void actualiza() {
        System.out.println(this.separador);
        if (this.juegoModel.finalDelJuego()) {
            String infoFinJuego = "\nFINAL DEL JUEGO\n" + "Ranking de jugadores:\n";
            int i = 1;
            ArrayList<Jugador> ranking = this.juegoModel.ranking();
            for (Jugador jugador: ranking) {
                infoFinJuego += "\tPosicion " + i + ": " + jugador.ToString() + "\n";
                i++;
            }
            System.out.println(infoFinJuego);
        } else {
            String infoJugador = this.juegoModel.getJugadorActual().ToString();
            String infoCasillaActual = this.juegoModel.getTablero().getCasilla(this.juegoModel.getJugadorActual().getCasillaActual()).toString();
            System.out.println("Jugador Actual:\n\t" + infoJugador +"\nCasilla Actual:\n\t" + infoCasillaActual);
        } 
    }
    
    /*    
    Debe mostrar un menú preguntando si se desea comprar la calle a la
    que se ha llegado y devolver el valor del enumerado correspondiente a SI ó NO.
    */
    public Respuesta comprar() {
        Respuesta resp_usuario = Respuesta.NO;
        String cadena="";
        boolean ok = false;
        do {
            System.out.print ("¿Desea comprar la calle actual? Introduzca 'SI'/'NO'.\n");
            cadena = in.nextLine();
            if (cadena.equals("SI")|| cadena.equals("NO")) {
                ok = true;
                resp_usuario = Respuesta.valueOf(cadena);
            }
        } while (!ok);
        
        System.out.println("Ha introducido: " + cadena);
        
        return resp_usuario;
    }
    /*
    Debe mostrar un menú (usando el método menu)
    preguntando por el número de gestión inmobiliaria elegida (e incluyendo la acción de
    TERMINAR). Devolverá su valor convertido en enumerado de operación inmobiliaria.
    */
    public OperacionInmobiliaria elegirOperacion() {
        if (this.juegoModel.getJugadorActual().getPropiedades().isEmpty()) {
            System.out.println("El jugador actual aun no tiene propiedades para gestionar.");
            this.iGestion = 2;
        } else {
            ArrayList <String> lista = new ArrayList<String>();
            lista.add("CONSTRUIR_CASA");
            lista.add("CONSTRUIR_HOTEL");
            lista.add("TERMINAR");
            this.iGestion = this.menu("Introduzca el numero de Gestion Inmobiliaria", lista);
        }
        return OperacionInmobiliaria.values()[this.iGestion];
    }
    
    /*
    Devolverá el índice de la propiedad del jugador actual, sobre la que se
    desea realizar la gestión (también pidiéndo al usuario con el método menu). De forma
    opcional 1 , puede pedirse al modelo el número total de propiedades del jugador para
    controlar que el usuario introduzca un número dentro del rango apropiado.
    */
    public int elegirPropiedad() {
        String titulo = "Introduzca el indice de la propiedad del jugador sobre la que realizar la operacion.";
        ArrayList <String> lista = new ArrayList<>();
        for (Casilla c:this.juegoModel.getJugadorActual().getPropiedades())
            lista.add(c.toString());
        this.iPropiedad = this.menu(titulo, lista);
        return this.iPropiedad;
    }

    /*
    Muestra en consola el valor
    del argumento, que contiene la siguiente operación que va a realizar el juego.
    */
    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operacion) {
        System.out.println("Siguiente operacion: " + operacion.toString()+"\n");
    }

    /*
    Mientras el diario tenga eventos pendientes, los lee y muestra en consola.
    */
    @Override
    public void mostrarEventos() {
        if (Diario.getInstance().eventosPendientes()) {
            String salida = "Eventos pendientes del Diario:"; 
            while(Diario.getInstance().eventosPendientes()) {
                salida += "\n\t" + Diario.getInstance().leerEvento();
            }
            System.out.println(salida+"\n");
        }
    }
    
    // Indica al usuario y espera a que pulse cualquier tecla.
    public void pausa() {
        System.out.print ("\nPulsa una tecla\n");
        in.nextLine();
    }

    int leeEntero (int max, String msg1, String msg2) {
        Boolean ok;
        String cadena;
        int numero = -1;
        do {
          System.out.print (msg1);
          cadena = in.nextLine();
          try {  
            numero = Integer.parseInt(cadena);
            ok = true;
          } catch (NumberFormatException e) { // No se ha introducido un entero
            System.out.println (msg2);
            ok = false;  
          }
          if (ok && (numero < 0 || numero >= max)) {
            System.out.println (msg2);
            ok = false;
          }
        } while (!ok);

        return numero;
    }

    int menu (String titulo, ArrayList<String> lista) {
        String tab = "  ";
        int opcion;
        System.out.println (titulo);
        for (int i = 0; i < lista.size(); i++) {
          System.out.println (tab+i+"-"+lista.get(i));
        }

        opcion = leeEntero(lista.size(),
                              "\n"+tab+"Elige una opción: ",
                              tab+"Valor erróneo");
        return opcion;
    }
    
    public VistaTextual (CivitasJuego juegoModel) {
        in = new Scanner (System.in);
        this.juegoModel=juegoModel;
    }
}