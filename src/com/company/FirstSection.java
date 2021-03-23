package com.company;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FirstSection {
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
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
            proceedsDividedPlanned[i] = ((proceedsDividedCurrent[i] * (100 + plannedIncrease[i])/100));
            proceedsDividedPlanned[i] = round(proceedsDividedPlanned[i], 2);
            proceedsPlaned += proceedsDividedPlanned[i];
        }
        incomePlanedCurrentActivities = proceedsPlaned + incomeFromOtherCurrentActivities;
        incomePlaned = incomePlanedCurrentActivities + incomePlanedInvest + incomePlanedFinance;
        for (int i =0; i<6; i++){
            incomePercentage[i] = round((proceedsDividedPlanned[i]/proceedsPlaned*100*100)/100, 2) ;
        }

        System.out.println("proceedsPlaned = "+proceedsPlaned+"\tincomePlaned = "+incomePlaned+"\tincomePlanedCurrentActivities = "+incomePlanedCurrentActivities);
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
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(3).getNumericCellValue());
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(4).getNumericCellValue());
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(5).getNumericCellValue());
        System.out.println("sgserg");
        for(int i=0;i<6;i++){
           // System.out.println(workbook.getSheetAt(0).getRow(k).getCell(variant+2).getStringCellValue());
            proceedsDividedCurrent[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
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
        incomePlanedFinance    = workbook.getSheetAt(0).getRow(k+1).getCell(variant+1).getNumericCellValue();
        incomeFromOtherCurrentActivities = workbook.getSheetAt(0).getRow(k+2).getCell(variant+1).getNumericCellValue();
        System.out.println(incomePlanedInvest+" "+incomePlanedFinance +" "+incomeFromOtherCurrentActivities);// проверка данных
        firstSection();

    }
}
