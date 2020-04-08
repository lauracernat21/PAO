package Reservations;

import java.util.*;

public class Main {

    public static void menu() {
        System.out.println("Choose what you want to do: \n 1. Buy tickets to a show \n 2. Show all the programmed shows \n 3. Add a new show \n " +
                           "4. Cancel a show \n 5. Show all the bought tickets \n 6. Show all the bought tickets of a certain show \n 7. Return tickets \n " +
                           "8. Show the details of a show \n 9. Add a new hall \n 10. Show all halls \n 11. Show all the seats of a hall \n 0. Exit " +
                           "\n Your choice: ");
    }

    public static void main(String[] args) {

//        Spectator Laura = new Spectator("Laura", 21);
//        Spectator Gabriela = new Spectator("Gabriela", 10);
//        Spectator Mihai = new Spectator("Mihai", 32);

        // hall and seats for hall 1

        Hall hall_1 = new Hall(5, 5, 25, 1);
        hall_1.initialization();

        // hall and seats for hall 2

        Hall hall_2 = new Hall(5,5, 25, 2);
        hall_2.initialization();

        List<Hall> halls = new ArrayList<>();
        halls.add(hall_1);
        halls.add(hall_2);

        // prices

        float price_1 = 50.0f;
        float price_2 = 65.5f;

        // dates

        String date1 = "12-05-2020 18:00";
        String date2 = "27-07-2020 20:00";

        // shows

        Show show1 = new Show("Bani din Cer", date1, hall_1, price_1);
        Show show2 = new Show("Hamlet", date2, hall_2, price_2);

        List<Show> shows = new ArrayList<>();
        shows.add(show1);
        shows.add(show2);

        List<Ticket> tickets = new ArrayList<>();

        System.out.println("Welcome! ");

        boolean ok = true;
        Scanner in = new Scanner(System.in);

        while(ok) {
            menu();
            int choice = in.nextInt();
            Service service = new Service();
            switch (choice) {
                case 1: {

                    // CUMPARA BILET
                    System.out.println("Which show would you like to attend?\n");
                    service.showAllShows(shows);
                    int showNumber = in.nextInt();
                    System.out.println("How many tickets would you like to buy? \n");
                    int numberOfTickets = in.nextInt();
                    service.buyTicket(shows.get(showNumber - 1), numberOfTickets, tickets);
                    break;
                }
                case 2: {

                    // AFISEAZA NUMELE SPECTACOLELOR PROGRAMATE
                    service.showAllShows(shows);
                    break;
                }
                case 3: {

                    // ADAUGA UN SPECTACOL
                    service.addShow(shows, halls);
                    service.showAllShows(shows);
                    break;
                }
                case 4: {

                    // ANULEAZA UN SPECTACOL
                    System.out.println("Which show would you like to cancel? ");
                    service.showAllShows(shows);
                    int toBeCancelled = in.nextInt();
                    service.cancelShow(shows, shows.get(toBeCancelled - 1), tickets);
                    service.showAllShows(shows);
                    break;
                }
                case 5: {

                    // AFISEAZA BILETELE CUMPARATE LA TOATE SPECTACOLELE
                    service.showAllTheTickets(tickets);
                    break;
                }
                case 6: {

                    // AFISEAZA BILETELE CUMPARATE LA UN ANUMIT SPECTACOL
                    System.out.println("Which show's tickets would you like to see?");
                    service.showAllShows(shows);
                    int chosen = in.nextInt();
                    service.showTicketsForAShow(tickets, shows.get(chosen - 1));
                    break;
                }
                case 7: {

                    // RETURNEAZA UN BILET
                    service.returnTicket(tickets, shows);
                    break;
                }
                case 8: {

                    // AFISEAZA DETALIILE UNUI SPECTACOL
                    System.out.println("Which show details would you like to know?");
                    service.showAllShows(shows);
                    int index = in.nextInt();
                    service.showDetails(shows.get(index - 1));
                    break;
                }
                case 9: {

                    // ADAUGA O SALA NOUA
                    service.addHall(halls);
                    break;
                }
                case 10: {

                    // AFISEAZA TOATE SALILE
                    service.showAllHalls(halls);
                    break;
                }
                case 11: {

                    //AFISEAZA LOCURILE UNEI SALI: false - biletul respectiv nu a fost cumparat / true - biletul a fost cumparat
                    System.out.println("Which show's hall would you like to see?");
                    service.showAllShows(shows);
                    int index = in.nextInt();
                    service.showHall(shows.get(index - 1));
                    break;
                }
                case 0: {
                    ok = false;
                    break;
                }
                default: {
                    System.out.println("Please choose from possible actions");
                }
            }
            if(ok) {
                System.out.println("Do you want to continue? y/n");
                String cont = in.next();
                if (cont.equals("n")) {
                    ok = false;
                }
            }
        }
    }
}
