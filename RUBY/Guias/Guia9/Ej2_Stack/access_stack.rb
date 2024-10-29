# frozen_string_literal: true

require_relative 'stack'
class AccessStack < Stack

  def initialize
    @push_accesses = 0
    @pop_accesses = 0
    super
  end
  def push(elem)
    @push_accesses += 1
    super(elem)
  end

  def pop
    @pop_accesses += 1
    super
  end

  attr_reader :push_accesses, :pop_accesses
end
