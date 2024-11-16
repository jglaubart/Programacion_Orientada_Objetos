# frozen_string_literal: true
require_relative 'team'
class TeamPosition
  def initialize(team)
    @team = team
    @points = 0
    @gf = 0
    @gc = 0
  end

  attr_reader :points, :gf, :gc, :team

  def match(gf, gc)
    @gf += gf
    @gc += gc

    @points += 3 if gf > gc
    @points += 1 if gc == gf
  end

  def <=>(other)
    return nil unless other.is_a?(TeamPosition)
    [other.points, other.gf, other.gc, other.team.country] <=> [@points, @gf, @gc, @team.country]
  end

  def to_s
    "#{@team.country} #{@points} #{gf} #{gc}"
  end
end
