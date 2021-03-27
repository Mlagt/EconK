package com.company;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SecondSection {
    //переменные из методички

    //Переменные второго раздела
    double fixedAssetsPlaned=0;
    double[] fixedAssetsDividedCurrent = new double[6];
    double[] fixedAssetsDividedPlanned = new double[6];
    double[] fixedAssetsDividedPlannedYear = new double[6];
    double[] fixedAssetsMonth = new double[11];
    int[] inputVerify = new int[12];
    int[] outputVerify = new int[12];
    String[][] fixedAssetsInput = new String[6][5];
    String[][] fixedAssetsOutput = new String[6][4];

    public void Initialization(String pathname,int variant) throws IOException {

        int k = 20;//положение колонки с которой идут цифры в методичке
        FileInputStream inputStream = new FileInputStream(new File(pathname));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        for (int i = 0; i < 6; i++) {
             fixedAssetsDividedCurrent[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getNumericCellValue();
            System.out.println(fixedAssetsDividedCurrent[i]);
            k++;
        }
        k++;
        for (int i = 0; i < 6; i++) {
            fixedAssetsInput[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getStringCellValue().split(" ");
            System.out.println(fixedAssetsInput[i][0]);
            k++;
        }
        k++;
        for (int i = 0; i < 6; i++) {
            fixedAssetsOutput[i] = workbook.getSheetAt(0).getRow(k).getCell(variant+1).getStringCellValue().split(" ");
            System.out.println(fixedAssetsOutput[i][0]);
            k++;
        }
        for (int i = 0; i<6; i++){
            for (int o =0; o<12; o++){
                inputVerify[o] = 0;
                outputVerify[o] = 0;
            }
            if (fixedAssetsInput[i][0].equals("o") && fixedAssetsOutput[i][0].equals("o")){
                fixedAssetsDividedPlanned[i] = fixedAssetsDividedCurrent[i];
            }else{if (fixedAssetsInput[i][0].equals("o")){
                switchInput(i, fixedAssetsOutput, outputVerify);
                fixedAssetsDividedPlannedYear[i] = fixedAssetsDividedCurrent[i] - Double.parseDouble(fixedAssetsOutput[i][0]);
            }else if (fixedAssetsOutput[i][0].equals("o")){
                switchInput(i, fixedAssetsInput, inputVerify);
                fixedAssetsDividedPlannedYear[i] = fixedAssetsDividedCurrent[i] + Double.parseDouble(fixedAssetsInput[i][0]);
            }else{
                switchInput(i, fixedAssetsOutput, outputVerify);
                switchInput(i, fixedAssetsInput, inputVerify);
                fixedAssetsDividedPlannedYear[i] = fixedAssetsDividedCurrent[i] + Double.parseDouble(fixedAssetsInput[i][0])-Double.parseDouble(fixedAssetsOutput[i][0]);}

                    fixedAssetsDividedPlanned[i] = ((2920+2817/*fixedAssetsDividedCurrent[i]+fixedAssetsDividedPlannedYear[i]*/)/2 +
                           fixedAssets(i, 2920/*fixedAssetsDividedCurrent[i]*/))/12;

                }

            fixedAssetsPlaned += fixedAssetsDividedPlanned[i];
            System.out.println(fixedAssetsDividedPlanned[i]);
            System.out.println(fixedAssetsDividedPlannedYear[i]);
        }
        System.out.println(fixedAssetsPlaned);
    }

    private void switchInput(int i, String[][] fixedAssetsInput, int[] inputVerify) {
        switch (fixedAssetsInput[i][2]){
           case  "1":
            case "марта":
            case "феврале":
                inputVerify[2] = 1;
               break;
           case "2":
            case "июня":
            case "мае":
                inputVerify[5] = 1;
               break;
           case "3":
            case "сентября":
            case "августе":
                inputVerify[8] =1;
               break;
           case "4":
            case "декабря":
            case "ноябре":
                inputVerify[11] = 1;
               break;
            case "февраля":
               inputVerify[1] = 1;
               break;
           case "марте":
            case "апреля":
                inputVerify[3] = 1;
               break;
            case "апреле":
            case "мая":
                inputVerify[4] = 1;
               break;
            case "июне":
            case "июля":
                inputVerify[6] = 1;
               break;
            case "июле":
            case "августа":
                inputVerify[7] = 1;
               break;
            case "сентябре":
            case "октября":
                inputVerify[9] = 1;
               break;
            case "октябре":
            case "ноября":
                inputVerify[10] = 1;
               break;
        }
    }


    public double fixedAssets( int o, double inp){
    double output = inp;
    for (int i=2; i<12; i++) {
        if (fixedAssetsInput[o][0].equals("o")) {
            output += inp - 103 * outputVerify[i];
        }else if (fixedAssetsOutput[o][0].equals("o")){
        output +=inp + Double.parseDouble(fixedAssetsInput[o][0]) * inputVerify[i];
            }

        else {output += inp+ Double.parseDouble(fixedAssetsInput[o][0]) * inputVerify[i]- Double.parseDouble(fixedAssetsOutput[o][0]) * outputVerify[i];
            }
        System.out.println(inputVerify[i]);
        System.out.println(outputVerify[i]);
    }

    return output;
}} //метод подсчета ОС по месяцам НЕ РАБОАЕТ