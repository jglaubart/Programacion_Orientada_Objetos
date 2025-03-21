# frozen_string_literal: true

class Booking
  include Comparable

  def initialize(attraction, date)
    @attraction = attraction
    @date = date
  end

  attr_reader :attraction, :date

  def <=>(other)
    [@date, @attraction] <=> [other.date, other.attraction]
  end

  def inspect
    "Booking of #{@attraction} on the day #{@date}"
  end
end
