# frozen_string_literal: true

class Gear
  def initialize(chairing, cog)
    @chairing = chairing
    @cog = cog
  end

  attr_accessor :chairing, :cog

  def ratio
    @chairing / @cog.to_f
  end
end
