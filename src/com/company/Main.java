package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\zetzp\\Desktop\\project\\Data1.xlsx";
        int variant = 9;





        //FirstSection firstSection = new FirstSection();
        //firstSection.Initialization(path,variant);
        SecondSection secondSection = new SecondSection();
        secondSection.Initialization(path, variant);
    }
}