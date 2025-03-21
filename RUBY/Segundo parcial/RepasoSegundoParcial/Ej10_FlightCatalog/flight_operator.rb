# frozen_string_literal: true
require_relative 'flight'
class FlightOperator

  def initialize(catalog)
    @flights = catalog
  end

  def miles_status(member, airline)
    "Millas de #{member.name} en #{airline}: #{member.get_miles(airline)}"
  end

  def buy_flight(code, member)
    flight = @flights.get_flight(code)
    raise 'Flight not found' if flight.nil?
    return 0 if member.use_miles(flight)
    member.add_miles(flight)
    flight.price
  end

end
