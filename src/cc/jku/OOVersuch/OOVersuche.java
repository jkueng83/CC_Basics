package cc.jku.OOVersuch;

public class OOVersuche {
    public static void main(String[] args) {

        RoofType rt1 = new RoofType("Ziegeldach");
        Room r1 = new Room("room 1", 10, 10);
        Room r2 = new Room("room 2", 5, 5);
        Room r3 = new Room("livingroom", 3.8, 4.5);


        House house1 = new House(rt1, 1, 2, "green");
        house1.addRoom(r1);
        house1.addRoom(r2);
        house1.addRoom(r3);
        house1.addRoom(r1);

        System.out.println(house1.getSumOfRooms());

        System.out.println(house1.getRoomsNames());

        r1.setName("new name for room 1");

        System.out.println(house1.getRoomsNames());

        System.out.println(house1.getNameOfRoomN(0));

        /*

        House house2 = new House (rt1, 1, 2, 3 ,"green");

        house1.printHouseDetails();
        house2.printHouseDetails();

        house2 = house1;


        house1.printHouseDetails();
        house2.printHouseDetails();

        house1.setNumberOfWindows(12);
        house1.setNumberOfDoors(13);
        house1.setNumberOfRooms(14);

        house1.setColor("blue");


        house1.printHouseDetails();

        house1.printHouseDetails();
        house2.printHouseDetails();

        System.out.println(house1);
        System.out.println(house2);

*/

    }
}
