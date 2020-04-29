package Reservations;

public class Hall {

    private Seat[][] seats;
    private int total_seats;
    private int hall_number;
    private int length;
    private int width;

    public Hall() {
    }

    public Hall(int length, int width, int total_seats, int hall_number) {

        seats = new Seat[length][width];
        this.total_seats = total_seats;
        this.hall_number = hall_number;
        this.length = length;
        this.width = width;
    }

    public void initialization() {
        for(int i = 0; i < seats.length; i++)
        {
            for(int j = 0; j < seats[0].length; j++)
            {
                seats[i][j] = new Seat(i+1, j+1, false);
            }
        }
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public int getHall_number() {
        return hall_number;
    }

    public void setHall_number(int hall_number) {
        this.hall_number = hall_number;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
