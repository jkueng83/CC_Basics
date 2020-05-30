package cc.jku.io.ioAuto;

/*
Aufgabe
-------
Lasse über eine Konsolenanwendung den Benutzer ein Auto konfigurieren.

Sprich, er kann auswählen ob er z.B. die 100 PS Version oder die 200 PS Version möchte, aber auch ob es ein Diesel oder
Benziner ist. Je nach Auswahl wird ein anderer Gesamtpreis errechnet, da Modifikationen ja unterschiedlich kosten.

Wenn der Benutzer fertig konfiguriert hat, so wollen wir die Rechnungsdaten in eine Textdatei schreiben, in etwa in
dieser Form:

Auto;Treibstoff;PS;Preis
BMX X3;DIESEL;200;60.000
BMW X3;BENZIN;150;50.000

 */

import java.util.ArrayList;
import java.util.List;

public class MainAuto {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        List<Engine> engines = new ArrayList<>();

        /* Das waren die ersten Tests:

        Engine engine = new Engine(130,ENGINETYPE.BENZIN);
        engines.add(engine);

        Car car = new Car("VW Golf" );
        cars.add(car);

        System.out.println(car.getCarDataString());

        car.addEngine(engine);
        System.out.println(car.getCarDataString());
        */

        Customer customer = new Customer();
        customer.configureCar();

    }


}
