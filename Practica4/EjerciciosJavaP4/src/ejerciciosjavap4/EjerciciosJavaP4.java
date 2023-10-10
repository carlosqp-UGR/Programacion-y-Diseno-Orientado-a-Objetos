package ejerciciosjavap4;

import java.util.ArrayList;

public class EjerciciosJavaP4 {

/*
    public static void main(String[] args) { 
    // Sesión 1
        Casilla casilla = new Casilla ("casilla");
        CasillaCalle casillaCalle = new CasillaCalle("casillaCalle", 2);
   
        // 1. Reutilización
        // Los métodos del padre son heredados por los hijos, y por tanto 
        // pueden ser reutilizados. Ambos ejecutan el mismo método.
            // casilla -> He recibido un jugador.
            // casillaCalle -> He recibido un jugador.
        
        // 2. Redefinición o sobre-escritura completa
        // Cada una de las clases ha ejecutado su método propio:
            // casilla -> He recibido un jugador.
            // casillaCalle -> Soy una casilla calle y he recibido un jugador.
        
        // 3. Redefinición o sobre-escritura parcial
        // La clase hija ha redefinido (parcialmente) un método de la clase padre.
        // El método del hijo ejecuta el método del padre y además lo extiende.
            // casilla -> He recibido un jugador.
            // casillaCalle -> He recibido un jugador.
            //                  Y además soy una casilla calle.
                
        // 4. Métodos propios y casting
        
        casilla.recibeJugador();
        casillaCalle.recibeJugador();
        
        // La clase padre no puede ejecutar métodos de la clase hijo
            // casilla.construirCasa(); Error.
        casillaCalle.construirCasa();
        
        // Un puntero del padre, puede apuntar a cualquiera de sus descendientes,
        // A la hora de ejecutar métodos, los ejecutará del objeto al que apunte.
        ArrayList<Casilla> tablero = new ArrayList<>();
        tablero.add(casilla);
        tablero.add(casillaCalle);
        
        // No se puede ejecutar
            // tablero.get(0).construirCasa();
        
        // La siguiente sentencia da error de compilación, se debe arreglar con un casteo.
            // tablero.get(1).construirCasa(); Error de compilación

        // Un padre siempre se puede castear por un hijo, ya que el hijo ES UN (descendiente del) padre.
        ((CasillaCalle) tablero.get(1)).construirCasa();
        // Para arreglar sin casteo, se debe desarrollar un método abstracto(vacío) en el padre.
    }
*/
    public static void main(String[] args) { 
        CasillaCalle casilla1 = new CasillaCalle("casilla1", 0);
        Casilla casilla2 = new Casilla("casilla2");
        
        // Se puede realizar la asignación porque CasillaCalle ES UNA Casilla
        // Ahora casilla2 apunta a un objeto CasillaCalle.
        casilla2 = casilla1;
        
        // Llama al método recibeJugador de CasillaCalle
        casilla1.recibeJugador();
        
        // Llama al método recibeJugador de CasillaCalle
        casilla2.recibeJugador();
        
        casilla1.construirCasa();
        
        // Para que compile se debe hacer un casteo
        ((CasillaCalle) casilla2).construirCasa();
        
        // Al final, numCasas = 2, por que apuntan ambos punteros al mismo sitio (mismo objeto)
    
        // Pregunta de clase: Para crear un objeto Casilla que almacene un objeto CasillaSorpresa,
        // debo crear antes dicho objeto casillaSorpresa y despues el objeto Casilla que lo apunte.
        CasillaSorpresa casillaSorpresa = new CasillaSorpresa ("Sorpresa");
        Casilla casillaNueva = casillaSorpresa;
        
        casillaSorpresa.muestraSorpresa();
        ((CasillaSorpresa) casillaNueva).muestraSorpresa();
    
    }
}
