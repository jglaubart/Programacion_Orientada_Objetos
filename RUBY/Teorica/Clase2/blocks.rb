# frozen_string_literal: true

# Imprime los números del 0 al 8
9.times do |e|
  p e
end

# Imprime los impares del 0 al 8
9.times do |e|
  p e if e.odd?
end

# Si es una sola proposición
9.times { |e| p e if e.odd? }


####################################################33
# Bloques con yield
def Block
  def test
    puts 'You are in the method'
    yield
    puts 'You are again back to the method'
    yield
  end

  def test2
    yield 5
    puts 'You are in the method test'
    yield 100
  end
end

block = Block.new

# Invocamos al método y le “pasamos” un bloque
block.test { puts 'You are in the block' }
#You are in the method
#You are in the block
#You are again back to the method
#You are in the block

# Invocamos al método y le “pasamos” un bloque
block.test2 { |i| puts "You are in the block #{i}" }
# You are in the block 5
# You are in the method test
# You are in the block 100