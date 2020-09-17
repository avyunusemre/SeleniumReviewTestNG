package com.techproed.tests;

import com.techproed.pages.GlbPantsPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GlbPantsTest {

    @Test (groups = "glbtest")
    public  void test() {
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_pants"));

        GlbPantsPage glbPantsPage = new GlbPantsPage();
        for (WebElement w : glbPantsPage.pants) {
            System.out.println(w.getText());
        }
    }
}
