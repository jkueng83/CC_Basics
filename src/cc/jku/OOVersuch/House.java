package cc.jku.OOVersuch;

import java.util.ArrayList;

//public  enum ROOF_TYPE {ZIEGELDACH, FLACHDACH, ALUDACH, SCHINDELDACH} ;
public class House {

    private RoofType roofType;
    private int numberOfWindows;
    private int numberOfDoors;
    private ArrayList<Room> rooms;
    private String color;


    public House(RoofType roofType, int numberOfWindows, int numberOfDoors, String color) {
        this.roofType = roofType;
        this.numberOfWindows = numberOfWindows;
        this.numberOfDoors = numberOfDoors;
        this.rooms = new ArrayList<Room>();
        this.color = color;
    }

    public double getSumOfRooms() {
        double sum = 0;

        // Beide Schleifen liefern das gleiche Ergebnis

        // foreach Schleife
        /*
        for (Room room : this.rooms) {
            sum += room.getArea();
        }
        */

        // for i Schleife wie gehabt
        for (int i = 0; i < this.rooms.size(); i++) {
            sum += this.rooms.get(i).getArea();
        }

        return sum;
    }

    public String getRoomsNames() {
        String roomsNames = "";
        for (Room room : this.rooms) {
            roomsNames += room.getName();
            roomsNames += ";";
        }
        return roomsNames;

    }

    public String getNameOfRoomN(int numberOfRoom) {
        return this.rooms.get(numberOfRoom).getName();// this.rooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public RoofType getRoofType() {
        return roofType;
    }

    public void setRoofType(RoofType roofType) {
        this.roofType = roofType;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        if (numberOfWindows < 0) {
            return;
        }
        this.numberOfWindows = numberOfWindows;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
