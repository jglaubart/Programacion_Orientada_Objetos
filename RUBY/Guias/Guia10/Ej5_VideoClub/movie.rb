# frozen_string_literal: true

class Movie
  def initialize(name, cat)
    @name = name
    @category = cat
  end

  attr_reader :category
end
