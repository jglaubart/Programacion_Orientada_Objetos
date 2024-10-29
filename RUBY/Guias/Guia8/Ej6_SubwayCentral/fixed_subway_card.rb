# frozen_string_literal: true
require_relative 'subway_card'

class FixedSubwayCard < SubwayCard
  def initialize(central, rides)
    @subway_central = central
    raise 'Invalid rides parameter' unless rides.is_a?(Integer) && rides.positive?
    @rides = rides
  end

  private def can_ride?
    @rides > 0
  end

  def ride
    raise 'Not more rides' unless can_ride?
    @rides -= 1
  end

  def to_s
    "Fixed #{super} [Rides: #{@rides}]"
  end
end
