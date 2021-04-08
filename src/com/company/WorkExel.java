package com.company;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class WorkExel {

    public double[] number = new double[63];
    int i=0;


    public void CreatExel(String sheetText,int rowParametr,int cellParametr,double[] cellValue) throws IOException {
        Workbook wb = new XSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("D:\\Java\\File\\AnswerWorkbook.xlsx");

        Sheet sheet = wb.createSheet(sheetText);
        Row row = sheet.createRow(rowParametr-1);
        Cell cell = row.createCell(cellParametr-1);
        for (int i=0;i<cellValue.length;i++){
            cell.setCellValue(cellValue[i]);
            cellParametr++;
            cell = row.createCell(cellParametr-1);
        }
        wb.write(fileOut);
        fileOut.close();
    }
}

