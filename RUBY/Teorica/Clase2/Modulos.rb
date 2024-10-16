# frozen_string_literal: true

#Brindan una forma de agrupar métodos, constantes, clases
# Proveen un ambiente con un nombre
# Permiten el uso de mixins: agregar funcionalidad a clases
# Se pueden utilizar en las clases de varias formas
    #include integra los métodos del módulo como métodos de instancia
    # extend integra los métodos del módulo como métodos de clase
    # prepend es similar a include pero difiere en la ubicación de la jerarquía

#Conunto de todos metodos "default" que despues voy a utilizar

module A
  def a1 = 1
  def repetido = "a"
end

module B
  def b1 = 3
  def repetido = "b"
end

class Sample
  include A   #Con include son metdos de instancia
  include B
  extend B    #Con extend metodo de clase

  def s1 = 5
end

samp = Sample.new
puts samp.a1   #1
puts samp.b1   #3
puts samp.s1   #5
puts samp.repetido   #imprime b ya que el modulo B se agrego despues por lo que el ultimo

puts Sample.b1 # b, lo llamo desde la clase Sample ya que se tomo tambien como metodo de clase