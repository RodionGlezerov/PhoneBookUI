package com.telran.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class HomePage extends TestBase {

    @Test
    public void openHomePage() {
        System.out.println("Home Component: " + isHomeComponentPresent2());
        isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));

    }

    public boolean isHomeComponentPresent2() {
        try {
            driver.findElements(By.xpath("//div[@id='root']/div[2]/div/div"));
            return true;
        } catch (NoSuchElementException ex) {
        }
        return false;
    }


}
