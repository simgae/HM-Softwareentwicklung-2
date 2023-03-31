package edu.hm.gaertner.simon.lab23.a05;

import edu.hm.cs.rs.se.ss23.Xmark;

/**
 * Distance record.
 * @param amount of units
 * @param unit -> km, m, mm
 */
@Xmark("a03")
public record BetterDistance(int amount, Units unit) {

    /**
     * Ctor.
     * @param amount of units
     * @param unit - only available: mm - m - km -> is no longer needed because we can only transfer units which are
     *             defined in the Unit Enum
     */
    public BetterDistance {
        checkAmount(amount);
    }

    /**
     * Recalculate amount to new unit.
     * @param unit new unit
     * @return new amount in the new unit
     * @throws IllegalStateException when any unit parameter is wrong.
     */
    public int as(Units unit){
        return switch (this.unit()) {
            case M -> switch (unit) {
                case MM -> this.amount() * 100 * 10;
                case M  -> this.amount();
                case KM -> this.amount() / 1000;
            };
            case MM -> switch (unit) {
                case MM -> this.amount();
                case M -> this.amount() / 10 / 100;
                case KM -> this.amount() / 10 / 100 / 1000;
            };
            case KM -> switch (unit) {
                case MM -> this.amount() * 1000 * 100 * 10;
                case M -> this.amount() * 1000;
                case KM -> this.amount();
            };
        };
    }

    /**
     * Check if this amount is greater than that amount.
     * @param that object.
     * @return true when correct otherwise false
     */
    public boolean more (BetterDistance that){
        final int distanceThat = that.as(this.unit());

        return this.amount() > distanceThat;
    }

    /**
     * Add the distance of that to this distance.
     * @param that object
     * @return new object with added distance and unit of this
     */
    public BetterDistance add(BetterDistance that){
        final int distanceThat = that.as(this.unit());

        final int newDistance = distanceThat + this.amount();

        return new BetterDistance(newDistance, this.unit());
    }

    /**
     * Check if the amount parameter is correct.
     * @param amount parameter
     * @throws IllegalArgumentException when unit parameter is negative
     */
    private void checkAmount (int amount){
        if(amount < 0)
            throw new IllegalArgumentException("Negative amount!");
    }

    /**
     * main Method for testing reasons.
     * @param args arguments
     */
    public static void main(String[] args) {
        System.out.println(new BetterDistance(123_456, Units.M).as(Units.KM));
        System.out.println(new BetterDistance(123_456, Units.M).more(new BetterDistance(123, Units.KM)));
        System.out.println(new BetterDistance(123_456, Units.MM).add(new BetterDistance(123, Units.M)).amount());
    }


}
