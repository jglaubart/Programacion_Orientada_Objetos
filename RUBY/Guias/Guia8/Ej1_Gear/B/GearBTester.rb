# frozen_string_literal: true

require_relative 'gearB'

rim = 26
tire = 1.5
puts GearB.new(52, 11, rim, tire).gear_inches # => 137.0909090909091
rim = 24
tire = 1.25
puts GearB.new(52, 11, rim, tire).gear_inches # => 125.27272727272728