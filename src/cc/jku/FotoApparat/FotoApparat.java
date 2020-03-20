package cc.jku.FotoApparat;

import java.util.ArrayList;
import java.util.List;

public class FotoApparat {
    private String brand;
    private String type;
    private String producingCountry;
    private double megaPixel;
    public static final int MIN_FOCALLENGTH = 10;
    private int focalLengthMin; // Brennweite Min
    private int focalLengthMax; // Brennweite Max
    private List<CameraFunction> cameraFunctions;
    private String owner;
    private int pictureCounter;

    public void getCameraData() {
        //System.out.println();
        System.out.println("_________________________________________________");
        System.out.println();
        System.out.println("###### PRINT CAMERA DATA ######");
        System.out.println();
        System.out.println("Brand: " + this.brand);
        System.out.println("Type: " + this.type);
        System.out.println("Focal Length: " + this.focalLengthMin + " - " + this.focalLengthMax);
        System.out.print("Camera functions: ");

        for (int i = 0; i < this.cameraFunctions.size(); i++) {
            if(i!=0){
                System.out.print(", ");
            }
            System.out.print(this.cameraFunctions.get(i).getFunction() );
        }

        System.out.println();
        System.out.println("Owner: " + this.owner);
        System.out.println("Picture counter: " + this.pictureCounter);

    }

    public FotoApparat(String brand, String typ, String producingCountry) {
        this.brand = brand;
        this.type = typ;
        this.producingCountry = producingCountry;
        this.cameraFunctions = new ArrayList<>();
    }

    public void addCameraFunctions(CameraFunction cameraFunction) {
        this.cameraFunctions.add(cameraFunction);
    }

    public void makePicture() {
        System.out.println("Klick!");
        this.pictureCounter++;
    }


    public void setFocalLength(int focalLengthMin, int focalLengthMax) {
        if ((focalLengthMin < MIN_FOCALLENGTH) || (focalLengthMax < MIN_FOCALLENGTH)) {
            System.out.println("The focal length must be at least " + MIN_FOCALLENGTH);
        } else {
            if (focalLengthMin > focalLengthMax) {
                System.out.println("Focal length min must be smaller then focal length max!");
            } else {
                this.focalLengthMin = focalLengthMin;
                this.focalLengthMax = focalLengthMax;
            }
        }
    }

    public int getFocalLengthMin() {
        return focalLengthMin;
    }

    public int getFocalLengthMax() {
        return focalLengthMax;
    }

    public double getMegaPixel() {
        return megaPixel;
    }

    public void setMegaPixel(double megaPixel) {
        if (megaPixel < 1) {
            System.out.println("Value to small for mega pixel!");
        } else {
            this.megaPixel = megaPixel;
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


}
