# frozen_string_literal: true

#Espera que los elementos sean comparables, es decir, que sobreescriban el ⇔ (el orden natural)
# La implementación utiliza un RBTree, similar a TreeSet en Java

#Como no está incluida en la biblioteca estándar, es necesario descargar la gema https://rubygems.org/gems/sorted_set/versions/1.0.3

require 'set'
class SortedSet < Set
  def initialize(*args)
    @hash = RBTree.new(*args)
    super
  end
end

p s1 = SortedSet[1, 2]		# => #<SortedSet: {1, 2}>
p s2 = SortedSet[2, 1, 2, 1]	# => #<SortedSet: {1, 2}>
p s1 == s2					# => true

p s1.add('one')  # => comparison of String with 1 failed (ArgumentError)

p s1.merge([2, 6])  # => #<SortedSet: {1, 2, 6}>
p s1.subset?(s2)  # => false
p s2.subset?(s1)   # => true
p SortedSet[1, 3, 5] - SortedSet[1, 5]  # => #<SortedSet: {3}>
p s1.include?(2)  # => true

s1.each { |e| p e }   # => 1\n2\n6
s1.reverse_each { |e| p e }  # => 6\n2\n1
