package org.example.pages;

import org.example.models.Item;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    By searchIcon = By.xpath("//summary[@aria-label='Search']//span");
    By searchBar = By.id("Search-In-Modal");
    By searchIcon2 = By.xpath("//button[@class='search__button field__button']");
    By searchResults = By.xpath("//li[@class='grid__item']//a");
    //By productName = By.cssSelector(".predictive-search_item-heading");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage search(String searchItem) {
        //webDriver.findElement(searchIcon).click();
        actions.click(searchIcon);
        //webDriver.findElement(searchBar).sendKeys(searchItem);
        actions.type(searchBar,searchItem);
        //webDriver.findElement(searchIcon2).click();
        actions.click(searchIcon2);
        return this;
    }

    public List<Item> getSearchItems() {
        List<WebElement> elements = waits.waitUntilAllElementsAreVisible(searchResults);
        List<Item> items = new ArrayList<>();
        for (WebElement element : elements) {
            //String name = element.getText().trim();
            String name = actions.getText(element);
            Item item = new Item();
            item.setName(name);
            items.add(item);
        }
        return items;
    }
}