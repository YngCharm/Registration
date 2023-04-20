package org.example;

import org.example.authorization.Authorization;
import org.example.registration.Registration;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Authorization authorization = new Authorization();
        authorization.searchingInFile();
        authorization.authorizing();


        Registration registration = new Registration();
        registration.registering();
        registration.writingDatabase();
    }
}