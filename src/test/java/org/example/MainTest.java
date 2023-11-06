package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testIsMutantColumnasFilasYDiagonales() {
        String[] mutantDNA = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(Main.isMutant(mutantDNA));
    }

    @Test
    void testIsMutantUnaFilaMutante() {
        String[] mutantDNA = {
                "ATGCGA",
                "CAGTGC",
                "TTGTAT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertFalse(Main.isMutant(mutantDNA));
    }

    @Test
    void testIsMutantTodasLasFilasMutantes() {
        String[] mutantDNA = {
                "AGGGGA",
                "CAGGGG",
                "TTTTTT",
                "AAAAGG",
                "CCCCTA",
                "TYTTTT"
        };
        assertTrue(Main.isMutant(mutantDNA));
    }

    @Test
    void testIsMutantTodasColumnasMutantes() {
        String[] mutantDNA = {
                "ATGCGA",
                "ATGCGA",
                "ATGCGA",
                "ATGCGA",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(Main.isMutant(mutantDNA));
    }

    @Test
    void testIsMutantUnaDiagonalMutante() {
        String[] mutantDNA = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };
        assertTrue(Main.isMutant(mutantDNA));
    }

    @Test
    void testIsMutantTodasDiagonalesMutantes() {
        String[] mutantDNA = {
                "ATGCGA",
                "CATGGC",
                "TCATGT",
                "ATCATG",
                "CCTCAT",
                "TCATCA"
        };
        assertTrue(Main.isMutant(mutantDNA));
    }

    @Test
    void testIsMutantDNAHumano() {
        String[] nonMutantDNA = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGACGG",
                "CGCCTA",
                "TCACTG"
        };
        assertFalse(Main.isMutant(nonMutantDNA));
    }

    @Test
    void testIsMutantMatrizPequeña() {
        String[] smallMatrix = {
                "ATG",
                "CAG",
                "TTT",
        };
        assertFalse(Main.isMutant(smallMatrix));
    }

    @Test
    void testIsMutantMatrizIrregular() {
        String[] nonSquareMatrix = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG"
        };
        assertFalse(Main.isMutant(nonSquareMatrix));
    }

    @Test
    void testIsMutantMatrizDeCaracterSolo() {
        String[] singleCharacterMatrix = {"A"};
        assertFalse(Main.isMutant(singleCharacterMatrix));
    }

    @Test
    void testIsMutantMatrizVacia() {
        String[] emptyMatrix = {};
        assertFalse(Main.isMutant(emptyMatrix));
    }

    @Test
    void testIsMutantMatrizNula() {
        assertFalse(Main.isMutant(null));
    }

    @Test
    void testIsMutantCaracteresErroneos(){
        String[] nonSquareMatrix = {
                "FTGCGA",
                "CFGTGA",
                "TTFTGA",
                "AGAFGA"
        };
        assertFalse(Main.isMutant(nonSquareMatrix));
    }
}
