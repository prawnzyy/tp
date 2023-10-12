package seedu.address.model.ingredient;

public class Quantity {
    private double value;
    private Unit unit;

    /**
     * Constructs a Quantity instance.
     * @param value The numerical value of the quantity.
     * @param unit The unit of the quantity.
     */
    protected Quantity (double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    protected void add(Quantity otherQuantity) {
        value += otherQuantity.convertToUnit(unit).value;
    }

    protected Quantity convertToUnit(Unit toUnit) {
        return new Quantity(value * Unit.getConversionRatio(this.unit, toUnit), toUnit);
    }
}
