# frozen_string_literal: true

class AbstractClass
  def initialize
    raise 'Cannot instantiate an abstract class'   #Si se trata de instanciar, se lanza una excepcion
  end

  def init(some_var)
    @some_var = some_var
  end

  private :init
end

class ConcreteClass < AbstractClass
  def initialize(some_var, other_var)
    init(some_var)
    @other_var = other_var
  end

  def to_s
    "#{@some_var} - #{@other_var}"
  end
end


