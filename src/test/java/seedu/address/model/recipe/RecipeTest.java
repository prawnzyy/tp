package seedu.address.model.recipe;

import org.junit.jupiter.api.Test;
import seedu.address.model.Name;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.TypicalRecipe.*;

public class RecipeTest {
    @Test
    public void equalsTest() {
        assertEquals(COOKIES, COOKIES);

        assertNotEquals(COOKIES, SPONGECAKE);
    }

    @Test
    public void recipe_nullName_throwsNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> new Recipe(null, new ArrayList<>(), new ArrayList<>()));
    }

    @Test
    public void recipe_nullIngredientList_throwsNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> new Recipe(new Name("Test"), null, new ArrayList<>()));
    }

    @Test
    public void recipe_nullStepsList_throwsNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> new Recipe(new Name("Test"), new ArrayList<>(), null));
    }

    @Test
    public void containsIngredient_nullIngredient_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> COOKIES.containsIngredient(null));
    }
    @Test
    public void containsIngredient_correctIngredient_returnsTrue() {
        assertTrue(COOKIES.containsIngredient(new Name("Flour")));
        assertTrue(COOKIES.containsIngredient(new Name("Chocolate Chips")));

        assertTrue(SPONGECAKE.containsIngredient(new Name("Baking Soda")));
        assertTrue(SPONGECAKE.containsIngredient(new Name("Eggs")));
    }

    @Test
    public void containsIngredient_wrongIngredient_returnsFalse() {
        assertFalse(COOKIES.containsIngredient(new Name("Eggs")));
        assertFalse(COOKIES.containsIngredient(new Name("Yeast")));

        assertFalse(SPONGECAKE.containsIngredient(new Name("Chocolate Chips")));
    }

    @Test
    public void containsIngredient_ingredientTrailingSpace_returnsFalse() {
        assertFalse(SPONGECAKE.containsIngredient(new Name("Flour ")));
    }

    @Test
    public void modifyRecipe_recipeHasDifferentIdentity_success() {
        Recipe modifiedCookie = COOKIES.modifyRecipeStep(4, 7);
        assertNotEquals(modifiedCookie, COOKIES);

        Recipe modifiedSpongecake = SPONGECAKE.modifyRecipeStep(2, "New step");
        assertNotEquals(modifiedSpongecake, SPONGECAKE);
    }

    @Test
    public void modifyRecipe_recipeHasSameUniqueId_success() {
        Recipe modifiedCookie = COOKIES.modifyRecipeStep(4, 7);
        assertEquals(modifiedCookie.getId(), COOKIES.getId());

        Recipe modifiedSpongecake = SPONGECAKE.modifyRecipeStep(2, "New step");
        assertEquals(modifiedSpongecake.getId(), SPONGECAKE.getId());
    }

    @Test
    public void modifyRecipe_recipeHasDifferentStringRepresentation_sucess() {
        Recipe modifiedCookie = COOKIES.modifyRecipeStep(4, 7);
        assertNotEquals(modifiedCookie.getFullRecipe(), COOKIES.getFullRecipe());

        Recipe modifiedSpongecake = SPONGECAKE.modifyRecipeStep(2, "New step");
        assertNotEquals(modifiedCookie.getFullRecipe(), COOKIES.getFullRecipe());
    }

    @Test
    public void modifyRecipe_nullRecipeInstruction_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> COOKIES.modifyRecipeStep(4, null));
    }

    @Test
    public void modifyRecipe_indexGreaterThanAvailableSteps_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> COOKIES.modifyRecipeStep(7, "Hello"));
    }

    @Test
    public void getFullString_sameAsStringRepresentation_success() {
        assertEquals(COOKIES.getFullRecipe(), COOKIES_STRING);

        assertEquals(SPONGECAKE.getFullRecipe(), SPONGECAKE_STRING);
    }

    @Test
    public void getFullString_recipeHasCorrectModifiedRepresentation_success() {
        String modifiedCookieString = "1. Cookies\nFlour 200.0 GRAM\nMilk 100.0 GRAM\n" +
                "Chocolate Chips 50.0 GRAM\n1. Mix flour with milk\n2. Put chocolate chips in mixture\n" +
                "3. Shape dough into cookie shape\n4. New step";
        Recipe modifiedCookie = COOKIES.modifyRecipeStep(4, "New step");
        assertEquals(modifiedCookieString, modifiedCookie.getFullRecipe());
    }
}
