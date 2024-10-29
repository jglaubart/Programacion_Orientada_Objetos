# frozen_string_literal: true

require_relative 'Movie'
require_relative 'Customer'
class VideoClub
  def initialize
    @movies = Hash.new {}
    @customers = Hash.new {}
  end

  def add_movie(name, category)
    @movies[name] = Movie.new(name, category)
  end

  def add_customer(name)
    @customers[name] = Customer.new(name)
  end

  def rent(movie, customer, days)
    raise "Movie #{movie} not found" unless @movies.include? movie
    raise "Customer #{customer} not found" unless @customers.include?(customer)
    movie = @movies[movie]
    customer = @customers[customer]
    customer.add_points(movie.category.points(days))
    customer.add_charges(movie.category.charges(days))
  end

  def resume(customer_name)
    raise "Customer #{customer_name} not found" unless @customers.include? customer_name
    customer = @customers[customer_name]
    "Resume points: #{customer.points}, charge: #{customer.charges}"
  end

end
