package com.example.tests;

import com.example.model.Item;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {
    /*Открыть браузер и развернуть на весь экран.
                Зайти на yandex.ru.
                Перейти на Яндекс Маркет
        Выбрать раздел  Компьютеры
        Выбрать раздел Планшеты
        Зайти в расширенный поиск
        Задать параметр поиска от 20000 до 35000 рублей.
                Выбрать производителя “Apple”
        Применить условия поиска
        Запомнить второй элемент в результатах поиска
        В поисковую строку ввести запомненное значение.
        Найти и проверить, что наименование товара соответствует запомненному значению.
*/

    @Test
    public void testItem() throws InterruptedException {
        app.getMainPage().goToMarket(By.cssSelector("[data-id='market']"));

        app.getMarketItem().switchToNextTab();

        app.getMarketHeader().selectComputersDepartment(By.cssSelector("[href*='/catalog--kompiuternaia-tekhnika']"));

        app.getMarketItem().filterItem(new Item().setItemType("planshety")
                .setPriceFrom("20000").setPriceTo("35000")
                .setBrand("Apple"));

        app.getMainPage().pause(4000);
        String item = app.getMarketItem().getItemNameFromListByOrder(2);
        System.out.println(item);

        String itemName = app.getMarketItem().getItemNameFromListByOrder(2);
        app.getMarketHeader().searchItemFromSearchBox(itemName);
        app.getMainPage().pause(4000);
        String foundItemName = app.getMarketItem().getItemNameFromListByOrder(1);

        Assert.assertEquals(foundItemName,itemName);
    }
}
