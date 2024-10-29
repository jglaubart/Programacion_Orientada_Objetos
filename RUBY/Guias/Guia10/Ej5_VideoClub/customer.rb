# frozen_string_literal: true

class Customer
  def initialize(name)
    @name = name
    @points = 0
    @charges = 0
  end

  def add_points(points)
    @points += points
  end

  def add_charges(charge)
    @charges += charge
  end

  attr_reader :charges, :points
end
