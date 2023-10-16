package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_QUANTITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_UNIT;


import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.Name;
import seedu.address.model.ingredient.Quantity;

/**
 * Adds a ingredient to the address book.
 */
public class UseCommand extends Command {

    public static final String COMMAND_WORD = "use";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Depletes a specified amount of an ingredient from stock. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_QUANTITY + "QUANTITY "
            + PREFIX_UNIT + "UNIT "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "milk "
            + PREFIX_QUANTITY + "600 "
            + PREFIX_UNIT + "ml ";

    public static final String MESSAGE_SUCCESS = "Ingredient used: %1$s";
    public static final String MESSAGE_USED_UP = "Ingredient used up: %1$s";

    private final Name toUse;
    private final Quantity quantityUsed;

    public UseCommand(Name ingredient, Quantity quantity) {
        requireNonNull(ingredient);
        toUse = ingredient;
        quantityUsed = quantity;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        // check method used for when the entire ingredient is depleted
        if ((model.getQuantityOf(toUse).getValue() - quantityUsed.getValue())<= 0) {
            model.deleteIngredient(toUse);
            return new CommandResult(String.format(MESSAGE_USED_UP, Messages.format(new Ingredient(toUse, model.getQuantityOf(toUse)))));
        } else {
            model.useIngredient(toUse, quantityUsed);
            return new CommandResult(String.format(MESSAGE_SUCCESS,
                    Messages.format(new Ingredient(toUse, model.getQuantityOf(toUse)))));
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UseCommand)) {
            return false;
        }

        UseCommand otherUseCommand = (UseCommand) other;
        return toUse.equals(otherUseCommand.toUse);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toUse", toUse)
                .toString();
    }
}
