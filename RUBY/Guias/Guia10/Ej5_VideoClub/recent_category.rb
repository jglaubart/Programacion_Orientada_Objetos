# frozen_string_literal: true

require_relative 'movie_category'
class RecentCategory < MovieCategory
  PRICE = 3
  RENT_DAYS = 1
  LATE_PRICE = 3

  def initialize
    super(PRICE, RENT_DAYS, LATE_PRICE)
  end

  def charges(days)
    @rent_period * days
  end

  def points(days)
    super + days - @rent_period
  end

end
