package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.RecipeUuidMatchesPredicate;


import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_MODIFY_RECIPE_SUCCESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_QUANTITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_UNIT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_UUID;

public class ModifyCommand extends Command {
    public static final String COMMAND_WORD = "modify";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Modifies the details of the ingredients used in the "
            + "recipe"
            + "by the uuid used in the displayed recipe list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: "
            + PREFIX_UUID + "UUID "
            + PREFIX_NAME + "NAME "
            + PREFIX_QUANTITY + "QUANTITY "
            + PREFIX_UNIT + "UNIT "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_UUID + "1 "
            + PREFIX_NAME + "milk "
            + PREFIX_QUANTITY + "600 "
            + PREFIX_UNIT + "ml ";
    private int recipeUuid;
    private Ingredient editedIngredient;

    public ModifyCommand(int uuid, Ingredient newIngredient) {
        requireNonNull(newIngredient);
        requireNonNull(uuid);
        editedIngredient = newIngredient;
        recipeUuid = uuid;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasRecipe(recipeUuid)) {
            throw new CommandException(Messages.MESSAGE_RECIPE_DOES_NOT_EXIST);
        }

        Recipe oldRecipe = model.getRecipe(recipeUuid);
        if (!oldRecipe.containsIngredient(editedIngredient.getName())) {
            throw new CommandException(Messages.MESSAGE_NO_SUCH_INGREDIENT);
        }

        Recipe newRec = oldRecipe.modifyIngredients(editedIngredient.getName().fullName, editedIngredient);
        model.deleteRecipe(oldRecipe);
        model.addRecipe(newRec);
        model.updateFilteredRecipeList(new RecipeUuidMatchesPredicate(recipeUuid));
        return new CommandResult(String.format(MESSAGE_MODIFY_RECIPE_SUCCESS,
                recipeUuid));

    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ModifyCommand)) {
            return false;
        }

        ModifyCommand otherModifyCommand = (ModifyCommand) other;
        return editedIngredient.equals(otherModifyCommand.editedIngredient);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toModify", editedIngredient)
                .toString();
    }
}
