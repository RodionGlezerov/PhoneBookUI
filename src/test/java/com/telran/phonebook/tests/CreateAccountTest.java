package com.telran.phonebook.tests;

import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {


    //click on LOGIN link
    @BeforeMethod
    public void ensurePreconditions() {
        //precondition: user should be logged out
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getHeader().clickOnLoginLink();
        }
    }

    //test
    @Test
    public void createAccountPositiveTest() throws InterruptedException {

        //assert is registration from dispalayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        int i = (int) (((System.currentTimeMillis()) / 1000) % 3600);
        //fill registration form
        app.getUser().fillLoginRegistrationForm(new User().setEmail("rodert" + i + "@gmail.com").setPassword("Aa123456789~"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //verify Sign Out button displayed
        app.getUser().pause(1000);
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());

    }


    @Test
    public void createAccountNegativeTestWithoutPassword() {
        //assert is registration from dispalayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        //fill registration form
        app.getUser().fillLoginRegistrationForm(new User().setEmail("Man@gmail.com"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //verify Sign Out button displayed
        //Thread.sleep(1000);
        Assert.assertTrue(app.getUser().isAlertPresent());
        Assert.assertTrue(app.getUser().isErrorMessagePresent());

    }
    @Test
    public void createAccountNegativeTestWithInvalidPassword() {
        //assert is registration from dispalayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());

        //fill registration form
        app.getUser().fillLoginRegistrationForm(new User().setEmail("Man@gmail.com").setPassword("Aa123456789"));
        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        //verify Sign Out button displayed
        //Thread.sleep(1000);
        Assert.assertTrue(app.getUser().isAlertPresent());
        Assert.assertTrue(app.getUser().isErrorMessagePresent());

    }

}

