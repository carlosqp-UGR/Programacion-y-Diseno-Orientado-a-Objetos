#include Modelo_laberinto ¿?
#include Controlador_laberinto  ¿?

require_relative 'modelo_laberinto/laberinto'
require_relative 'controlador_laberinto/controlador'
require_relative 'vista_laberinto/vista_laberinto'

# Orden de creación del Modelo-Vista-Controlador
#   1. Modelo
#   2. Controlador
#   3. Vista

puts "Cargando el juego..."

# Se crea el modelo
model = Modelo_laberinto::Laberinto.new()
puts "Modelo creado correctamente."

# Crea el controlador
ctrl = Controlador_laberinto::Controlador.new(model)
puts "Controlador creado correctamente"

# Crea la vista
view = Vista_laberinto.new(ctrl)
puts "Vista creada correctamente."

puts "¡¡ A jugar !!"
view.menu_usuario