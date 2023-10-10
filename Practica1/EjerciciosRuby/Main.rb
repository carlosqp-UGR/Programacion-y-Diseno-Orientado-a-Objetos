require_relative 'Parcela'

nueva=Parcela.new("Garrucha", 36, 40, 30)
nueva.construirCasa()
nueva.construirCasa()
nueva.print()

vacia=Parcela.new()
vacia.print()