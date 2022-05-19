package Sort;

import Car.Car;
import java.util.Comparator;

public class Sort implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
        return (int) (c1.getProductionDate() - c2.getProductionDate());
    }
}
