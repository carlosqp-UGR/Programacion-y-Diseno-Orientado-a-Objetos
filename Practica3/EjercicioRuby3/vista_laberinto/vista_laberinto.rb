
class Vista_laberinto

  def initialize(controlador)
    @controlador=controlador
  end

  def menu_usuario()
    estado = @controlador.estado
    case (estado)
    when Controlador_laberinto::Estado_juego::EN_ENTRADA_LABERINTO
      # Filtro de entrada do-while: inicio del juego
      num_vidas = 0
      loop do
        puts "Intoduzca el número de vidas (entre 1 y 10) antes de entrar en el laberinto: \n"
        st = gets.chomp
        num_vidas = st.to_i
        break if (1<=num_vidas && num_vidas<=10)
        end
      @controlador.entrar(num_vidas)

    when Controlador_laberinto::Estado_juego::DENTRO_VIVO
      # Seguir jugando
      self.informe_dentro(@controlador.habitacion_usuario, @controlador.vidas)
      puts "\nPulse ENTER para continuar"
      st = gets.chomp
      @controlador.intentar_avanzar
      # puts Lista_direcciones[@controlador.intentar_avanzar]

    when Controlador_laberinto::Estado_juego::EN_SALIDA_LABERINTO
      self.informe_final(@controlador.habitacion_usuario, @controlador.vidas)
      exit 0

    when Controlador_laberinto::Estado_juego::DENTRO_MUERTO
      self.informe_final(@controlador.habitacion_usuario, @controlador.vidas)
      exit 0
    end

    # Finalizamos el método llamando nuevamente a este para que vuelva a evaluar el estado
    self.menu_usuario
  end

  def informe_dentro(habitacion, vidas)
    puts "Vidas: " + vidas.to_s + "\nHabitacion:\t" +  habitacion.to_s
  end

  def informe_final(habitacion, vidas)
    if (vidas<=0)
      puts "¡Ha perdido! Se ha quedado en " + habitacion.to_s
    else
      puts "¡Ha ganado! Vidas restantes: " + vidas.to_s
    end
  end

end
