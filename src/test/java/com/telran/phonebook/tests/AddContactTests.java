package com.telran.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        //ensure Sign Out button doesn't displayed
        if (!app.getHeader().isSignOutButtonPresent()) {
            //click on loggin link
            app.getHeader().clickOnLoginLink();
            //login
            app.getUser().login();
            //click on the link Add
            app.getHeader().clickOnAddLink();
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) (((System.currentTimeMillis()) / 1000) % 3600);
        //fill contact form
        app.getContact().addRandomContact(i);
        //asset
        Assert.assertTrue(app.getContact().isContactCreated("Robert" + i));
    }


}



