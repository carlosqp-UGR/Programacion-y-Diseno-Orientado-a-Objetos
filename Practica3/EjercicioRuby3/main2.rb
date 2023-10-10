require_relative 'modelo_laberinto/laberinto'
require_relative 'controlador_laberinto/controlador'
require_relative 'vista_laberinto/vista2_laberinto'

puts "Cargando el juego..."
# Se crea el modelo
model = Modelo_laberinto::Laberinto.new
# Se crea el controlador
ctrl = Controlador_laberinto::Controlador.new(model)
# Se crea la vista
view = Vista2_laberinto.new(ctrl,model)
# Inicia el juego
puts " ¡¡ A jugar !!"
puts
view.menu_usuario