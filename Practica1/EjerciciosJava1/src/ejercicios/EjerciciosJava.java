/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

/**
 *
 * @author carlosqp
 */
public class EjerciciosJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Parcela p1=new Parcela("Garrucha",1500,3000,550);
        Parcela p2=new Parcela("Turre",1800,250,60);
        Parcela p3=new Parcela();
        
        p1.construirHotel();
        p2.construirCasa();
        
        p1.infoParcela();
        p2.infoParcela();
        p3.infoParcela();

        // Prueba de construir casas
        boolean construyeCasa;
        for (int i=0; i<5; i++)
            construyeCasa=p1.construirCasa();
        System.out.println("\nNumero de casas de la parcela 1: " + p1.getNumCasas());
    }
    
}
