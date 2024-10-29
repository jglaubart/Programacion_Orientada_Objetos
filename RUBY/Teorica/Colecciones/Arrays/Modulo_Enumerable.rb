  # frozen_string_literal: true

  #Las colecciones de Ruby incluyen el módulo Enumerable e implementan un
  # metodo each
  # que permite iterar por los sus elementos

  ####module Enumerable###
  #  def count
  #  def select
  #  def map
  #  def reduce
  #  def to_a
  #  def sort
  #  def min
  #  def max

  ################################################################################################

  #class Array
  #  include Enumerable
  #  ...
  # class Set
  #  include Enumerable
  #  ...
  # class Hash
  #  include Enumerable
  #  ...
  # class Range
  #  include Enumerable

  ################################################################################################
  # EACH

  # each invoca al bloque una vez para cada elemento de la colección pasando el elemento como parámetro
  # reverse_each itera en sentido inverso

  v = [1, 5, 2]

  v.each { |e| p e }   # ==> 1 5 2

  v.reverse_each { |e| p e } # ==> 2 5 1
  ################################################################################################
  # ENUMERATOR DE EACH / REVERSE_EACH

  # Si al invocar a each no se le envía un bloque se obtiene un Enumerator que puede ser usado como un iterador externo.
  # El metodo next retorna el siguiente valor o lanza la excepción StopIteration si no hay más elementos

  arr = [1, 2, 3]
  a = arr.each
  p a.class		# => Enumerator
  p a				# => #<Enumerator: [1, 2, 3]:each>
  p a.next			# => 1
  p a.next			# => 2
  p a.next			# => 3
  #p a.next			# => iteration reached an end (StopIteration)

  a = arr.each
  p a.take(2)		# => [1, 2]
  p a.next			# => 1


  a = arr.reverse_each
  p a.class		# => Enumerator
  p a				# => #<Enumerator: [1, 2, 3]:reverse_each>
  p a.next			# => 3
  p a.next			# => 2
  p a.next			# => 1
  p a.next			# => iteration reached an end (StopIteration)

  a = arr.reverse_each
  p a.take(2)		# => [3, 2]
  p a.next			# => 3




