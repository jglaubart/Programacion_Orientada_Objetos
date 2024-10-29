# frozen_string_literal: true
require_relative 'figure'
class Rectangle < Figure
  def initialize(p1, p2)
    @p1 = p1
    @p2 = p2
  end

  def base
    (@p2.x - @p1.x).abs
  end
  def height
    (@p2.y - @p1.y).abs
  end

  def perimeter
    2*height + 2*base
  end

  def area
    height*base
  end

  def to_s
    "Rectangulo [ #{@p1} , #{@p2} ]"
  end
end
