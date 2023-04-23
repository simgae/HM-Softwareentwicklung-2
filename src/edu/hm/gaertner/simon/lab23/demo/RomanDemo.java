package edu.hm.gaertner.simon.lab23.demo;

import edu.hm.gaertner.simon.lab23.a32.CachedRoman;
import edu.hm.gaertner.simon.lab23.a32.Roman;

import java.time.LocalDate;

public class RomanDemo {

    public static void main(String[] args) {

        /*
        Roman thisYear = new Roman(LocalDate.now().getYear());
        System.out.println(thisYear.number());  // 2023
        System.out.println(thisYear.text());    // MMXXIII

        Roman ninetyNine = new Roman(99);
        System.out.println(ninetyNine.number()); // 99
        System.out.println(ninetyNine.text());  // XCIX

        Roman ten = new Roman("IX");
        System.out.println(ten.number()); // 9
        System.out.println(ten.text());  // IX

         */

        // langsam
        for (int number = 1; number < 10; number++)
            System.out.println(CachedRoman.make(number).text());

        // schnell
        for (int number = 1; number < 10; number++)
            System.out.println(CachedRoman.make(number).text());

        // ohne Factory kein Effekt
        for (int number = 1; number < 10; number++)
            System.out.println(new Roman(number).text());


    }
}
