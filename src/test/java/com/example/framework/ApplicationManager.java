package com.example.framework;

import com.example.framework.MainPageHelper;
import com.example.framework.MarketHeaderHelper;
import com.example.framework.MarketItemHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    MainPageHelper mainPage;
    MarketHeaderHelper marketHeader;
    MarketItemHelper marketItem;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://yandex.ru/");

        mainPage = new MainPageHelper(wd);
        marketHeader = new MarketHeaderHelper(wd);
        marketItem = new MarketItemHelper(wd);
    }

    public MainPageHelper getMainPage() {
        return mainPage;
    }

    public MarketHeaderHelper getMarketHeader() {
        return marketHeader;
    }

    public MarketItemHelper getMarketItem() {
        return marketItem;
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public void stop() {
        wd.quit();
    }
}
