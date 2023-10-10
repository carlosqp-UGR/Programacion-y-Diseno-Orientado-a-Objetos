require_relative 'operacion.rb'
require_relative 'estado_juego.rb'
require_relative '../modelo_laberinto/direccion'

module Controlador_laberinto
  class Controlador

    def initialize(modelo)
      @vidas = 0
      @estado = Estado_juego::EN_ENTRADA_LABERINTO
      @modelo = modelo
      @habitacion_usuario = nil
    end

    attr_reader :estado, :habitacion_usuario, :vidas

    def entrar(vidas)
      # Actualiza el numero de vidas
      @vidas = vidas
      # Cambiar a la habitacion de entrada al laberinto:
      #   - Pedir a la puerta_entrada del laberinto(modelo) la habitacion_al_otro_lado de donde está el usuario (que es nula, pues está fuera)
      @habitacion_usuario = @modelo.puerta_entrada.habitacion_al_otro_lado(nil)
      #   - Construir una pared (nueva_pared de Elemento_separador)
      pared =  Modelo_laberinto::Elemento_separador.nueva_pared(@habitacion_usuario, nil)
      #   - Cambiar la puerta de entrada (al SUR) por dicha pared (set_lado)
      @habitacion_usuario.set_lado(Modelo_laberinto::Direccion::SUR, pared)

      # Actualiza el estado del juego
      @estado = Estado_juego::DENTRO_VIVO
    end

    def intentar_avanzar
      # Se mueve aleatoriamente en una direccion
      random = Random.new
      direccion_avance = random.rand(5)
      puts "Intenta avanzar hacia " + Modelo_laberinto::Lista_direcciones[direccion_avance]
      if direccion_avance==Modelo_laberinto::Direccion::HIPERESPACIO
        if (@habitacion_usuario == @modelo.habitaciones[0])
          @habitacion_usuario = @modelo.habitaciones[2]
        else  # @habitacion_usuario == @modelo.habitaciones[1] || @habitacion_usuario == @modelo.habitaciones[2]
          @habitacion_usuario = nil
          @estado = Estado_juego::EN_SALIDA_LABERINTO
        end
      else
        # Comprueba si puede pasar
        puede_pasar = @habitacion_usuario.pasar(direccion_avance)

        if puede_pasar  # Si puede pasar cambia de habitación
          @habitacion_usuario = @habitacion_usuario.get_lado(direccion_avance).habitacion_al_otro_lado(@habitacion_usuario)
          if (@habitacion_usuario == nil)  # Si la nueva habitacion es nula, cambia de estado
            @estado = Estado_juego::EN_SALIDA_LABERINTO
          end
        else  # Si no puede pasar pierde una vida
          @vidas = @vidas - 1
          if (@vidas <= 0)  # Si no le quedan vidas, cambia de estado
            @estado = Estado_juego::DENTRO_MUERTO
          end
        end
      end
      return direccion_avance
    end

  end
end
