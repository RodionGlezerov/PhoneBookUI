package utils;

import model.Contact;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
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

}
