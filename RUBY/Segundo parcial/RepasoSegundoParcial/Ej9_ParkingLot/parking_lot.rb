# frozen_string_literal: true

require_relative 'parking_space'
class ParkingLot
  def initialize(name)
    @name = name
    @parking_spaces_by_level = {}
  end

  def add_parking_space(level, id)
    @parking_spaces_by_level[level] = {} unless
      @parking_spaces_by_level.key?(level) # se crea un nuevo nivel con nuevo mapa dentro a menos que ya exista el nivel
    @parking_spaces_by_level[level][id] = ParkingSpace.new(id)
  end

  def park(level, id)
    valid_parking_space(level, id)
    @parking_spaces_by_level[level][id].park
  end

  def unpark(level, id)
    valid_parking_space(level, id)
    @parking_spaces_by_level[level][id].unpark
  end

  def information
    s = "Parking Lot #{@name}\n"
    @parking_spaces_by_level.keys.sort.each do |level|
      s += "Level #{level}\n"
      @parking_spaces_by_level[level].values.sort.each do |parking_space|
        s += "#{parking_space}\n"
      end
    end
    s
  end

  private
  def valid_parking_space(level, id)
    raise 'Invalid Level' unless @parking_spaces_by_level.key?(level)
    raise 'Invalid Parking Space' unless @parking_spaces_by_level[level].key?(id)
  end
end
