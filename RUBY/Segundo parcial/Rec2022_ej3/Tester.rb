# frozen_string_literal: true
require_relative 'raffle_manager'
require_relative 'participant'
require_relative 'raffle'

rm = RaffleManager.new

viaje_egresados = Raffle.new('Viaje Egresados', 60000)
festival = Raffle.new('Festival', 90000)
feria = Raffle.new('Feria', 60000)

pedro = Participant.new('Pedro', 1234)
jorge = Participant.new('Jorge', 4321)
ana = Participant.new('Ana', 8888)
juan = Participant.new('Juan', 9999)
arturo = Participant.new('Arturo', 5555)

puts rm.raffles
# Raffle Manager is empty

# La participante Ana entra en el sorteo Viaje Egresados
rm.enter_raffle(viaje_egresados, ana)
rm.enter_raffle(viaje_egresados, juan)
rm.enter_raffle(viaje_egresados, arturo)
rm.enter_raffle(festival, pedro)
rm.enter_raffle(festival, jorge)
rm.enter_raffle(feria, pedro)
puts rm.raffles
# Raffle Manager
# Festival - Prize $90000:
# + Pedro - DNI: 1234
# + Jorge - DNI: 4321
# Feria - Prize $60000:
# + Pedro - DNI: 1234
# Viaje Egresados - Prize $60000:
# + Ana - DNI: 8888
# + Juan - DNI: 9999
# + Arturo - DNI: 5555
# La participante Ana se retira del sorteo Viaje Egresados
rm.exit_raffle(Raffle.new('Viaje Egresados', 60000), Participant.new('Ana', 8888))
puts rm.raffles
# Raffle Manager
# Festival - Prize $90000:
# + Pedro - DNI: 1234
# + Jorge - DNI: 4321
# Feria - Prize $60000:
# + Pedro - DNI: 1234
# Viaje Egresados - Prize $60000:
# + Juan - DNI: 9999
# + Arturo - DNI: 5555
begin
  # Falla pues nadie entró al torneo F5
  rm.exit_raffle(Raffle.new('Torneo F5', 60000), Participant.new('Paula', 6666))
rescue ArgumentError => e
  puts e
  # Raffle Torneo F5 not exists
end
begin
  # Falla pues Juan ya entró en el sorteo Viaje Egresados
  rm.enter_raffle(viaje_egresados, Participant.new('Juan', 9999))
rescue ArgumentError => e
  puts e
  # Participant Juan already entered
end
