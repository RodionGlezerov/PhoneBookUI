package com.telran.phonebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        //precondition: user should be logged out
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();

        } else {
            driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        }
    }

    @Test
    public void loginAccountPositiveTest () throws InterruptedException {
        //assert is registration from dispalayed
        Assert.assertTrue(isElementPresent(By.cssSelector(".login_login__3EHKB")));

        //fill registration form
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("Man@gmail.com");
        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Aa123456789~");
        //click on Login button
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
        //verify Sign Out button displayed
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[href='/home']")).click();
        driver.findElement(By.cssSelector("[href='/about']")).click();
        driver.findElement(By.cssSelector("[href='/contacts']")).click();
        driver.findElement(By.cssSelector("[href='/add']")).click();
        driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        
    }


    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(driver, 20).until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }
}
