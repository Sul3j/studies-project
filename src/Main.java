import Car.Car;
import CarDatabase.CarDatabase;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String mark, model, color;
        int productionDate, course, doorQuantity, index;

        CarDatabase base = new CarDatabase();
        Scanner scan = new Scanner(System.in);

        char zn;

        do {
            System.out.println("1. Wyświetl auta");
            System.out.println("2. Dodaj auto");
            System.out.println("3. Usuń auto");
            System.out.println("4. Aktualizuj auto");
            System.out.println("5. Zapis do pliku");
            System.out.println("6. Wczytanie danych z pliku");
            System.out.println("x. Wyjdź z programu");

            zn = scan.next().charAt(0);

            switch (zn) {
                case '1':
                {
                    for(Car c : base.getCars()) {
                        System.out.println("marka: " + c.getMark());
                        System.out.println("model: " + c.getModel());
                        System.out.println("data produkcji: " + c.getProductionDate());
                        System.out.println("kolor: " + c.getColor());
                        System.out.println("przebieg: " + c.getCourse());
                        System.out.println("ilość drzwi: " + c.getDoorQuantity());
                    }
                    break;
                }
                case '2':
                {
                    scan.nextLine();
                    System.out.println("Podaj markę samochodu: ");
                    mark = scan.nextLine();
                    System.out.println("Podaj model samochodu: ");
                    model = scan.nextLine();
                    System.out.println("Podaj datę produkcji samochodu: ");
                    productionDate = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Podaj kolor samochodu: ");
                    color = scan.nextLine();
                    System.out.println("Podaj przebieg samochodu: ");
                    course = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Podaj ilość drzwi samochodu: ");
                    doorQuantity = scan.nextInt();
                    scan.nextLine();
                    Car car = new Car(mark, model, productionDate, color, course, doorQuantity);
                    base.addCar(car);
                    System.out.println("DODANO NOWE AUTO!");
                    break;
                }
                case '3':
                {
                    System.out.println("Podaj index auta które chcesz usunąć: ");
                    index = scan.nextInt();
                    scan.nextLine();
                    base.deleteCar(index);
                    System.out.println("Usunięto auto z indexem " + index);
                    break;
                }
                case '4':
                {
                    scan.nextLine();
                    System.out.println("Podaj markę samochodu: ");
                    mark = scan.nextLine();
                    System.out.println("Podaj model samochodu: ");
                    model = scan.nextLine();
                    System.out.println("Podaj datę produkcji samochodu: ");
                    productionDate = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Podaj kolor samochodu: ");
                    color = scan.nextLine();
                    System.out.println("Podaj przebieg samochodu: ");
                    course = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Podaj ilość drzwi samochodu: ");
                    doorQuantity = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Podaj index auta które chcesz zaktualizować: ");
                    index = scan.nextInt();
                    scan.nextLine();
                    Car car = new Car(mark, model, productionDate, color, course, doorQuantity);
                    base.updateCar(index, car);
                    System.out.println("Zaktualizowano auto z indexem " + index);
                    break;
                }
                case '5':
                {
                    base.saveCar();
                    System.out.println("DODANO POMYŚLNIE");
                    break;
                }
                case '6':
                {
                    System.out.println("DANE Z PLIKU");
                    base.loadCar();
                    break;
                }
                case 'x':
                    System.out.println("DO WIDZENIA!");
                    break;
            }
        } while(zn!= 'x');
    }
}
