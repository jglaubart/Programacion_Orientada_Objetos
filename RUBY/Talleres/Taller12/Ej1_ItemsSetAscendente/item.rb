# frozen_string_literal: true

class Item
  include Comparable

  def <=>(other)
    return nil unless other.is_a?(Item)
    product <=> other.product
  end

  def initialize(product, quantity)
    @product = product
    @quantity = quantity
  end

  attr_reader :product
  attr_accessor :quantity


  def total
    @product.price * @quantity
  end

  def eql?(other)
    return false unless other.is_a?(Item)
    @product == other.product
  end

  def hash
    [@product].hash
  end
end
