package cc.jku.ioAbteilungen2;

import cc.jku.ioAbteilungen.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainIOAbteilungen2 {
    public static void main(String[] args) {
        /*
        Aufgabe java.io Abteilungen 1
        -----------------------------
        Wir nehmen die vorherige Aufgabe mit den Abteilungen her und erzeugen nun die Abteilungen nicht mehr händisch
        sondern auch via java.io
        Die Textdatei wurde erweitert um eine “Parent” - Abteilung, das heißt wir ordnen nun nicht nur mehr Personen
        einer Abteilung zu, sondern bauen auch einen Abteilungsbaum und ordnen Abteilungen untereinander zu.
         */

        List<Department2> departments = new ArrayList<>();

        String name;
        String departmentName;
        String parentDepartmentName;
        String[] strings = new String[3];

        File file = new File("./testdata/Abteilungen1 (2).txt");

        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String readLine = null;

            while ((readLine = bufferedReader.readLine()) != null) {
                //System.out.println("string in line: " + readLine); // zum Testen

                strings = readLine.split(";");

                for (int i = 0; i < strings.length; i++) {
                    strings[i] = strings[i].strip();
                   //System.out.println("." + strings[i] + "."); // zum Testen
                }

                if (strings.length > 0) {
                    name = strings[0];
                } else {
                    name = "";
                }

                if (strings.length > 1) {
                    departmentName = strings[1];
                } else {
                    departmentName = "";
                }

                if (strings.length > 2) {
                    parentDepartmentName = strings[2];
                } else {
                    parentDepartmentName = "";
                }

                if (!name.equalsIgnoreCase("PersonenName")) {

                    Person person = new Person(name);
                    boolean departmentExists = false;

                    for (Department2 parentDepartment : departments) {

                        if (parentDepartment.getName().equalsIgnoreCase(departmentName)) {
                            // Persone einer Bestehenden Abteilung zuordnen.
                            departmentExists = true;
                            parentDepartment.addPerson(person);
                            break;
                        }

                    }

                    if (!departmentExists) {
                        // Person einer neuen Abteilung zuordnen.

                        Department2 newDepartment = new Department2(departmentName);
                        departments.add(newDepartment);
                        newDepartment.addPerson(person);

                        if (!parentDepartmentName.equalsIgnoreCase("")) {
                            // Department dem Parent Department zuordnen.

                            for (Department2 department : departments) {

                                if (department.getName().equalsIgnoreCase(parentDepartmentName)) {
                                    department.addChildDepartment(newDepartment);
                                }

                            }

                        }

                    }

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        departments.get(0).printAllMembers();

    }
}
