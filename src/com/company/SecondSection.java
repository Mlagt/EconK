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
                switch (fixedAssetsOutput[i][2]){
                    case  "1":
                        outputVerify[2] = 1;
                    case "2":
                        outputVerify[5] = 1;
                    case "3":
                        outputVerify[8] =1;
                    case "4":
                        outputVerify[11] = 1;
                    case "феврале":
                        outputVerify[2] = 1;
                    case "февраля":
                        outputVerify[1] = 1;
                    case "марте":
                        outputVerify[3] = 1;
                    case "марта":
                        outputVerify[2] = 1;
                    case "апреле":
                        outputVerify[4] = 1;
                    case "апреля":
                        outputVerify[3] = 1;
                    case "мае":
                        outputVerify[5] = 1;
                    case "мая":
                        outputVerify[4] = 1;
                    case "июне":
                        outputVerify[6] = 1;
                    case "июня":
                        outputVerify[5] = 1;
                    case "июле":
                        outputVerify[7] = 1;
                    case "июля":
                        outputVerify[6] = 1;
                    case "августе":
                        outputVerify[8] = 1;
                    case "августа":
                        outputVerify[7] = 1;
                    case "сентябре":
                        outputVerify[9] = 1;
                    case "сентября":
                        outputVerify[8] = 1;
                    case "октябре":
                        outputVerify[10] = 1;
                    case "октября":
                        outputVerify[9] = 1;
                    case "ноябре":
                        outputVerify[11] = 1;
                    case "ноября":
                        outputVerify[10] = 1;
                    case "декабре":
                        outputVerify[11] = 1;
                    case "декабря":
                        outputVerify[10] = 1;

                }
                fixedAssetsDividedPlannedYear[i] = fixedAssetsDividedCurrent[i] - Double.parseDouble(fixedAssetsOutput[i][0]);
            }else if (fixedAssetsOutput[i][0].equals("o")){
                switch (fixedAssetsInput[i][2]){
                    case  "1":
                        inputVerify[2] = 1;
                    case "2":
                        inputVerify[5] = 1;
                    case "3":
                        inputVerify[8] =1;
                    case "4":
                        inputVerify[11] = 1;
                    case "феврале":
                        inputVerify[2] = 1;
                    case "февраля":
                        inputVerify[1] = 1;
                    case "марте":
                        inputVerify[3] = 1;
                    case "марта":
                        inputVerify[2] = 1;
                    case "апреле":
                        inputVerify[4] = 1;
                    case "апреля":
                        inputVerify[3] = 1;
                    case "мае":
                        inputVerify[5] = 1;
                    case "мая":
                        inputVerify[4] = 1;
                    case "июне":
                        inputVerify[6] = 1;
                    case "июня":
                        inputVerify[5] = 1;
                    case "июле":
                        inputVerify[7] = 1;
                    case "июля":
                        inputVerify[6] = 1;
                    case "августе":
                        inputVerify[8] = 1;
                    case "августа":
                        inputVerify[7] = 1;
                    case "сентябре":
                        inputVerify[9] = 1;
                    case "сентября":
                        inputVerify[8] = 1;
                    case "октябре":
                        inputVerify[10] = 1;
                    case "октября":
                        inputVerify[9] = 1;
                    case "ноябре":
                        inputVerify[11] = 1;
                    case "ноября":
                        inputVerify[10] = 1;
                    case "декабре":
                        inputVerify[11] = 1;
                    case "декабря":
                        inputVerify[10] = 1;

                }
                fixedAssetsDividedPlannedYear[i] = fixedAssetsDividedCurrent[i] + Double.parseDouble(fixedAssetsInput[i][0]);
            }else{
                    switch (fixedAssetsOutput[i][2]){
                        case  "1":
                            outputVerify[2] = 1;
                        case "2":
                            outputVerify[5] = 1;
                        case "3":
                            outputVerify[8] =1;
                        case "4":
                            outputVerify[11] = 1;
                        case "феврале":
                            outputVerify[2] = 1;
                        case "февраля":
                            outputVerify[1] = 1;
                        case "марте":
                            outputVerify[3] = 1;
                        case "марта":
                            outputVerify[2] = 1;
                        case "апреле":
                            outputVerify[4] = 1;
                        case "апреля":
                            outputVerify[3] = 1;
                        case "мае":
                            outputVerify[5] = 1;
                        case "мая":
                            outputVerify[4] = 1;
                        case "июне":
                            outputVerify[6] = 1;
                        case "июня":
                            outputVerify[5] = 1;
                        case "июле":
                            outputVerify[7] = 1;
                        case "июля":
                            outputVerify[6] = 1;
                        case "августе":
                            outputVerify[8] = 1;
                        case "августа":
                            outputVerify[7] = 1;
                        case "сентябре":
                            outputVerify[9] = 1;
                        case "сентября":
                            outputVerify[8] = 1;
                        case "октябре":
                            outputVerify[10] = 1;
                        case "октября":
                            outputVerify[9] = 1;
                        case "ноябре":
                            outputVerify[11] = 1;
                        case "ноября":
                            outputVerify[10] = 1;
                        case "декабре":
                            outputVerify[11] = 1;
                        case "декабря":
                            outputVerify[10] = 1;

                    }
                 switch (fixedAssetsInput[i][2]){
                    case  "1":
                        inputVerify[2] = 1;
                    case "2":
                        inputVerify[5] = 1;
                    case "3":
                        inputVerify[8] =1;
                    case "4":
                        inputVerify[11] = 1;
                    case "феврале":
                        inputVerify[2] = 1;
                    case "февраля":
                        inputVerify[1] = 1;
                    case "марте":
                        inputVerify[3] = 1;
                    case "марта":
                        inputVerify[2] = 1;
                    case "апреле":
                        inputVerify[4] = 1;
                    case "апреля":
                        inputVerify[3] = 1;
                    case "мае":
                        inputVerify[5] = 1;
                    case "мая":
                        inputVerify[4] = 1;
                    case "июне":
                        inputVerify[6] = 1;
                    case "июня":
                        inputVerify[5] = 1;
                    case "июле":
                        inputVerify[7] = 1;
                    case "июля":
                        inputVerify[6] = 1;
                    case "августе":
                        inputVerify[8] = 1;
                    case "августа":
                        inputVerify[7] = 1;
                    case "сентябре":
                        inputVerify[9] = 1;
                    case "сентября":
                        inputVerify[8] = 1;
                    case "октябре":
                        inputVerify[10] = 1;
                    case "октября":
                        inputVerify[9] = 1;
                    case "ноябре":
                        inputVerify[11] = 1;
                    case "ноября":
                        inputVerify[10] = 1;
                    case "декабре":
                        inputVerify[11] = 1;
                    case "декабря":
                        inputVerify[10] = 1;

                }
                fixedAssetsDividedPlannedYear[i] = fixedAssetsDividedCurrent[i] + Double.parseDouble(fixedAssetsInput[i][0])-Double.parseDouble(fixedAssetsOutput[i][0]);}

                    fixedAssetsDividedPlanned[i] = ((2920+2817/*fixedAssetsDividedCurrent[i]+fixedAssetsDividedPlannedYear[i]*/)/2 +
                           fixedAssets(i, 2920/*fixedAssetsDividedCurrent[i]*/))/12;

                }

            fixedAssetsPlaned += fixedAssetsDividedPlanned[i];
            System.out.println(fixedAssetsDividedPlanned[i]);
        }
        System.out.println(fixedAssetsPlaned);
    }


public double fixedAssets( int o, double inp){
    double output = inp;
    for (int i=1; i<12; i++) {
        if (!(fixedAssetsInput[o][0].equals("o") || fixedAssetsOutput[o][0].equals("o"))){
        output +=inp - 103 * outputVerify[i];
        output +=inp + Double.parseDouble(fixedAssetsInput[o][0]) * inputVerify[i];}
        else output += inp;
    }
    return output;
}}