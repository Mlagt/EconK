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

    public void ReadExel(String pathname) throws IOException {

        // Read XSL file
        FileInputStream inputStream = new FileInputStream(new File(pathname));

        // Get the workbook instance for XLS file
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // Get first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        // XSSFRow row = sheet.getRow(2);
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();
        //HSSW

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // Change to getCellType() if using POI 4.x
                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case _NONE:
                        System.out.print("");
                        System.out.print("\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        System.out.print("\t");
                        break;
                    case FORMULA:
                        // Formula
                        System.out.print(cell.getCellFormula());
                        System.out.print("\t");
                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                        // Print out value evaluated by formula
                        System.out.print(evaluator.evaluate(cell).getNumberValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        System.out.print("\t");
                        number[i]=cell.getNumericCellValue();
                        i++;
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        System.out.print("\t");
                        break;
                    case ERROR:
                        System.out.print("!");
                        System.out.print("\t");
                        break;
                }

            }
            System.out.println("");
        }
    }
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

