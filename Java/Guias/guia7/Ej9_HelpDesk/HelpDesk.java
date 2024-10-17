package Guias.guia7.Ej9_HelpDesk;

import java.util.*;

public class HelpDesk {
    private final Map<ClientType, Queue<HelpTicket>> tickets = new EnumMap<>(ClientType.class);

    public HelpDesk openTicket(ClientType type, String name, String question){
        tickets.putIfAbsent(type, new LinkedList<>());  //agrega la nueva lista para el tipo de cliente si no estaba incluido
        tickets.get(type).add(new HelpTicket(type, name, question));
        return this;
    }

    public HelpTicket getNextTicket(ClientType type){
        if(!tickets.containsKey(type) || tickets.get(type).isEmpty()){
            throw new NoSuchElementException();
        }
        return tickets.get(type).poll();
    }

    public HelpTicket getNextTicket(){
        for(Queue<HelpTicket> clientTickets : tickets.values()){
            if(!clientTickets.isEmpty()){
                return clientTickets.poll();
            }
        }
        throw new NoSuchElementException();
    }

    public boolean hasTickets(){
        boolean ans = false;
        for(Queue<HelpTicket> clientTickets : tickets.values()){
            if(!clientTickets.isEmpty()){
                ans = true;
            }
        }
        return ans;
    }

    static class HelpTicket {   //clase interna porque puede hacer HelpDesk.HelpTicket
        private final ClientType type;
        private final String name, question;

        public HelpTicket(ClientType type, String name, String question) {
            this.type = type;
            this.name = name;
            this.question = question;
        }

        @Override
        public String toString() {
            return "HelpTicket for %s asking %s".formatted(name, question);
        }
    }
}


