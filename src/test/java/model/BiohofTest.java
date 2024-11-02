package model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.*;


class BiohofTest {
    @Test
    void testMaxAlter5() {
        Biohof b = new Biohof();
        try {
            b.setMaxAnzahl(5);
            System.out.println("test ist erfolgreich");
        } catch (BiohofException e) {
            fail();
        }
    }

    @Test
    void testMaxAlter7() {
        Biohof b = new Biohof();
        try {
            b.setMaxAnzahl(7);
            fail();

        } catch (BiohofException e) {
            System.out.println("test ist erfolgreich");
        }

    }

    @Test
    void testMinAlter() throws BiohofException {
        Biohof b = new Biohof();
        Tier t1, t2, t3;




        t1 = new Tier("Berta", 156, 2000, 2017, true);
        t2 = new Tier("Berta", 156, 2000, 2018, true);
        t3 = new Tier("Berta", 156, 2000, 2019, true);

        b.setMaxAnzahl(5);
        b.aufnehmen(t1);
        b.aufnehmen(t2);
        b.aufnehmen(t3);

        int min = b.minAlter();
        if (min != 5) {
            fail();
        }
    }

}