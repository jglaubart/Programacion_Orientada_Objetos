# frozen_string_literal: true

require_relative 'parking_lot'

parking_lot = ParkingLot.new('EstacionARTE')
parking_lot.add_parking_space('A', 1030)
parking_lot.add_parking_space('A', 1000)
parking_lot.add_parking_space('A', 1001)
parking_lot.add_parking_space('B', 1001)
puts parking_lot.information
puts '##########'
begin
  parking_lot.park('Z',1001)
rescue RuntimeError => e
  puts e.message
end
puts '##########'
begin
  parking_lot.unpark('A',9999)
rescue RuntimeError => e
  puts e.message
end
puts '##########'
parking_lot.park('A',1001)
parking_lot.unpark('A',1001)
parking_lot.park('A',1001)
begin
  parking_lot.park('A',1001)
rescue RuntimeError => e
  puts e.message
end
puts '##########'
begin
  parking_lot.unpark('B',1001)
rescue RuntimeError => e
  puts e.message
end
puts '##########'
parking_lot.park('B',1001)
puts parking_lot.information

#Parking Lot EstacionARTE
# Level A
# #1000: Available
# #1001: Available
# #1030: Available
# Level B
# #1001: Available
# ##########
# Invalid Level
# ##########
# Invalid Parking Space
# ##########
# Cannot Park Reserved Parking Space
# ##########
# Cannot Unpark Available Parking Space
# ##########
# Parking Lot EstacionARTE
# Level A
# #1000: Available
# #1001: Reserved
# #1030: Available
# Level B
# #1001: Reserved