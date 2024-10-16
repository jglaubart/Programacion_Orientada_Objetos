# frozen_string_literal: true

class Human
  def initialize(first_name, last_name)
    @first_name = first_name
    @last_name  = last_name
  end

  def full_name
    "#{@first_name} #{@last_name}"
  end

  def self.classification   #Metodo de clase con self
    'Mammal'
  end
end
