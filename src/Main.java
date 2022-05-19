import Accounts.Accounts;
import Car.Car;
import CarDatabase.CarDatabase;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static boolean login() {
        String login, password;
        Accounts accounts = new Accounts();
        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj login: ");
        login = scan.nextLine();
        System.out.println("Podaj hasło: ");
        password = scan.nextLine();
        if (accounts.login(login, password)) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {

        String mark, model, color, login, password;
        int productionDate, course, doorQuantity, index, min, max;
        boolean isLogged = false;

        Accounts accounts = new Accounts();
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
            System.out.println("7. Sortowanie danych rosnąco po roczniku");
            System.out.println("8. Sortowanie danych malejąco po roczniku");
            System.out.println("9. Wyszukiwanie po przedziale przebiegu");
            System.out.println("a. Wyszukiwanie po marce samochodu");
            System.out.println("b. Dodaj konto");
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
                        System.out.println("----------------------------");
                    }
                    break;
                }
                case '2':
                {
                    isLogged = login();

                    if(isLogged) {
                        scan.nextLine();
                        do {
                            System.out.println("Podaj markę samochodu: ");
                            mark = scan.nextLine();
                            if (mark.length() < 3) {
                                System.out.println("Nazwa marki musi mieć conajmiej 3 litery");
                            }
                        } while (mark.length() < 3);
                        do {
                            System.out.println("Podaj model samochodu: ");
                            model = scan.nextLine();
                            if (model.length() < 2) {
                                System.out.println("Nazawa modelu musi mieć conajmiej 2 litery");
                            }
                        } while (model.length() < 2);
                        do {
                            System.out.println("Podaj datę produkcji samochodu: ");
                            productionDate = scan.nextInt();
                            scan.nextLine();
                            if (productionDate < 1900) {
                                System.out.println("Rok produkcji samochodu musi być większy niż 1900");
                            }
                        } while (productionDate < 1900);
                        do {
                            System.out.println("Podaj kolor samochodu: ");
                            color = scan.nextLine();
                            if (color.length() < 3) {
                                System.out.println("Długość nazwy kloru musi być minimum 3 literowa");
                            }
                        } while (color.length() < 3);
                        do {
                            System.out.println("Podaj przebieg samochodu: ");
                            course = scan.nextInt();
                            scan.nextLine();
                            if (course < 1) {
                                System.out.println("przebieg nie może być krótszy niż 1km");
                            }
                        } while (course < 1);
                        do {
                            System.out.println("Podaj ilość drzwi samochodu: ");
                            doorQuantity = scan.nextInt();
                            scan.nextLine();
                            if (doorQuantity < 2) {
                                System.out.println("Ilość drzwi nie może być mniejsza niż 2");
                            }
                        } while (doorQuantity < 2);
                        Car car = new Car(mark, model, productionDate, color, course, doorQuantity);
                        base.addCar(car);
                        System.out.println("DODANO NOWE AUTO!");
                    } else {
                        System.out.println("Podano złe dane logowania");
                    }
                    break;
                }
                case '3':
                {
                    isLogged = login();

                    if(isLogged) {
                        System.out.println("Podaj index auta które chcesz usunąć: ");
                        index = scan.nextInt();
                        scan.nextLine();
                        base.deleteCar(index);
                        System.out.println("Usunięto auto z indexem " + index);
                    } else {
                        System.out.println("Podano złe dane logowania");
                    }
                    break;
                }
                case '4':
                {

                    isLogged = login();

                    if(isLogged) {
                        scan.nextLine();
                        do {
                            System.out.println("Podaj markę samochodu: ");
                            mark = scan.nextLine();
                            if (mark.length() < 3) {
                                System.out.println("Nazwa marki musi mieć conajmiej 3 litery");
                            }
                        } while (mark.length() < 3);
                        do {
                            System.out.println("Podaj model samochodu: ");
                            model = scan.nextLine();
                            if (model.length() < 2) {
                                System.out.println("Nazawa modelu musi mieć conajmiej 2 litery");
                            }
                        } while (model.length() < 2);
                        do {
                            System.out.println("Podaj datę produkcji samochodu: ");
                            productionDate = scan.nextInt();
                            scan.nextLine();
                            if (productionDate < 1900) {
                                System.out.println("Rok produkcji samochodu musi być większy niż 1900");
                            }
                        } while (productionDate < 1900);
                        do {
                            System.out.println("Podaj kolor samochodu: ");
                            color = scan.nextLine();
                            if (color.length() < 3) {
                                System.out.println("Długość nazwy kloru musi być minimum 3 literowa");
                            }
                        } while (color.length() < 3);
                        do {
                            System.out.println("Podaj przebieg samochodu: ");
                            course = scan.nextInt();
                            scan.nextLine();
                            if (course < 1) {
                                System.out.println("przebieg nie może być krótszy niż 1km");
                            }
                        } while (course < 1);
                        do {
                            System.out.println("Podaj ilość drzwi samochodu: ");
                            doorQuantity = scan.nextInt();
                            scan.nextLine();
                            if (doorQuantity < 2) {
                                System.out.println("Ilość drzwi nie może być mniejsza niż 2");
                            }
                        } while (doorQuantity < 2);
                        do {
                            System.out.println("Podaj index auta które chcesz zaktualizować: ");
                            index = scan.nextInt();
                            scan.nextLine();
                            if (base.getCars().size() >= index && index > 0) {
                                System.out.println("Auto o takim indeksie nie istnieje");
                            } else {
                                Car car = new Car(mark, model, productionDate, color, course, doorQuantity);
                                base.updateCar(index, car);
                                System.out.println("Zaktualizowano auto z indexem " + index);
                            }
                        } while (base.getCars().size() >= index && index > 0);
                    } else {
                        System.out.println("Podano złe dane logowania");
                    }
                    break;
                }
                case '5':
                {
                    base.saveCar();
                    break;
                }
                case '6':
                {
                    base.loadCar();
                    break;
                }
                case '7':
                {
                    isLogged = login();

                    if(isLogged) {
                        for (Car c : base.sortCarsByYearAsc()) {
                            System.out.println("marka: " + c.getMark());
                            System.out.println("model: " + c.getModel());
                            System.out.println("data produkcji: " + c.getProductionDate());
                            System.out.println("kolor: " + c.getColor());
                            System.out.println("przebieg: " + c.getCourse());
                            System.out.println("ilość drzwi: " + c.getDoorQuantity());
                            System.out.println("----------------------------");
                        }
                    } else {
                        System.out.println("Podano złe dane logowania");
                    }
                    break;
                }
                case '8':
                {
                    isLogged = login();

                    if(isLogged) {
                        for (Car c : base.sortCarsByYearDesc()) {
                            System.out.println("marka: " + c.getMark());
                            System.out.println("model: " + c.getModel());
                            System.out.println("data produkcji: " + c.getProductionDate());
                            System.out.println("kolor: " + c.getColor());
                            System.out.println("przebieg: " + c.getCourse());
                            System.out.println("ilość drzwi: " + c.getDoorQuantity());
                            System.out.println("----------------------------");
                        }
                    } else {
                        System.out.println("Podano złe dane logowania");
                    }
                    break;
                }
                case '9':
                {
                    System.out.println("Podaj minimalną date produkcji: ");
                    min = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Podaj maksymalną date produkcji: ");
                    max = scan.nextInt();
                    scan.nextLine();

                    for(Car c : base.searchByProductionDate(min, max)) {
                        System.out.println("marka: " + c.getMark());
                        System.out.println("model: " + c.getModel());
                        System.out.println("data produkcji: " + c.getProductionDate());
                        System.out.println("kolor: " + c.getColor());
                        System.out.println("przebieg: " + c.getCourse());
                        System.out.println("ilość drzwi: " + c.getDoorQuantity());
                        System.out.println("----------------------------");
                    }
                    break;
                }
                case 'a':
                {
                    System.out.println("Podaj marke samochodu: ");
                    scan.nextLine();
                    mark = scan.nextLine();

                    for(Car c : base.searchByMark(mark)) {
                        System.out.println("marka: " + c.getMark());
                        System.out.println("model: " + c.getModel());
                        System.out.println("data produkcji: " + c.getProductionDate());
                        System.out.println("kolor: " + c.getColor());
                        System.out.println("przebieg: " + c.getCourse());
                        System.out.println("ilość drzwi: " + c.getDoorQuantity());
                        System.out.println("----------------------------");
                    }
                    break;
                }
                case 'b':
                {
                    scan.nextLine();
                    System.out.println("Podaj login: ");
                    login = scan.nextLine();
                    System.out.println("Podaj hasło: ");
                    password = scan.nextLine();
                    accounts.signup(login, password);
                    System.out.println("Dodano nowego użytkwnika");
                }
                case 'c':
                {

                }
                case 'x':
                    System.out.println("DO WIDZENIA!");
                    break;
            }
        } while(zn!= 'x');
    }
}
