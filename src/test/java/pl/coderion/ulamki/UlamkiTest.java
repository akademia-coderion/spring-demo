package pl.coderion.ulamki;

import org.junit.jupiter.api.Test;
import pl.coderion.Euklides;
import pl.coderion.Ulamek;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UlamkiTest {

    @Test
    void uprosc() {
        Ulamek ulamek = new Ulamek(12, 18);
        ulamek = Euklides.uprosc(ulamek);

        assertEquals(2, ulamek.getLicznik());
        assertEquals(3, ulamek.getMianownik());
    }
}
