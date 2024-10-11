# frozen_string_literal: true

class Father
  def self.default_make = 'Father'    #con self es metodo de clase

  def father_one = self.class.default_make

  def father_two = Father.default_make
end

class Son < Father    #Herencia
  def self.default_make = 'Son'
end


a = Son.new                   #Son
puts a.father_one             #Father
puts a.father_two

a = Father.new
puts a.father_one
puts a.father_two

a = Father.new
# puts a.default_make    ---> Error, no puedo llamar a un metodo de clase
