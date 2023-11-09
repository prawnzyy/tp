package seedu.address.logic.commands;

import static seedu.address.logic.Messages.MESSAGE_MODIFY_RECIPE_SUCCESS;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIngredients.EGG;
import static seedu.address.testutil.TypicalIngredients.getTypicalInventory;
import static seedu.address.testutil.TypicalRecipe.getTypicalRecipeBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.Unit;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.RecipeUuidMatchesPredicate;
import seedu.address.model.recipe.UniqueId;
import seedu.address.testutil.IngredientBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code ModifyCommand}.
 */
public class ModifyCommandTest {
    private Model model = new ModelManager(getTypicalInventory(), new UserPrefs(), getTypicalRecipeBook());
    private Model expectedModel = new ModelManager(getTypicalInventory(), new UserPrefs(), getTypicalRecipeBook());

    @Test
    public void execute_validArguments_recipeModified() {
        UniqueId uuid = new UniqueId(1);

        // flour ingredient with a quantity of 50 grams
        Ingredient ingredient = new IngredientBuilder().withName("Flour").withQuantity(50, Unit.GRAM).build();
        ModifyCommand command = new ModifyCommand(uuid, ingredient);

        Recipe oldRecipe = model.getRecipe(uuid);
        expectedModel.deleteRecipe(oldRecipe);

        Recipe newRecipe = oldRecipe.modifyIngredients(ingredient.getName().fullName, ingredient);
        String expectedMessage = String.format(MESSAGE_MODIFY_RECIPE_SUCCESS, uuid);

        expectedModel.addRecipe(newRecipe);
        expectedModel.updateFilteredRecipeList(new RecipeUuidMatchesPredicate(uuid));

        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }
}