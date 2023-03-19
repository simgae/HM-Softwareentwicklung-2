package edu.hm.cs.rs.se.ss23;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Markiert ein Sourcefile fuer Crossmarking.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2023-03-18
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
@Repeatable(Xmarks.class)
public @interface Xmark {
    /** Subpackage, das zum Crossmarking eingereicht ist. */
    String value();
}
