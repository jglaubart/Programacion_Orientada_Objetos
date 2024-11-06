# frozen_string_literal: true
require_relative 'subway_station'
class StatedSubwayStation < SubwayStation
  def initialize(name)
    super(name)
    @state = "Open"
  end

  attr_reader :state

  def close_station
    @state = "Closed"
  end

  def open_station
    @state = "Open"
  end

  def to_s
    "#{super} is #{@state}"
  end
end
