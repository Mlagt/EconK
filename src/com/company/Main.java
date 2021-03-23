package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\zetzp\\Desktop\\project\\Data.xlsx";
        int variant = 8;





        FirstSection firstSection = new FirstSection();
        firstSection.Initialization(path,variant);

    }
}