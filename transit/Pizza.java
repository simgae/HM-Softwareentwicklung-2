/** Eine Pizza.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-06-16
 */
public interface Pizza {
    /** {@return Preis der Pizza in Eurocent.} */
    int price();

    /** {@return Test, ob diese Pizza vegetarisch ist.} */
    boolean vegetarian();

    /** {@return Test, ob diese Pizza scharf ist.} */
    boolean hot();
}
