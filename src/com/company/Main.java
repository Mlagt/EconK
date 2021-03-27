package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\ztpze\\Downloads\\Data1 (1).xlsx";
        int variant = 9;





        //FirstSection firstSection = new FirstSection();
        //firstSection.Initialization(path,variant);
        SecondSection secondSection = new SecondSection();
        secondSection.Initialization(path, variant);
    }
}