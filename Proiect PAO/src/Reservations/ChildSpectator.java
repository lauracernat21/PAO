package Reservations;

public class ChildSpectator extends Spectator {

    private float discount;

    public ChildSpectator() {
    }

    public ChildSpectator(String name, int age) {
        super(name, age);
    }

    public ChildSpectator(float discount) {
        this.discount = discount;
    }

    public ChildSpectator(String name, int age, float discount) {
        super(name, age);
        this.discount = discount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
