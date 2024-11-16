# frozen_string_literal: true
require_relative 'city_bookings'
require_relative 'booking_exception'
class MaxCityBookings < CityBookings
  def initialize(city, max)
    @max = max
    super(city)
  end

  def book(attraction, day)
    raise BookingException,'Reached Max' if @bookings.size == @max
    super(attraction, day)
  end

  attr_reader :max
end
