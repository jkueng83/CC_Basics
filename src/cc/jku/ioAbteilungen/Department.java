package cc.jku.ioAbteilungen;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;

    List<Person> people;

    public Department(String name) {
        this.name = name;
        this.people = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public void printMembers() {
        System.out.println("Members of the department \"" + this.name + "\":");
        for (Person person : this.people) {
            person.printPersonName();
        }
    }


}
