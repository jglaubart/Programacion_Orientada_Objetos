# frozen_string_literal: true

require_relative 'movie_category'
class ChildrenCategory < MovieCategory
  PRICE = 3
  RENT_DAYS = 3
  LATE_PRICE = 1.5

  def initialize
    super(PRICE, RENT_DAYS, LATE_PRICE)
  end
end
