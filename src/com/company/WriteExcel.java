package com.company;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    public static void main(String[] args) throws IOException {
        Workbook wb = new XSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("E:\\project\\demo.xlsx");

        Sheet sheet = wb.createSheet("Издатели");
        Row row = sheet.createRow(3);
        Cell cell = row.createCell(4);
        cell.setCellValue("Hello world");

        wb.write(fileOut);
        fileOut.close();
    }
}