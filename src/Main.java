import Accounts.Accounts;
import Car.Car;
import CarDatabase.CarDatabase;

import java.util.List;
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

    private static void showCar(int current , CarDatabase base, List<Car> list) {
        System.out.println("marka: " + base.viewCars(current, list).getMark());
        System.out.println("model: " + base.viewCars(current, list).getModel());
        System.out.println("data produkcji: " + base.viewCars(current, list).getProductionDate());
        System.out.println("kolor: " + base.viewCars(current, list).getColor());
        System.out.println("przebieg: " + base.viewCars(current, list).getCourse());
        System.out.println("ilosc drzwi: " + base.viewCars(current, list).getDoorQuantity());
    }

    public static void main(String[] args) {

        String mark, model, color, login, password;
        int productionDate, course, doorQuantity, min, max, current = 0, currentSort = 0, currentSearch = 0;
        boolean isLogged = false;

        Accounts accounts = new Accounts();
        CarDatabase base = new CarDatabase();
        Scanner scan = new Scanner(System.in);

        char zn, z;

        do {
            System.out.println("c. Przegladaj w lewo");
            System.out.println("v. Przegladaj w prawo");
            System.out.println("1. Dodaj auto");
            System.out.println("2. Usun auto");
            System.out.println("3. Aktualizuj auto");
            System.out.println("s. Zapisz do pliku");
            System.out.println("r. Wczytanie danych z pliku");
            System.out.println("4. Sortowanie danych rosnaco po roczniku");
            System.out.println("5. Sortowanie danych malejaco po roczniku");
            System.out.println("6. Sortowanie danych od A do Z po marce");
            System.out.println("7. Sortowanie danych od Z do A po marce");
            System.out.println("8. Wyszukiwanie po przedziale przebiegu");
            System.out.println("9. Wyszukiwanie po marce samochodu");
            System.out.println("a. Dodaj konto");
            System.out.println("x. Wyjdz z programu");

            zn = scan.next().charAt(0);

            switch (zn) {
                // Przegladaj w lewo
                case 'c': {
                    if (current >= 1) {
                        current--;
                        showCar(current, base, base.getCars());
                    } else {
                        current = base.getCars().size() - 1;
                        showCar(current, base, base.getCars());
                    }
                    break;
                }
                // Przegladaj w prawo
                case 'v': {
                    if (current < base.getCars().size() - 1) {
                        current++;
                        showCar(current, base, base.getCars());
                    } else  {
                        current = 0;
                        showCar(current, base, base.getCars());
                    }
                    break;
                }
                // Dodaj auto
                case '1': {
                    isLogged = login();

                    if(isLogged) {
                        scan.nextLine();
                        do {
                            System.out.println("Podaj marke samochodu: ");
                            mark = scan.nextLine();
                            if (mark.length() < 3) {
                                System.out.println("Nazwa marki musi miec conajmiej 3 litery");
                            }
                        } while (mark.length() < 3);
                        do {
                            System.out.println("Podaj model samochodu: ");
                            model = scan.nextLine();
                            if (model.length() < 2) {
                                System.out.println("Nazawa modelu musi miec conajmiej 2 litery");
                            }
                        } while (model.length() < 2);
                        do {
                            System.out.println("Podaj date produkcji samochodu: ");
                            productionDate = scan.nextInt();
                            scan.nextLine();
                            if (productionDate < 1900) {
                                System.out.println("Rok produkcji samochodu musi być wiekszy niz 1900");
                            }
                        } while (productionDate < 1900);
                        do {
                            System.out.println("Podaj kolor samochodu: ");
                            color = scan.nextLine();
                            if (color.length() < 3) {
                                System.out.println("Długosc nazwy kloru musi byc minimum 3 literowa");
                            }
                        } while (color.length() < 3);
                        do {
                            System.out.println("Podaj przebieg samochodu: ");
                            course = scan.nextInt();
                            scan.nextLine();
                            if (course < 1) {
                                System.out.println("przebieg nie moze byc krotszy niz 1km");
                            }
                        } while (course < 1);
                        do {
                            System.out.println("Podaj ilosc drzwi samochodu: ");
                            doorQuantity = scan.nextInt();
                            scan.nextLine();
                            if (doorQuantity < 2) {
                                System.out.println("Ilosc drzwi nie moze byc mniejsza niz 2");
                            }
                        } while (doorQuantity < 2);
                        Car car = new Car(mark, model, productionDate, color, course, doorQuantity);
                        base.addCar(car);
                        System.out.println("DODANO NOWE AUTO!");
                    } else {
                        System.out.println("Podano zle dane logowania");
                    }
                    break;
                }
                // Usun auto
                case '2': {
                    isLogged = login();

                    if(isLogged) {
                        System.out.println("Usunięto auto " + base.viewCars(current, base.getCars()).getMark() + " " + base.viewCars(current, base.getCars()).getModel());
                        base.deleteCar(current);
                        current = 0;
                    } else {
                        System.out.println("Podano zle dane logowania");
                    }
                    break;
                }
                // Aktualizuj auto
                case '3': {

                    isLogged = login();

                    if(isLogged) {
                        scan.nextLine();
                        do {
                            System.out.println("Podaj marke samochodu: ");
                            mark = scan.nextLine();
                            if (mark.length() < 3) {
                                System.out.println("Nazwa marki musi miec conajmiej 3 litery");
                            }
                        } while (mark.length() < 3);
                        do {
                            System.out.println("Podaj model samochodu: ");
                            model = scan.nextLine();
                            if (model.length() < 2) {
                                System.out.println("Nazawa modelu musi miec conajmiej 2 litery");
                            }
                        } while (model.length() < 2);
                        do {
                            System.out.println("Podaj date produkcji samochodu: ");
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
                                System.out.println("Długość nazwy kloru musi byc minimum 3 literowa");
                            }
                        } while (color.length() < 3);
                        do {
                            System.out.println("Podaj przebieg samochodu: ");
                            course = scan.nextInt();
                            scan.nextLine();
                            if (course < 1) {
                                System.out.println("przebieg nie może byc krotszy niż 1km");
                            }
                        } while (course < 1);
                        do {
                            System.out.println("Podaj ilosc drzwi samochodu: ");
                            doorQuantity = scan.nextInt();
                            scan.nextLine();
                            if (doorQuantity < 2) {
                                System.out.println("Ilosc drzwi nie moze byc mniejsza niż 2");
                            }
                        } while (doorQuantity < 2);

                        Car car = new Car(mark, model, productionDate, color, course, doorQuantity);
                        base.updateCar(current, car);
                        System.out.println("ZAKTUALIZOWANO AUTO");
                        current = 0;

                    } else {
                        System.out.println("Podano zle dane logowania");
                    }
                    break;
                }
                // Zapisz do pliku
                case 's': {
                    base.saveCar();
                    break;
                }
                // Wczytanie danych z pliku
                case 'r': {
                    base.loadCar();
                    break;
                }
                // Sortowanie danych rosnaco po roczniku
                case '4': {
                    isLogged = login();

                    if(isLogged) {
                        do {
                            System.out.println("c. przegladaj w lewo");
                            System.out.println("v. przegladaj w prawo");
                            System.out.println("x. Wyjdz z przegladania");

                            z = scan.next().charAt(0);
                            switch (z)
                            {
                                case 'c':
                                {
                                    if (currentSort >= 1) {
                                        currentSort--;
                                        showCar(currentSort, base, base.sortCarsByYearAsc());
                                    } else {
                                        currentSort = base.sortCarsByYearAsc().size() - 1;
                                        showCar(currentSort, base, base.sortCarsByYearAsc());
                                    }
                                    break;
                                }

                                case 'v': {
                                    if (currentSort < base.sortCarsByYearAsc().size() - 1) {
                                        currentSort++;
                                        showCar(currentSort, base, base.sortCarsByYearAsc());
                                    } else  {
                                        currentSort = 0;
                                        showCar(currentSort, base, base.sortCarsByYearAsc());
                                    }
                                    break;
                                }
                                case 'x': {
                                    currentSort = 0;
                                    break;
                                }
                            }
                        } while (z != 'x');
                    } else {
                        System.out.println("Podano zle dane logowania");
                    }
                    break;
                }
                // Sortowanie danych malejaco po roczniku
                case '5': {
                    isLogged = login();

                    if(isLogged) {
                        do {
                            System.out.println("c. przegladaj w lewo");
                            System.out.println("v. przegladaj w prawo");
                            System.out.println("x. Wyjdz z przegladania");

                            z = scan.next().charAt(0);
                            switch (z)
                            {
                                case 'c':
                                {
                                    if (currentSort >= 1) {
                                        currentSort--;
                                        showCar(currentSort, base, base.sortCarsByYearDesc());
                                    } else {
                                        currentSort = base.sortCarsByYearDesc().size() - 1;
                                        showCar(currentSort, base, base.sortCarsByYearDesc());
                                    }
                                    break;
                                }

                                case 'v': {
                                    if (currentSort < base.sortCarsByYearDesc().size() - 1) {
                                        currentSort++;
                                        showCar(currentSort, base, base.sortCarsByYearDesc());
                                    } else  {
                                        currentSort = 0;
                                        showCar(currentSort, base, base.sortCarsByYearDesc());
                                    }
                                    break;
                                }
                                case 'x': {
                                    currentSort = 0;
                                    break;
                                }
                            }
                        } while (z != 'x');
                    } else {
                        System.out.println("Podano zle dane logowania");
                    }
                    break;
                }
                // Sortowanie danych od A do Z po marce
                case '6': {
                    isLogged = login();

                    if(isLogged) {
                        do {
                            System.out.println("c. przegladaj w lewo");
                            System.out.println("v. przegladaj w prawo");
                            System.out.println("x. Wyjdz z przegladania");

                            z = scan.next().charAt(0);
                            switch (z)
                            {
                                case 'c':
                                {
                                    if (currentSort >= 1) {
                                        currentSort--;
                                        showCar(currentSort, base, base.sortCarByMarkAZ());
                                    } else {
                                        currentSort = base.sortCarByMarkAZ().size() - 1;
                                        showCar(currentSort, base, base.sortCarByMarkAZ());
                                    }
                                    break;
                                }

                                case 'v': {
                                    if (currentSort < base.sortCarByMarkAZ().size() - 1) {
                                        currentSort++;
                                        showCar(currentSort, base, base.sortCarByMarkAZ());
                                    } else  {
                                        currentSort = 0;
                                        showCar(currentSort, base, base.sortCarByMarkAZ());
                                    }
                                    break;
                                }
                                case 'x': {
                                    currentSort = 0;
                                    break;
                                }
                            }
                        } while (z != 'x');
                    } else {
                        System.out.println("Podano zle dane logowania");
                    }
                    break;
                }
                // Sortowanie danych od Z do A po marce
                case '7': {
                    isLogged = login();

                    if(isLogged) {
                        do {
                            System.out.println("c. przegladaj w lewo");
                            System.out.println("v. przegladaj w prawo");
                            System.out.println("x. Wyjdz z przegladania");

                            z = scan.next().charAt(0);
                            switch (z)
                            {
                                case 'c':
                                {
                                    if (currentSort >= 1) {
                                        currentSort--;
                                        showCar(currentSort, base, base.sortCarByMarkZA());
                                    } else {
                                        currentSort = base.sortCarByMarkZA().size() - 1;
                                        showCar(currentSort, base, base.sortCarByMarkZA());
                                    }
                                    break;
                                }

                                case 'v': {
                                    if (currentSort < base.sortCarByMarkZA().size() - 1) {
                                        currentSort++;
                                        showCar(currentSort, base, base.sortCarByMarkZA());
                                    } else  {
                                        currentSort = 0;
                                        showCar(currentSort, base, base.sortCarByMarkZA());
                                    }
                                    break;
                                }
                                case 'x': {
                                    currentSort = 0;
                                    break;
                                }
                            }
                        } while (z != 'x');
                    } else {
                        System.out.println("Podano zle dane logowania");
                    }
                    break;
                }
                // Wyszukiwanie po przedziale przebiegu
                case '8': {
                    System.out.println("Podaj minimalna date produkcji: ");
                    min = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Podaj maksymalna date produkcji: ");
                    max = scan.nextInt();
                    scan.nextLine();


                    do {
                        System.out.println("c. przegladaj w lewo");
                        System.out.println("v. przegladaj w prawo");
                        System.out.println("x. Wyjdz z przegladania");

                        z = scan.next().charAt(0);

                        switch (z)
                        {
                            case 'c':
                            {
                                if (currentSearch >= 1) {
                                    currentSearch--;
                                    showCar(currentSearch, base, base.searchByProductionDate(min, max));
                                } else {
                                    currentSearch = base.searchByProductionDate(min, max).size() - 1;
                                    showCar(currentSearch, base, base.searchByProductionDate(min, max));
                                }
                                break;
                            }

                            case 'v': {
                                if (currentSearch < base.searchByProductionDate(min, max).size() - 1) {
                                    currentSearch++;
                                    showCar(currentSearch, base, base.searchByProductionDate(min, max));
                                } else  {
                                    currentSearch = 0;
                                    showCar(currentSearch, base, base.searchByProductionDate(min, max));
                                }
                                break;
                            }
                            case 'x': {
                                currentSearch = 0;
                                break;
                            }
                        }
                    } while (z != 'x');

                    break;
                }
                // Wyszukiwanie po marce samochodu
                case '9': {
                    System.out.println("Podaj marke samochodu: ");
                    scan.nextLine();
                    mark = scan.nextLine();

                    do {
                        System.out.println("c. przegladaj w lewo");
                        System.out.println("v. przegladaj w prawo");
                        System.out.println("x. Wyjdz z przegladania");

                        z = scan.next().charAt(0);

                        switch (z)
                        {
                            case 'c':
                            {
                                if (currentSearch >= 1) {
                                    currentSearch--;
                                    showCar(currentSearch, base, base.searchByMark(mark));
                                } else {
                                    currentSearch = base.searchByMark(mark).size() - 1;
                                    showCar(currentSearch, base, base.searchByMark(mark));
                                }
                                break;
                            }

                            case 'v': {
                                if (currentSearch < base.searchByMark(mark).size() - 1) {
                                    currentSearch++;
                                    showCar(currentSearch, base, base.searchByMark(mark));
                                } else  {
                                    currentSearch = 0;
                                    showCar(currentSearch, base, base.searchByMark(mark));
                                }
                                break;
                            }
                            case 'x': {
                                currentSearch = 0;
                                break;
                            }
                        }
                    } while (z != 'x');

                    break;
                }
                // Dodaj konto
                case 'a': {
                    scan.nextLine();
                    System.out.println("Podaj login: ");
                    login = scan.nextLine();
                    System.out.println("Podaj haslo: ");
                    password = scan.nextLine();
                    accounts.signup(login, password);
                    System.out.println("Dodano nowego uzytkwnika");
                    break;
                }
                // Wyjdz z programu
                case 'x': {
                    System.out.println("DO WIDZENIA!");
                    break;
                }
            }
        } while(zn!= 'x');
    }
}