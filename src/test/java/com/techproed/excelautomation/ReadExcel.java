package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test() throws IOException {
        String pathExcelFile = "src\\test\\resources\\ULKELER.xlsx";
        //Java'da herhangi bir dosyanın açılabilmesi için FileInputStream class'ından
        //bir nesne olusturulur ve parametre olarak açılmak istenen dosyanın adresi
        //gönderilir.
        FileInputStream fileInputStream = new FileInputStream(pathExcelFile);


        //Excel dosyasını okumak için Workbook kullanıyoruz.
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //Excel = Workbook
        //Sayfa = Sheet
        //Satır = Row
        //Hücre = Cell

        //SAYFA(sheet) SEÇİMİ
        Sheet sayfa1 = workbook.getSheetAt(0);

        //SATIR(row) SEÇİMİ
        Row satır1 = sayfa1.getRow(0);

        //HÜCRE (cell) SEÇİMİ
        Cell satır1hucre1 = satır1.getCell(0);

        System.out.println(satır1hucre1);

        System.out.println(sayfa1.getRow(2).getCell(1));

        //Tablodaki son satırın index'ini alalım
        int sonSatir = workbook.getSheetAt(0).getLastRowNum();

        //TÜM BAŞKENTLER SÜTUNUNU EKRANA YAZDIRDIK
        for (int i = 0; i <= sonSatir; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }

        //TÜM BAŞKENTLER SÜTUNUNU EKRANA YAZDIRDIK
        for (int j = 0; j <= sonSatir; j++) {
            System.out.println(workbook.getSheetAt(0).getRow(j).getCell(1));
        }

        int sonSutun = workbook.getSheetAt(0).getRow(3).getLastCellNum();

        //BELİRLİ BİR SATIRDAKİ TUM HÜCRELERİ YAZDIRMA
        for(int k = 0; k < sonSutun; k++) {
            System.out.print(workbook.getSheetAt(0).getRow(3).getCell(k) + " ");
        }

        // Excel dosyasını kapatmak için bu kodları kullanabiliriz.
        workbook.close();
        fileInputStream.close();


    }
}
