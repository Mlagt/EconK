package com.company;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ThirdSection {
    //переменные из файла
    double[] usefulLife = new double[6];
    double numberEmployeesPlannedYear;
    String plannedIncreasEemployees;
    String plannedReductionEmployees;
    double averageMonthWagesYear;
    double plannedGrowthRateAverageWeages;
    double[] materialCostsCurrentYear = new double[3];
    double[] percentageMaterialCostReductionPlannedYear = new double[3];
    double otherProductionCosts;
    //Переменные третьего раздела
    double laborCosts, peoplePlaned, peopleCurrent, salaryPlaned, salaryCurrent, salaryGrowth;
    double socialContributions;
    double depreciationAmount;
    double[] depreciationNorm = new double[6];
    double[] depreciationDivided = new double[6];
    double materialContributions100Planned, materialContributions100Current;
    double[] materialContributions100 = new double[3];
    double[] materialContributionsDivided = new double[3];
    double materialContributionsAmount;
    double otherCostsPlaned, costsAmount, costPrice100;
    double[] costsAmountDivided = new double[5];
    double[] costPrice100Divided = new double[5];

    FirstSection firstSection;
    SecondSection secondSection;

    private void Calculation() {
        firstSection = new FirstSection();
        secondSection = new SecondSection();
        salaryPlaned = averageMonthWagesYear*plannedGrowthRateAverageWeages/100;
       // peoplePlaned //подсчет числиности людей
        laborCosts = peoplePlaned*salaryPlaned*12;     //ЗОТ
        socialContributions = laborCosts*34/100;       //ОСН
        for (int i=0;i<depreciationNorm.length;i++){
            depreciationNorm[i]=round(1/usefulLife[i]*100,2);
            depreciationDivided[i]=secondSection.fixedAssetsDividedPlanned[i]*depreciationNorm[i]/100;
            depreciationAmount+=depreciationDivided[i]; //А
        }
        for (int i=0;i<materialCostsCurrentYear.length;i++){
            materialContributions100[i]=materialCostsCurrentYear[i]*(100-percentageMaterialCostReductionPlannedYear[i])/100;
            materialContributionsDivided[i]=materialContributions100[i]*firstSection.proceedsPlaned/100;
            materialContributionsAmount+=materialContributionsDivided[i]; //MЗ
        }
        otherCostsPlaned = round((laborCosts+socialContributions+depreciationAmount+materialContributionsAmount)*8/92,2);//ПР
        costsAmount = laborCosts+socialContributions+depreciationAmount+materialContributionsAmount+otherCostsPlaned; //З
        costPrice100=costsAmount/firstSection.proceedsPlaned*100;

        costPrice100Divided[0]=laborCosts/firstSection.proceedsPlaned*100;
        costsAmountDivided[0]=laborCosts/firstSection.proceedsPlaned*100;
        costPrice100Divided[1]=socialContributions/firstSection.proceedsPlaned*100;
        costsAmountDivided[1]=socialContributions/firstSection.proceedsPlaned*100;
        costPrice100Divided[2]=depreciationAmount/firstSection.proceedsPlaned*100;
        costsAmountDivided[2]=depreciationAmount/firstSection.proceedsPlaned*100;
        costPrice100Divided[3]=materialContributionsAmount/firstSection.proceedsPlaned*100;
        costsAmountDivided[3]=materialContributionsAmount/firstSection.proceedsPlaned*100;
        costPrice100Divided[4]=otherCostsPlaned/firstSection.proceedsPlaned*100;
        costsAmountDivided[4]=otherCostsPlaned/firstSection.proceedsPlaned*100;


        System.out.println("----------Ответы 3 раздел----------");
        System.out.println("Зон = "+ laborCosts);
        System.out.println("осн = "+ laborCosts);
        System.out.println("А = "+ laborCosts);
        System.out.println("МЗ = "+ laborCosts);
        System.out.println("З = "+ laborCosts);
        System.out.print("costPrice100Divided= ");
        for (int i=0;i<costPrice100Divided.length;i++) System.out.print(costPrice100Divided[i]+" ");System.out.println("");
        System.out.print("costsAmountDivided= ");
        for (int i=0;i<costsAmountDivided.length;i++) System.out.print(costsAmountDivided[i]+" ");System.out.println("");


    }


    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    public void Initialization(String pathname,int variant) throws IOException {
        int k=41;//положение колонки с которой идут цифры в методичке
        FileInputStream inputStream = new FileInputStream(new File(pathname));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        for(int i=0;i<6;i++){
            usefulLife[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
            System.out.println(usefulLife[i]); //проверка данных
            k++;
        }
        numberEmployeesPlannedYear = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();k++;
        System.out.println(numberEmployeesPlannedYear);
        plannedIncreasEemployees =  workbook.getSheetAt(0).getRow(k).getCell(variant+1).getStringCellValue();k++;
        plannedReductionEmployees =  workbook.getSheetAt(0).getRow(k).getCell(variant+1).getStringCellValue();k++;
        System.out.println( plannedIncreasEemployees+ " " + plannedReductionEmployees);
        averageMonthWagesYear  = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();k++;
        plannedGrowthRateAverageWeages = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();k++;
        System.out.println( averageMonthWagesYear+ " " + plannedGrowthRateAverageWeages);
        k++;
        for(int i=0;i<3;i++){
            materialCostsCurrentYear[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
            System.out.println(materialCostsCurrentYear[i]); //проверка данных
            k++;
        } k++;
        for(int i=0;i<3;i++){
            percentageMaterialCostReductionPlannedYear[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
            System.out.println(percentageMaterialCostReductionPlannedYear[i]); //проверка данных
            k++;
        }
        otherProductionCosts  = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
        System.out.println( otherProductionCosts);
        Calculation();
    }



}
