package cc.jku.io.ioWrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainWrite {
    public static void main(String[] args) {
        File file = new File("./testdata/WriteFile.txt"); // Pfad der Datei

        DateTimeString DTS = new DateTimeString();

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file, true); //append = true wird angehängt, false = überschreiben;

            for (int i = 0; i < 10; i++) {
                String writeString = "";

                writeString = DTS.getDateTimeYYYYmmddHHmmssSSS() + " " + "neuer Text" + " + noch was";

                System.out.println(writeString);
                fileWriter.write(writeString + "\n");
            }

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File konnt nicht geschrieben werden.");
        }

    }

}
