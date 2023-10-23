package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_QUANTITY_DESC;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_FLOUR;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.QUANTITY_DESC_FLOUR;
import static seedu.address.logic.commands.CommandTestUtil.UNIT_DESC_FLOUR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_AMOUNT_FLOUR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_FLOUR;
import static seedu.address.logic.commands.CommandTestUtil.VALID_UNIT_FLOUR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_QUANTITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_UNIT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIngredients.FLOUR;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.AddCommand;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.Name;
import seedu.address.model.ingredient.Unit;
import seedu.address.testutil.IngredientBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();


    @Test
    public void parse_allFieldsPresent_success() {
        Ingredient expectedIngredient = new IngredientBuilder(FLOUR).withQuantity(100, Unit.GRAM).build();

        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_FLOUR + QUANTITY_DESC_FLOUR
                + UNIT_DESC_FLOUR, new AddCommand(expectedIngredient));
    }

    // not yet accounted for invalid units
    @Test
    public void parse_repeatedValue_failure() {
        String validExpectedIngredientString = NAME_DESC_FLOUR + QUANTITY_DESC_FLOUR + UNIT_DESC_FLOUR;

        // multiple names
        assertParseFailure(parser, NAME_DESC_FLOUR + validExpectedIngredientString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_NAME));

        // multiple quantities
        assertParseFailure(parser, QUANTITY_DESC_FLOUR + validExpectedIngredientString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_QUANTITY));

        // multiple units
        assertParseFailure(parser, UNIT_DESC_FLOUR + validExpectedIngredientString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_UNIT));

        // multiple fields repeated
        assertParseFailure(parser,
                validExpectedIngredientString + NAME_DESC_FLOUR + QUANTITY_DESC_FLOUR + UNIT_DESC_FLOUR
                        + validExpectedIngredientString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_NAME, PREFIX_QUANTITY, PREFIX_UNIT));

        // invalid value followed by valid value

        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + validExpectedIngredientString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_NAME));

        // invalid email
        assertParseFailure(parser, INVALID_QUANTITY_DESC + validExpectedIngredientString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_QUANTITY));


        // valid value followed by invalid value

        // invalid name
        assertParseFailure(parser, validExpectedIngredientString + INVALID_NAME_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_NAME));

        // invalid email
        assertParseFailure(parser, validExpectedIngredientString + INVALID_QUANTITY_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_QUANTITY));

    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, VALID_NAME_FLOUR + QUANTITY_DESC_FLOUR + UNIT_DESC_FLOUR,
                expectedMessage);

        // missing phone prefix
        assertParseFailure(parser, NAME_DESC_FLOUR + VALID_AMOUNT_FLOUR + UNIT_DESC_FLOUR,
                expectedMessage);

        // missing email prefix
        assertParseFailure(parser, NAME_DESC_FLOUR + QUANTITY_DESC_FLOUR + VALID_UNIT_FLOUR,
                expectedMessage);


        // all prefixes missing
        assertParseFailure(parser, VALID_NAME_FLOUR + VALID_AMOUNT_FLOUR + VALID_UNIT_FLOUR,
                expectedMessage);
    }


    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + QUANTITY_DESC_FLOUR + UNIT_DESC_FLOUR,
                Name.MESSAGE_CONSTRAINTS);


        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_NAME_DESC + INVALID_QUANTITY_DESC + UNIT_DESC_FLOUR,
                Name.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_FLOUR + QUANTITY_DESC_FLOUR + UNIT_DESC_FLOUR,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }

}
