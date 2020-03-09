package cc.jku.OOVersuch;

public class RoofType {

    private String name;


    public RoofType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "RoofType{" +
                "name='" + name + '\'' +
                '}';
    }
}
