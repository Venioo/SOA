package pack.Car;

import java.util.ArrayList;

public class CarChoiceHelper {
    private String carType;
    private int bottomLimit;
    private int topLimit;
    private ArrayList<Car> cars = new ArrayList<>();

    public CarChoiceHelper(String carType, int bottomLimit, int topLimit) {
        this.carType = carType;
        this.bottomLimit = bottomLimit;
        this.topLimit = topLimit;
        cars.add(new Car("luksusowy", 5000, "Bentley"));
        cars.add(new Car("luksusowy", 6000, "Maserati"));
        cars.add(new Car("luksusowy", 7000, "Bugatti"));
        cars.add(new Car("sportowy", 3000, "Ferrari"));
        cars.add(new Car("miejski", 1000, "Ford"));
    }

    public ArrayList<String> findCars() {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getType().equals(this.carType)) {
                if (bottomLimit <= car.getPrice() && topLimit >= car.getPrice()) {
                    names.add(car.getName());
                }
            }
        }
        return names;
    }
}
