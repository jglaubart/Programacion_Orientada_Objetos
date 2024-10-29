# frozen_string_literal: true

require_relative 'movie_category'
class StandardCategory < MovieCategory
  PRICE = 2
  RENT_DAYS = 2
  LATE_PRICE = 1.5

  def initialize
    super(PRICE, RENT_DAYS, LATE_PRICE)
  end
end
