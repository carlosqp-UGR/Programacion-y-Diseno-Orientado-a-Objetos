# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "direccion.rb"

module Modelo_laberinto

class Habitacion
  
  attr_reader :num_habitacion
  
  def initialize (num_habitacion)
    @num_habitacion=num_habitacion
    @lados=Array.new(4)
  end
  
  def set_lado(direccion, separador)
    @lados[direccion]=separador
  end
  
  def get_lado(direccion)
    @lados[direccion]
  end
  
  def pasar(direccion)
    if get_lado(direccion)!=nil && get_lado(direccion).tipo==Tipo_separacion::PUERTA
      return true
    else return false
    end
  end
  
  def to_s
    p="Habitacion "+@num_habitacion.to_s+"\n"
    p=p+"\tLados:\n"
    p=p+"\t\tNorte: "+@lados[Direccion::NORTE].to_s+"\n"
    p=p+"\t\tSur "+@lados[Direccion::SUR].to_s+"\n"
    p=p+"\t\tEste: "+@lados[Direccion::ESTE].to_s+"\n"
    p=p+"\t\tOeste: "+@lados[Direccion::OESTE].to_s+"\n"
  end
  
end

end
