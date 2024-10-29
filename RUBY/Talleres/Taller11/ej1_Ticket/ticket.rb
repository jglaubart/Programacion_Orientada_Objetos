# frozen_string_literal: true

class Ticket
  @@current_id = 999
  def initialize
    @@current_id += 1
    @id = @@current_id
    @products = []
  end

  def add(product, quantity)
    @products << [product, quantity]
  end

  def total
    @products.map { |product, quantity| product.price * quantity }.sum
  end
  private :total

  def to_s
    "TICKET Nº #{@id}\n######################\n" +
      @products.map{|product, quantity| "#{product.name}     #{quantity}  $#{product.price}"}.join("\n") +
      "\n############################\nTOTAL $#{format('%.2f', total)}"
  end

end
