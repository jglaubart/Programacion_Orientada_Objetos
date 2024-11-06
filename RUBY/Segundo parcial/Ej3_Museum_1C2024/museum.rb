# frozen_string_literal: true
require_relative 'exhibition'

class Museum
  def initialize
    @exhibits = {}
  end

  def add_exhibition(pavilion, name, theme)
    @exhibits[pavilion] = [] unless @exhibits.key?(pavilion)
    raise 'Cannot add exhibition' if @exhibits[pavilion].size >= pavilion.cap
    @exhibits[pavilion] << Exhibition.new(name, theme)
  end

  def pavilions
    @exhibits.keys
  end

  def pavilion_exhibits(pavilion)
    @exhibits[pavilion]
  end
end
