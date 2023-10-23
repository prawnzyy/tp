package seedu.address.model.recipe;

import org.junit.jupiter.api.Test;
import seedu.address.model.Name;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.TypicalRecipe.*;

public class RecipeTest {
    @Test
    public void equalsTest() {
        assertEquals(COOKIES, COOKIES);

        assertNotEquals(COOKIES, SPONGECAKE);
    }

    @Test
    public void containsIngredientTest() {
        assertThrows(NullPointerException.class, () -> COOKIES.containsIngredient(null));

        assertTrue(COOKIES.containsIngredient(new Name("Flour")));
        assertTrue(COOKIES.containsIngredient(new Name("Chocolate Chips")));

        assertFalse(COOKIES.containsIngredient(new Name("Eggs")));
        assertFalse(COOKIES.containsIngredient(new Name("Yeast")));

        assertTrue(SPONGECAKE.containsIngredient(new Name("Baking Soda")));
        assertTrue(SPONGECAKE.containsIngredient(new Name("Eggs")));

        assertFalse(SPONGECAKE.containsIngredient(new Name("Chocolate Chips")));

        // Trailing space in name
        assertFalse(SPONGECAKE.containsIngredient(new Name("Flour ")));
    }

    @Test
    public void modifyRecipeTest() {
        Recipe modifiedCookie = COOKIES.modifyRecipeStep(4, 7);
        assertNotEquals(modifiedCookie, COOKIES);
        assertEquals(modifiedCookie.getId(), COOKIES.getId());
        assertNotEquals(modifiedCookie.getFullRecipe(), COOKIES.getFullRecipe());

        Recipe modifiedSpongecake = SPONGECAKE.modifyRecipeStep(2, "New step");
        assertNotEquals(modifiedSpongecake, SPONGECAKE);
        assertEquals(modifiedCookie.getId(), COOKIES.getId());
        assertNotEquals(modifiedCookie.getFullRecipe(), COOKIES.getFullRecipe());

        assertThrows(NullPointerException.class, () -> COOKIES.modifyRecipeStep(4, null));

        assertThrows(IllegalArgumentException.class, () -> COOKIES.modifyRecipeStep(7, "Hello"));
    }

    @Test
    public void getFullString() {
        assertEquals(COOKIES.getFullRecipe(), COOKIES_STRING);

        assertEquals(SPONGECAKE.getFullRecipe(), SPONGECAKE_STRING);

        String modifiedCookieString = "1. Cookies\nFlour 200.0 GRAM\nMilk 100.0 GRAM\n" +
                "Chocolate Chips 50.0 GRAM\n1. Mix flour with milk\n2. Put chocolate chips in mixture\n" +
                "3. Shape dough into cookie shape\n4. New step";
        Recipe modifiedCookie = COOKIES.modifyRecipeStep(4, "New step");

        assertEquals(modifiedCookieString, modifiedCookie.getFullRecipe());
        assertNotEquals(modifiedCookie.getFullRecipe(), COOKIES.getFullRecipe());
    }
}
