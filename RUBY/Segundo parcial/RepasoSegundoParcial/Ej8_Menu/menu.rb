# frozen_string_literal: true

require_relative 'Employee'
require_relative 'Company'
class Menu
  def initialize(name)
    @name = name
    @employees = []
    @companies = []
  end

  def authorize(accessor)
    if accessor.is_a?(Employee)
      @employees << accessor
    elsif accessor.is_a?(Company)
      @companies << accessor
    end
  end

  def access?(accessor)
    included_by_company?(accessor) || included_by_employee?(accessor)
  end

  private

  def included_by_employee?(accessor)
    @employees.include?(accessor)
  end

  def included_by_company?(accessor)
    accessor.companies.any? { |company| @companies.include?(company) }
  end
end
