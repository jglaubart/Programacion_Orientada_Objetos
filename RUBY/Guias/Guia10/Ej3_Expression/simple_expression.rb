# frozen_string_literal: true
require_relative 'Expression'

class SimpleExpression
  include Expression

  attr_writer :value

  def initialize(value)
    @value = value
  end

  def evaluate
    @value
  end

end
