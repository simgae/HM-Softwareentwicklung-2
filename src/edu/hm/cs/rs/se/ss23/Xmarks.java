package edu.hm.cs.rs.se.ss23;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/** Container fuer wiederholte Xmark.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-18
 */
@Target(ElementType.TYPE)
public @interface Xmarks {
    Xmark[] value();
}
