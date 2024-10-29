# frozen_string_literal: true
####################################################################################################
# Metodo MAP

#Es un metodo ofrecido por las colecciones (arrays, etc.)
# Recibe un bloque (funcion) y retorna una nueva colección con la misma cantidad de elementos,
# habiendo aplicado el bloque a cada elemento

v = [1, -2, 3, -4]

v2 = v.map { |e| e * 2 }
p v2 # => [2, -4, 6, -8]

v3 = v.map { |e| e.positive? }
p v3 # => [true, false, true, false]


n = [1, nil, 2, nil, 3, nil, 4, nil]
n2 = n.map { |e| e * 2 unless e.nil? }
p n2   # => [2, nil, 4, nil, 6, nil, 8, nil]
####################################################################################################
#Ejercicio MAP

n = [1, nil, 2, nil, 3, nil, 4, nil]
m = n.clone
#Dado un vector, obtener una copia donde se reemplaza cada nil por 0

m.map! {|e | 0 if e.nil?}
p m
