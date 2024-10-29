# frozen_string_literal: true

require_relative 'HTML_text'
class PlainText
  include HTMLText

  attr_writer :content

  def initialize(content)
    @content = content
  end

  def source
    @content
  end
end
