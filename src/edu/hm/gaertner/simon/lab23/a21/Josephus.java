package edu.hm.gaertner.simon.lab23.a21;

import edu.hm.cs.rs.se.ss23.Xmark;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Task 2.1.
 */
@Xmark("a21")
public class Josephus {

    /**
     * List which contains all prisoners.
     */
    private final List<String> prisoners;

    /**
     * Ctor for Josephus class.
     *
     * @param prisoners - list with all prisoners
     * @throws NullPointerException when prisoners is null
     */
    public Josephus(List<String> prisoners) {
        Objects.requireNonNull(prisoners);
        this.prisoners = new ArrayList<>(prisoners);
    }

    /**
     * Calculates the prisoners released by the king.
     *
     * @param bad   - any multiple of bad will be remained in the prison
     * @param happy - amount of prisoners which will be released
     * @return all the prisoners names which will be released
     */
    public List<String> hailTheKing(int bad, int happy) {

        checkParameters(bad, happy);

        // Prisoners which could be released
        final List<String> freedPersons = new ArrayList<>(getPrisoners());

        int prisoner = 1;

        while (freedPersons.size() > happy) {

            for (String person : getPrisoners()) {

                // Check if we have enough prisoners
                final boolean enoughPrisoners = freedPersons.size() > happy;

                // Check if the prisoner has the chance
                if (freedPersons.contains(person) && enoughPrisoners) {

                    // Check if prisoner is multiple of bad - if yes -> will stay in prison
                    removePersonIfNecessary(prisoner, bad, freedPersons, person);

                    prisoner++;
                }

            }

        }

        return freedPersons;
    }

    /**
     * Check if prisoner is multiple of bad -> if yes - prisoner will not be released.
     * @param prisoner - prisoner number
     * @param bad - value
     * @param freedPersons - list of possible freed persons
     * @param person - name of person
     */
    private void removePersonIfNecessary(int prisoner, int bad, List<String> freedPersons, String person){
        if (prisoner % bad == 0) {
            freedPersons.remove(person);
        }
    }

    /**
     * Check input parameters.
     * @param bad - parameter 1
     * @param happy - parameter 2
     * @throws IllegalArgumentException when one or both are less than 1
     */
    private void checkParameters(int bad, int happy){
        if (bad < 1 || happy < 1)
            throw new IllegalArgumentException("Invalid parameters!");
    }

    /**
     * Getter for prisoner list.
     *
     * @return prisoner list
     */
    private List<String> getPrisoners() {
        return prisoners;
    }
}
