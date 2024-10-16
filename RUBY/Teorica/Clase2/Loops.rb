# frozen_string_literal: true

#While
a = 1
while a < 10 do
puts a
a += 1
end        #1 2 3 4 5 6 7 8 9

#Otra forma
a = 0
puts a while (a += 1) < 10

######################################################
#Until
a = 1
until a == 10
  puts a
  a += 1
end        #1 2 3 4 5 6 7 8 9

#Otra forma
a = 0
puts a until (a += 1) == 10
######################################################
# Break
a = 1
while true do
  puts a
  a += 1
  break if a == 10
end
##########################################################################################################################
#EJERCICIO: Escribir un programa que imprima los pares entre 1 y 100 inclusive, incrementando de a 1 una variable entera
#Opcion 1
a = 1
while a <= 100
  puts a if a % 2 == 0
  a += 1
end

#Opcion 2
for a in (1..100)
  puts a if a.even?
end

#Opcion 3
101.times { |a| puts a if a.nonzero? && a.even? }
100.times {|a|puts a+1 if a.odd?}
############################################################################################################





