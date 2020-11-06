package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;
    int ALKUSALDO = 100000;
    int KORTINSALDO = 0;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(KORTINSALDO);
    }

    @Test
    public void alkuSaldo() {
        assertEquals(ALKUSALDO, kassa.kassassaRahaa());
    }

    @Test
    public void alkuMyynnit() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateistostoTuoKassaanOikeanMaaranRahaa() {
        kassa.syoMaukkaasti(400);
        kassa.syoEdullisesti(240);

        assertEquals((ALKUSALDO + 400 + 240), kassa.kassassaRahaa());
    }

    @Test
    public void kateistostoAntaaOikeanMaaranVaihtorahaa() {
        assertEquals(200, kassa.syoMaukkaasti(500) + kassa.syoEdullisesti(340));
    }

    @Test
    public void riittamatonMaksuPalauttaaKaikkiRahat() {
        assertEquals(200, kassa.syoEdullisesti(100) + kassa.syoMaukkaasti(100));
    }

    @Test
    public void kateistostoKasvattaaMyytyjenMaaraa() {
        kassa.syoMaukkaasti(500);
        kassa.syoMaukkaasti(500);
        kassa.syoEdullisesti(500);
        kassa.syoEdullisesti(500);

        assertEquals(4, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void riittamatonMaksuEiKasvataMyytyjenMaaraa() {
        kassa.syoMaukkaasti(100);
        kassa.syoMaukkaasti(100);
        kassa.syoEdullisesti(100);
        kassa.syoEdullisesti(100);

        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void riittamatonMaksuEiKasvataKassanSaldoa() {
        kassa.syoMaukkaasti(100);
        kassa.syoMaukkaasti(100);
        kassa.syoEdullisesti(100);
        kassa.syoEdullisesti(100);

        assertEquals(0, kassa.kassassaRahaa() - ALKUSALDO);
    }

    @Test
    public void maksukortinLatausLisaaRahanKortille() {
        kassa.lataaRahaaKortille(kortti, 2000);

        assertEquals(2000, kortti.saldo());
    }

    @Test
    public void maksukortilleEiVoiLadataNegatiivistaSummaa() {
        kassa.lataaRahaaKortille(kortti, -2000);

        assertEquals(0, kortti.saldo());
    }

    @Test
    public void maksukortinLatausLisaaRahanKassaan() {
        kassa.lataaRahaaKortille(kortti, 2000);

        assertEquals(ALKUSALDO + 2000, kassa.kassassaRahaa());
    }

    @Test
    public void maksukortiltaVeloitetaanOikein() {
        kassa.lataaRahaaKortille(kortti, 2000);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);

        assertEquals(2000 - 640, kortti.saldo());
    }

    @Test
    public void korttimaksuKasvattaaMyytyjenLounaidenMaaraa() {
        kassa.lataaRahaaKortille(kortti, 2000);
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);

        assertEquals(4, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void kassaPalauttaaOikeinRiittivatkoKortinRahat() {
        kassa.lataaRahaaKortille(kortti, 250);
        assertTrue(kassa.syoEdullisesti(kortti));
        assertFalse(kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void maksukortiltaEiVeloitetaJosSaldoEiRiita() {
        kassa.lataaRahaaKortille(kortti, 200);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);

        assertEquals(200, kortti.saldo());
    }

    @Test
    public void myytyjenMaaraEiKasvaJosSaldoEiRiita() {
        kassa.lataaRahaaKortille(kortti, 200);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);

        assertEquals(0, kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty());
    }

    public KassapaateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

}
