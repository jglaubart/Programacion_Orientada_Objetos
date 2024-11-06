# frozen_string_literal: true

require_relative 'museum'
class ThemedMuseum < Museum
  def add_exhibition(pavilion, name, theme)
    raise 'Theme does not match' unless pavilion.theme == theme
    super
  end
end
