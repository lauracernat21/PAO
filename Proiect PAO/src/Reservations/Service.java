package Reservations;

import java.util.*;
import static Reservations.ReadFromCsv.*;

public class Service {

//    public void loadData() {
//        // shows
//
//        List<Show> shows = ReadFromCsv.readShows(1);
//
//    }

    public void buyTicket(Show show, int numberOfTickets, List<Ticket> tickets) {
        Scanner in = new Scanner(System.in);
        int availableTickets = show.getHall().getTotal_seats() - tickets.size();

        if (numberOfTickets <= availableTickets) {
            for (int i = 0; i < numberOfTickets; i++) {

                System.out.println("Insert your data: \n Name:");
                String name = in.next();
                System.out.println("Age: \n");
                int age = in.nextInt();

                Spectator spectator;
                if (age < 18) {
                    spectator = new ChildSpectator(name, age, 0.15f);
                    show.setPrice(0.15f * show.getPrice());
                }
                else {
                    spectator = new AdultSpectator(name, age);
                }

                Random rand = new Random();
                int x = rand.nextInt(show.getHall().getLength());
                int y = rand.nextInt(show.getHall().getWidth());
                Seat seat = show.getHall().getSeats()[x][y];


                Ticket ticket = new Ticket(show, spectator, seat);
                show.getHall().getSeats()[x][y].setTaken(true);

                tickets.add(ticket);
                System.out.println("Ticket has been bought.");
            }
        }
        else {
            System.out.println("There are not enough available tickets at this show.");
        }
    }

    public void showAllShows(List<Show> shows) {
        System.out.println("These are all the shows: ");
        int i = 1;
        for(Show show: shows) {
            System.out.println(i + ". " + show.getName());
            i++;
        }
    }

    public void addShow(List<Show> shows, List<Hall> halls) {
        Show show = new Show();

        System.out.println("What is the name of the show ?");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        show.setName(name);

        System.out.println("When will the show be performed?");
        String date = in.nextLine();
        show.setDate(date);

        System.out.println("Select a hall: ");
        for(Hall hall : halls) {
            System.out.println("Hall " + hall.getHall_number());
        }
        int hall = in.nextInt();
        show.setHall(halls.get(hall - 1));

        System.out.println("Add a price for the tickets to this show: ");
        float price = in.nextFloat();
        show.setPrice(price);

        shows.add(show);
        System.out.println("Show has been added.");
    }

    public void cancelShow(List<Show> shows, Show show, List<Ticket> tickets) {
        shows.remove(show);
        tickets.removeIf(ticket -> ticket.getShow().equals(show));
        System.out.println("Show has been cancelled.");
    }

    public void showDetails(Show show) {
        System.out.println("Name: " + show.getName() + " \nDate: " + show.getDate() + "\nHall: " + show.getHall().getHall_number() + "\nPrice/ticket: " + show.getPrice());
    }

    public void showAllTheTickets(List<Ticket> tickets) {
        for (Ticket ticket: tickets) {
            System.out.println("\nName: " + ticket.getShow().getName() + "\nDate: " + ticket.getShow().getDate() + "\nPrice: " + ticket.getShow().getPrice() + "\nHall: "
                            + ticket.getShow().getHall().getHall_number() + "\nRow: " + ticket.getSeat().getRow() + "\nSeat: " + ticket.getSeat().getSeat()
                            + "\nSpectator: " + ticket.getSpectator().getName());
        }
    }

    public void showTicketsForAShow(List<Ticket> tickets, Show show) {
        for (Ticket ticket: tickets) {
            if (ticket.getShow().equals(show)) {
                System.out.println("\nName: " + ticket.getShow().getName() + "\nDate: " + ticket.getShow().getDate() + "\nPrice: " + ticket.getShow().getPrice() + "\nHall: "
                        + ticket.getShow().getHall().getHall_number() + "\nRow: " + ticket.getSeat().getRow() + "\nSeat: " + ticket.getSeat().getSeat()
                        + "\nSpectator: " + ticket.getSpectator().getName());
            }
        }
    }

    public void returnTicket(List<Ticket> tickets, List<Show> shows) {
        Scanner in = new Scanner(System.in);
        System.out.println("Whose ticket would you like to return?");
        String name = in.next();
        System.out.println("For which show?");
        Service service = new Service();
        service.showAllShows(shows);
        int choice = in.nextInt();
        tickets.removeIf(ticket -> ticket.getSpectator().getName().equals(name) && ticket.getShow().equals(shows.get(choice - 1)));
        System.out.println("Ticket has been returned.");
    }

    public void addHall(List<Hall> halls) {

        Scanner in = new Scanner(System.in);
        System.out.println("Insert the number of rows of the hall: ");
        int length = in.nextInt();
        System.out.println("Insert the number of seats per row: ");
        int width = in.nextInt();
        System.out.println("Insert hall number: ");
        int hall_number = in.nextInt();
        int total_seats = length * width;
        Hall hall = new Hall(length, width, total_seats, hall_number);
        hall.initialization();
        halls.add(hall);
    }

    public void showAllHalls(List<Hall> halls) {
        for (Hall hall: halls) {
            System.out.println("Hall number: " + hall.getHall_number() + "\nHall total seats: " + hall.getTotal_seats() + "\n");
        }
    }

    public void showHall(Show show) {
        for (int i = 0; i < show.getHall().getLength(); i++) {
            System.out.print("Row " + show.getHall().getSeats()[i][i].getRow() + ": ");
            for(int j = 0; j < show.getHall().getWidth(); j++) {
                System.out.print("Seat " + show.getHall().getSeats()[i][j].getSeat() + " " + show.getHall().getSeats()[i][j].isTaken() + ", ");
            }
            System.out.println("\n");
        }
    }
}