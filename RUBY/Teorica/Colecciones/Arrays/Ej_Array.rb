# frozen_string_literal: true

n = [1, nil, 2, nil, 3, nil, 4, nil]
m = n.clone

#Dado un vector, obtener una copia donde se reemplaza cada nil por 0
i=0
until i == m.size
  m[i] = 0 if m[i] == nil
  i+=1
end

p m

# Dado el vector anterior, obtener la suma de todos sus elementos

sum = 0
i=0
until i == m.size
  sum+=m[i]
  i+=1
end

p sum
