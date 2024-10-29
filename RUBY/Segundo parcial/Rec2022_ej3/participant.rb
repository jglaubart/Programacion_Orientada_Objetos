# frozen_string_literal: true

class Participant
  def initialize(name, id)
    @name = name
    @id = id
  end

  attr_reader :name, :id

  def to_s
    "#{@name} - DNI: #{@id}"
  end

  def ==(other)
    @name == other.name && @id == other.id    #para el exit y ver si ya existe
  end
end
