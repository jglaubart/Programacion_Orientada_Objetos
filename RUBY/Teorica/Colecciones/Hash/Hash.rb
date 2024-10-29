# frozen_string_literal: true

#Colección no ordenada de pares clave-valor
# Cada valor se “indexa” por una clave que es única
# Si se accede por una clave inexistente, retorna nil
# La implementación utiliza una tabla de Hash, similar a HashMap en Java

months = {}       			# Un hash vacío
p months[1]       			# => nil

months = Hash.new             # Un hash vacío
p months[1]       			# => nil

months = Hash.new('month')	# "month" es el valor por defecto
p months[1]           		# => "month"

months = {}
months[3] = 'Marzo'
months[5] = 'Mayo'
months['Jan'] = 'Enero'
p months[1]				# => "nil"
p months[3]				# => "Marzo"
p months[5]				# => 'Mayo'

p months 				# {3=>"Marzo", 5=>"Mayo", "Jan"=>"Enero"}
p months.keys   			# => [3, 5, "Jan"]
p months.key?('Jan') 		# => true
p months.values   		# => ["Marzo", "Mayo", "Enero"]
p months.value?('Jan')	# => false

months.each { |key, value| puts "#{key} -> #{value}" }
# 3 -> Marzo
# 5 -> Mayo
# Jan -> Enero

###################################################################################################
# Set tiene un Hash donde la clave es el elemento y el valor es siempre la instancia true

# class Hash
# include Enumerable
#
# def []=(key, value)
# def [] key
# def delete(key)
# def key?(key)
# def value?(value)
# def keys
# def values
#
#def size
#def empty?
#def default=(value)
# def clear
# def each
# def each_key
# def each_value
###################################################################################################
#ejercicio HASH

class Point
  def initialize(x, y)
    @x, @y = x, y
  end
  def ==(other)
    return false unless other.is_a?(Point)
    @x == other.x && @y == other.y
  end
  def hash
    [@x, @y].hash
  end
  alias_method :eql?, :==
  attr_accessor :x, :y
end

my_map = Hash.new
p1 = Point.new(0, 0)
p2 = Point.new(1, 1)
p3 = Point.new(2, 2)
my_map[p1] = '00'
my_map[p2] = '11'
my_map[p3] = '22'

p my_map.key?(p1)    # ==> true
p1.x = 2
p my_map.key?(p1)    # ==> false

class Point2
  def initialize(x, y)
    @x, @y = x, y
  end
  def ==(other)
    return false unless other.is_a?(Point2)
    @x == other.x && @y == other.y
  end
  def hash
    @x + @y
  end
  alias_method :eql?, :==
  attr_accessor :x, :y
end

my_map = Hash.new
p1 = Point2.new(0, 2)
p2 = Point2.new(1, 1)
p3 = Point2.new(2, 0)
my_map[p1] = '02'
my_map[p2] = '11'
my_map[p3] = '20'

p my_map[p1]    # ==> "02"
p my_map[p2]    # ==> "11"
p my_map[p3]    # ==> "20"

my_map[Point2.new(1.0, 1.0)] = '1.0, 1.0'
p my_map[p2]   # ==> "1.0, 1.0"
###################################################################################################
# VALORES POR DEFECTO

#Si se invoca con paréntesis el valor por defecto es una única instancia
#Si se invoca con llaves el valor por defecto se obtiene evaluando el bloque cada vez

months = Hash.new('september')
months[2].upcase!
p months[2] # "SEPTEMBER"
p months[4] # "SEPTEMBER"

months = Hash.new{'september'}
months[2].upcase!
p months[2] # "september"
p months[4] # "september"

#La diferencia entre paréntesis y llaves es importante
# por ejemplo cuando el valor por defecto es una colección vacía

mal = Hash.new([])
mal['hola'] = mal['hola'] << 'mundo'
mal['hola'] = mal['hola'] << 'adios'
mal['hello'] = mal['hello'] << 'world'

p mal # ==> {"hola"=>["mundo", "adios", "world"], "hello"=>["mundo", "adios", "world"]}


bien = Hash.new {[]}
bien['hola'] = bien['hola'] << 'mundo'
bien['hola'] = bien['hola'] << 'adios'
bien['hello'] = bien['hello'] << 'world'

p bien  # ==> {"hola"=>["mundo", "adios"], "hello"=>["world"]}