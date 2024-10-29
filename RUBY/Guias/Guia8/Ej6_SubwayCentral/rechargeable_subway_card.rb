# frozen_string_literal: true

require_relative 'subway_card'
class RechargeableSubwayCard < SubwayCard
  def initialize(central)
    @subway_central = central
    @balance = 0
  end

  private def ride_cost
    @subway_central.ride_cost
  end

  private def can_ride?
    ride_cost <= @balance
  end

  def recharge(num)
    raise 'Invalid parameter' unless ride_cost.is_a?(Numeric) && ride_cost.positive?
    @balance += num
  end

  def ride
    raise 'Not enough funds' unless can_ride?
    @balance -= ride_cost
  end

  def to_s
    "Rechargeable #{super} [Balance: $#{@balance}]"
  end

end

