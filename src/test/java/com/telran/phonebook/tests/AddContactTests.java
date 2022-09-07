package com.telran.phonebook.tests;

import model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviders;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {
    @DataProvider
    public Iterator<Object[]> newContact(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Robert","Schwarz","79853423","rod@gmail.com","Barcelona","Engeenier"});
        list.add(new Object[]{"Robert1","Schwarz1","79854553","rod1@gmail.com","Barcelona","Engeenier"});
        list.add(new Object[]{"Robert2","Schwarz2","643853423","rod2@gmail.com","Barcelona","Engeenier"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>newContactWithCSV() throws IOException {
        List<Object[]>list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Contacts.csv")));
        String line = reader.readLine();

        while (line !=  null) {


            String[] split = line.split(",");

            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setSurname(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])});
            line = reader.readLine();
        }

            return list.iterator();

    }

    @BeforeMethod
    public void ensurePreconditions(){
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

    @Test (dataProvider = "newContact",dataProviderClass = DataProviders.class, enabled = false)
    public void addContactPositiveTestFromDataProvider(String name, String sName, String phone, String email, String add, String desc) {
        app.getContact().addContact(new Contact()
                .setName(name)
                .setSurname(sName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(add)
                .setDescription(desc));
       app.getContact().removeContact();
    }

    @Test (dataProvider = "newContactWithCSV",dataProviderClass = DataProviders.class, enabled = false)
    public void addContactPositiveTestFromDataProviderWithCsvFile(Contact contact) {
        app.getContact().addContact(contact);
        logger.info(String.valueOf(app.getContact().isContactCreated(contact.getName())));
        app.getContact().removeContact();
        app.getUser().pause(1000);

    }


}



