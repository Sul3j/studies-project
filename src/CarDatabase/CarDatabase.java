package CarDatabase;
import Car.Car;
import Sort.Sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;
import java.io.IOException;

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
        cars.remove(index);
    }

    public void updateCar(int index, Car car) {
        cars.set(index, car);
    }

    public void saveCar() {
        try {
            File db = new File("db.txt");
            if(db.createNewFile()) {
                System.out.println("Stworzono nowy plik " + db.getName());
            }

            FileWriter dbSave = new FileWriter("db.txt");
            for(Car c : this.cars) {
                dbSave.write(c.getMark() + ";" + c.getModel() + ";" + c.getProductionDate() + ";" + c.getColor() + ";" + c.getCourse() + ";" + c.getDoorQuantity() + "\n");
            }
            dbSave.close();
            System.out.println("ZAPISANO DO PLIKU");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public void loadCar() {
        try {
            File db = new File("db.txt");
            Scanner scan = new Scanner(db);
            StringTokenizer token;
            List<Object> elementsArray = new ArrayList<Object>();

            while (scan.hasNextLine()) {
                token = new StringTokenizer(scan.nextLine(), ";");
                while(token.hasMoreElements()) {
                    elementsArray.add(token.nextToken());
                }

                Car car = new Car(elementsArray.get(0).toString(), elementsArray.get(1).toString(), Integer.parseInt(elementsArray.get(2).toString()), elementsArray.get(3).toString(), Integer.parseInt(elementsArray.get(4).toString()), Integer.parseInt(elementsArray.get(5).toString()));
                this.addCar(car);
                elementsArray.clear();
            }
            System.out.println("WCZYTANO Z PLIKU");
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            e.printStackTrace();
        }
    }

    public List<Car> sortCarsByYearAsc() {
        List<Car> carToSort = new ArrayList<Car>();
        carToSort = this.cars;
        Collections.sort(carToSort, new Sort());
        return  carToSort;
    }

    public List<Car> sortCarsByYearDesc() {
        List<Car> carToSort = new ArrayList<Car>();
        carToSort = this.cars;

        Collections.sort(carToSort, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return (int) (o2.getProductionDate() - o1.getProductionDate());
            }
        });

        return  carToSort;
    }

    //sortowanie bombelkowe
    private List<Car> sortStringArray(List<String> strArray, List<Car> cars, boolean option) {
        String temp = null;
        List<Car> sortCarsAZ = new ArrayList<Car>();
        List<Car> sortCarsZA = new ArrayList<Car>();

        for(int i = 0; i < strArray.size(); i++) {
            for(int j = 1; j < strArray.size() - i; j++) {
                if (strArray.get(j-1).compareToIgnoreCase(strArray.get(j)) > 0)
                {
                    temp = strArray.get(j-1);
                    strArray.set(j-1, strArray.get(j));
                    strArray.set(j, temp);
                }
            }
        }

        for (String s : strArray) {
            for (Car c : cars) {
                if (c.getMark().equals(s)) {
                    sortCarsAZ.add(c);
                }
            }
        }

        for (int i = 1; i <= sortCarsAZ.size(); i++) {
            sortCarsZA.add(sortCarsAZ.get(sortCarsAZ.size() - i));
        }

        if (option) {
            return sortCarsAZ;
        } else {
            return sortCarsZA;
        }
    }



    public List<Car> sortCarByMarkAZ() {
        List<String> marks = new ArrayList<String>();

        for(Car c : cars) {
            marks.add(c.getMark());
        }

        return sortStringArray(marks, cars, true);
    }

    public List<Car> sortCarByMarkZA() {
        List<String> marks = new ArrayList<String>();

        for(Car c : cars) {
            marks.add(c.getMark());
        }

        return sortStringArray(marks, cars, false);
    }

    public List<Car> searchByProductionDate(int min, int max) {
        List<Car> searchCar = new ArrayList<Car>();

        for(int i=0; i<cars.size(); i++) {
            if(cars.get(i).getProductionDate() >= min && cars.get(i).getProductionDate() <= max)
            {
                searchCar.add(cars.get(i));
            }
        }

        return searchCar;
    }

    public List<Car> searchByMark(String mark) {
        List<Car> searchCar = new ArrayList<Car>();

        for(int i=0; i<cars.size(); i++) {
            if(cars.get(i).getMark().toLowerCase().equals(mark.toLowerCase()))
            {
                searchCar.add(cars.get(i));
            }
        }

        return searchCar;
    }

    public Car viewCars(int index, List<Car> cars) {
        return cars.get(index);
    }
}

