import Calc.Monom;
import Calc.Operatii;

import java.util.TreeMap;
public class CalcModel {
    static final String INITIAL_VALUE = "0";
    private String m_total;
    private String m_total1;
    CalcModel() {
        reset();
    }
    public void reset() {
        m_total = "0";
        m_total1 ="0";
    }
    public void multiplyBy(String operand,String operand1) {
        TreeMap<Integer,Monom> p1,p2;
        p1=Operatii.convertToPolynomial(operand);
        p2=Operatii.convertToPolynomial(operand1);
        m_total=Operatii.toString(Operatii.inmultire(p1,p2));
    }
    public void substract(String operand,String operand1) {
        TreeMap<Integer,Monom> p1,p2;
        p1=Operatii.convertToPolynomial(operand);
        p2=Operatii.convertToPolynomial(operand1);
        m_total= Operatii.toString(Operatii.scadere(p1,p2));
    }
    public void derivare(String operand) {
        TreeMap<Integer,Monom> p1;
        p1=Operatii.convertToPolynomial(operand);
        m_total=Operatii.toString(Operatii.derivare(p1));
    }
    public void integrare(String operand) {
        TreeMap<Integer,Monom> p1;
        p1=Operatii.convertToPolynomial(operand);
        m_total=Operatii.toString(Operatii.integrare(p1));
    }
    public void addTo(String operand,String operand1) {
        TreeMap<Integer, Monom> p1,p2;
        p1=Operatii.convertToPolynomial(operand);
        p2=Operatii.convertToPolynomial(operand1);
        m_total=Operatii.toString(Operatii.adunare(p1,p2));
    }
    public void impartire(String operand,String operand1) {
        TreeMap<Integer,Monom> p1,p2;
        p1=Operatii.convertToPolynomial(operand);
        p2=Operatii.convertToPolynomial(operand1);
        m_total=Operatii.toString(Operatii.impartire(p1,p2));
    }
    public void impartire1(String operand,String operand1) {
        TreeMap<Integer,Monom> p1,p2;
        p1=Operatii.convertToPolynomial(operand);
        p2=Operatii.convertToPolynomial(operand1);
        m_total=Operatii.toString(Operatii.impartire1(p1,p2));
    }
    public void setValue(String value) {
      m_total=value;
    }
    public String getValue() {
        return m_total;
    }
}
