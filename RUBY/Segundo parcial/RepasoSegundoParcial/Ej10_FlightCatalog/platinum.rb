# frozen_string_literal: true
require_relative 'category'
class Platinum < Category
  MULTIPLIER = 1.25

  def initialize
    init_for_cat(MULTIPLIER)
  end

  def reached_limit(miles)
    false
  end
end
