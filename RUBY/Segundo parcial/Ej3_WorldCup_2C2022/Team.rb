# frozen_string_literal: true

class Team
  def initialize(name)
    @country = name
  end

  attr_reader :country

  def ==(other)
    return false unless other.is_a? Team
    @country == other.country
  end

  alias_method :eql?, :==

  def hash
    @country.hash
  end
end
