package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "D:\\Java\\File\\Data3.xlsx";
        int vatiant = 2;





        FirstSection firstSection = new FirstSection();
        firstSection.Initialization(path,vatiant);

    }
}