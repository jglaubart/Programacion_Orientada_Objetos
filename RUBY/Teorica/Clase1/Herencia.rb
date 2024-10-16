# frozen_string_literal: true

class Father
  def initialize(name)
    @name = name
  end

  def self.default_make = 'Father'    #con self es metodo de clase

  def father_one = self.class.default_make

  def father_two = Father.default_make

  def to_s
    "Father: #{@name}"
  end
end

class Son < Father    #Herencia
  def self.default_make = 'Son'
  ####################################
  #Super  --->   llama al metodo con el mismo nombre de la clase padre, no se puede llamar a otro
  def to_s
    "Son of #{super}"
  end
  ####################################
end


a = Son.new("Hijo")      #Son
puts a.father_one             #Father
puts a.father_two

a = Father.new("Padre")
puts a.father_one
puts a.father_two

a = Father.new("Padre2")
# puts a.default_make    ---> Error, no puedo llamar a un metodo de clase
