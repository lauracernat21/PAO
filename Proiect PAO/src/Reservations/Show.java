package Reservations;

public class Show {

    protected String name;
    protected String date;
    protected Hall hall;
    protected float price;

    public Show() {

    }

    public Show(String name, String date, Hall hall, float price) {
        this.name = name;
        this.date = date;
        this.hall = hall;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
