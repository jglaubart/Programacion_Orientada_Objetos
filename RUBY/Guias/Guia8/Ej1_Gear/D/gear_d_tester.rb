# frozen_string_literal: true

class GearDTester
  require_relative 'gearD'

  puts GearD.new(52, 11, 26, 1.5).gear_inches # => 137.0909090909091

  puts GearD.new(52, 11).ratio # => 4.7272727272727275
end
