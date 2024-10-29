# frozen_string_literal: true

a = [10, 20, 30, 40]
b = [10, 20, 50, 50]

puts a[0]		# => 10
puts a[3]		# => 40
puts a[-1]	# => 40    Un índice negativo indica que es relativo al final del array
puts a[-2]	# => 30
puts a.size	# => 4
puts a			# => 10\n20\n30\n40
p a				# => [10, 20, 30, 40]


p a | b           # => [10, 20, 30, 40, 50] Unión

p a & b           # => [10, 20] Intersección

p a - b           # => [30, 40] Resta

p a.intersect?(b) # => true (al menos un elemento en común)

p b.uniq          # => [10, 20, 50]    DEVUELVE NUEVO SIN DUPLICADOS
p b               # => [10, 20, 50, 50]
p b.uniq!         # => [10, 20, 50]  (“bang” method)  SACA LOS REPETIDOS
p b               # => [10, 20, 50]

######################################################################
v = Array.new(10)
puts v.size       # => 10
puts v.count(1)   # => 0    cantidad de apariciones del elemento
v[0] = 1
v[1] = 2
v[10] = 10        # => Agranda el vector una posición
puts v.count(1)   # => 1


p v    # [1, 2, nil, nil, nil, nil, nil, nil, nil, nil, 10]
puts(v.count { |e| e.nil? })   # 8
puts(v.count { |e| !e.nil? && e > 1 })  # 2

puts(v.include?(10))   #true
puts(v.include?(30))   #false
w = v.select { |e| !e.nil? && e > 1 }  # w = [2,10]   --->  devuelve un nuevo array con los elementos que cumplen
v.select! { |e| !e.nil? && e > 1 }   #Mantiente en el vector unicamente los que cumplen
###################################################################################################################
# Sobreescribir el == para que pueda usar bien el count
class Container
  def initialize(value)
    @value = value
  end

  def ==(other)
    return false unless other.is_a?(Container)
    @value == other.value
  end

  protected attr_reader :value
end
###################################################################################################################

# Array ---> Stack
a = ['a', 'b', 'c', 'd']
p a.pop					# => "d"
p a.pop(2)				# => ["b", "c"]
p a         				# => ["a"]

a = ['a', 'b', 'c']
p a.push('d', 'e', 'f')	# => ["a", "b", "c", "d", "e", "f"]

# << es similar a push, pero aplica a un solo parámetro
a = ['a', 'b', 'c']
a << 'd' << 'e' << 'f'
p a 						# => ["a", "b", "c", "d", "e", "f"]
###################################################################################################################
# Vector de vectores
a = [[1, 2, 3], [4, 5, 6]]
p a.size        # => 2
p a             # => [[1, 2, 3], [4, 5, 6]]
p a[0]          # => [1, 2, 3]
p a[0][0]       # => 1
a[2] = 'String'
p a             # => [[1, 2, 3], [4, 5, 6], "String"]

p a[0] == a[1]  # => false
p a[0] == a[4]  # => false
p a[1] == a[-2] # => true

p a[-4]         # => nil