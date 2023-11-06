package mediamarkt.dao;


import mediamarkt.model.Computer;

public interface Mediamarkt {
    boolean addComputer(Computer computer);
   Computer removeComputer(String barcode);
   Computer findComputer(String barcode);
   int quantity();
   double totalHdd();

    void printComputers(); // изменнения для git hub

    // lkz git
}


