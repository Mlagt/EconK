package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        double[] num = new double[10];
        for (int i=0;i<num.length;i++) num[i]=(int)(Math.random()*100);
        for (int i=0;i<num.length;i++) System.out.print(num[i]+" ");

        WorkExel exel = new WorkExel();
        exel.CreatExel("Вариант 1",2,2,num);
        //for (int i=0;i<exel.number.length;i++) System.out.print(exel.number[i]+" ");
    }
}