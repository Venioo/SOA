package zadanie3;

public class Car {
    private String make;
    private String model;
    private String price;
    private String engine;

    public Car(String make, String model, String price, String engine) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }

    public String getEngine() {
        return engine;
    }
}
