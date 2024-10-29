# frozen_string_literal: true

class MovieCategory
  def initialize(price, rent_period, late_price)
    @price = price
    @rent_period = rent_period
    @late_price = late_price
  end

  def charges(days)
    return @price + (@late_price * (days - @rent_period)) if days > @rent_period
    @price
  end

  def points(days)   #en principio suma 1 por cada pelicula nueva
    1
  end
end
