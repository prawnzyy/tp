package seedu.address.logic.parser;

import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_FLOUR;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.QUANTITY_DESC_FLOUR;
import static seedu.address.logic.commands.CommandTestUtil.UNIT_DESC_FLOUR;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.UseCommand;
import seedu.address.model.Name;
import seedu.address.model.ingredient.Quantity;
import seedu.address.model.ingredient.Unit;

public class UseCommandParserTest {

    private UseCommandParser parser = new UseCommandParser();

    @Test
    public void parse_validArgs_returnsUseCommand() {
        UseCommand command = new UseCommand(new Name("Flour"), new Quantity(100.0, Unit.GRAM));
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_FLOUR + QUANTITY_DESC_FLOUR
                + UNIT_DESC_FLOUR, command);
    }

    @Test
    public void parse_nonValidArgs_throwsIllegalArgumentException() {
        assertParseFailure(parser, PREAMBLE_WHITESPACE + "y/test", "Invalid command format! \n"
                + "use: Depletes a specified amount of an ingredient from stock. "
                + "Parameters: n/NAME q/QUANTITY u/UNIT Example: use n/milk q/600 u/ml ");
    }

    @Test
    public void parse_noQuantityAndUnit_returnsUseCommand() {
        UseCommand command = new UseCommand(new Name("Flour"), new Quantity(100.0, Unit.GRAM));
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_FLOUR, command);
    }

    @Test
    public void parse_negativeQuantity_throwsParseException() {
        assertParseFailure(parser, PREAMBLE_WHITESPACE + NAME_DESC_FLOUR + " q/-100 " + UNIT_DESC_FLOUR,
                "Quantity cannot be negative");
    }

    @Test
    public void parse_nonNumericQuantity_throwsParseException() {
        assertParseFailure(parser, PREAMBLE_WHITESPACE + NAME_DESC_FLOUR + " q/onehundred " + UNIT_DESC_FLOUR,
                "Invalid quantity: onehundred");
    }
}
