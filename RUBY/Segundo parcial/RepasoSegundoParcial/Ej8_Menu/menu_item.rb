# frozen_string_literal: true
require_relative 'menu'
class MenuItem < Menu
  def initialize(name, menu)
    super(name)
    @menu = menu
  end

  def access?(accessor)
    @menu.access?(accessor) || super(accessor)
  end
end
