# frozen_string_literal: true

require_relative 'formatted_text'
class BoldText < FormattedText
  FORMAT = 'b'

  def initialize(content)
    super(content, FORMAT)
  end
end
