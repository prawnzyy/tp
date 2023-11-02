package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RecipeViewCommand;
import seedu.address.model.recipe.RecipeUuidMatchesPredicate;

public class RecipeViewCommandParserTest {

    private RecipeViewCommandParser parser = new RecipeViewCommandParser();

    @Test
    public void parse_validArgs_returnsRecipeViewCommand() {
        // no leading and trailing whitespaces
        RecipeViewCommand expectedRecipeViewCommand =
                new RecipeViewCommand(new RecipeUuidMatchesPredicate(1));
        assertParseSuccess(parser, "1", expectedRecipeViewCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n 1 \t", expectedRecipeViewCommand);
    }

    @Test
    public void parse_noArgs_throwsParseException() {
        assertParseFailure(parser, " ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, RecipeViewCommand.MESSAGE_USAGE));
    }
}
