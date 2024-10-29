# frozen_string_literal: true

class GearB
  def initialize(chairing, cog, rim, tire)
    @chairing = chairing
    @cog = cog
    @rim = rim
    @tire = tire
  end

  attr_accessor :chairing, :cog

  def ratio
    @chairing / @cog.to_f
  end

  def diameter
    @rim + 2 * @tire
  end
  private :diameter

  def gear_inches
    ratio * diameter
  end

end
