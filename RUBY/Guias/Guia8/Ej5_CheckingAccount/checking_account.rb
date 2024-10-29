# frozen_string_literal: true

require_relative 'bank_account'
class CheckingAccount < BankAccount
  def initialize(id, overdraft)
    create(id)
    @overdraft = overdraft
  end

  private def canExtract?(amount)
    amount >= @saldo + @overdraft
  end

end
