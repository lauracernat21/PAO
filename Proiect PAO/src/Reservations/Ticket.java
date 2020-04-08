package Reservations;

public class Ticket {

    private Show show;
    private Spectator spectator;
    private Seat seat;

    public Ticket() {
    }

    public Ticket(Show show, Spectator spectator, Seat seat) {
        this.show = show;
        this.spectator = spectator;
        this.seat = seat;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Spectator getSpectator() {
        return spectator;
    }

    public void setSpectator(Spectator spectator) {
        this.spectator = spectator;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

}
