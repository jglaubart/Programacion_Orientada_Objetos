# frozen_string_literal: true


class Exceptions  #---> extiende a exception, hay errores que extienden a StandardError, que a su vez extiente a exception
  def Exc
    aux = 1
    raise 'Invalid' unless aux==1   #lanzar a menos que...
    raise "Invalid" if aux != 1     #lanzar si ocurre que...

    arg = nil
    raise ArgumentError.new('Can\'t be nil') if arg.nil?

    raise 'Error'	# => Lanza RuntimeError
  end
end

#capturar ERRORES
begin
  c = a / b
rescue ZeroDivisionError
  puts 'División por cero'
rescue NoMethodError
  puts 'No son números'
end

#Crear excepciones propias
class InvalidPointError < StandardError
  def initialize(msg = 'Invalid Point')
    super
  end
end



############################################################################################################
#Comparaciones
class Father
  def initialize(name)
    @name = name
  end
  def to_s
    @name
  end
end

o1 = Father.new("Padre")
o1.is_a?(Father)   #instanceof Father ---> true
o2 = Father.new("Padre2")

o1.equal?(o2) #es verdadero si a y b son el mismo objeto (a y b referencian la misma instancia). No se recomienda sobreescribirlo.
o1 == o2  # es verdadero si a y b representan el mismo objeto (a y b son equivalentes). Por defecto es lo mismo que equal?. Se recomienda sobreescribirlo.
o1.eql?(o2)  #utilizado por metodos que usen una tabla de hash
o1 === o2   # igual que ==, pero es case sensitive


class Person
def initialize(id) = @id = id
CONST = "Const"

def ==(other)
  return false unless other.is_a?(Person)
  @id == other.id
end
protected attr_reader :id
end


a = Person.new(100)
b = Person.new(100)

      a == b  #true
      a.equal?(b) #false ---> distintos objetos
b = a # asignacion
      a == b #true
      a.equal?(b) #true ---> mismo objeto
############################################################################################################

#Condicionales
a = 1
if a == 0
  puts 'a is zero'
elsif a == 1
  puts 'a is one' # Imprime 'a is one'
elsif a >= 1
  puts 'a is greater than or equal to one'
else
  puts 'a is some other value'
end
######################################
puts 'a is zero' if a.zero?
puts 'a is positive' if a.positive?
######################################
puts 'a is not zero' unless a.zero?
######################################
case
when a == 1, a == 2
  puts 'a is one or two'
when a == 3
  puts 'a is three'
else
  puts 'I don\'t know what a is'
end

