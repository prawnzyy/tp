package seedu.address.logic.parser;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.ModifyCommand;
import seedu.address.logic.commands.UseCommand;
import seedu.address.model.Name;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.Quantity;
import seedu.address.model.ingredient.Unit;
import seedu.address.model.recipe.UniqueId;

import org.junit.jupiter.api.Test;

import static seedu.address.logic.commands.CommandTestUtil.INVALID_NEG_UUID_DESC_RECIPE;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_ZERO_UUID_DESC_RECIPE;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_FLOUR;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.QUANTITY_DESC_FLOUR;
import static seedu.address.logic.commands.CommandTestUtil.UNIT_DESC_FLOUR;
import static seedu.address.logic.commands.CommandTestUtil.UUID_DESC_RECIPE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class ModifyCommandParserTest {
    private ModifyCommandParser parser = new ModifyCommandParser();

    @Test
    public void parse_validArgs_returnsModifyCommand() {
        Ingredient editedIngredient = new Ingredient(new Name("Flour"), new Quantity(100.0, Unit.GRAM));
        ModifyCommand command = new ModifyCommand(new UniqueId(1), editedIngredient);
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + UUID_DESC_RECIPE + NAME_DESC_FLOUR + QUANTITY_DESC_FLOUR
                + UNIT_DESC_FLOUR, command);
    }
    @Test
    public void parse_nonValidArgs_throwsIllegalArgumentException() {
        assertParseFailure(parser, PREAMBLE_WHITESPACE + "y/test", "Invalid command format! "
                + "\n" + "modify: Modifies the ingredients used in the recipe by the uuid used in the displayed recipe"
                + " list. Existing values will be overwritten by the input values."
                + "\n" + "Parameters: i/UUID n/NAME q/QUANTITY u/UNIT Example: modify i/1 n/milk q/600 u/g ");
    }

    @Test
    public void parse_negativeQuantity_throwsParseException() {
        assertParseFailure(parser, PREAMBLE_WHITESPACE + UUID_DESC_RECIPE + NAME_DESC_FLOUR + " q/-100 "
                        + UNIT_DESC_FLOUR, "Quantity has to be positive");
    }

    @Test
    public void parse_nonNumericQuantity_throwsParseException() {
        assertParseFailure(parser, PREAMBLE_WHITESPACE + UUID_DESC_RECIPE + NAME_DESC_FLOUR + " q/e "
                        + UNIT_DESC_FLOUR, "Invalid quantity: e");
    }

    @Test
    public void parse_UUID_equals_zero() {
        assertParseFailure(parser, PREAMBLE_WHITESPACE + INVALID_ZERO_UUID_DESC_RECIPE + NAME_DESC_FLOUR
                + QUANTITY_DESC_FLOUR + UNIT_DESC_FLOUR, "The recipe index provided is invalid");
    }

    @Test
    public void parse_UUID_negative() {
        assertParseFailure(parser, PREAMBLE_WHITESPACE + INVALID_NEG_UUID_DESC_RECIPE + NAME_DESC_FLOUR
                + QUANTITY_DESC_FLOUR + UNIT_DESC_FLOUR, "The recipe index provided is invalid");
    }

    @Test
    public void parse_invalid_units() {
        assertParseFailure(parser, PREAMBLE_WHITESPACE + UUID_DESC_RECIPE + NAME_DESC_FLOUR
                + QUANTITY_DESC_FLOUR + " u/ml ", "This is not a valid unit!");
    }

}
