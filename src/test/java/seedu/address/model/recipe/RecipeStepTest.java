package seedu.address.model.recipe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecipeStepTest {
    @Test
    public void stringTest() {
        assertThrows(NullPointerException.class, () -> new RecipeStep(null, 1));

        RecipeStep someSteps = new RecipeStep("Test recipe steps", 1);
        assertEquals("1. Test recipe steps", someSteps.toString());
    }

    @Test
    public void modifyStepsTest() {
        RecipeStep someSteps = new RecipeStep("Test recipe steps", 1);

        assertThrows(NullPointerException.class, () -> someSteps.modifyStep(null));

        assertEquals("5. Test recipe steps", someSteps.modifyStep(5).toString());

        assertEquals("1. New instruction", someSteps.modifyStep("New instruction").toString());
    }
}
