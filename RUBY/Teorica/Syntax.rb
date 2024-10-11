# frozen_string_literal: false

class Date
  #variable de instancia ---> @. No hace falta declararlas, las reconoce en el constructor
  # variable de clase (static) ---> @@

  def initialize(day, month, year)#Constructor
    @day = day
    @month = month
    @year = year
  end
  #########################################################################
  #GETTER
  attr_reader :day, :month, :year #hace directamente los tres getters
  ##########################################################################
  #SETTER
  attr_writer :month, :year, :day
  ##########################################################################
  #GTTER Y SETTER JUNTOS
  attr_accessor :month, :year, :day
  ##########################################################################
end
##########################################################################
#Puedo retomar la definicion de la clase y seguir agregando cosas  ---> puedo modificar clases ya existentes
class Date
  def to_s
    "Fecha: #{@day} / #{@month} / #{@year}"
  end
end



##########################################################################
##########################################################################
##########################################################################
#Main suelto


aux = Date.new(31,10,2024)
puts aux

aux.day = 1
aux.month = aux.month+1

puts aux
##########################################################################
#CONSTANTE
CONST_NEW_YEAR = Date.new(1,1,2025)
##########################################################################
#STRINGS
s1 = 'World'
puts "Hello #{s1}\n"   # con " " dobles se puede hacer un formatted
puts 'Hello {s1}\n'    # con '' simples es todo literal

size = s1.size #5
only_ascii = s1.ascii_only? #false
new_instance = s1.capitalize # => retorna una nueva instancia 'Abc'
chars = s1.chars # => ["a", "b", "c"]
isInclude = s1.include?('ld') # => true
isInclude2 = s1.include?('dl') # => false
s_to_String = s1.to_s # => "abcde"
orld = s1.delete('W') # => "orld"
multiple_delete = 'abcdeabcde'.delete('^a') # => "aa" , negacion
reverse = 'abcde'.reverse # => "edcba"
multiple = '|' * 5 # => "|||||"

s2 = "Hello you"
s2["you"] = "World"  #queda "Hello World"

##########################################################################
#valores por defecto
def hello(first_name = 'John', last_name = 'Doe')
  "Hello #{first_name} #{last_name}"   #Devuelve el String
end

# aux.toupper  ----> no hay compilacion por lo que siempre falla en ejecucion pero se puede ejecutar




