# frozen_string_literal: true
require_relative 'figure'
class Ellipse < Figure
  def initialize(center, ax1, ax2)
    @center = center
    mayor = ax1 > ax2 ? ax1 : ax2
    @ax1 = mayor
    @ax2 = ax1 != mayor ? ax1 : ax2
  end

  def to_s
    "Elipse [Centro: #{@center}, DMayor: #{@ax1}, DMenor: #{@ax2}]"
  end

  def area
    Math::PI * (@ax1/2) * (@ax2/2)
  end

  def perimeter
    Math::PI * ((@ax1/2) + (@ax2/2))
  end
end
