# frozen_string_literal: true

class Product
  include Comparable

  def <=>(other)
    return nil unless other.is_a?(Product)
    [price, name] <=> [other.price, other.name]
  end

  def initialize(name, price)
    @name = name
    @price = price
  end

  attr_reader :name, :price

  def ==(other)
    return false unless other.is_a?(Product)
    name == other.name && price == other.price
  end

  alias_method :eql?, :==

  def hash
    [@name, @price].hash
  end
end
