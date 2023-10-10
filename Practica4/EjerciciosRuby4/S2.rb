module Herencia
  class Persona
    def initialize(nombre)
      @nombre=nombre
    end

    def andar
      result = "Soy #{@nombre} y estoy andando"
    end

    def to_s
      result = "Soy una persona y mi nombre es #{@nombre}"
    end

    attr_reader :nombre
  end

  class Deportista < Persona

    def initialize(nombre, horas_entrenamiento)
      super(nombre)
      @horas_entranamiento=horas_entrenamiento
    end

    def competicion_deportiva
      result = "He entrenado #{@horas_entranamiento.to_s} hora(s) para la competicion."
    end

    attr_reader :horas_entranamiento
  end

  class Corredor < Deportista

    # def initialize(nombre, horas_entrenamiento)
    # super
    # end

    def correr
      result = "Soy #{@nombre} y estoy corriendo"
    end

    def to_s
      result = super
      result += " y soy corredor"
    end

  end

  class Nadador < Deportista
    def initialize(nombre, horas_entrenamiento)
      super
    end

    def nadar
      result =  "Soy #{@nombre} y estoy nadando"
    end

    def to_s
      result = super
      result += " y soy nadador"
    end
  end

  puts "Hola"
  p = Persona.new("P1")
  d = Deportista.new("P2", 10)
  c = Corredor.new("P3", 20)
  n = Nadador.new("P4", 30)
  # Si no tienen constructor, lo herendan de su padre
  #
  puts p.to_s
  puts d.to_s
  puts c.to_s
  puts n.to_s

  puts p.andar
  puts d.andar
  puts c.andar
  puts n.andar

  # Con cada objeto puedes llamar a sus métodos propios y heredados
  # Persona : propios[initialize, andar, to_s]
  # Deportista : propios[initialize, competicion_deportiva, to_s], heredados[andar(Persona)]
  # Corredor : propios[initialize, correr, to_s], heredados[andar(Persona), competicion_deportiva(Deportista)]
  # Nadador : propios[initialize, nadar, to_s], heredados[andar(Persona), competicion_deportiva(Deportista)]

  puts d.competicion_deportiva
  puts c.competicion_deportiva
  puts n.competicion_deportiva

  puts "Adios"

end