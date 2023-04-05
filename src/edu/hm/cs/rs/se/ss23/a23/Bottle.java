package edu.hm.cs.rs.se.ss23.a23;

import edu.hm.cs.rs.se.ss23.a23.fluid.Fluid;

/** Eine Flasche.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-04-03
 * @param <F> Was diese Flasche enthalten kann.
 */
public class Bottle<F extends Fluid> {
    /** Der Inhalt dieser Flasche oder null, wenn sie leer ist. */
    private F content;

    /** Fuellt die Flasche auf.
     * @param content Zukuenftiger Inhalt. Nicht null.
     * @return Diese Flasche, aufgefuellt.
     * @throws IllegalStateException wenn die Flasche schon etwas enthaelt.
     */
    public Bottle<F> fill(F content) {
        if(this.content != null)
            throw new IllegalStateException();
        this.content = content;
        return this;
    }

    /** Entleert die Flasche.
     * @return content Bisheriger Inhalt. Nicht null.
     * @throws IllegalStateException wenn die Flasche leer ist.
     */
    public F consume() {
        if(content == null)
            throw new IllegalStateException();
        final F result = content;
        content = null;
        return result;
    }

    /** {@return Test ob die Flasche gerade leer ist.} */
    public boolean empty() {
        return content == null;
    }

    @Override public String toString() {
        return "Bottle{" + (empty()? "": content) + '}';
    }
}
