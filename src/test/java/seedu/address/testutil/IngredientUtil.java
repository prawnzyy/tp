package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.tag.Tag;

/**
 * A utility class for Person.
 */
public class IngredientUtil {

    /**
     * Returns an add command string for adding the {@code person}.
     */
    public static String getAddCommand(Ingredient ingredient) {
        return AddCommand.COMMAND_WORD + " " + getIngredientDetails(ingredient);
    }

    /**
     * Returns the part of command string for the given {@code person}'s details.
     */
    public static String getIngredientDetails(Ingredient ingredient) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + ingredient.getName().fullName + " ");
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditIngredientDescriptorDetails(EditPersonDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        return sb.toString();
    }
}
