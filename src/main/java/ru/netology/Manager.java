package ru.netology;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class Manager {
    private Repository repository;
    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add (Ticket ticket) {
        repository.save(ticket);
    }

    public void delById(int id) {
        repository.removeById(id);
    }

    public Ticket[] searchAirport(String from, String to){
        Ticket[] result = new Ticket[0];

        //Сделал как в разборном семинаре, почему-то неработает, массив[0]
        /*for (Ticket ticket : repository.getTickets()){
            if (matches(ticket, from, to)) {
                Ticket[] temp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    temp[i] = result[i];
                }
                temp[temp.length - 1] = ticket;
            }
        }*/

        //Громоздко, но работает
        int index = 0;
        int index1;
        for (Ticket ticket : repository.getTickets()){
            Ticket[] temp = new Ticket[result.length + 1];
            if (matches(ticket, from, to)) {
                index1 = 0;
                for (Ticket ticket1 : result) {
                    temp[index1] = ticket1;
                    index1++;
                }
                temp[index] = ticket;
                index++;
                result = temp;
            }
        }

        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getDeparture().contains(from) && ticket.getArrival().contains(to)) {
            return true;
        } else {
            return false;
        }
    }
}
