package Reservations;

public class Seat {

    private int row;
    private int seat;
    boolean taken;

    public Seat() {
    }

    public Seat(int i , int j, boolean taken) {
        this.row = i;
        this.seat = j;
        this.taken = false;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
