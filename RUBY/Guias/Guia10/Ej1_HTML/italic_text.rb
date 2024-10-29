# frozen_string_literal: true

require_relative 'formatted_text'
class ItalicText < FormattedText
  FORMAT = 'i'

  def initialize(content)
    super(content, FORMAT)
  end
end
