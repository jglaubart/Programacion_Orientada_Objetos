# frozen_string_literal: true

class Section

  def initialize(name)
    @name = name
  end

  attr_reader :name

  def ==(other)
    return false unless other.is_a?(Section)
    @name == other.name
  end

  alias_method :eql?, :==

  def hash
    @name.hash
  end

  def to_s
    "#{@name}"
  end
end