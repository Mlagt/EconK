package com.company;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FirstSection {
    //Переменные первого раздела
    //Переменные из методички
    double[] proceedsImplementation = new double[6];
    double[] plannedIncrease = new double[6];
    double incomeFromOtherCurrentActivities, incomePlanedInvest, incomePlanedFinance;
    //Переменные в ответе
    double proceedsPlaned; // Выручка планируемая
    double[] proceedsDividedPlanned = new double[6];
    double[] proceedsDividedCurrent = new double[6];
    double incomePlaned, incomePlanedCurrentActivities; //Доход планируемый
    double[] incomePercentage = new double[6];

    public void firstSection(String[] args){
        for (int i =0; i<6; i++){
            proceedsDividedPlanned[i] = (proceedsDividedCurrent[i] * (100 + plannedIncrease[i]))/100;
            incomePlaned += proceedsDividedPlanned[i];
        }
        incomePlanedCurrentActivities = proceedsPlaned + incomeFromOtherCurrentActivities;
        incomePlaned = incomePlanedCurrentActivities + incomePlanedInvest + incomePlanedFinance;
    }

    public void Initialization(String pathname,int variant) throws IOException {
        int k=3;//положение колонки с которой идут цифры в методичке
        FileInputStream inputStream = new FileInputStream(new File(pathname));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        for(int i=0;i<6;i++){
           proceedsImplementation[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
           System.out.println(workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue()); //проверка данных
            k++;
        }
        k++;
        for(int i=0;i<6;i++){
            plannedIncrease[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
           System.out.println(plannedIncrease[i]); // проверка данных
            k++;
        }
        incomePlanedInvest =  workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
        incomePlanedFinance    = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
        incomeFromOtherCurrentActivities = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
        System.out.println(incomePlanedInvest+" "+incomePlanedFinance +" "+incomeFromOtherCurrentActivities);// проверка данных
    }
}
