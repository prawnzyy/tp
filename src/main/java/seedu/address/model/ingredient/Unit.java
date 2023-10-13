package seedu.address.model.ingredient;


import java.util.HashMap;
import java.util.Map;

public  enum Unit {
    GRAM,
    KILOGRAM,
    PIECE;

    //May need to update this to 3-dimensional matrix for different ingredient conversions.
    private static final Map<Unit, Map<Unit, Double>> conversionMatrix = new HashMap<>();

    //Set the values of the conversion matrix.
    static {
        for(int i = 0; i < Unit.values().length; i++) {
            //Set the diagonal of the conversion matrix to 1.
            addConversionRatio(Unit.values()[i], Unit.values()[i], 1);
        }
        addConversionRatio(KILOGRAM, GRAM, 1000);
    }

    /**
     * Adds conversion ratio for a given pair of units, also adds the reciprocal for the reverse pair.
     * @param from The unit to convert from.
     * @param to The unit to convert to.
     * @param ratio The ratio to multiply the value by.
     */
    private static void addConversionRatio(Unit from, Unit to, double ratio) {
        conversionMatrix.computeIfAbsent(from, x -> new HashMap<>());
        conversionMatrix.get(from).put(to, ratio);

        //Assume commutative conversion for all units
        conversionMatrix.computeIfAbsent(to, x -> new HashMap<>());
        conversionMatrix.get(to).put(from, 1 / ratio);
    }

    /**
     * Get the conversion ratio between two units.
     * @param from The unit to convert from.
     * @param to The unit to convert to.
     * @return The conversion ratio.
     */
    protected static double getConversionRatio(Unit from, Unit to) {
        return conversionMatrix.get(from).get(to);
    }

    @Override
    public String toString() {
        return name();
    }
}
