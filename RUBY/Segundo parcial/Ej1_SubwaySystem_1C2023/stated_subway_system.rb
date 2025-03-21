# frozen_string_literal: true

require_relative 'subway_system'
require_relative 'stated_subway_station'
require_relative 'subway_line'
require 'set/sorted_set'

class StatedSubwaySystem < SubwaySystem
  def add_station(line, station)
    new_line = SubwayLine.new(line)
    @stations_per_line[new_line] = SortedSet.new unless @stations_per_line.key?(new_line)
    new_station = StatedSubwayStation.new(station)
    @stations_per_line[new_line].add(new_station)
    new_station
  end
end
