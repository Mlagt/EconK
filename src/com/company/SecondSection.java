package com.company;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SecondSection {
    //переменные из методички
    osCost
    //Переменные второго раздела
    double fixedAssetsPlaned, fixedAssetsThisYear, fixedAssetsNextYear, fixedAssetsInput, fixedAssetsOutput;
    double[] fixedAssetsDivided = new double[6];
    double[] fixedAssetsMonth = new double[11];

    public void Initialization(String pathname,int variant) throws IOException {
        int k=3;//положение колонки с которой идут цифры в методичке
        FileInputStream inputStream = new FileInputStream(new File(pathname));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        for(int i=0;i<6;i++){
           // proceedsImplementation[i] = workbook.getSheetAt(0).getRow(variant+2).getCell(k).getNumericCellValue();
            // System.out.println(proceedsImplementation[i]); проверка данных
            k++;
        }
        k++;
        for(int i=0;i<6;i++){
            //plannedIncrease[i] = workbook.getSheetAt(0).getRow(variant+2).getCell(k).getNumericCellValue();
            //  System.out.println(plannedIncrease[i]);  проверка данных
            k++;
        }
        //incomePlanedInvest =  workbook.getSheetAt(0).getRow(variant+2).getCell(k).getNumericCellValue();
        //incomePlanedFinance    = workbook.getSheetAt(0).getRow(variant+2).getCell(k+1).getNumericCellValue();
       // incomeFromOtherCurrentActivities = workbook.getSheetAt(0).getRow(variant+2).getCell(k+2).getNumericCellValue();
        // System.out.println(incomePlanedInvest+" "+incomePlanedFinance +" "+incomeFromOtherCurrentActivities); проверка данных
    }
}


