# frozen_string_literal: true

class BankAccount

  def initialize
    raise 'Debe sobreescribir este método'
  end

  def create(id)
    @id = id
    @saldo = 0
  end

  def deposit(amount)
    @saldo += amount
  end

  def canExtract?(amount)
    raise 'Se debe sobreescribir'
  end

  def extract(amount)
    raise 'No cuenta con los fondos necesarios' unless canExtract? amount
    @saldo -= amount
  end

  def to_s
    "Cuenta #{@id} con saldo #{@saldo}"
  end

  private :create, :canExtract?
end

