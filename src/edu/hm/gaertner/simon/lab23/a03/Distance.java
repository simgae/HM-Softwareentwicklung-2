package edu.hm.gaertner.simon.lab23.a03;

public record Distance(int amount, String unit) {

    /**
     * Ctor.
     * @param amount of units
     * @param unit - only available: mm - m - km
     */
    public Distance {
        checkUnits(unit);
        checkAmount(amount);
    }

    /**
     * Recalculate amount to new unit.
     * @param unit new unit
     * @return new amount in the new unit
     * @throws IllegalStateException when any unit parameter is wrong.
     */
    public int as(String unit){
        checkUnits(unit);

        return switch (this.unit()) {
            case "m" -> switch (unit) {
                case "mm" -> this.amount() * 100 * 10;
                case "m" -> this.amount();
                case "km" -> this.amount() / 1000;
                default -> throw new IllegalStateException("Unexpected value: " + unit);
            };
            case "mm" -> switch (unit) {
                case "mm" -> this.amount();
                case "m" -> this.amount() / 10 / 100;
                case "km" -> this.amount() / 10 / 100 / 1000;
                default -> throw new IllegalStateException("Unexpected value: " + unit);
            };
            case "km" -> switch (unit) {
                case "mm" -> this.amount() * 1000 * 100 * 10;
                case "m" -> this.amount() * 1000;
                case "km" -> this.amount();
                default -> throw new IllegalStateException("Unexpected value: " + unit);
            };
            default -> throw new IllegalStateException("Unexpected value: " + unit);
        };
    }

    /**
     * Check if this amount is greater than that amount.
     * @param that object.
     * @return true when correct otherwise false
     */
    public boolean more (Distance that){
        final int distanceThat = that.as(this.unit());

        return this.amount() > distanceThat;
    }

    /**
     * Add the distance of that to this distance.
     * @param that object
     * @return new object with added distance and unit of this
     */
    public Distance add(Distance that){
        final int distanceThat = that.as(this.unit());

        final int newDistance = distanceThat + this.amount();

        return new Distance(newDistance, this.unit());
    }

    /**
     * Check if the unit parameter is correct.
     * @param unit parameter.
     * @throws IllegalArgumentException when unit parameter is wrong.
     */
    private void checkUnits(String unit){
        if(!(unit.equals("m") || unit.equals("mm") || unit.equals("km")))
            throw new IllegalArgumentException("Wrong unit!");
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
        System.out.println(new Distance(123_456, "m").as("km"));
        System.out.println(new Distance(123_456, "m").more(new Distance(123, "km")));
        System.out.println(new Distance(123_456, "mm").add(new Distance(123, "m")).amount());
    }


}
