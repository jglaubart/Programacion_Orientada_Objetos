# frozen_string_literal: true

class Raffle
  include Comparable

  def initialize(name, prize)
    @name = name
    @prize = prize
  end

  attr_reader :name, :prize

  def ==(other)
    return false unless other.is_a?(Raffle)
    name == other.name
  end

  alias_method :eql?, :==

  def hash
    [@name].hash
  end

  def <=>(other)
    return nil unless other.is_a?(Raffle)
    c = [other.prize, @name] <=> [@prize, other.name]  #descendente por premio, alfabetico por nombre
  end

  def to_s
    "#{@name} - Prize: #{@prize}"
  end
end
