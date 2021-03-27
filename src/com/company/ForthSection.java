package com.company;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ForthSection {
    //переменные из файла
    double preferentialProfit, expensesOtherCurrentActivities, financeExpenses, investmentExpenses ;

    //Переменные третьего раздела
    double profitSaleOfGoodsPlaned, valueAddedTax, VAT ,
            profitCurrentActivities, profitInvestActivities,
            profitFinanceActivities, profitBeforeTaxes,
            profitTaxable, profitTaxes, profitClear;

    FirstSection firstSection;
    ThirdSection thirdSection;

    private void Calculation() {
        firstSection = new FirstSection();
        try {
            firstSection.Initialization("D:\\Java\\File\\Data1.xlsx",2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        thirdSection = new ThirdSection();
        try {
            thirdSection.Initialization("D:\\Java\\File\\Data1.xlsx",2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        VAT =round(firstSection.proceedsPlaned*25/125,2);
        profitSaleOfGoodsPlaned = firstSection.proceedsPlaned-VAT-thirdSection.costsAmount;
        profitCurrentActivities = profitSaleOfGoodsPlaned+firstSection.incomeFromOtherCurrentActivities-expensesOtherCurrentActivities;
        profitInvestActivities = firstSection.incomePlanedInvest-investmentExpenses;
        profitFinanceActivities = firstSection.incomePlanedFinance-financeExpenses;
        profitBeforeTaxes= profitCurrentActivities+profitInvestActivities+profitFinanceActivities;
        profitTaxable = profitBeforeTaxes-preferentialProfit;
        profitTaxes=profitTaxable*18/100;
        profitClear = profitBeforeTaxes-profitTaxes;

        System.out.println("----------Ответы 4 раздел----------");
        System.out.println("proceedsPlaned = "+ firstSection.proceedsPlaned);
        System.out.println("VAT = "+ VAT);
        System.out.println("profitSaleOfGoodsPlaned = "+ profitSaleOfGoodsPlaned);
        System.out.println("profitCurrentActivities = "+ profitCurrentActivities);
        System.out.println("profitInvestActivities = "+ profitInvestActivities);
        System.out.println("profitFinanceActivities = "+ profitFinanceActivities);
        System.out.println("profitBeforeTaxes = "+ profitBeforeTaxes);
        System.out.println("profitTaxable = "+ profitTaxable);
        System.out.println("profitTaxes = "+ profitTaxes);
        System.out.println("profitClear = "+ profitClear);

    }


    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void Initialization(String pathname,int variant) throws IOException {
        int k=61;//положение колонки с которой идут цифры в методичке
        FileInputStream inputStream = new FileInputStream(new File(pathname));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        preferentialProfit = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();k++;
        System.out.println(preferentialProfit);
        expensesOtherCurrentActivities  = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();k++;
        financeExpenses = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();k++;
        System.out.println( expensesOtherCurrentActivities+ " " + financeExpenses);
        investmentExpenses  = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
        System.out.println( investmentExpenses);
        Calculation();
    }



}
