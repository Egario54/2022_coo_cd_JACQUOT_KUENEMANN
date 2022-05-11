package test;

import XML.ChargeurMagasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ChargeurMagasinTest {

    @Test
    void test_chargerMagasin() throws FileNotFoundException {
        ChargeurMagasin charge = new ChargeurMagasin("C:\\Users\\kuene\\Desktop\\Cours\\Conception objet\\2022_coo_cd_JACQUOT_KUENEMANN\\untitled\\src\\XML_FILES");
        assertEquals(12, charge.chargerMagasin().getNombreCds());
    }

    @Test
    void test_chargerMagasinException() {
        ChargeurMagasin charge = new ChargeurMagasin("C:\\Users\\kuene\\Desktop\\Cours\\Conception objet\\2022_coo_cd_JACQUOT_KUENEMANN\\untitled\\src\\toujours_plus_long_les_chemins_d'acces");
        FileNotFoundException f = assertThrows(FileNotFoundException.class, charge::chargerMagasin);
    }
}