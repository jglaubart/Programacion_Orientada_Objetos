# frozen_string_literal: true

require_relative 'ellipse'
class Circle < Ellipse
  def initialize(center, radius)
    super(center, radius*2, radius*2)
  end

  def to_s
    "Circulo [Centro: #{@center}, Radio: #{@ax1/2}]"
  end
end
