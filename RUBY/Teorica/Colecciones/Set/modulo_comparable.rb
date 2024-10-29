# frozen_string_literal: true

#Se debe incluir si se busca ofrecer orden natural para las instancias
# La clase debe definir el comportamiento del operador <=>

#module Comparable
# def <(other)
# def <=(other)
# def ==(other)
# def >(other)
# def >=(other)
# def between?(min, max)
# def clamp(...)
# end

class Date
  include Comparable
  def initialize(year, month, day)
    @year = year
    @month = month
    @day = day
  end

  protected attr_reader :day, :month, :year

  def <=>(o)
    return nil unless o.is_a?(Date)
    [@year, @month, @day] <=> [o.year, o.month, o.day]
  end

end

##################################################################################################
# SORT
b = [3, 2, 4, 5, 6, 1, 8, 3]
p b.sort   # => [1, 2, 3, 3, 4, 5, 6, 8]
p b.sort { |x, y| y <=> x }  # => [8, 6, 5, 4, 3, 3, 2, 1]

set = Set.new(b)
c = set.sort
p c   # => [1, 2, 3, 4, 5, 6, 8]

[3, '2'].sort  # comparison of Integer with String failed (ArgumentError)
##################################################################################################