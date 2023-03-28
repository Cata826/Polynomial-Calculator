package Calc;
import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.TreeMap;
    public class Operatii {
        public boolean equals(TreeMap<Integer,Monom> p1) {
            return super.equals(p1);
        }
        public static TreeMap<Integer,Monom> negare (TreeMap<Integer,Monom> p1) {
            TreeMap<Integer, Monom> result = new TreeMap<>();
            for (Integer key : p1.keySet()) {
                Monom monom = p1.get(key);
                monom.setCoeficient(-monom.getCoeficient());
                result.put(key, monom);
            }
            return result;
        }
        public static TreeMap<Integer, Monom> inmultire(TreeMap<Integer, Monom> p1, TreeMap<Integer, Monom> p2) {
            TreeMap<Integer, Monom> result = new TreeMap<>();
            for (Integer key : p1.keySet()) {
                for (Integer key1 : p2.keySet()) {
                    Monom monom1 = p1.get(key);
                    Monom monom2 = p2.get(key1);
                    Monom fin = new Monom(0.0, 0);
                    fin.setCoeficient(monom1.getCoeficient() * monom2.getCoeficient());
                    fin.setPutere(monom1.getPutere() + monom2.getPutere());
                    if (result.containsKey(fin.getPutere())) {
                        Monom m = result.get(fin.getPutere());
                        m.setCoeficient(m.getCoeficient() + fin.getCoeficient());
                    } else {
                        result.put(fin.getPutere(), fin);
                    }
                }
            }
            return result;
        }
        public static TreeMap<Integer,Monom> scadere(TreeMap<Integer, Monom> p1, TreeMap<Integer, Monom> p2) {
            TreeMap<Integer, Monom> poli ;
            new TreeMap<>();
            poli=negare(p2);
            TreeMap<Integer, Monom> result;
            new TreeMap<>();
            result=adunare(p1,poli);
            return result;
        }
        public static TreeMap<Integer,Monom> adunare(TreeMap<Integer, Monom> p1, TreeMap<Integer, Monom> p2) {
            TreeMap<Integer, Monom> result = new TreeMap<>();
            for (Integer key : p1.keySet()) {
                Monom monom1 = p1.get(key);
                result.put(key, monom1);
            }
            for (Integer key : p2.keySet()) {
                Monom monom2 = p2.get(key);
                if (result.containsKey(key)) {
                    Monom monom1 = result.get(key);
                    double c = monom1.getCoeficient() + monom2.getCoeficient();
                    result.put(key, new Monom(c, key));
                } else {
                    result.put(key, monom2);
                }
            }
            return result;
        }
        public static TreeMap<Integer,Monom> derivare(TreeMap<Integer, Monom> p1) {
            TreeMap<Integer, Monom> result = new TreeMap<>();
            for (Integer key : p1.keySet()) {
                Monom monom = p1.get(key);
                monom.setCoeficient(monom.getCoeficient()* monom.getPutere());
                monom.setPutere(monom.getPutere()-1);
                result.put(key-1, monom);
            }
            return result;
        }
        public static TreeMap<Integer, Monom> integrare(TreeMap<Integer, Monom> p1) {
            TreeMap<Integer, Monom> result = new TreeMap<>();
            for (Integer key : p1.descendingKeySet()) {
                Monom monom = p1.get(key);
                if (monom.getPutere() > 0) {
                    monom.setCoeficient(Math.round(monom.getCoeficient() / (monom.getPutere() + 1.0) * 100.0) / 100.0);
                    monom.setPutere(monom.getPutere() + 1);
                    result.put(key + 1, new Monom(monom.getCoeficient(), monom.getPutere()));
                } else {
                    result.put(key + 1, new Monom(monom.getCoeficient(), monom.getPutere()));
                }
            }
            return result;
        }
        public static TreeMap<Integer, Monom> convertToPolynomial(String input) {
                TreeMap<Integer, Monom> poli = new TreeMap<>();
                String[] monomials = input.split("(?=[+-])");
                for (String monomial : monomials) {
                    double coeficient;int exponent;
                    if (monomial.contains("x")) {
                        int x = monomial.indexOf("x");
                        if (x == 0) {
                            coeficient = 1;
                        } else if (monomial.substring(0, x).equals("-")) {
                            coeficient = -1;
                        } else {
                            coeficient = Double.parseDouble(monomial.substring(0, x));}
                        if (monomial.contains("^")) {
                            exponent = Integer.parseInt(monomial.substring(x + 2));
                        } else {
                            exponent = 1;}
                    } else {
                        coeficient = Double.parseDouble(monomial);
                        exponent = 0;}
                    Monom monom1 = new Monom(coeficient, exponent);
                    int ex = monom1.getPutere();
                    Monom monom2 = poli.get(ex);
                    if (monom2 == null) {
                        poli.put(ex, monom1);}
                    else {
                        double suma = monom2.getCoeficient() + monom1.getCoeficient();
                        monom2.setCoeficient(suma);}
                }
                return poli;}
        public static TreeMap<Integer,Monom> div(TreeMap<Integer,Monom> p1,TreeMap<Integer,Monom> p2)
        {
            TreeMap<Integer,Monom> result =new TreeMap<>();
            for (Integer key1 : p1.descendingKeySet()) {
                for (Integer key2 : p2.descendingKeySet()) {
                    Monom m1 = p1.get(key1);
                    Monom m2 = p2.get(key2);
                    int putere = m1.getPutere() - m2.getPutere();
                    double coeficient = m1.getCoeficient() / m2.getCoeficient();
                    result.put(putere, new Monom(coeficient, putere));
                    break;
                }
                break;
            }
            return result;
        }
        public static TreeMap<Integer,Monom> impartire(TreeMap<Integer,Monom> p1,TreeMap<Integer,Monom> p2) {
                TreeMap<Integer, Monom> result = new TreeMap<>();
                TreeMap<Integer, Monom> e = new TreeMap<>();
                if (p2.lastKey() > p1.lastKey()) {
                    e.putAll(p1);
                    p1.putAll(p2);
                    p2.putAll(p1);}
                result=div(p1,p2);
                TreeMap<Integer, Monom> r1 = inmultire(result, p2);
                TreeMap<Integer, Monom> r2;
                TreeMap<Integer, Monom> q = new TreeMap<>();
                r2 = scadere(p1, r1);
                p1 = r2;
                TreeMap<Integer, Monom> result1 = new TreeMap<>();
                TreeMap<Integer, Monom> result2 = new TreeMap<>();
                for (Integer key1 : p1.descendingKeySet()) {
                    for (Integer key2 : p2.descendingKeySet()) {
                        Monom m1 = p1.get(key1);
                        Monom m2 = p2.get(key2);
                        if(key1>=key2){
                        result1.put(0, new Monom(m1.getCoeficient() / m2.getCoeficient(), m1.getPutere() - m2.getPutere()));
                        result2 = adunare(result, result1);
//                        rest=(scadere(r2,inmultire(result,p1)));
                        break;}
                    else break;}}
                TreeMap<Integer, Monom>[] fin = new TreeMap[2];
                fin[0] = result2;
                fin[1] = scadere(r2,inmultire(result1,p2));
                return fin[0];
            }
        public static TreeMap<Integer,Monom> impartire1(TreeMap<Integer,Monom> p1,TreeMap<Integer,Monom> p2) {
            TreeMap<Integer, Monom> result = new TreeMap<>();
            TreeMap<Integer, Monom> e = new TreeMap<>();
            if (p2.lastKey() > p1.lastKey()) {
                e.putAll(p1);
                p1.putAll(p2);
                p2.putAll(p1);}
            result=div(p1,p2);
            TreeMap<Integer, Monom> r1 = inmultire(result, p2);
            TreeMap<Integer, Monom> r2;
            TreeMap<Integer, Monom> q = new TreeMap<>();
            r2 = scadere(p1, r1);
            p1 = r2;
            TreeMap<Integer, Monom> result1 = new TreeMap<>();
            TreeMap<Integer, Monom> result2 = new TreeMap<>();
            for (Integer key1 : p1.descendingKeySet()) {
                for (Integer key2 : p2.descendingKeySet()) {
                    Monom m1 = p1.get(key1);
                    Monom m2 = p2.get(key2);
                    if(key1>=key2){
                        result1.put(0, new Monom(m1.getCoeficient() / m2.getCoeficient(), m1.getPutere() - m2.getPutere()));
                        result2 = adunare(result, result1);
//                        rest=(scadere(r2,inmultire(result,p1)));
                        break;}
                    else break;}}
            TreeMap<Integer, Monom>[] fin = new TreeMap[2];
            fin[0] = result2;
            fin[1] = scadere(r2,inmultire(result1,p2));
            return fin[1];
        }
        public static String toString(TreeMap<Integer, Monom> poli) {
            StringBuilder sb = new StringBuilder();
            boolean isFirstTerm = true;
            for (Map.Entry<Integer, Monom> entry : poli.descendingMap().entrySet()) {
                int exponent = entry.getKey();
                Monom monom = entry.getValue();
                double coeficient = monom.getCoeficient();
                if (coeficient == 0) {
                    continue;
                }
                if (!isFirstTerm) {
                    sb.append(coeficient > 0 ? " + " : " - ");
                    coeficient = Math.abs(coeficient);
                } else {
                    isFirstTerm = false;
                }
                sb.append(coeficient);
                if (exponent > 1) {
                    sb.append("x^").append(exponent);
                } else if (exponent == 1) {
                    sb.append("x");}
            }
            return sb.toString();}

        }
