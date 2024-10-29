# frozen_string_literal: true

require 'set'
class Bag

  def initialize
    @bag = Hash.new {}
  end

  def add(point)
    @bag[point] = 0 unless @bag.key?(point)   #si no existe lo crea con 0 apariciones
    @bag[point] += 1    #siempre suma 1
  end

  def size
    @bag.size
  end

  def count(point)
    return 0 unless @bag.key?(point)
    @bag[point]
  end

  def delete(point)
    return 0 unless @bag.key?(point)
    @bag[point] -= 1
    @ans = @bag[point]
    @bag.delete(point) if @ans == 0
    @ans
  end

  def to_s
    "{" + @bag.map { |key, value| "#{key}=>#{value}" }.join(", ") + "}"
  end

end
