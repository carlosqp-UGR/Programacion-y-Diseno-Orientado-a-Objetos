package ejerciciosjavap4;

import java.util.Random;

public class CasillaSorpresa extends Casilla {
    static final int MAX_SORPRESA = 10;
    private int sorpresa;

    
    CasillaSorpresa(String nombre) {
        super(nombre);
        Random random = new Random();
        this.sorpresa = random.nextInt(CasillaSorpresa.MAX_SORPRESA);
    }
    
    public void muestraSorpresa() {
        System.out.println("Es la sorpresa " + this.sorpresa);
    }
    
}
