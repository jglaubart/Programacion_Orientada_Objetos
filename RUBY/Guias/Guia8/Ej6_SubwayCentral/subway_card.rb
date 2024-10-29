# frozen_string_literal: true
require_relative 'subway_central'
class SubwayCard
  @subway_central

  def initialize
    raise 'Abstract Class'
  end

  private def can_ride?
    raise 'implement method'
  end

  def ride
    raise 'implement method'
  end

  def to_s
    "Subway Card [Central: #{@subway_central}]"
  end
end
