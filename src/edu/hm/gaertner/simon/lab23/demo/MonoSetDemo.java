package edu.hm.gaertner.simon.lab23.demo;

import edu.hm.gaertner.simon.lab23.a31.MonoSet;

import java.util.List;
import java.util.Set;

public class MonoSetDemo {
    public static void main(String[] args) {
        MonoSet<Integer> mi = new MonoSet<>();
        System.out.println(mi.isEmpty()); // true
        System.out.println(mi.add(23)); // true
        System.out.println(mi.add(42)); // false
        System.out.println(mi.remove(23)); // true
        System.out.println(mi.remove(23)); // false

        mi.addAll(List.of(666, -1, 666));

        for(int n: mi)
            System.out.println(n); // 666

        System.out.println(mi.equals(Set.of(666))); // true

        MonoSet<Set<Integer>> msi = new MonoSet<>();
        System.out.println(msi.add(mi)); // true
        System.out.println(msi.add(Set.of(666))); // false
    }
}
