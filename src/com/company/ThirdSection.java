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
    double numberEmployersCurrentYear;
    double numberEmployeesPlannedYear;
    String[] plannedIncreaseEmployees = new String[4];
    String[] plannedReductionEmployees = new String[4];
    double averageMonthWagesYear;
    double plannedGrowthRateAverageWeages;
    double[] materialCostsCurrentYear = new double[3];
    double[] percentageMaterialCostReductionPlannedYear = new double[3];
    double otherProductionCosts;
    //Переменные третьего раздела
    double laborCosts, peoplePlaned, peopleCurrent, salaryPlaned, salaryCurrent, salaryGrowth;
    double socialContributions;
    double depreciationAmount = 0;
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

        if (plannedReductionEmployees[0].equals("o")&&plannedIncreaseEmployees[0].equals("o")) {
            numberEmployeesPlannedYear = numberEmployersCurrentYear;
        }else{ if(!plannedReductionEmployees[0].equals("o")&&!plannedIncreaseEmployees[0].equals("o")){
            secondSection.switchHumans(plannedIncreaseEmployees, secondSection.inputVerify);
            secondSection.switchHumans(plannedReductionEmployees, secondSection.outputVerify);
        }else{ if(!plannedIncreaseEmployees[0].equals("o")) secondSection.switchHumans(plannedIncreaseEmployees, secondSection.inputVerify);
        if(!plannedReductionEmployees[0].equals("o")) secondSection.switchHumans(plannedReductionEmployees, secondSection.outputVerify);}}

        numberEmployeesPlannedYear = humansPlanned(numberEmployersCurrentYear);
        System.out.println("Число хуманов равно "+ numberEmployersCurrentYear);

        salaryPlaned = averageMonthWagesYear*plannedGrowthRateAverageWeages/100;

        laborCosts = round(numberEmployersCurrentYear*salaryPlaned*12/1000, 2);     //ЗОТ
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
        otherCostsPlaned = round((laborCosts+socialContributions+depreciationAmount+materialContributionsAmount)*12.5/87.5,2);//ПР
        costsAmount = laborCosts+socialContributions+depreciationAmount+materialContributionsAmount+otherCostsPlaned; //З
        costPrice100=costsAmount/firstSection.proceedsPlaned*100;

        costPrice100Divided[0]= FirstSection.round(laborCosts/firstSection.proceedsPlaned*100);
        costsAmountDivided[0]= FirstSection.round(laborCosts/costsAmount*100);
        costPrice100Divided[1]= FirstSection.round(socialContributions/firstSection.proceedsPlaned*100);
        costsAmountDivided[1]= FirstSection.round(socialContributions/costsAmount*100);
        costPrice100Divided[2]= FirstSection.round(depreciationAmount/firstSection.proceedsPlaned*100);
        costsAmountDivided[2]= FirstSection.round(depreciationAmount/costsAmount*100);
        costPrice100Divided[3]= FirstSection.round(materialContributionsAmount/firstSection.proceedsPlaned*100);
        costsAmountDivided[3]= FirstSection.round(materialContributionsAmount/costsAmount*100);
        costPrice100Divided[4] = FirstSection.round(otherCostsPlaned / firstSection.proceedsPlaned * 100);
        costsAmountDivided[4]= FirstSection.round(otherCostsPlaned/costsAmount*100);


        System.out.println("----------Ответы 3 раздел----------");
        System.out.println("Зон = "+ laborCosts);
        System.out.println("осн = "+ socialContributions);
        System.out.println("А = "+ depreciationAmount);
        System.out.println("МЗ = "+ materialContributionsAmount);
        System.out.println("П = "+ otherCostsPlaned);
        System.out.println("З = "+ costsAmount);
        System.out.print("costPrice100Divided= ");
        for (int i=0;i<costPrice100Divided.length;i++) System.out.print(costPrice100Divided[i]+" ");System.out.println();
        System.out.print("costsAmountDivided= ");
        for (int i=0;i<costsAmountDivided.length;i++) System.out.print(costsAmountDivided[i]+" ");System.out.println();


    }


    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    public void Initialization(String pathname,int variant) throws IOException {
        firstSection = new FirstSection();
        firstSection.Initialization(pathname, variant);
        secondSection = new SecondSection();
        secondSection.Initialization(pathname, variant);
        int k=41;//положение колонки с которой идут цифры в методичке
        FileInputStream inputStream = new FileInputStream(new File(pathname));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        for(int i=0;i<6;i++){
            usefulLife[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
            System.out.println(usefulLife[i]); //проверка данных
            k++;
        }
        numberEmployersCurrentYear = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();k++;
        System.out.println(numberEmployeesPlannedYear);
        plannedIncreaseEmployees =  workbook.getSheetAt(0).getRow(k).getCell(variant+1).getStringCellValue().split(" ");k++;
        plannedReductionEmployees =  workbook.getSheetAt(0).getRow(k).getCell(variant+1).getStringCellValue().split(" ");k++;
        System.out.println( plannedIncreaseEmployees +" 1 " + plannedReductionEmployees);
        averageMonthWagesYear  = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();k++;
        plannedGrowthRateAverageWeages = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();k++;
        System.out.println( averageMonthWagesYear+ "  " + plannedGrowthRateAverageWeages);
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

    private double humansPlanned(double inp){
        double output = inp;

        for (int i=1; i<12; i++) {
            if (plannedIncreaseEmployees[0].equals("o")) {
                output += - Double.parseDouble(plannedReductionEmployees[0]) * secondSection.outputVerify[i];

            }else if (plannedReductionEmployees[0].equals("o")){
                output +=  + Double.parseDouble(plannedIncreaseEmployees[0]) * secondSection.inputVerify[i];

            }
            else {output +=  + Double.parseDouble(plannedIncreaseEmployees[0]) * secondSection.inputVerify[i]- Double.parseDouble(plannedReductionEmployees[0]) * secondSection.outputVerify[i];

            }
            //System.out.println(inputVerify[i]);
            //System.out.println(outputVerify[i]);
        }
    return output;}
}
