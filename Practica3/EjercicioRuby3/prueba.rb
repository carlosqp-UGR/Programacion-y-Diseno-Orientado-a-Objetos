require_relative 'modelo_laberinto/direccion'

module Mod1
  module Alfabeto
    A=0
    B=1
    C=2
    D=3
  end

  Vector_nombres = Array["Carlos", "Antonio", "Jesus"]

  class ObjectTest1
    def initialize(value)
      @integer = value
    end

    attr_reader :integer

    def main
      check = self.integer
      case check
      when Alfabeto::A
        puts "A"
      when Alfabeto::B
        puts "B"
      when Alfabeto::C
        puts "C"
      when Alfabeto::D
        puts "D"
      else
        puts "Wrong Letter"
      end
    end
  end
end

module Mod2
  include Mod1
  class ObjectTest2
    def initialize
      @value = 0
    end

    attr_reader :value

    def print_ObjectTest2
      puts self.value.to_s
    end

    def print_ObjectTest1
      objeto1 = Mod1::ObjectTest1.new(25)
      puts objeto1.integer.to_s
    end

  end

end

# Para probar
obj = Mod1::ObjectTest1.new(0)
obj.main

def filtro
  integer = 0
  loop do
    puts "Introduzca el valor de integer\n"
    st = gets.chomp
    integer = st.to_i
    break if (1<= integer && integer<=10)
  end
  puts "Valor correcto! Integer = " + integer.to_s
  suma = integer + integer
  puts "Suma = " + suma.to_s
end


# filtro
nombre = "Nombre: "
nombre += Mod1::Vector_nombres[1]
puts nombre

direccion = Modelo_laberinto::Lista_direcciones[2]
puts direccion

# Genera numeros aleatorios
random = Random.new
for i in (0..9)
  value = random.rand(4)
  puts "\tAleatorio " + i.to_s + " = " + value.to_s
end

object_test2 = Mod2::ObjectTest2.new
object_test2.print_ObjectTest2
object_test2.print_ObjectTest1