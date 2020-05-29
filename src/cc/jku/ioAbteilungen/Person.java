package cc.jku.ioAbteilungen;

public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void printPersonName(){
        System.out.println("Name: " + this.name);
    }
}
