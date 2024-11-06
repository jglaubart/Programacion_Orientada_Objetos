# frozen_string_literal: true
require_relative 'category'
class Standard < Category
  MULTIPLIER = 1
  MAX = 1000

  def initialize
    init_for_cat(MULTIPLIER)
  end

  def max_miles
    MAX
  end
end
