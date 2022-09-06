package com.telran.phonebook.tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        //precondition: user should be logged out
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getHeader().clickOnLoginLink();
        }
    }


    @Test
    public void loginPositiveTest() throws InterruptedException {
        //fill login form
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegistrationForm(new User().setEmail("Man@gmail.com").setPassword( "Aa123456789~"));
        app.getUser().clickOnLoginButton();
        //assert user logged in
        app.getUser().pause(3000);
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }



}
