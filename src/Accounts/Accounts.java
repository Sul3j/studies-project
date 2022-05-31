package Accounts;

import Car.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Accounts {
    public void signup(String login, String password) {
        try {
            File db = new File("accounts.txt");
            if(db.createNewFile()) {
                System.out.println("Stworzono nowy plik " + db.getName());
            } else {
                System.out.println("Plik już istnieje");
            }

            Writer dbSave = new BufferedWriter(new FileWriter("accounts.txt", true));
            int hashPassword = password.hashCode();

            dbSave.write(login + ";" + hashPassword + "\n");
            dbSave.close();
            System.out.println("UTWORZONO KONTO");
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public boolean login(String login, String password) {
        boolean loginFlag = false;

        try {
            File db = new File("accounts.txt");
            Scanner scan = new Scanner(db);
            StringTokenizer token;
            List<Object> elementsArray = new ArrayList<Object>();

            while (scan.hasNextLine()) {
                token = new StringTokenizer(scan.nextLine(), ";");
                while(token.hasMoreElements()) {
                    elementsArray.add(token.nextToken());
                }

                if(elementsArray.get(0).toString().equals(login) && Integer.parseInt(elementsArray.get(1).toString()) == password.hashCode()) {
                    loginFlag = true;
                    return loginFlag;
                } else {
                    loginFlag = false;
                }

                elementsArray.clear();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
            e.printStackTrace();
        }

        return loginFlag;
    }
}
