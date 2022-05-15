package CarDatabase;
import Car.Car;
import java.util.ArrayList;
import java.util.List;

public class CarDatabase {
    private List<Car> cars = new ArrayList<Car>();

    public CarDatabase() {};

    public List<Car> getCars() {
        return this.cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void deleteCar(int index) {
        cars.remove(index - 1);
    }

    public void updateCar(int index, Car car) {
        cars.set(index - 1, car);
    }
}
