package com.techproed.tests;

import org.testng.annotations.Test;

public class DependsOnMethods {

    @Test
    public void test01() { //sisteme giriş testiniz
        System.out.println("test01");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() { //sisteme giriş yaptıktan sonraki işlemler
        System.out.println("test02");
    }
}
