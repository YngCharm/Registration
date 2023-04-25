package org.example.authorization;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import static jdk.javadoc.internal.tool.Main.execute;

public class Authorization {
    public HashMap<String, String> customer = new HashMap<>();
    final static String DATABASE_PATH = "E:\\прроекты java\\Registration\\database.txt";

    File file = new File(DATABASE_PATH);

    public void addingCustomer() {
        customer.put("Sasha2875", "Alex2003");
        customer.put("VladKing", "123");
    }

    public void entering() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Авторизация" + "\n" + "2 - Регистрация");
        String enter = scanner.nextLine();

        if (enter.equals("1") || enter.equals("Авторизация")) {
            authorizing();
        }
    }



    public  void searchingInFile() {
        addingCustomer();
        try (BufferedReader br = new BufferedReader(new FileReader(DATABASE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                int symbolIndex = line.indexOf(':');

                if (symbolIndex != -1) {
                    // Чтение слова до символа ":"
                    String beforeSymbol = line.substring(0, symbolIndex);
                    System.out.println("Логин " + beforeSymbol);


                    // Чтение слова после символа ":"
                    String afterSymbol = line.substring(symbolIndex + 1);
                    System.out.println("Пароль " + afterSymbol);
                    customer.put(beforeSymbol, afterSymbol);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void authorizing() throws IOException {
        addingCustomer();
        searchingInFile();
        System.out.println(customer);
        BufferedReader br = new BufferedReader(new FileReader(DATABASE_PATH));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();

        while (br.readLine() != null) {

            if (customer.containsKey(login) && (customer.containsValue(password))) {
                entering();
            } else authorizing();

        }
        System.out.println("Вход успешный");
    }
}
