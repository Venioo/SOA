package pack.Car;

public class Car {
    private String type;
    private int price;
    private String name;

    public Car(String type, int price, String name) {
        this.type = type;
        this.price = price;
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}
