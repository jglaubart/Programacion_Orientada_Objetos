# frozen_string_literal: true

#Los rangos incluyen el módulo Enumerable por lo que ofrecen each y reverse_each para iterar
# Además con step se puede cambiar el salto por defecto

# Imprime los impares del 1 al 9
(1..10).each { |e| p e if e.odd? }

# Imprime los impares del 1 al 9
(1..10).step(2).each { |e| p e }

# Imprime los impares del 9 al 1
(1..10).reverse_each { |e| p e if e.odd? }

# Imprime los impares del 9 al 1
(1..9).step(2).reverse_each { |e| p e }