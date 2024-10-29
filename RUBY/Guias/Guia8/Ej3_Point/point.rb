# frozen_string_literal: true

class Point
  def initialize(x,y)
    @x = x
    @y = y
  end

  attr_reader :x, :y

  def to_s
    "{#{@x},#{@y}}"
  end

  def distance(other)
    ((other.x - @x)**2 + (other.y - @y)**2)**0.5
  end
end
