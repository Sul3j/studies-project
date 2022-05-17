package CarDatabase;
import Car.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

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
        cars.remove(index + 1);
    }

    public void updateCar(int index, Car car) {
        cars.set(index + 1, car);
    }

    public void saveCar() {
        try {
            File db = new File("db.txt");
            if(db.createNewFile()) {
                System.out.println("Stworzono nowy plik " + db.getName());
            } else {
                System.out.println("Plik już istnieje");
            }

            FileWriter dbSave = new FileWriter("db.txt");
            dbSave.write("Testowy zapis do pliku");
            dbSave.close();
            System.out.println("zapisano do pliku");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public void loadCar() {
        try {
            File db = new File("db.txt");
            Scanner scan = new Scanner(db);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                System.out.println(data);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            e.printStackTrace();
        }
    }
}

