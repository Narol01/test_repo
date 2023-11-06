package mediamarkt.model;

public class Laptop extends Computer {

    private String display;
    private int batteryCapacity;
    private double weight;

    public Laptop(String barcode, int ram, int hdd, String brand, String display, int batteryCapacity, double weight) {
        super(barcode, ram, hdd, brand);
        this.display = display;
        this.batteryCapacity = batteryCapacity;
        this.weight = weight;
    }

    @Override
    public String toString() {
        String a = super.toString();
        return a +
                " " +
                "display='" + display + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", weight=" + weight ;
    }
}
