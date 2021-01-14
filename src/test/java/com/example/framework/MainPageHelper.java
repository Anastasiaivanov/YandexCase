package com.example.framework;

import com.example.framework.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageHelper extends HelperBase {

    public MainPageHelper(WebDriver wd){
        super(wd);
    }

    public void goToMarket(By locator) {
        click(locator);
    }
}
