package mediamarkt.dao;

import mediamarkt.model.Computer;


public class MediamarktImpl implements Mediamarkt {
    // поля которые описывают магазин
    private Computer[] computers; // массив для гаджетов
    private int size; //текущее кол во

    //конструктор
    public MediamarktImpl(int capacity) {

        computers = new Computer[capacity];//максим размер полок магазина
    }


    @Override
    public boolean addComputer(Computer computer) {
        if (computer == null || size == computers.length || findComputer(computer.getBarcode()) != null) {
            return false;
        }
        computers[size] = computer;
        size++;
        return true;
    }

    @Override
    public Computer removeComputer(String barcode) {
        for (int i = 0; i < size; i++) {
            if (computers[i].getBarcode() == barcode) {
                Computer temp = computers[i];
                computers[i] = computers[size - 1];
                computers[size - 1] = null;
                size--;
                return temp;
            }
        }
        return null;
    }

    @Override
    public Computer findComputer(String barcode) {
        for (int i = 0; i < size; i++) {
            if (computers[i].getBarcode() == barcode) {
                return computers[i];
            }
        }
        return null;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public double totalHdd() {
        int sumHdd = 0;
        for (int i = 0; i < computers.length; i++) {
            if (computers[i] != null) {
                sumHdd = sumHdd + computers[i].getHdd();
            }
        }
        return sumHdd;
    }

    @Override
    public void printComputers() {
        for (int i = 0; i < size; i++) {
            System.out.println(computers[i]);

        }

    }
}