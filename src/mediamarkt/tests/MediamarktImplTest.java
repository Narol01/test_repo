package mediamarkt.tests;

import mediamarkt.dao.Mediamarkt;
import mediamarkt.dao.MediamarktImpl;
import mediamarkt.model.Computer;
import mediamarkt.model.Laptop;
import mediamarkt.model.SmartPhone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediamarktImplTest {
    Mediamarkt mediamarkt;
    Computer[] comp;

    @BeforeEach
    void setUp() {
        mediamarkt = new MediamarktImpl(5);
        comp = new Computer[4];

        comp[0] = new Computer("10001",16,256,"Dell");
        comp[1] = new Computer("10002",32,1000,"Asus");
        comp[2] = new Laptop("10003",16,512,"Aser","14",150,4);
        comp[3] = new SmartPhone("10004",8,128,"Apple","6",99,200,"8d","red");
        for (int i = 0; i < comp.length; i++) {
            mediamarkt.addComputer(comp[i]);
        }

    }

    @Test
    void addComputer() {
        assertFalse(mediamarkt.addComputer(null));
        //второй раз не можем добавить
        assertFalse(mediamarkt.addComputer(comp[1]));
        Computer computer1  =  new Computer("10005",6,1256,"ibm");
        assertTrue(mediamarkt.addComputer(computer1));//добавили
        assertEquals(5,mediamarkt.quantity());
        Computer computer3 = new Computer("10006",16,256,"HP");
        assertFalse(mediamarkt.addComputer(computer3)); // не можем превысить capacity
        printComputers();
    }

    @Test
    void removeComputer() {
        assertEquals( comp[1],mediamarkt.removeComputer("10002"));
        assertEquals(3,mediamarkt.quantity());//  стало на один меньше
        assertNull(mediamarkt.removeComputer("10002")); // дважды нельзя удалить
        assertNull(mediamarkt.findComputer("10002"));// не можем найти
        printComputers();

    }

    @Test
    void findComputer() {
        assertEquals( comp[1],mediamarkt.findComputer("10002"));
        assertNull(mediamarkt.findComputer("10006")); //не найден за границей arr

    }

    @Test
    void quantity() {assertEquals(4,mediamarkt.quantity());
    }

    @Test
    void totalHdd() {assertEquals(1896,mediamarkt.totalHdd());
    }


    @Test
    void printComputers() {mediamarkt.printComputers();
    }
}