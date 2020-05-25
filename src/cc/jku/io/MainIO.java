package cc.jku.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MainIO {
    public static void main(String[] args) {

        File file = new File("./testdata/Text.txt");
        //  ./ vom gleichen Ordner weiter
        //  ../ einen Ordner zurück

        List<Person> people = new ArrayList<>();


        try {
            FileReader fileReader = new FileReader(file);

            /*
            int charValue;
            while ((charValue = fileReader.read()) != -1) {
                System.out.println(Character.toString(charValue));
            }
            */

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                System.out.println(line);
                String[] lineArray = line.split(";");

                for (int i = 0; i < lineArray.length; i++) {
                    System.out.println("Line Array Value: " + lineArray[i]);
                }

                Person person = new Person(lineArray[0], lineArray[1], lineArray[2]);
                people.add(person);

            }

            for (Person person : people) {
                System.out.println(person.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
