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

        List<Spectator> spectators = ReadFromCsv.readSpectators();
        List<Show> shows = ReadFromCsv.readShows();
        List<Hall> halls = ReadFromCsv.readHalls();


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

                    Audit.getInstance().writeLogs("Cumpara un bilet");

                    System.out.println("Which show would you like to attend?\n");
                    service.showAllShows(shows);
                    int showNumber = in.nextInt();
                    System.out.println("How many tickets would you like to buy? \n");
                    int numberOfTickets = in.nextInt();
                    service.buyTicket(shows.get(showNumber - 1), numberOfTickets, tickets);
                    break;
                }
                case 2: {

                    Audit.getInstance().writeLogs("Afiseaza numele spectacolelor programate");

                    // AFISEAZA NUMELE SPECTACOLELOR PROGRAMATE
                    service.showAllShows(shows);
                    break;
                }
                case 3: {

                    Audit.getInstance().writeLogs("Adauga un spectacol");

                    // ADAUGA UN SPECTACOL
                    service.addShow(shows, halls);
                    service.showAllShows(shows);
                    break;
                }
                case 4: {

                    Audit.getInstance().writeLogs("Anuleaza un spectacol");

                    // ANULEAZA UN SPECTACOL
                    System.out.println("Which show would you like to cancel? ");
                    service.showAllShows(shows);
                    int toBeCancelled = in.nextInt();
                    service.cancelShow(shows, shows.get(toBeCancelled - 1), tickets);
                    service.showAllShows(shows);
                    break;
                }
                case 5: {

                    Audit.getInstance().writeLogs("Afiseaza toate biletele cumparate la toate spectacolele");

                    // AFISEAZA BILETELE CUMPARATE LA TOATE SPECTACOLELE
                    service.showAllTheTickets(tickets);
                    break;
                }
                case 6: {

                    Audit.getInstance().writeLogs("Afiseaza toate biletele cumparate la un anumit spectacol");

                    // AFISEAZA BILETELE CUMPARATE LA UN ANUMIT SPECTACOL
                    System.out.println("Which show's tickets would you like to see?");
                    service.showAllShows(shows);
                    int chosen = in.nextInt();
                    service.showTicketsForAShow(tickets, shows.get(chosen - 1));
                    break;
                }
                case 7: {

                    Audit.getInstance().writeLogs("Returneaza un bilet");

                    // RETURNEAZA UN BILET
                    service.returnTicket(tickets, shows);
                    break;
                }
                case 8: {

                    Audit.getInstance().writeLogs("Afiseaza detaliile unui spectacol");

                    // AFISEAZA DETALIILE UNUI SPECTACOL
                    System.out.println("Which show details would you like to know?");
                    service.showAllShows(shows);
                    int index = in.nextInt();
                    service.showDetails(shows.get(index - 1));
                    break;
                }
                case 9: {

                    Audit.getInstance().writeLogs("Adauga o sala noua");

                    // ADAUGA O SALA NOUA
                    service.addHall(halls);
                    break;
                }
                case 10: {

                    Audit.getInstance().writeLogs("Afiseaza toate salile");

                    // AFISEAZA TOATE SALILE
                    service.showAllHalls(halls);
                    break;
                }
                case 11: {

                    Audit.getInstance().writeLogs("Afiseaza locurile unei sali");

                    //AFISEAZA LOCURILE UNEI SALI: false - biletul respectiv nu a fost cumparat / true - biletul a fost cumparat
                    System.out.println("Which show's hall would you like to see?");
                    service.showAllShows(shows);
                    int index = in.nextInt();
                    service.showHall(shows.get(index - 1));
                    break;
                }
                case 0: {

                    Audit.getInstance().writeLogs("Exit");
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
