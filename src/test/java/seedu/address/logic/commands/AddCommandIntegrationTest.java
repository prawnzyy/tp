package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIngredients.getTypicalInventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.Name;
import seedu.address.model.UserPrefs;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.Quantity;
import seedu.address.model.ingredient.Unit;
import seedu.address.testutil.IngredientBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalInventory(), new UserPrefs());
    }

    @Test
    public void execute_newIngredient_success() {
        Ingredient validIngredient = new IngredientBuilder().build();
        Ingredient expectedIngredient = new Ingredient(new Name("Flour"), new Quantity(150.0, Unit.GRAM));

        Model expectedModel = new ModelManager(model.getInventory(), new UserPrefs());
        expectedModel.addIngredient(validIngredient);
        assertCommandSuccess(new AddCommand(validIngredient), model,
                String.format(AddCommand.MESSAGE_SUCCESS, Messages.format(expectedIngredient)),
                expectedModel);
    }
}
