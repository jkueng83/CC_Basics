package cc.jku.FotoApparat;

public class Main {
    public static void main(String[] args) {

        FotoApparat nikonD300  = new FotoApparat("Nikon", "D300", "Not Austria! ;0)");
        nikonD300.setFocalLength(18,200);
        nikonD300.setMegaPixel(12.3);
        nikonD300.setOwner("Johannes Küng");

        CameraFunction cameraFunction1 = new CameraFunction("Einzelaufnahme");
        nikonD300.addCameraFunctions(cameraFunction1);
        CameraFunction cameraFunctionSerienbild = new CameraFunction("Serienbild 5/s");
        nikonD300.addCameraFunctions(cameraFunctionSerienbild);
        CameraFunction cameraFunctionSelbstausloeser3s = new CameraFunction("Selbstauslöser 3s");
        nikonD300.addCameraFunctions(cameraFunctionSelbstausloeser3s);
        CameraFunction cameraFunctionSelbstausloeser10s = new CameraFunction("Selbstauslöser 10s");
        nikonD300.addCameraFunctions(cameraFunctionSelbstausloeser10s);

        for (int i = 0; i <15 ; i++) {
            nikonD300.makePicture();
        }

        FotoApparat canonEosR = new FotoApparat("canon","Eos R", "Vieleicht China");
        canonEosR.setOwner("not me");
        canonEosR.setMegaPixel(30.3);
        canonEosR.setFocalLength(24,105);

        CameraFunction canonEosRSerienbildaufnahme = new CameraFunction("Serienbildaufnahme 8/s") ;
        canonEosR.addCameraFunctions(canonEosRSerienbildaufnahme);
        CameraFunction canonEosRVideo4K = new CameraFunction("Video 4K");
        canonEosR.addCameraFunctions(canonEosRVideo4K);
        CameraFunction canonEosRFullHDMovies = new CameraFunction("Full-HD-Movies");
        canonEosR.addCameraFunctions(canonEosRFullHDMovies);

        for (int i = 0; i <77 ; i++) {
            canonEosR.makePicture();
        }

        FotoApparat sonyRX100 = new FotoApparat("Sony", "RX100", "???");
        sonyRX100.setFocalLength(24,200);
        sonyRX100.setMegaPixel(20.1);
        sonyRX100.setOwner("Hans Groß");

        CameraFunction sony4KHDRAufnahme = new CameraFunction("4K HDR-Aufnahme");
        sonyRX100.addCameraFunctions(sony4KHDRAufnahme);
        CameraFunction sonyIso = new CameraFunction("Iso 100–12.800");
        sonyRX100.addCameraFunctions(sonyIso);
        CameraFunction bis20BilderProSekunde = new CameraFunction("Bis zu 20 Bildern pro Sekunde");
        sonyRX100.addCameraFunctions(bis20BilderProSekunde);

        for (int i = 0; i <36 ; i++) {
            sonyRX100.makePicture();
        }

        nikonD300.getCameraData();

        canonEosR.getCameraData();

        sonyRX100.getCameraData();

    }
}
