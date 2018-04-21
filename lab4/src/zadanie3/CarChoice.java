package zadanie3;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

@ManagedBean
@SessionScoped
public class CarChoice {
    private String make, model, personalData, engine, minPrice, maxPrice, telephoneNumber;
    private CarSimpleMap carSimpleMap = new CarSimpleMap();
    private List<String> makeList, modelList, engineList = new ArrayList<>(Arrays.asList("ON", "Benzyna"));
    private List<Car> matchingCars = new ArrayList<>();
    private boolean formValidation;

    public void validateForm() {
        try {
            formValidation = !telephoneNumber.isEmpty() && !personalData.isEmpty() &&
                    Integer.parseInt(minPrice) < Integer.parseInt(maxPrice);
        } catch (Exception e) {
            formValidation = false;
        }
    }

    public void clearForm() {
        make = null;
        model = null;
        personalData = null;
        minPrice = null;
        maxPrice = null;
        telephoneNumber = null;
        engine = null;
        matchingCars.clear();
    }

    public void findMatchingCars() {
        if (matchingCars != null)
            matchingCars.clear();
        for (int i = 0; i < carSimpleMap.getAvailableCarsCars().size(); i++) {
            Car car = carSimpleMap.getAvailableCarsCars().get(i);
            if (make.equals(car.getMake()) && model.equals(car.getModel()) && engine.equals(car.getEngine())
                    && Integer.parseInt(minPrice) <= Integer.parseInt(car.getPrice())
                    && Integer.parseInt(maxPrice) >= Integer.parseInt(car.getPrice())) {
                matchingCars.add(car);
            }
        }
    }

    public List<String> getMakeList() {
        makeList = new ArrayList<>(carSimpleMap.getModelCatalog().keySet());
        return makeList;
    }

    public List<String> getModelList() {
        modelList = carSimpleMap.findModels(make);
        return modelList;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getPersonalData() {
        return personalData;
    }

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public List<String> getEngineList() {
        return engineList;
    }

    public void setEngineList(List<String> engineList) {
        this.engineList = engineList;
    }

    public boolean isFormValidation() {
        return formValidation;
    }

    public void setFormValidation(boolean formValidation) {
        this.formValidation = formValidation;
    }

    public List<Car> getMatchingCars() {
        return matchingCars;
    }

    public void setMatchingCars(List<Car> matchingCars) {
        this.matchingCars = matchingCars;
    }
}