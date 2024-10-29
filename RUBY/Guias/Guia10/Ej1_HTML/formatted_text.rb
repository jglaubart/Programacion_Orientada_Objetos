# frozen_string_literal: true
require_relative 'plain_text'

class FormattedText < PlainText

  def initialize(content, format)
    super(content)
    @format = format
  end

  def source
    "<#{@format}>#{super}</#{@format}>"
  end
end
