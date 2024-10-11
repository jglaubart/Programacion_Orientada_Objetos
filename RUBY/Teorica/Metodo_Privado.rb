# frozen_string_literal: true

class Father
  def priv_method
    puts "Private method"
  end
  private :priv_method


  def protected_method
    puts "Protected method"
  end
  def father_method(other)
    other.protected_method
  end
  protected :protected_method
end

class Son < Father
  def self.default_make
    'Son'
  end
  def some_method
    priv_method     #puedo llamar a un metodo privado de la clase padre
  end


  def method2
    protected_method
  end
end

son = Son.new
son.some_method
son = Son.new
son.method2

