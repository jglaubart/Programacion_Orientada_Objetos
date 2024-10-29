# frozen_string_literal: true

#Colección sin orden y sin repetidos
# La implementación utiliza una tabla de hash (Similar a HashSet en Java)

p s1 = Set[1, 2]            # => #<Set: {1, 2}>
p s2 = [2, 1, 2, 1].to_set  # => #<Set: {2, 1}>
p s1 == s2                  # => true
p s1.add('one')             # => #<Set: {1, 2, "one"}>
p s1.add('one')             # => #<Set: {1, 2, "one"}>
p s1 << 'two'               # => #<Set: {1, 2, "one", "two"}>
p s1.merge([2, 6])   # => #<Set: {1, 2, "one", "two", 6}>
p s1.subset?(s2)            # => false
p s2.subset?(s1)            # => true
p Set[1, 3, 5] - Set[1, 5]  # => #<Set: {3}>
p s1.include?('two')        # => true
s1.each { |e| p e }         # Imprime los elementos del Set

########################################################################################################
#IMPLEMETACIONES OBLIGATORIAS
# ==

#SPACESHIP

#obj.hash:
# es usado por una tabla de hash para indexar un elemento.
# Delegaremos el cálculo del hash a la clase Array


# obj.eql?(other):
# es usado por una tabla de hash para determinar equivalencia entre dos elementos.
# Es un buen diseño implementar la equivalencia sobreescribiendo ==(other) así eql?(other) puede reutilizar ese comportamiento

class Foo
  def initialize(number) = @number = number

  def to_s = @number.to_s

  def inspect = to_s

  def ==(other)
      return false unless other.is_a?(Foo)
      @number == other.number
  end

  def hash
    [@number].hash
  end

  def <=>(other)
    return nil unless other.is_a?(Foo)
    @number <=> other.number
  end

  alias_method :eql?, :==      #Indica que eql? se comporta igual que el ==

  protected attr_reader :number
end
########################################################################################################
# OPERADOR SPACESHIP <=>     ----> similar al compareTo

#Definido en la clase Object y retorna nil
# Se espera que retorne -1, 0 ó 1 si son de la misma clase, o nil si son instancias de distintas clases

p 1 <=> 4       # -1 (También 1.<=>(4))
p 1 <=> 1       # 0
p 4 <=> 1       # 1

p 'Hola' <=> 'Adios'  # 1
p 'Hola' <=> 'Hola'   # 0
p 'Hola' <=> 3        # nil


