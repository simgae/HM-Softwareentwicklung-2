package edu.hm.gaertner.simon.lab23.demo;

import edu.hm.gaertner.simon.lab23.a34.SymmetricMap;

public class SymmetricMapDemo {

    public static void main(String[] args) {
        // Zweiter Eintrag ersetzt den ersten mit dem gleichen Wert
        SymmetricMap<String, Integer> map = new SymmetricMap<>();
        map.put("IV", 4);
        map.put("IIII", 4);
        System.out.println(map.size()); // 1

        // Die Umkehrabbildung funktioniert genauso
        SymmetricMap<Integer, String> reverted = map.revert();
        reverted.put(-4, "IV");
        reverted.put(4, "IV");
        reverted.put(-4, "-IV");
        System.out.println(reverted); // {-4=-IV, 4=IV}

        // Geradzahliges Umdrehen aendert nichts
        SymmetricMap<Integer, Integer> original = new SymmetricMap<>();
        original.put(1, 2);
        original.put(2, 3);
        original.put(null, null);
        SymmetricMap<Integer, Integer> copy = original.revert().revert().revert().revert();
        System.out.println(copy.equals(original)); // true
    }
}
