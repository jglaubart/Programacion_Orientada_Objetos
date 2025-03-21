# frozen_string_literal: true
require_relative 'category'
class Gold < Category
  MULTIPLIER = 1.1
  MAX = 2000

  def initialize
    init_for_cat(MULTIPLIER)
  end

  def max_miles
    MAX
  end
end
