class Parcela
  # Atributos de instancia de la clase
  @FACTORALQUILERCALLE=1.0
  @FACTORALQUILERCASA=1.0
  @FACTORALQUILERHOTEL=4.0

  # Métodos de clase (para acceder a los atributos de instancia de la clase)
  def self.factorAlquilerCalle  # Parcela.factorAlquilerCalle ó self.class.factorAlquilerCalle
    return @FACTORALQUILERCALLE
  end

  def self.factorAlquilerCasa  # Parcela.factorAlquilerCasa ó self.class.factorAlquilerCasa
    return @FACTORALQUILERCASA
  end

  def self.factorAlquilerHotel  # Parcela.factorAlquilerHotel ó self.class.factorAlquilerHotel
    return @FACTORALQUILERHOTEL
  end

"#{  # Atributos de clase (Version ejercicio 2)
  @@FACTORALQUILERCALLE=1.0
  @@FACTORALQUILERCASA=1.0
  @@FACTORALQUILERHOTEL=4.0}"

  # Constructor
  def initialize(nombre="VACIO", precioCompra=0, precioEdificar=0, precioBaseAlquiler=0)
    @nombre=nombre
    @precioCompra=precioCompra
    @precioEdificar=precioEdificar
    @precioBaseAlquiler=precioBaseAlquiler
    @numCasas=0
    @numHoteles=0
  end

  # Métodos de consulta
  def nombre
    return @nombre
  end

  def precioCompra
    return @precioCompra
  end

  def precioEdificar
    return @precioEdificar
  end

  def numCasas
    return @numCasas
  end

  def numHoteles
    return @numHoteles
  end

"#{  # Método de instancia, version ejercicio 2
  def precioAlquilerCompleto()
    precio=@precioBaseAlquiler*(@@FACTORALQUILERCALLE+@@FACTORALQUILERCASA*
                                @numCasas+@@FACTORALQUILERHOTEL*@numHoteles)
    return precio
  end}"

  # Método de instancia, versión ejercicio 3
  def precioAlquilerCompleto()
    precio=@precioBaseAlquiler*(Parcela.factorAlquilerCalle+Parcela.factorAlquilerCasa*
                                @numCasas+Parcela.factorAlquilerHotel*@numHoteles)
    return precio
  end

  def construirCasa()
    @numCasas+=1
    return true
  end

  def construirHotel()
    @numHoteles+=1
    return true
  end

  def print()
    puts "Parcela " + @nombre + ":"
    puts "\tPrecio Compra: " + @precioCompra.to_s
    puts "\tPrecio Edificacion: " + @precioEdificar.to_s
    puts "\tPrecio Alquiler Completo: " + self.precioAlquilerCompleto.to_s
    puts "\tNumero Casas: " + @numCasas.to_s
    puts "\tNumero Hoteles: " + @numHoteles.to_s
  end

end
