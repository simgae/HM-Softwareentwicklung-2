package edu.hm.gaertner.simon.lab23.a23;

import edu.hm.cs.rs.se.ss23.a23.Bottle;
import edu.hm.cs.rs.se.ss23.a23.fluid.Fluid;

import java.util.Collection;

public class Bottles {

    /**
     * Fill fluid into bottle if the bottle is empty.
     * If bottle is full do nothing.
     * @param bottle which should be filled.
     * @param fluid of the bottle.
     */
    public static <F extends Fluid> void tryFill(Bottle<? super F> bottle, F fluid){
        if(bottle.empty())
            bottle.fill(fluid);

    }

    /**
     * Remove fluid from bottle when bottle is full.
     * If bottle is empty return null.
     * @param bottle which should be emptied.
     * @return null when bottle was empty, otherwise the fluid.
     */
    public static <F extends Fluid> F tryConsume(Bottle<F> bottle){

        F result = null;

        if (!bottle.empty())
            result = bottle.consume();

        return result;
    }

    /**
     * Check fluid of bottle - change nothing on the bottle.
     * @param bottle which should be checked
     * @return null if the bottle is empty, otherwise the fluid
     */
    public static <F extends Fluid> F peekInto(Bottle<F> bottle){
        F result = null;

        if(!bottle.empty()){
            result = tryConsume(bottle);
            tryFill(bottle, result);
        }

        return result;
    }

    /**
     * Count bottles in the collection which contains the fluid.
     * @param fluid which should be count.
     * @param collection of bottles.
     * @return number of bottles which contains the fluid.
     */
    public static <F extends Fluid> int countWith(F fluid, Collection<Bottle<? extends Fluid>> collection){

        int counter = 0;

        for (Bottle<? extends Fluid> bottle: collection) {
            if(!bottle.empty()){
                final Fluid content = peekInto(bottle);

                if(content.equals(fluid))
                    counter++;

            }
        }
        return counter;
    }

    /**
     * Fill bottle one in bottle two.
     * @param bottleOne will be empty after method, when bottle two is empty.
     * @param bottleTwo will be full after method, when bottle one is not emtpy.
     */
    public static void fillOver(Bottle<? extends Fluid> bottleOne, Bottle<? extends Fluid> bottleTwo){
        if(!bottleOne.empty() && bottleTwo.empty()){
            final Fluid fluid = tryConsume(bottleOne);
            tryFill(bottleTwo, fluid);
        }
    }
}
