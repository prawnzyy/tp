package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIngredients.BENSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.ingredient.Name;
import seedu.address.model.ingredient.Phone;

public class JsonAdaptedIngredientTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String VALID_NAME = BENSON.getName().toString();

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedIngredient person = new JsonAdaptedIngredient(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedIngredient person =
                new JsonAdaptedIngredient(INVALID_NAME);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    /*
    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedIngredient person = new JsonAdaptedIngredient(null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }
    */

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedIngredient person =
                new JsonAdaptedIngredient(VALID_NAME);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }
}
