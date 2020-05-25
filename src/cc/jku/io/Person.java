package cc.jku.io;

public class Person {
    private String firstName;
    private String secondName;
    private String city;

    public Person(String firstName, String secondName, String city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;

    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
