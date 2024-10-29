# frozen_string_literal: true

class Item
  def initialize(product, quantity)
    @product = product
    @quantity = quantity
  end

  attr_reader :product
  attr_accessor :quantity


  def total
    @product.price * @quantity
  end

end
