# frozen_string_literal: true

class Product
  def initialize(name, price)
    @name = name
    @price = price
  end

  attr_reader :name, :price

  def ==(other)
    return false unless other.is_a?(Product)
    name == other.name && price == other.price
  end


end
