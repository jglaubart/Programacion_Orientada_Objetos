# frozen_string_literal: true

module Expression
  def evaluate
    raise 'Not implemented'
  end

  def not
    require_relative 'not_expression'
    NotExpression.new(self)
  end

  def and(exp)
    require_relative 'and_expression'
    AndExpression.new(self, exp)
  end

  def or(exp)
    require_relative 'or_expression'
    OrExpression.new(self, exp)
  end

end
