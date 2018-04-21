package zadanie3;

import java.util.*;

public class CarSimpleMap {
    private List<Car> availableCars;
    private Map<String, List<String>> modelCatalog;

    public CarSimpleMap() {
        modelCatalog = new HashMap<>();
        availableCars = new ArrayList<>();
        modelCatalog.put("Audi", new ArrayList<>(Arrays.asList("A4", "A5", "A6")));
        modelCatalog.put("BMW", new ArrayList<>(Arrays.asList("X3", "X5", "X6")));
        Car c1 = new Car("Audi", "A5", "50","ON");
        Car c2 = new Car("Audi", "A5", "55","ON");
        Car c3 = new Car("Audi", "A5", "60","ON");
        Car c4 = new Car("Audi", "A6", "30","Benzyna");
        Car c5 = new Car("BMW", "X5", "40","Benzyna");
        availableCars.add(c1);
        availableCars.add(c2);
        availableCars.add(c3);
        availableCars.add(c4);
        availableCars.add(c5);
    }

    public List<Car> getAvailableCarsCars() {
        return availableCars;
    }

    public Map<String, List<String>> getModelCatalog() {
        return modelCatalog;
    }

    public List<String> findModels(String make) {
        return modelCatalog.get(make);
    }
}
