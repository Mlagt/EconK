package com.company;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SecondSection {
    //переменные из методички
    double[] osCostatBeginningPlannedYear = new double[6];
    String[] commissioningPlannedYear = new String[6];
    double[] commissioningPlanned = new double[6];
    String[] decommissioningPlannedYear = new String[6];
    double[] decommissioningPlanned = new double[6];
    //Переменные второго раздела
    double fixedAssetsPlaned, fixedAssetsThisYear, fixedAssetsNextYear, fixedAssetsInput, fixedAssetsOutput;
    double[] fixedAssetsDivided = new double[6];
    double[] fixedAssetsMonth = new double[11];

    public void Calculation(){
    }

    public void Initialization(String pathname,int variant) throws IOException {
        int k=20;//положение колонки с которой идут цифры в методичке
        FileInputStream inputStream = new FileInputStream(new File(pathname));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        for(int i=0;i<6;i++){
            // System.out.println(workbook.getSheetAt(0).getRow(k).getCell(variant+2).getStringCellValue());
           osCostatBeginningPlannedYear[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
            System.out.println(osCostatBeginningPlannedYear[i]); //проверка данных
            k++;
        }
        k++;
        for(int i=0;i<6;i++){
           commissioningPlannedYear[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getStringCellValue();
           System.out.println(workbook.getSheetAt(0).getRow(k).getCell(variant+1).getStringCellValue()); // проверка данных
           k++;
        }
        k++;
        for(int i=0;i<6;i++){
           commissioningPlannedYear[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getStringCellValue();
           System.out.println(workbook.getSheetAt(0).getRow(k).getCell(variant+1).getStringCellValue()); // проверка данных
           k++;
        }
        Calculation();
    }
}


