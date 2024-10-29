# frozen_string_literal: true
require_relative '../C/wheel'
class GearD
  def initialize(chairing, cog, rim = nil, tire = nil)
    @chairing = chairing
    @cog = cog
    @wheel = Wheel.new(rim,tire)
  end

  #attr_accessor :chairing, :cog, :wheel


  def ratio
    @chairing / @cog.to_f
  end

  def gear_inches
    @wheel.diameter * ratio
  end
end
