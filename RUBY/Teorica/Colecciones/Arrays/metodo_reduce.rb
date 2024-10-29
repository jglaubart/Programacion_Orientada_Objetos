

#Es un metodo ofrecido por las colecciones (arrays, etc.)
# que combina los elementos aplicando una función binaria, y opcionalmente un valor inicial

words = ['Hola', 'Mundo', 'Chau']
l = words.reduce do |longest_w, current_w|
  current_w.length > longest_w.length ? current_w : longest_w
end
p l # => "Mundo"

l = words.reduce { |l_w, c_w| c_w.length > l_w.length ? c_w : l_w }
p l # => "Mundo"

n = [1, nil, 2, nil, 3, nil, 4, nil]
ans = n.reduce { |accum, e| accum.to_s + e.to_s }
p ans # => "1234"

#################################################################################################
# ejercicio Reduce

n = [1, 0, 2, 0, 3, 0, 4, 0]
m = n.clone
#Dado el vector anterior, obtener la suma de todos sus elementos
sum = m.reduce(0) { |accum, e| accum + e }   #0 es el valor inicial de accum, e es el que ira iterando
#La suma se va guardando en accum que luego se devuelve
p sum

#############################################################################################################################
#Si no recibe un valor inicial, toma como valor inicial el primer elemento del enumerable y la iteracion empieza por el segundo

v = [1, 2, 3]

v.reduce { |accum, e| p e }			# => 2 3
v.reduce { |accum, e| p accum }		# => 1 1  ya que accum comienza en 1 que es el primer elemento

v.reduce(0) { |accum, e| p e }       # => 1 2 3
v.reduce(0) { |accum, e| p accum }   # => 0 0 0


