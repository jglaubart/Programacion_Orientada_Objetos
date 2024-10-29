# frozen_string_literal: true

class SavingsAccount < BankAccount
  def initialize(id)
    create(id)
  end

  private def canExtract?(amount)
    amount <= @saldo
  end
end
