# frozen_string_literal: true

class Category
  def initialize
    raise 'Abstract class'
  end

  def miles(flight_miles, current_miles)
    new_miles = current_miles + flight_miles * @multiplier
    return new_miles unless reached_limit(new_miles)
    return max_miles
  end

  private
  def reached_limit(miles)
    miles > max_miles
  end

  def init_for_cat(multiplier)
    @multiplier = multiplier
  end

  def max_miles
    raise 'Abstract'
  end
end
