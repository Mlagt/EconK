package com.company;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

class FirstSection {
    public static double round(double value) {
        if (2 < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    //Переменные первого раздела
    //Переменные из методички
    double[] proceedsImplementation = new double[6];
    double[] plannedIncrease = new double[6];
    double incomeFromOtherCurrentActivities, incomePlanedInvest, incomePlanedFinance;
    double[] proceedsDividedCurrent = new double[6];
    //Переменные в ответе
    double proceedsPlaned=0; // Выручка планируемая
    double[] proceedsDividedPlanned = new double[]{ 1, 1, 1, 1,1,1 };

    double incomePlaned=0, incomePlanedCurrentActivities=1; //Доход планируемый
    double[] incomePercentage = new double[]{ 1, 1, 1, 1,1,1 };

    private void firstSection(){
        for (int i =0; i<6; i++){
            proceedsDividedPlanned[i] = ((proceedsDividedCurrent[i] * (100 + plannedIncrease[i])/100));
            proceedsDividedPlanned[i] = round(proceedsDividedPlanned[i]);
            proceedsPlaned += proceedsDividedPlanned[i];
        }
        proceedsPlaned = round(proceedsPlaned);
        incomePlanedCurrentActivities = proceedsPlaned + incomeFromOtherCurrentActivities;
        incomePlaned = incomePlanedCurrentActivities + incomePlanedInvest + incomePlanedFinance;
        for (int i =0; i<6; i++){
            incomePercentage[i] = round((proceedsDividedPlanned[i]/proceedsPlaned*100*100)/100) ;
        }

        System.out.println("proceedsPlaned = "+proceedsPlaned+"\tincomePlaned = "+incomePlaned+"\tincomePlanedCurrentActivities = "+incomePlanedCurrentActivities);
        System.out.print("proceedsDividedPlanned= ");
        for (double v : proceedsDividedPlanned) System.out.print(v + " ");
        System.out.println("");
        System.out.print("incomePercentage= ");
        for (double v : incomePercentage) System.out.print(v + " ");

    }

    void Initialization(String pathname, int variant) throws IOException {
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
