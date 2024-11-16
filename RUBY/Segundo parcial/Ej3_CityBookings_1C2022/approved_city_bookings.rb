# frozen_string_literal: true
require_relative 'max_city_bookings'
require_relative 'booking_exception'
class ApprovedCityBookings < MaxCityBookings
  def initialize(city, max, approved)
    super(city, max)
    @approved = approved
  end

  def book(attraction, day)
    raise BookingException,'Attraction not approved' unless @approved.include?(attraction)
    super(attraction, day)
  end

  attr_reader :max
end
