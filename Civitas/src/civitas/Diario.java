package civitas;
import java.util.ArrayList;

public class Diario {
    // Es un singleton. La propia clase almacena la referencia a la única instancia
    static final private Diario instance = new Diario();
    private final ArrayList<String> eventos;

    // Constructor privado para evitar que se creen mas instancias
    private Diario () {
      eventos = new ArrayList<>();
    }
    
    public boolean eventosPendientes () {
      return !eventos.isEmpty();
    }
    
    // Método de clase para obtener la instancia --> Diario.getInstance()
    static public Diario getInstance() {
      return instance;
    }

    public String leerEvento () {
      String salida = "";
      if (!eventos.isEmpty()) {
        salida = eventos.remove(0);
      }
      return salida;
    }
    
    public String getEventos() {
        String output = "";
        while(Diario.getInstance().eventosPendientes())
            output += Diario.getInstance().leerEvento() + "\n";
        return output;
    }
    
    void ocurreEvento (String e) {
      eventos.add(e);
    }

}
