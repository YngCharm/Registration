package org.example.registration;

import org.example.authorization.Authorization;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Registration {
    Authorization authorization = new Authorization();
    final static String DATABASE_PATH = "E:\\прроекты java\\Registration\\database.txt";
    File file = new File(DATABASE_PATH);
    public static String reverse(String createPassword) {
        return new StringBuilder(createPassword).reverse().toString();
    }

    public Registration() throws IOException {
    }

    public void registering() {
        authorization.addingCustomer();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Придумайте логин: ");
        String createLogin = scanner.nextLine();
        System.out.println("Придумайте пароль: ");
        String createPassword = scanner.nextLine();

        createPassword = reverse(createPassword);

        if ((!authorization.customer.containsKey(createLogin))) {
            authorization.customer.put(createLogin, createPassword);

        } else {
            System.out.println("Логин уже занят " + "\n" + "Придумайте новый логин");
            registering();
        }
    }

    public void writingDatabase() {
        authorization.addingCustomer();
        BufferedWriter bf = null;

        try {

            bf = new BufferedWriter(new FileWriter(file, true));

            for (Map.Entry<String, String> entry :
                    authorization.customer.entrySet()) {

                bf.write(entry.getKey() + ":"
                        + entry.getValue());

                bf.newLine();
            }

            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                bf.close();
            } catch (Exception e) {
            }
        }
    }
}