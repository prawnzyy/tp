package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.recipe.Recipe;

/**
 * An UI component that displays information of a {@code Recipe}.
 */
public class RecipeCard extends UiPart<Region> {
    private static final String FXML = "RecipeListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Recipe recipe;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label ingredient;

    /**
     * Creates a {@code IngredientCode} with the given {@code Ingredient} and index to display.
     */
    public RecipeCard(Recipe recipe, int displayedIndex) { // To be updated
        super(FXML);
        this.recipe = recipe;
        id.setText(displayedIndex + ". ");
        name.setText(recipe.getName().toString());
        StringBuilder stringBuilder = new StringBuilder();
        for (Ingredient ingredient : recipe.getIngredients()) {
            stringBuilder.append("Name: " + ingredient.getName() + " Quantity: " + ingredient.getQuantity());
            stringBuilder.append("\n");
        }
        String ingredients = stringBuilder.toString();
        ingredient.setText(ingredients);
    }
}
