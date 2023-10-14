package seedu.address.model.ingredient.exceptions;

import seedu.address.model.ingredient.Unit;

public class UnitFormatException extends IllegalArgumentException {
    private static String template = "Unit %s is not a valid unit! " + Unit.MESSAGE_CONSTRAINTS;
    public UnitFormatException(String str) {
        super(String.format(template, str));
    }
}
