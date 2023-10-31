package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.RecipeBook;
import seedu.address.model.UserPrefs;
import seedu.address.model.ingredient.NameContainsKeywordsPredicate;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.RecipeUuidMatchesPredicate;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX;
import static seedu.address.logic.Messages.MESSAGE_RECIPE_LISTED;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIngredients.getTypicalInventory;
import static seedu.address.testutil.TypicalRecipe.getTypicalRecipeBook;

/**
 * Contains integration tests (interaction with the Model) for {@code RecipeViewCommand}.
 */
public class RecipeViewCommandTest {
    private Model model = new ModelManager(getTypicalInventory(), new UserPrefs(), getTypicalRecipeBook());
    private Model expectedModel = new ModelManager(getTypicalInventory(), new UserPrefs(), getTypicalRecipeBook());

    @Test
    public void equals() {
        RecipeUuidMatchesPredicate firstPredicate = new RecipeUuidMatchesPredicate(1);
        RecipeUuidMatchesPredicate secondPredicate = new RecipeUuidMatchesPredicate(2);

        RecipeViewCommand recipeViewFirstCommand = new RecipeViewCommand(firstPredicate);
        RecipeViewCommand recipeViewSecondCommand = new RecipeViewCommand(secondPredicate);

        // same object -> returns true
        assertTrue(recipeViewFirstCommand.equals(recipeViewFirstCommand));

        // same values -> returns true
        RecipeViewCommand recipeViewFirstCommandCopy = new RecipeViewCommand(firstPredicate);
        assertTrue(recipeViewFirstCommand.equals(recipeViewFirstCommandCopy));

        // different types -> returns false
        assertFalse(recipeViewFirstCommand.equals(1));

        // null -> returns false
        assertFalse(recipeViewFirstCommand.equals(null));

        // different ingredient -> returns false
        assertFalse(recipeViewFirstCommand.equals(recipeViewSecondCommand));
    }

    //TODO may not be the correct way to test groups of inputs might need to change test
    @Test
    public void execute_validUuid_recipeFound() {
        String expectedMessage1 = String.format(MESSAGE_RECIPE_LISTED, 1);
        String expectedMessage2 = String.format(MESSAGE_RECIPE_LISTED, 2);

        // boundary value analysis, using uuid 1 and 2
        RecipeUuidMatchesPredicate predicate1 = new RecipeUuidMatchesPredicate(1);
        RecipeUuidMatchesPredicate predicate2 = new RecipeUuidMatchesPredicate(2);
        RecipeViewCommand command1 = new RecipeViewCommand(predicate1);
        RecipeViewCommand command2 = new RecipeViewCommand(predicate2);

        // testing command1
        expectedModel.updateFilteredRecipeList(predicate1);
        assertCommandSuccess(command1, model, expectedMessage1, expectedModel);

        // testing command2
        expectedModel.updateFilteredRecipeList(predicate2);
        assertCommandSuccess(command2, model, expectedMessage2, expectedModel);
    }

    @Test
    public void execute_invalidUuid_throwsInvalidUuidException() {
        String expectedMessage = MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX;

        // boundary value analysis, using uuid 0 and -1
        RecipeUuidMatchesPredicate predicate1 = new RecipeUuidMatchesPredicate(0);
        RecipeUuidMatchesPredicate predicate2 = new RecipeUuidMatchesPredicate(-1);
        RecipeViewCommand command1 = new RecipeViewCommand(predicate1);
        RecipeViewCommand command2 = new RecipeViewCommand(predicate2);

        // testing command1
        expectedModel.updateFilteredRecipeList(predicate1);
        assertCommandFailure(command1, model, expectedMessage);

        // testing command2
        expectedModel.updateFilteredRecipeList(predicate2);
        assertCommandFailure(command2, model, expectedMessage);
    }

    /*
    todo not sure if should have separate exceptions for searching uuid that are deleted using index for
    todo getrecipe may not be appropriate either for the recipe is dictated by uuid
    */
    @Test
    public void execute_deletedUuidRecipe_throwsInvalidUuidException() {
        String expectedMessage = MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX;

        Recipe deletedRecipe = model.getRecipe(0);
        model.deleteRecipe(deletedRecipe);

        RecipeUuidMatchesPredicate predicate = new RecipeUuidMatchesPredicate(1);
        RecipeViewCommand command = new RecipeViewCommand(predicate);
        assertCommandFailure(command, model, expectedMessage);
    }

    @Test
    public void toStringMethod() {
        RecipeUuidMatchesPredicate predicate = new RecipeUuidMatchesPredicate(1);
        RecipeViewCommand recipeViewCommand = new RecipeViewCommand(predicate);
        String expected = RecipeViewCommand.class.getCanonicalName() + "{predicate=" + predicate + "}";
        assertEquals(expected, recipeViewCommand.toString());
    }
}
