# frozen_string_literal: true

class Table
  include Comparable

  def initialize(name, cap, section)
    @name = name
    @cap = cap
    @section = section
  end

  def <=>(other)
    [other.cap, @name] <=> [@cap, other.name]
  end

  attr_reader :name, :cap

  def to_s
    "Table #{@name} for #{@cap} in section #{@section}"
    #Table Mesa 2 for 4 people in section Planta Baja
  end
end
