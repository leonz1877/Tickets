package ru.netology;

public class Repository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        Ticket[] temp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            temp[i] = tickets[i];
        }
        temp[temp.length - 1] = ticket;
        tickets = temp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) != null){
            Ticket[] temp = new Ticket[tickets.length - 1];
            int index =0;
            for (Ticket ticket : tickets) {
                if (ticket.getId() != id) {
                    temp[index] = ticket;
                    index++;
                }
            }
            tickets = temp;
        }
        else {
            throw new NotFoundException("Билет с id " + id + " не найден");
        }

    }

    public Ticket[] getTickets() {
        return tickets;
    }
}
