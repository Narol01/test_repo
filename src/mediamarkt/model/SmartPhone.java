package mediamarkt.model;

public class SmartPhone extends Laptop {
    private String camera;
    private String color;

    public SmartPhone(String barcode, int ram, int hdd, String brand, String display, int batteryCapacity, double weight, String camera, String color) {
        super(barcode, ram, hdd, brand, display, batteryCapacity, weight);
        this.camera = camera;
        this.color = color;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString()  +
                " camera='" + camera + '\'' +
                ", color=" + color ;
    }
}
