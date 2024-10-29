# frozen_string_literal: true

class Stack
  def initialize
    @elems = []
  end

  def push(elem)
    @elems.push(elem)
  end

  def pop
    raise "Stack is empty" if empty?
    @elems.pop
  end

  def empty?
    @elems.empty?
  end

  def peek
    raise "Stack is empty" if empty?
    @elems.last
  end
end
