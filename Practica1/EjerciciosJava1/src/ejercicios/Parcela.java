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
public class Parcela {
    
/**
 * @brief Atributos de clase (constantes)
 */
    private static final float FACTORALQUILERCALLE = 1.0f;
    private static final float FACTORALQUILERCASA = 1.0f;
    private static final float FACTORALQUILERHOTEL = 4.0f;    

/**
 * @brief Atributo de clase
 */
    private static int MAX_CASAS = 2;
    
/**
 * @brief Atributos de instancia
 */
    private String nombre;
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private int numCasas;
    private int numHoteles;
 
/**
 * @brief Constructor por defecto
 */
    public Parcela() {
        this.nombre = "Sin Nombre";
        this.precioCompra = 0;
        this.precioEdificar = 0;
        this.precioBaseAlquiler = 0;
        this.numCasas=0;
        this.numHoteles=0;    
    }
    
/**
 * @brief Constructor de la clase Parcela
 * @param nombre
 * @param precioCompra
 * @param precioEdificar
 * @param precioBaseAlquiler 
 */

    public Parcela(String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        this.numCasas=0;
        this.numHoteles=0;
    }

/**
 * @brief Métodos de consulta
 * @return 
 */
    public String getNombre() {
        return nombre;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public float getPrecioEdificar() {
        return precioEdificar;
    }

    public int getNumCasas() {
        return numCasas;
    }

    public int getNumHoteles() {
        return numHoteles;
    }

/**
 * @brief Calcula el precio del alquiler, según las reglas de Civitas
 * @return precioAlquilerCompleto
 */
    public float getPrecioAlquilerCompleto() {
        float precioAlquilerCompleto=this.precioBaseAlquiler*(Parcela.FACTORALQUILERCALLE
                                     +Parcela.FACTORALQUILERCASA*this.numCasas+Parcela.FACTORALQUILERHOTEL
                                     *this.numHoteles);
        return precioAlquilerCompleto;
    }
    
/**
 * @brief Métodos de modificación
 * @return 
 */
    public boolean construirCasa() {
        if (this.numCasas<Parcela.MAX_CASAS) {
            this.numCasas=this.numCasas+1;
            return true;
        } else
            return false;
    }
    
    public boolean construirHotel() {
        this.numHoteles=this.numHoteles+1;
        return true;
    }

    public boolean igualdadIdentidad(Parcela otraParcela) {
        return (this==otraParcela);
    }
    
    public boolean igualdadEstado(Parcela otraParcela) {
        boolean mismoEstado =   (this.nombre.equals(otraParcela.nombre)) &&
                                (this.numCasas==otraParcela.numCasas) &&
                                (this.numHoteles==otraParcela.numHoteles) &&
                                (this.precioBaseAlquiler==otraParcela.precioBaseAlquiler) &&
                                (this.precioCompra==otraParcela.precioCompra) &&
                                (this.precioEdificar==otraParcela.precioEdificar);
        return mismoEstado;
    }
    
/**
 * @brief Devuelve los datos de la parcela
 */
    public void infoParcela() {
        String info = "Parcela " + this.nombre + ":\n\tPrecio Compra: "
                + this.precioCompra + "\n\tPrecio Edificar: " + this.precioEdificar +
                "\n\tPrecio Alquiler Completo: " + this.getPrecioAlquilerCompleto() +
                "\n\tNumero Casas: " + this.numCasas + "\n\tNumero de Hoteles: " +
                this.numHoteles;
        System.out.println(info);
    }
}


