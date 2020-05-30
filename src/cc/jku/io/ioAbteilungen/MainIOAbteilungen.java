package cc.jku.io.ioAbteilungen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MainIOAbteilungen {
    public static void main(String[] args) {

        Department vorstand = new Department("Vorstand");
        Department einkauf = new Department("Einkauf");
        Department einkaufEuropa = new Department("Einkauf Europa");
        Department einkaufItalien = new Department("Einkauf Italien");
        Department einkaufAmerika = new Department("Einkauf USA");
        Department vertrieb = new Department("Vertrieb");
        Department vertriebEuopa = new Department("Vertrieb Europa");

        List<Department> departments = new ArrayList<>();

        departments.add(vorstand);
        departments.add(einkauf);
        departments.add(einkaufEuropa);
        departments.add(einkaufItalien);
        departments.add(einkaufAmerika);
        departments.add(vertrieb);
        departments.add(vertriebEuopa);

        File file = new File("./testdata/Abteilungen.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {

                String[] lineValue = line.split(";");

                for (int i = 0; i < lineValue.length ; i++) {
                    lineValue[i]= lineValue[i].strip();

                }

                if (lineValue[0] != "PersonenName") {

                    Person person = new Person(lineValue[0]);

                    for (Department department : departments) {

                        if (department.getName().equalsIgnoreCase(lineValue[1])) {
                            department.addPerson(person);
                        }

                    }

                }

            }

        } catch (Exception ex) {
            System.out.println("Fehler beim öffnen der Datei!");
        }

        for (Department department : departments) {
            department.printMembers();

        }


    }
}
