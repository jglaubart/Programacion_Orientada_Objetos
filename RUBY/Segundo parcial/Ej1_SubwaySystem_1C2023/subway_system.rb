# frozen_string_literal: true

require_relative 'subway_line'
require_relative 'subway_station'
require 'set/sorted_set'

class SubwaySystem

  def initialize(city)
    @city = city
    @stations_per_line = {}
  end

  def add_station(line, station)
    new_line = SubwayLine.new(line)
    @stations_per_line[new_line] = SortedSet.new unless @stations_per_line.key?(new_line)
    new_station = SubwayStation.new(station)
    @stations_per_line[new_line].add(new_station)
    new_station
  end

  def lines
    @stations_per_line.keys
  end

  def stations(line)
    @stations_per_line[SubwayLine.new(line)]
  end

end
