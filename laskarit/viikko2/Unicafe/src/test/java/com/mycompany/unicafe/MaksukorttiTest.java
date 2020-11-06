package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    int ALKUSALDO = 1000;

    @Before
    public void setUp() {
        kortti = new Maksukortti(ALKUSALDO);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoOikein() {       
        assertEquals(ALKUSALDO, kortti.saldo());
    }
    
    @Test
    public void kortinLataaminenKasvattaaSaldoa () {
        kortti.lataaRahaa(500);
        assertEquals("saldo: 15.0", kortti.toString());
    }

    @Test
    public void saldoVaheneeJosRahaaOnTarpeeksi() {     
        kortti.otaRahaa(500);
        assertEquals("saldo: 5.0", kortti.toString());
    }

    @Test
    public void saldoEiMuutuJosRahaaEiOleTarpeeksi() {    
        kortti.otaRahaa(1500);
        assertEquals("saldo: 10.0", kortti.toString());
    }   
    
    @Test
    public void korttiPalauttaaOikeinRiittivatkoRahat() {     
        assertTrue(kortti.otaRahaa(1000));
        assertFalse(kortti.otaRahaa(1500));               
    }    
}
