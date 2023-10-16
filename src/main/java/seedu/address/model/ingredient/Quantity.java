package seedu.address.model.ingredient;

public class Quantity {
    private double value;
    private Unit unit;

    /**
     * Constructs a Quantity instance.
     * @param value The numerical value of the quantity.
     * @param unit The unit of the quantity.
     */
    public Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }
    /**
     * Adds a quantity to this quantity.
     * @param otherQuantity
     */
    protected void add(Quantity otherQuantity) {
        value += otherQuantity.convertToUnit(unit).value;
    }

    /**
     * Subtracts a quantity from this quantity.
     * @param quantity
     */
    protected void subtract(Quantity quantity) {
        value -= quantity.convertToUnit(unit).value;
    }

    /**
     * Converts this quantity to a specified unit.
     * @param toUnit
     * @return The converted quantity.
     */
    protected Quantity convertToUnit(Unit toUnit) {
        return new Quantity(value * Unit.getConversionRatio(this.unit, toUnit), toUnit);
    }

    /**
     * Scales this quantity by a factor.
     * @param factor
     * @return The scaled quantity.
     */
    protected Quantity scale(double factor) {
        return new Quantity(value * factor, unit);
    }

    @Override
    public String toString() {
        return value + " " + unit.toString();
    }

    public static Quantity parseQuantity(String quantityString) {
        String[] splitStr = quantityString.split(" ");

        double val = Double.parseDouble(splitStr[0]);
        Unit unit = Unit.parseUnit(splitStr[1]);

        return new Quantity(val, unit);
    }
}
