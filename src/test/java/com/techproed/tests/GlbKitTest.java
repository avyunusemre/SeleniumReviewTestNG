package com.techproed.tests;

import com.techproed.pages.GlbKitPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class GlbKitTest {

    @Test
    public void test() {

        Driver.getDriver().get(ConfigurationReader.getProperty("glb_homeGarden"));
        GlbKitPage glbKitPage = new GlbKitPage();
        glbKitPage.bardakLink.click();

        System.out.println("ürün adı : " + glbKitPage.baslik.getText());
        System.out.println("fiyat : " + glbKitPage.fiyat.getText());
        System.out.println("açıklama : " + glbKitPage.aciklama.getText());



    }
}
