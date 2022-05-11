package test;

import XML.ChargeurMagasin;
import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class TestTri {
    @Test
    public void testTri() throws FileNotFoundException {
        ChargeurMagasin charge = new ChargeurMagasin("..//XML_FILES");
        Magasin resultat = charge.chargerMagasin();
        resultat.trierAlbum();

    }
}
