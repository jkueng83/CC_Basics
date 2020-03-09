package cc.jku.OOVersuch;

public class Room {
    private String name;
    private double length;
    private double width;

    public Room(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public double getArea(){
        return length * width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
