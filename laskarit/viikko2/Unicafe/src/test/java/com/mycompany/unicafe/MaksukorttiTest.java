package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    Kassapaate unicafeExactum;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
        unicafeExactum = new Kassapaate();
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinSaldoOikeinLuodessa() {
        String vastaus = kortti.toString();
        assertEquals(vastaus, "saldo: 0.10");
    }

    @Test
    public void kortinSaldoEiVaheneJosRahatEiRiita() {
        String vastaus = kortti.toString();
        unicafeExactum.syoEdullisesti(kortti);

        assertEquals(vastaus, "saldo: 0.10");
    }
}
