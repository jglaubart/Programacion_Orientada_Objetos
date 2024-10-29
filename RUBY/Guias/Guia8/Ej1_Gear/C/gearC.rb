# frozen_string_literal: true

class GearC
  def initialize(chairing, cog, wheel = nil)
    @chairing = chairing
    @cog = cog
    @wheel = wheel
  end

  #attr_accessor :chairing, :cog, :wheel

  def ratio
    @chairing / @cog.to_f
  end

  def gear_inches
    @wheel.diameter * ratio
  end
end
