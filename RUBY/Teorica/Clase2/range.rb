# frozen_string_literal: true

p (1..5).class     # Range.new(1, 5) => Range
p (1..5).max		# => 5
p (1...5).max		# Range.new(1, 5, true) => 4   ---> extremo superior no incluidos
p (1..5).min		# => 1
p (2...5).min		# => 2
p (1...1).min		# => nil
p (...5).size		# Beginless Ranges => Infinity
p (1...).size		# Endless Ranges => Infinity

p (1..3).overlap?(2..5)   # => true
p (1..3).overlap?(4..5)   # => false
p (1..4) == (1..4)        # => true
p (1..4).equal?(1..4)     # => false

### range === element ---> ver si element esta en el rango
p (1..10) === 15			# => false
p (1..10) === 3.14159	# => true
p ('a'..'j') === 'z'	# => false
p ('a'..'j') === 'c'	# => true

p 5 == (1..10)			# => false
p 5 === (1..10)			# => false
p 5.equal?(1..10)		# => false

p (1..10) === 5			# => true
p (1..10) == 5			# => false
p (1..10).equal?(5)		# => false

