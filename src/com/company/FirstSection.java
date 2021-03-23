package com.company;

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
    double[] proceedsDividedCurrent = new double[6];
    //Переменные в ответе
    double proceedsPlaned=1; // Выручка планируемая
    double[] proceedsDividedPlanned = new double[]{ 1, 1, 1, 1,1,1 };

    double incomePlaned=1, incomePlanedCurrentActivities=1; //Доход планируемый
    double[] incomePercentage = new double[]{ 1, 1, 1, 1,1,1 };

    public void firstSection(){
        for (int i =0; i<6; i++){
            proceedsDividedPlanned[i] = (proceedsDividedCurrent[i] * (100 + plannedIncrease[i]))/100;
            proceedsPlaned += proceedsDividedPlanned[i];
        }
        incomePlanedCurrentActivities = proceedsPlaned + incomeFromOtherCurrentActivities;
        incomePlaned = incomePlanedCurrentActivities + incomePlanedInvest + incomePlanedFinance;
        for (int i =0; i<6; i++){
            incomePercentage[i] = proceedsDividedCurrent[i]/incomePlaned*100;
        }

        System.out.println("proceedsPlaned= "+proceedsPlaned+"\tincomePlaned= "+incomePlaned+"\tincomePlanedCurrentActivities"+incomePlanedCurrentActivities);
        System.out.print("proceedsDividedPlanned= ");
        for (int i=0;i<proceedsDividedPlanned.length;i++) System.out.print(proceedsDividedPlanned[i]+" ");
        System.out.println("");
        System.out.print("incomePercentage= ");
        for (int i=0;i<incomePercentage.length;i++) System.out.print(incomePercentage[i]+" ");

    }

    public void Initialization(String pathname,int variant) throws IOException {
        int k=3;//положение колонки с которой идут цифры в методичке
        FileInputStream inputStream = new FileInputStream(new File(pathname));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        for(int i=0;i<6;i++){
            proceedsDividedCurrent[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+2).getNumericCellValue();
           System.out.println(proceedsDividedCurrent[i]); //проверка данных
            k++;
        }
        k++;
        for(int i=0;i<6;i++){
            plannedIncrease[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+2).getNumericCellValue();
          System.out.println(plannedIncrease[i]); // проверка данных
            k++;
        }
        incomePlanedInvest =  workbook.getSheetAt(0).getRow(k).getCell(variant+2).getNumericCellValue();
        incomePlanedFinance    = workbook.getSheetAt(0).getRow(k+1).getCell(variant+2).getNumericCellValue();
        incomeFromOtherCurrentActivities = workbook.getSheetAt(0).getRow(k+2).getCell(variant+2).getNumericCellValue();
        System.out.println(incomePlanedInvest+" "+incomePlanedFinance +" "+incomeFromOtherCurrentActivities);// проверка данных
        firstSection();
    }
}
