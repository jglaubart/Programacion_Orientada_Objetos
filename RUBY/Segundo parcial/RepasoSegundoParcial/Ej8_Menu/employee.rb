# frozen_string_literal: true

class Employee
  def initialize(name, companies)
    @name = name
    @companies = companies
  end
  attr_reader :companies, :name
end
