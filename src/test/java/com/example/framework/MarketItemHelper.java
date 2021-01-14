package com.example.framework;

import com.example.model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class MarketItemHelper extends HelperBase {

    public MarketItemHelper(WebDriver wd) {
        super(wd);
    }

    public void filterItem(Item item) {
        click(By.cssSelector("[href*='/catalog--" + item.getItemType() + "']"));
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.END).build().perform();
        type(By.cssSelector("#glpricefrom"), item.getPriceFrom());
        type(By.cssSelector("#glpriceto"), item.getPriceTo());
        click(By.xpath("//*[text()='" + item.getBrand() + "']"));
    }

    public void switchToNextTab() {
        List<String> avialableTabs = new ArrayList<>(wd.getWindowHandles());
        if (!avialableTabs.isEmpty()) {
            wd.switchTo().window(avialableTabs.get(1));
        }
    }
    public String getItemNameFromListByOrder(int number) {
        return wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][" + number + "]//h3")).getText();
    }
}
