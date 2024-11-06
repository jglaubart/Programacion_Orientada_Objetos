# frozen_string_literal: true
require_relative 'flight_catalog'
require_relative 'member'
require_relative 'platinum'
require_relative 'standard'
require_relative 'gold'
require_relative 'flight_operator'

flight_catalog = FlightCatalog.new

flight_catalog.add_flight(Flight.new('LA1','LATAM',200,600))
flight_catalog.add_flight(Flight.new('LA2','LATAM',400,3000))
flight_catalog.add_flight(Flight.new('LA3','LATAM',40,200))
flight_catalog.add_flight(Flight.new('UA1','United',3500,5000))

flight_operator = FlightOperator.new(flight_catalog)

juan = Member.new('Juan', Gold.new) # Juan tiene Categoría Gold

puts flight_operator.miles_status(juan, 'United') # 0
puts flight_operator.miles_status(juan, 'LATAM') # 0

puts flight_operator.buy_flight('UA1', juan) # 3500

puts flight_operator.miles_status(juan, 'United') # 2000 por el tope de categoría
puts flight_operator.miles_status(juan, 'LATAM') # 0

malena = Member.new('Malena', Platinum.new) # Malena tiene Categoría Platinum

puts flight_operator.miles_status(malena, 'United') # No registra millas
puts flight_operator.miles_status(malena, 'LATAM') # No registra millas

puts flight_operator.buy_flight('UA1', malena) # 3500
puts flight_operator.buy_flight('LA1', malena) # 200

puts flight_operator.miles_status(malena, 'United') # 6250.0 = 5000 * 1.25
puts flight_operator.miles_status(malena, 'LATAM') # 750.0 = 600 * 1.25

puts flight_operator.buy_flight('LA2', malena) # 400

puts flight_operator.miles_status(malena, 'United') # 6250.0
puts flight_operator.miles_status(malena, 'LATAM') # 4500.0 = 750.0 + 3000 * 1.25

puts flight_operator.buy_flight('LA3', malena) # 0 porque tenía 200 millas

puts flight_operator.miles_status(malena, 'United')  # 6250.0
puts flight_operator.miles_status(malena, 'LATAM') # 4300.0 = 4500.0 - 200.0

#Juan no registra millas acumuladas en United
# Juan no registra millas acumuladas en LATAM
# 3500
# Millas de Juan en United: 2000
# Millas de Juan en LATAM: 0
# Malena no registra millas acumuladas en United
# Malena no registra millas acumuladas en LATAM
# 3500
# 200
# Millas de Malena en United: 6250.0
# Millas de Malena en LATAM: 750.0
# 400
# Millas de Malena en United: 6250.0
# Millas de Malena en LATAM: 4500.0
# 0
# Millas de Malena en United: 6250.0
# Millas de Malena en LATAM: 4300.0
