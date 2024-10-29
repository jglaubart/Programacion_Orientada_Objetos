# frozen_string_literal: true

class OrExpression
  def initialize(exp1, exp2)
    @exp1 = exp1
    @exp2 = exp2
  end

  def evaluate
    @exp1.evaluate || @exp2.evaluate
  end
end
