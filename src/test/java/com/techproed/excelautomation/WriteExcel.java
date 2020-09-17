package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void test() throws IOException {
        String pathExcelFile = "src\\test\\resources\\ULKELER.xlsx";
        FileInputStream fileInputStream = new FileInputStream(pathExcelFile);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Dosyaya yeni bir bilgi ekleyebilmek için
        FileOutputStream fileOutputStream = new FileOutputStream(pathExcelFile);

        //Yeni hücreler oluşturduk ve içerisine veri ekledik.
        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NÜFUS");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("83 Milyon");

        //İstediğimiz satırı tamamıyla silmek için bu kodu kullanıyoruz.
        Row onuncuSatir = workbook.getSheetAt(0).getRow(10);
        workbook.getSheetAt(0).removeRow(onuncuSatir);

        //istediğimiz hücreyi silmek için bu kodu kullanırız.
        Cell almanyaNufus = workbook.getSheetAt(0).getRow(1).getCell(3);
        workbook.getSheetAt(0).getRow(1).removeCell(almanyaNufus);

        //yaptığınız değişikleri excel dosyasına uygular ve kaydeder.
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();




    }
}
