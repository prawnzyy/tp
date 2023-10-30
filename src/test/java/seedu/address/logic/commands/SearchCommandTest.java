package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalIngredients.getTypicalInventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.recipe.RecipeIngredientNameMatchesPredicate;

public class SearchCommandTest {
    private Model model;
    private Model expectedModel;
    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalInventory(), new UserPrefs(), model.getRecipeBook());
        expectedModel = new ModelManager(model.getInventory(), new UserPrefs(), model.getRecipeBook());
    }

    @Test
    public void equals() {
        RecipeIngredientNameMatchesPredicate firstPredicate =
                new RecipeIngredientNameMatchesPredicate("first");

        RecipeIngredientNameMatchesPredicate secondPredicate =
                new RecipeIngredientNameMatchesPredicate("second");

        SearchCommand searchFirstCommand = new SearchCommand(firstPredicate);
        SearchCommand searchSecondCommand = new SearchCommand(secondPredicate);

        // same object -> returns true
        assertTrue(searchFirstCommand.equals(searchFirstCommand));

        // same values -> returns true
        SearchCommand searchFirstCommandCopy = new SearchCommand(firstPredicate);
        assertTrue(searchFirstCommand.equals(searchFirstCommandCopy));

        // different types -> returns false
        assertFalse(searchFirstCommand.equals(1));

        // null -> returns false
        assertFalse(searchFirstCommand.equals(null));

        // different ingredient name -> returns false
        assertFalse(searchFirstCommand.equals(searchSecondCommand));
    }
}
