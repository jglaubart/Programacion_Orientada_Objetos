# frozen_string_literal: true
require_relative 'figure'
class Triangle < Figure
  def initialize(p1, p2, p3)
    @p1 = p1
    @p2 = p2
    @p3 = p3
  end

  def to_s
    "Trangulo {#{@p1} , #{@p2} , #{@p3}}"
  end

  def area
    0.5*( @p1.x*(@p2.y - @p3.y) + @p2.x*(@p3.y - @p1.y) + @p3.x*(@p2.y - @p2.y)).abs
  end

  def perimeter
    side1 + side2 + side3
  end

  private
  def side1
    @p1.distance(@p2)
  end
  def side2
    @p2.distance(@p3)
  end
  def side3
    @p3.distance(@p1)
  end
end
