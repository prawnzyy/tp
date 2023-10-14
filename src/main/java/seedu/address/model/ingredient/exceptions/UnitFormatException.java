package seedu.address.model.ingredient.exceptions;

public class UnitFormatException extends IllegalArgumentException {
    private static String template = "Ingredient %s is not a valid ingredient!" ;
    public UnitFormatException(String str) {
        super(String.format(template, str));
    }
}
