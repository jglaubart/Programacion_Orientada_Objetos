# frozen_string_literal: true

true && false  			# => false
true || false  			# => true
1 > 3 || 2 < 5  			# => true
(1 > 3 || 2 < 5).class  	# => TrueClass
4 && 5  					# => 5
5 && 4  					# => 4
5 || 4    				# => 5


a = false
b = true
puts a | b    # => true
puts a || b   # => true
puts b & a    # => false
puts b && a   # => false
puts !a       # => true
puts a.!      # => true
