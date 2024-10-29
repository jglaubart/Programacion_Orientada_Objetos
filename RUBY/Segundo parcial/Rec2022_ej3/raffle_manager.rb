# frozen_string_literal: true

class RaffleManager

  def initialize
    @participants_by_raffle = {}    #hash
  end

  def enter_raffle(raffle, participant)
    @participants_by_raffle[raffle] = [] unless @participants_by_raffle.key?(raffle)  #si no existe la key raffle, la creo y le guardo un arreglo vacio
    raise ArgumentError, "Participant #{participant} already entered" if @participants_by_raffle[raffle].include?(participant)
    @participants_by_raffle[raffle] << participant  #guardo el participante
  end

  def exit_raffle(raffle, participant)
    raise ArgumentError, "Raffle #{raffle} not exists" unless @participants_by_raffle.key?(raffle)
    @participants_by_raffle[raffle].delete(participant)
  end

  def raffles
    return 'Raffle Manager is empty' if @participants_by_raffle.keys.empty?
    s = "Raffle Manager\n"
    @participants_by_raffle.keys.sort.each do |raffle|
      s += "#{raffle}:\n"
      @participants_by_raffle[raffle].each do |participant|
        s += "+ #{participant}\n"
      end
    end
    s
  end

end
