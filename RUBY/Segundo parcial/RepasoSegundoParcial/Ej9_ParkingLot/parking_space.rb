# frozen_string_literal: true

class ParkingSpace
  def initialize(id)
    @available = true
    @id = id
  end

  def park
    raise 'Cannot park reserved parking space' unless @available
    @available = false
  end

  def unpark
    raise 'Cannot unpark available parking space' if @available
    @available = true
  end

  def <=>(other)
    return nil unless other.is_a?(ParkingSpace)
    id <=> other.id
  end

  attr_reader :id

  def to_s
    "##{id}: #{@available ? 'available' : 'reserved'}"
  end
end

