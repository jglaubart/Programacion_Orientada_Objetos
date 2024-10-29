# frozen_string_literal: true

require_relative 'gearC'
require_relative 'wheel'

puts GearC.new(52, 11, Wheel.new(26, 1.5)).gear_inches # => 137.0909090909091

puts GearC.new(52, 11).ratio # => 4.7272727272727275