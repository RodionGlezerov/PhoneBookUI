package com.telran.phonebook.tests;

import model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.getHeader().isSignOutButtonPresent()) {
            app.getHeader().clickOnLoginLink();
            app.getUser().login();
            Thread.sleep(1000);
            app.getHeader().clickOnAddLink();
            app.getContact().addContact(new Contact()
                    .setName("Robert")
                    .setSurname( "Benz")
                    .setPhone("1234567")
                    .setEmail("rodert@gmail.com")
                    .setAddress("Friedrich")
                    .setDescription("cooker"));
        }
    }

    @Test
    public void removeContactPositiveTest() throws InterruptedException {
        //check size of contact list
        int sizeBefore = app.getContact().sizeOfContacts();
        //remove contact
        app.getContact().removeContact();
        //check size of contact list
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        //compare list before - list after

        Assert.assertEquals(sizeAfter + 1, sizeBefore);
    }

}
