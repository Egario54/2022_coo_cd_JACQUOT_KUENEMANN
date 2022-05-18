package test;

import XML.ChargeurMagasin;
import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTri {
    @Test
    public void testTriAlbum() throws FileNotFoundException {
        ChargeurMagasin charge = new ChargeurMagasin("C:\\Users\\kuene\\Desktop\\Cours\\Conception objet\\2022_coo_cd_JACQUOT_KUENEMANN\\untitled\\src\\XML_FILES");
        Magasin resultat = charge.chargerMagasin();
        resultat.trierAlbum();
        String s = resultat.getCd(0).toStringTest() + resultat.getCd(11).toStringTest();
        assertEquals("Justin Bieber - Believe\n"+
                "Whitney Houston - Whitney Houston\n",s);
    }

    @Test
    public void testTriArtiste() throws FileNotFoundException {
        ChargeurMagasin charge = new ChargeurMagasin("C:\\Users\\kuene\\Desktop\\Cours\\Conception objet\\2022_coo_cd_JACQUOT_KUENEMANN\\untitled\\src\\XML_TEST");
        Magasin resultat = charge.chargerMagasin();
        resultat.trierArtiste();
        String s = resultat.getCd(0).getNomArtiste() + resultat.getCd(2).getNomArtiste();
        assertEquals("Justin Bieber"+
                "Whitney Houston",s);
    }
}
