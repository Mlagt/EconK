package com.company;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
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
    double[] proceedsDivided = new double[6];
    double incomePlaned, incomePlanedCurrentActivities; //Доход планируемый
    double[] incomePercentage = new double[6];

    public void Initialization(String pathname,int variant) throws IOException {
        int k=3;//положение колонки с которой идут цифры в методичке
        FileInputStream inputStream = new FileInputStream(new File(pathname));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.createRow(variant+1);
        Cell cell;
        for(int i=0;i<4;i++){
            cell = row.getCell(k);
            proceedsImplementation[i] = cell.getNumericCellValue();
            k++;
       }

        for (int i=0;i<proceedsImplementation.length;i++)
        System.out.println(proceedsImplementation[i]);

    }
}
