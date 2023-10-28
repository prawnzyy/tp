package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX;

import seedu.address.logic.commands.RecipeViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.recipe.RecipeUuidMatchesPredicate;
import seedu.address.model.recipe.UniqueId;

/**
 * Parser for the RecipeViewCommand, returns a RecipeViewCommand
 */
public class RecipeViewCommandParser implements Parser<RecipeViewCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the StockCommand
     * and returns a StockCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public RecipeViewCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        int uuid;
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RecipeViewCommand.MESSAGE_USAGE));
        }
        try {
            uuid = Integer.parseInt(trimmedArgs);
        } catch (NumberFormatException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, RecipeViewCommand.MESSAGE_USAGE));
        }
        if (!UniqueId.isValidId(uuid)) {
            throw new ParseException(String.format(MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX,
                    RecipeViewCommand.MESSAGE_USAGE));
        }
        return new RecipeViewCommand(new RecipeUuidMatchesPredicate(uuid));
    }
}
