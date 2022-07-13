package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Ticket ticket1 = new Ticket(121, 18_000, "Ижевск", "Москва", 125);
    Ticket ticket2 = new Ticket(122, 14_000, "Ижевск", "Москва", 120);
    Ticket ticket3 = new Ticket(231, 8_100, "Самара", "Москва", 115);
    Ticket ticket4 = new Ticket(341, 12_000, "Оренбург", "Москва", 130);
    Ticket ticket5 = new Ticket(451, 24_000, "Екатеринбург", "Санкт-Петербург", 125);
    Ticket ticket6 = new Ticket(561, 16_000, "Пермь", "Санкт-Петербург", 180);
    Ticket ticket7 = new Ticket(671, 16_000, "Москва", "Пермь", 170);

    //Проверяем методы сохранения и удаления билетов
    @Test
    public void addAndDelTicketsTest () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.delById(121);
        manager.delById(122);
        manager.delById(341);
        manager.delById(671);

        Ticket[] expected = {
                //ticket1,
                //ticket2,
                ticket3,
                //ticket4,
                ticket5,
                ticket6,
                //ticket7
        };

        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    //Проверяем поиск и сортировку при вводе названия аэропорта полностью
    @Test
    public void findFullNameAirPortTest () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {
                ticket2,
                ticket1
        };

        Ticket[] actual = manager.searchAirport("Ижевск", "Москва" );

        Assertions.assertArrayEquals(expected, actual);
    }

    //Проверяем поиск и сортировку при вводе части названия аэропорта
    @Test
    public void findOneLetterInNameAirPortTest () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {
                ticket4,
                ticket2,
                ticket6,
                ticket1,
                ticket5
        };

        Ticket[] actual = manager.searchAirport("е", "а" );

        Assertions.assertArrayEquals(expected, actual);
    }
}
