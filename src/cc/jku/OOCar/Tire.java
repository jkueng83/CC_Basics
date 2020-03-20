package cc.jku.OOCar;

public class Tire {
    // Reifen
    // 192/65 R 15 91 H
    // 192 Reifenbreite in mm
    // 65 Breiten Höhenverhöltins in %
    // R radial; D diagonal Reifen
    // 15 Felgendurchmesser in Zoll
    // 91 Tragfähigkeit 91=615 kg
    // H Geschwindigkeit H=210km/h

    private int width ; // Breite
    private int height ; // Höhe in Prozent
    private String typ ; // R radial, D diagonal
    private int  rimDiameter ; // Felgendurchmesser
    private int maxLoadNumber; // Tragfähigkeit
    private String speedType ; // Geschwindgkeits Type H=210km/h

    public Tire(int width, int height, String typ, int rimDiameter, int maxLoadNumber, String speedType) {
        this.width = width;
        this.height = height;
        this.typ = typ;
        this.rimDiameter = rimDiameter;
        this.maxLoadNumber = maxLoadNumber;
        this.speedType = speedType;
    }

    public String getTireTyp (){
        // 192/65 R 15 91 H
        String tireType =  this.width + "/" + this.height + " " + this.typ + " " + this.rimDiameter + " "
                + this.speedType + " " + this.maxLoadNumber;

        return tireType ;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getRimDiameter() {
        return rimDiameter;
    }

    public void setRimDiameter(int rimDiameter) {
        this.rimDiameter = rimDiameter;
    }

    public int getMaxLoadNumber() {
        return maxLoadNumber;
    }

    public void setMaxLoadNumber(int maxLoadNumber) {
        this.maxLoadNumber = maxLoadNumber;
    }

    public String getSpeedType() {
        return speedType;
    }

    public void setSpeedType(String speedType) {
        this.speedType = speedType;
    }
}
