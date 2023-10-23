package seedu.address.model.recipe.exceptions;

public class RecipeNotFoundException extends RuntimeException {
    private static String message = "Recipe does not exist in Recipe Book";
    public RecipeNotFoundException() {
        super(message);
    }

}
