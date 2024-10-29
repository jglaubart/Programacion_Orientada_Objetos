# frozen_string_literal: true

require_relative 'item'
class Ticket
  @@current_id = 999

  def initialize
    @@current_id += 1
    @id = @@current_id
    @items = Set.new
  end

  def add(product, quantity)
    @items << Item.new(product, quantity)
  end

  def total
    @ans = 0
    @items.map { |item|  item.total }.sum
  end

  private :total

  def to_s
    s = "TICKET Nº #{@id}\n"
    s += "####################\n"
    @items.sort.each { |item| s += "#{item.product.name}     #{item.quantity}  $#{item.product.price}\n" }
    s += "####################\n"
    s + "TOTAL $#{format('%.2f', total)}"
  end

end
