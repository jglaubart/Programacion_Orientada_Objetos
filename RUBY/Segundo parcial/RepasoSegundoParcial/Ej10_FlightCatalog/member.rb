# frozen_string_literal: true

require_relative 'flight'
class Member
  def initialize(name, category)
    @name = name
    @category = category
    @miles_by_airline = Hash.new{0}  # se debe hacer con Hash.new para poder pasar el 0 como valor inicial
  end

  attr_reader :name

  def add_miles(flight)
    current = @miles_by_airline[flight.airline]
    new_miles = @category.miles(flight.miles, current)
    @miles_by_airline[flight.airline] = new_miles
  end

  def get_miles(airline)
    @miles_by_airline[airline]
  end

  def use_miles(flight)
    miles = flight.miles
    return false unless @miles_by_airline[flight.airline] >= miles
    @miles_by_airline[flight.airline] -= miles
    return true
  end
end
