package seedu.address.model.recipe.exceptions;

import seedu.address.model.ingredient.Unit;

public class RecipeStepFormatException extends IllegalArgumentException {
    private static String template = "Not a valid recipe step!";
    public RecipeStepFormatException() {
        super(template);
    }
}
