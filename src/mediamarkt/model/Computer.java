package mediamarkt.model;

public class Computer {
    //fields
    private String barcode;
    private int ram;
    private int hdd;
    private String brand;
    // cons

    public Computer(String barcode, int ram, int hdd, String brand) {
        this.barcode = barcode;
        this.ram = ram;
        this.hdd = hdd;
        this.brand = brand;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setCpu(String barcode) {
        this.barcode = barcode;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override // переопределение super metoda Objekt
    public String toString() {
        return  "Computer  " +
                "Brand " + brand + '\'' +
                ",  ram=" + ram +
                ", hdd= " + hdd +
                ", cpu= " + barcode +" ";

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Computer computer = (Computer) object;

        return barcode.equals(computer.barcode);
    }

    @Override
    public int hashCode() {
        return barcode.hashCode();
    }
}
