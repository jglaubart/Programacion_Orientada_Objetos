# frozen_string_literal: true

class Pavilion
  def initialize(name, max_cap)
    @name = name
    @cap = max_cap
  end

  attr_reader :name, :cap

  def ==(other)
    return false unless other.is_a?(Pavilion)
    [@name, @cap] == [other.name, other.cap]
  end

  def hash
    [@name, @cap].hash
  end

  alias_method :eql?, :==

  def to_s
    "Pavilion #{@name} with cap #{@cap}"
  end
end

