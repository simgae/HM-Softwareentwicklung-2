package edu.hm.gaertner.simon.lab23.demo;

import edu.hm.cs.rs.se.ss23.a23.Bottle;
import edu.hm.cs.rs.se.ss23.a23.fluid.*;
import edu.hm.gaertner.simon.lab23.a23.Bottles;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/** Demoprogramm fuer Flaschen.
 * @version 2023-04-03
 */
public class Bottlery {
    /** Entry point.
     * @param args Kommandozeileargumente: keine.
     */
    public static void main(String... args) {
        Bottle<Drink> bd = new Bottle<>();
        Bottles.tryFill(bd, new Beer());
        Bottles.tryFill(bd, new Milk()); // schon voll, macht aber nichts
        // Bottles.tryFill(bd, new Nitro()); // Nope. Kein Treibstoff in eine Getraenkeflasche
        System.out.println(bd); // immer noch Bier

        final Drink d = Bottles.tryConsume(bd);
        // final Milk m = Bottles.tryConsume(bd); // Nope. Muss keine Mlich drin sein
        final Fluid f = Bottles.tryConsume(bd);
        System.out.println(d); // Bier
        System.out.println(Bottles.tryConsume(bd)); // nichts mehr

        Bottle<Fluid> bf = new Bottle<>();
        Bottles.tryFill(bd, new Milk());
        // Bottles.fillOver(bf, bd); // Nope. Weiss der Himmel, was in bf ist!
        Bottles.fillOver(bd, bf);
        System.out.println(bd); // jetzt leer
        System.out.println(bf); // Milk jetzt hier

        final Bottle<Milk> bm = new Bottle<>();
        // Bottles.tryFill(bm, new Beer()); // Nope. Kein Bier fuer Babys!
        Bottles.tryFill(bm, new Milk());
        Bottles.tryFill(bd, new Milk());
        Collection<Bottle<? extends Drink>> drinks = List.of(bd, bm, new Bottle<Beer>());
        System.out.println(Bottles.countWith(new Milk(), drinks)); // 2
        final Set<Bottle<? extends Fuel>> fuels = Set.of(new Bottle<Fuel>().fill(new Nitro()),
                                                         new Bottle<Diesel>());
        // System.out.println(Bottles.countWith(new Milk(), fuels)); // Nope. Treibstoffflaschen enthalten niemals Milch

        Bottles.tryFill(bf, new Nitro()); // schon voll
        System.out.println(Bottles.countWith(new Nitro(), List.of(bf, bm, new Bottle<Fuel>()))); // 0
    }
}
