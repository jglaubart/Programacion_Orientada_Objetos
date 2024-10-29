# frozen_string_literal: true

class ComplexNumber
  def initialize(real, img)
    @real = real
    @img = img
  end
  attr_reader :real, :img

  def +(other)
    ComplexNumber.new(real + other.real, img + other.img)
  end

  def to_s
    "#{real} #{img.positive? ? "+ #{img.abs}i" : "- #{img.abs}i"}"
  end
end
