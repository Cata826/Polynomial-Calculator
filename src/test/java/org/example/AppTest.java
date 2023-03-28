package org.example;
import Calc.Monom;
import Calc.Operatii;
import org.junit.Test;
import java.util.TreeMap;
public final class AppTest {
    @Test
    public void testScadere() {
        TreeMap<Integer, Monom> p1 = new TreeMap<>();
        p1.put(3, new Monom(2.0, 3));
        p1.put(1, new Monom(-1.0, 1));
        TreeMap<Integer, Monom> p2 = new TreeMap<>();
        p2.put(2, new Monom(3.0, 2));
        p2.put(1, new Monom(1.0, 1));
        p2.put(0, new Monom(-2.0, 0));
        TreeMap<Integer, Monom> result = Operatii.scadere(p1, p2);
        TreeMap<Integer, Monom> expected = new TreeMap<>();
        expected.put(3, new Monom(2.0, 3));
        expected.put(2, new Monom(-3.0, 2));
        expected.put(1, new Monom(-2.0, 1));
        expected.put(0, new Monom(2.0, 0));
        expected.equals(result);
    }
    @Test
    public void testImpartire() {
        TreeMap<Integer, Monom> p1 = new TreeMap<>();
        p1.put(3, new Monom(1.0, 3));
        p1.put(2, new Monom(-2.0, 2));
        p1.put(1, new Monom(6.0, 1));
        p1.put(0, new Monom(-5.0, 0));
        TreeMap<Integer, Monom> p2 = new TreeMap<>();
        p2.put(2, new Monom(1.0, 2));
        p2.put(0, new Monom(-1.0, 0));
        TreeMap<Integer,Monom> result = Operatii.impartire(p1, p2);
        TreeMap<Integer,Monom> expected = new TreeMap<>();
        expected.put(1,new Monom(1.0,1));
        expected.put(0,new Monom(-2.0,0));
        expected.equals(result);
    }
    @Test
    public void testImpartire1() {
        TreeMap<Integer, Monom> p1 = new TreeMap<>();
        p1.put(3, new Monom(1.0, 3));
        p1.put(2, new Monom(-2.0, 2));
        p1.put(1, new Monom(6.0, 1));
        p1.put(0, new Monom(-5.0, 0));
        TreeMap<Integer, Monom> p2 = new TreeMap<>();
        p2.put(2, new Monom(1.0, 2));
        p2.put(0, new Monom(-1.0, 0));
        TreeMap<Integer,Monom> result = Operatii.impartire1(p1, p2);
        TreeMap<Integer,Monom> expected = new TreeMap<>();
        expected.put(1,new Monom(7.0,1));
        expected.put(0,new Monom(7.0,0));
        expected.equals(result);
    }

    @Test
    public void testInmultire() {
        TreeMap<Integer, Monom> p1 = new TreeMap<>();
        p1.put(3, new Monom(2.0, 3));
        p1.put(1, new Monom(-1.0, 1));
        TreeMap<Integer, Monom> p2 = new TreeMap<>();
        p2.put(2, new Monom(3.0, 2));
        p2.put(1, new Monom(1.0, 1));
        p2.put(0, new Monom(-2.0, 0));
        TreeMap<Integer, Monom> result = Operatii.inmultire(p1, p2);
        TreeMap<Integer, Monom> expected = new TreeMap<>();
        expected.put(5, new Monom(6.0, 5));
        expected.put(4, new Monom(-2.0, 4));
        expected.put(3, new Monom(-1.0, 3));
        expected.put(2, new Monom(9.0, 2));
        expected.put(1, new Monom(-5.0, 1));
        expected.put(0, new Monom(4.0, 0));
        expected.equals(result);
    }

    @Test
    public void testAdunare() {
        TreeMap<Integer, Monom> p1 = new TreeMap<>();
        p1.put(3, new Monom(2.0, 3));
        p1.put(1, new Monom(-1.0, 1));
        TreeMap<Integer, Monom> p2 = new TreeMap<>();
        p2.put(2, new Monom(3.0, 2));
        p2.put(1, new Monom(1.0, 1));
        p2.put(0, new Monom(-2.0, 0));
        TreeMap<Integer, Monom> result = Operatii.adunare(p1, p2);
        TreeMap<Integer, Monom> expected = new TreeMap<>();
        expected.put(3, new Monom(2.0, 3));
        expected.put(2, new Monom(3.0, 2));
        expected.put(1, new Monom(-0.0, 1));
        expected.put(0, new Monom(-2.0, 0));
        expected.equals(result);
    }
    @Test
    public void testDerivare() {
        TreeMap<Integer, Monom> p2 = new TreeMap<>();
        p2.put(2, new Monom(3.0, 2));
        p2.put(1, new Monom(1.0, 1));
        p2.put(0, new Monom(-2.0, 0));
        TreeMap<Integer, Monom> result = Operatii.derivare(p2);
        TreeMap<Integer, Monom> expected = new TreeMap<>();
        expected.put(1, new Monom(6.0, 1));
        expected.put(0, new Monom(1.0, 0));
        expected.equals(result);
    }

    @Test
    public void testIntegrare() {
        TreeMap<Integer, Monom> p2 = new TreeMap<>();
        p2.put(2, new Monom(3.0, 2));
        p2.put(1, new Monom(1.0, 1));
        p2.put(0, new Monom(-2.0, 0));
        TreeMap<Integer, Monom> result = Operatii.integrare(p2);
        TreeMap<Integer, Monom> expected = new TreeMap<>();
        expected.put(3, new Monom(1.0, 3));
        expected.put(2, new Monom(0.3333333333333333, 2));
        expected.put(1, new Monom(-2.0, 1));
        expected.put(0, new Monom(0.0, 0));
        expected.equals(result);
    }



}
